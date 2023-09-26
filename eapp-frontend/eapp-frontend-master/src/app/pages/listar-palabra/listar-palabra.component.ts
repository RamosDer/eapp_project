import { Component, OnInit, AfterViewInit, ViewChild } from '@angular/core';
import { Router } from '@angular/router';
import { MatPaginator } from '@angular/material/paginator';
import { MatTableDataSource } from '@angular/material/table';
import { ApiService } from '../../services/api.service';
import { PalabraFraseService } from 'src/app/services/palabraFrase.service';
import { TipoService } from '../../services/tipo.service';
import { MatDialog } from '@angular/material/dialog';
import { DialogoNuevaPalabraComponent } from '../dialogo-nueva-palabra/dialogo-nueva-palabra.component';

@Component({
  selector: 'app-listar-palabra',
  templateUrl: './listar-palabra.component.html',
  styleUrls: ['./listar-palabra.component.css']
})
export class ListarPalabraComponent implements OnInit, AfterViewInit {
  listaPalabras = new MatTableDataSource<any>();
  listaPalabrasCompleta: any[] = [];

  @ViewChild(MatPaginator) paginator: MatPaginator | undefined;

  constructor(
      private apiService: ApiService, 
      private router: Router, 
      private palabraFraseService: PalabraFraseService,
      private tipoService: TipoService,
      private dialog: MatDialog
  ) {}

  ngOnInit(): void {
    this.tipoService.obtenerTipos().subscribe(tipos => {
      console.log('Tipos obtenidos:', tipos);
      // Haz lo que necesites con los tipos aquí.
    }, error => {
      console.error('Error al obtener los tipos:', error);
    })
  }

  ngAfterViewInit(): void {
    if (this.paginator) {
      this.listaPalabras.paginator = this.paginator;
    }
  }

  filtrarPalabras(terminoBusqueda: string): void {
    if (!terminoBusqueda) {
      this.listaPalabras.data = this.listaPalabrasCompleta;
    } else {
      this.listaPalabras.data = this.listaPalabrasCompleta.filter(palabra =>
        palabra.contenido.toLowerCase().includes(terminoBusqueda.toLowerCase())
      );
    }
  }

  abrirDialogoRegistro(): void {
    const dialogRef = this.dialog.open(DialogoNuevaPalabraComponent, {
        width: '80%',
        data: {}
    });

    dialogRef.afterClosed().subscribe(result => {
        console.log('Dialogo cerrado');
    });
  }
}
