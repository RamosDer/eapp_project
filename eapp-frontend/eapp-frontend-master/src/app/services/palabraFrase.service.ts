import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { PalabraFrase } from '../modelos/palabraFrase.model';
import { Significado } from '../modelos/significado.model';
import { catchError } from 'rxjs/operators';
import { throwError } from 'rxjs';
import { Observable } from 'rxjs';


@Injectable({
  providedIn: 'root'
})
export class PalabraFraseService {

  private apiUrl = 'http://localhost:8080/palabras';
  private apiSignificadosUrl = 'http://localhost:8080/significados';

  constructor(private http: HttpClient) { }

  registrarPalabra(palabra: PalabraFrase) {
    return this.http.post<PalabraFrase>(this.apiUrl, palabra)
      .pipe(
        catchError(this.handleError)
      );
  }

    // Obtener una palabra o frase por ID
  obtenerPalabraPorId(id: number): Observable<any> {  
    return this.http.get<any>(`${this.apiUrl}/${id}`);
  }

  agregarSignificado(significado: Significado) {
    return this.http.post<Significado>(this.apiSignificadosUrl, significado)
      .pipe(
        catchError(this.handleError)
      );
  }

  private handleError(error: any) {
    console.error('Ocurrió un error:', error); //  manejar el error de una forma más adecuada
    return throwError('Algo salió mal, por favor intenta de nuevo más tarde.');
  }

}
