import { Component, OnInit, Inject } from '@angular/core';
import { FormBuilder, FormGroup, Validators, FormArray } from '@angular/forms';
import { MatDialogRef, MAT_DIALOG_DATA } from '@angular/material/dialog';
import { MatChipInputEvent } from '@angular/material/chips';
import { PalabraFraseService } from 'src/app/services/palabraFrase.service';
import { SignificadoService } from 'src/app/services/significado.service';
import { COMMA, ENTER } from '@angular/cdk/keycodes';


@Component({
  selector: 'app-dialogo-nueva-palabra',
  templateUrl: './dialogo-nueva-palabra.component.html',
  styleUrls: ['./dialogo-nueva-palabra.component.css']
})

export class DialogoNuevaPalabraComponent {
  formulario: FormGroup;
  dificultades: string[] = ['EASY', 'MEDIUM', 'HARD'];
  selectable: boolean = true;
  removable: boolean = true;
  readonly separatorKeysCodes: number[] = [ENTER, COMMA];

  constructor(
    public dialogRef: MatDialogRef<DialogoNuevaPalabraComponent>,
    @Inject(MAT_DIALOG_DATA) public data: any,
    private formBuilder: FormBuilder,
    private palabraFraseService: PalabraFraseService,
    private significadoService: SignificadoService
  ) {
    this.formulario = this.formBuilder.group({
        texto: ['', Validators.required],
        significados: this.formBuilder.array([], Validators.required),
        tipo: ['', Validators.required],
        dificultad: ['', Validators.required],
        nuevoSignificado: ['']
    });
  }

  // Los métodos agregados/movidos
  get significadosArray(): FormArray {
    return this.formulario.get('significados') as FormArray;
  }

  registrar(): void {
    if (this.formulario.valid) {
      const palabra = this.formulario.value;
      this.palabraFraseService.registrarPalabra(palabra).subscribe(response => {
        alert('Registro exitoso!');
        this.dialogRef.close();
      }, error => {
        alert('Error al registrar');
      });
    } else {
      alert('Complete todos los campos obligatorios.');
    }
  }

  cancelar(): void {
    this.dialogRef.close();
  }

  agregarSignificadoDesdeBoton(): void {
    const value = this.formulario.get('nuevoSignificado')?.value.trim();
    const significados = this.formulario.get('significados') as FormArray;
    if (value && significados.length < 5) {
      this.significadoService.registrarSignificado({ texto: value }).subscribe(response => {
        significados.push(this.formBuilder.control(value));
        this.formulario.get('nuevoSignificado')?.setValue('');
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
    if (value) {
      const significados = this.formulario.get('significados') as FormArray;
      significados.push(this.formBuilder.control(value));
      if (input) {
        input.value = '';
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

