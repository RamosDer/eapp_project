import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { PalabraFrase } from '../modelos/palabraFrase.model';
import { Significado } from '../modelos/significado.model';
import { catchError } from 'rxjs/operators';
import { throwError, Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class PalabraFraseService {

  private apiBaseUrl = 'http://localhost:8080';  
  private apiUrl = `${this.apiBaseUrl}/palabras`;  
  private apiSignificadosUrl = `${this.apiBaseUrl}/significados`;  

  constructor(private http: HttpClient) { }

  registrarPalabra(palabra: PalabraFrase): Observable<PalabraFrase> {
    return this.http.post<PalabraFrase>(this.apiUrl, palabra)
      .pipe(catchError(this.handleError));
  }

  obtenerPalabraPorId(id: number): Observable<PalabraFrase> {
    return this.http.get<PalabraFrase>(`${this.apiUrl}/${id}`);
  }

  agregarSignificado(significado: Significado): Observable<Significado> {
    return this.http.post<Significado>(this.apiSignificadosUrl, significado)
      .pipe(catchError(this.handleError));
  }

  obtenerTodasLasPalabras(): Observable<PalabraFrase[]> {
    return this.http.get<PalabraFrase[]>(this.apiUrl)
      .pipe(catchError(this.handleError));
  }

  private handleError(error: any) {
    console.error('Ocurrió un error:', error);
    return throwError('Algo salió mal, por favor intenta de nuevo más tarde.');
  }

}
