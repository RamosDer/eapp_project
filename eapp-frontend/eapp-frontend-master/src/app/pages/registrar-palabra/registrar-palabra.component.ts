import { Component, OnInit, AfterViewInit, ViewChild, ChangeDetectorRef } from '@angular/core';
import { Router, ActivatedRoute } from '@angular/router';
import { FormBuilder, FormGroup, Validators, FormArray } from '@angular/forms';
import { MatPaginator } from '@angular/material/paginator';
import { MatTableDataSource } from '@angular/material/table';
import { MatChipInputEvent } from '@angular/material/chips';
import { ENTER, COMMA } from '@angular/cdk/keycodes';
import { ApiService } from '../../services/api.service';
import { MatCheckboxChange } from '@angular/material/checkbox';
import { PalabraFraseService } from 'src/app/services/palabraFrase.service';
import { PalabraFrase } from 'src/app/modelos/palabraFrase.model';
import { TipoService } from '../../services/tipo.service';
import { SignificadoService } from '../../services/significado.service';

@Component({
  selector: 'app-registrar-palabra',
  templateUrl: './registrar-palabra.component.html',
  styleUrls: ['./registrar-palabra.component.css']
})
export class RegistrarPalabraComponent implements OnInit, AfterViewInit {
  formulario: FormGroup;
  listaPalabras = new MatTableDataSource<any>();
  significados: FormArray = this.formBuilder.array([]);
  listaAprendido: FormArray = this.formBuilder.array([]);

  selectable = true;
  removable = true;
  separatorKeysCodes: number[] = [ENTER, COMMA];

  @ViewChild(MatPaginator) paginator: MatPaginator | undefined;

  // Modifica el constructor para incluir el ApiService.
  constructor(
      private apiService: ApiService, 
      private router: Router, 
      private formBuilder: FormBuilder,
      private cdr: ChangeDetectorRef,
      private palabraFraseService: PalabraFraseService,
      private tipoService: TipoService,
      private significadoService: SignificadoService,
      private route: ActivatedRoute
  ) {
    this.significados = this.formBuilder.array([]);
    this.listaAprendido = this.formBuilder.array([]);

    this.formulario = this.formBuilder.group({
        texto: ['', Validators.required],
        significados: this.significados,
        tipo: ['', Validators.required],
        dificultad: ['', Validators.required],
        nuevoSignificado: [''],
        listaAprendido: this.listaAprendido
    });

    const id = this.route.snapshot.params['idPalabraFrase'];
      if (id) {
        this.palabraFraseService.obtenerPalabraPorId(id).subscribe((response: PalabraFrase) => {
            console.log('Palabra obtenida: ', response);
      });
    }
  }

  ngOnInit(): void {
    this.tipoService.obtenerTipos().subscribe(tipos => {
      console.log('Tipos obtenidos:', tipos);
      // Haz lo que necesites con los tipos aquí, por ejemplo, almacenarlos en una variable del componente o usarlos en alguna lógica.
    }, error => {
      console.error('Error al obtener los tipos:', error);
    })
  }

  ngAfterViewInit(): void {
    if (this.paginator) {
      this.listaPalabras.paginator = this.paginator;
    }
  }

  get significadosArray(): FormArray {
    return this.formulario.get('significados') as FormArray;
  }

  registrar() {
    if (this.formulario.valid) {
      const palabra = this.formulario.value;
      console.log('Palabra a registrar:', palabra);
      // Cambia la llamada directa a HttpClient por la función del ApiService.
      this.palabraFraseService.registrarPalabra(palabra).subscribe(response => {
        alert('Registro exitoso!');
      }, error => {
        alert('Error al registrar');
      });
    } else {
      alert('Por favor, complete todos los campos obligatorios.');
    }
  }

  cancelar() {
    alert('Registro cancelado.');
    this.router.navigate(['/user-dashboard']);
  }

  actualizarAprendido(event: MatCheckboxChange, palabra: any) {
    this.apiService.actualizarAprendido(palabra.idPalabraFrase, event.checked).subscribe(response => {
      alert('Campo "aprendido" actualizado correctamente');
      palabra.aprendido = event.checked;
    }, error => {
      alert('Error al actualizar el campo "aprendido"');
    });
}


  // agregarSignificado(event: MouseEvent): void {
  //   const input = event?.target as HTMLInputElement;

  //   const value = input.value.trim();
  
  //   // Añadir significado a la lista de significados
  //   if (value) {
  //     const significados = this.formulario.get('significados') as FormArray;
  //     significados.push(this.formBuilder.control(value));
  //     input.value = ''; // Limpiar el campo de entrada
  //   }
  // }
  

  agregarSignificadoDesdeBoton(): void {
    const value = this.formulario.get('nuevoSignificado')?.value.trim();
    const significados = this.formulario.get('significados') as FormArray;

    if (value && significados.length < 5) {
        const nuevoSignificado = {
            texto: value  // Asume que 'texto' es la propiedad que quieres enviar al backend
        };

        // Usa el servicio para registrar el significado
        this.significadoService.registrarSignificado(nuevoSignificado).subscribe(response => {
            // Lógica después de registrar el significado en el backend
            significados.push(this.formBuilder.control(value));
            this.formulario.get('nuevoSignificado')?.setValue('');  // Limpiar el campo de entrada
        }, error => {
            console.error('Error al registrar el significado:', error);
        });
    } else if (significados.length >= 5) {
        alert('Solo puedes agregar hasta 5 significados.');
    }
}


  agregarSignificadoDesdeEvento(event: MatChipInputEvent): void {
    const input = event.input;
    const value = event.value.trim();
    
    // Añadir significado a la lista de significados
    if (value) {
        const significados = this.formulario.get('significados') as FormArray;
        significados.push(this.formBuilder.control(value));
        if (input) {
            input.value = ''; // Limpiar el campo de entrada
        }
    }
  }

  removerSignificado(index: number): void {
    const significados = this.formulario.get('significados') as FormArray;
    if (index >= 0 && index < significados.length) {
        significados.removeAt(index);
    }
}

}
