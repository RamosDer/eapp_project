import { Component, OnInit, AfterViewInit, ViewChild, ChangeDetectorRef } from '@angular/core';
import { Router } from '@angular/router';
import { FormBuilder, FormGroup, Validators, FormArray } from '@angular/forms';
import { MatPaginator } from '@angular/material/paginator';
import { MatTableDataSource } from '@angular/material/table';
import { MatChipInputEvent } from '@angular/material/chips';
import { ENTER, COMMA } from '@angular/cdk/keycodes';
import { ApiService } from '../../services/api.service';
import { MatCheckboxChange } from '@angular/material/checkbox';

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
      private cdr: ChangeDetectorRef
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
  }

  ngOnInit(): void {}

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

      // Cambia la llamada directa a HttpClient por la función del ApiService.
      this.apiService.registrarPalabra(palabra).subscribe(response => {
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

    if (value) {
        const significados = this.formulario.get('significados') as FormArray;
        significados.push(this.formBuilder.control(value));
        this.formulario.get('nuevoSignificado')?.setValue('');  // Limpiar el campo de entrada
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
