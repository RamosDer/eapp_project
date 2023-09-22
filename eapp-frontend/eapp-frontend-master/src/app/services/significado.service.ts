import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { environment } from '../../environments/environment';  // Asegúrate de que la ruta sea correcta.

@Injectable({
  providedIn: 'root'
})
export class SignificadoService {

  private baseURL = `http://localhost:8080/significados`;  // Asegúrate de que apiUrl esté definido en tu archivo environment.

  constructor(private http: HttpClient) { }

  // Registrar un nuevo significado
  registrarSignificado(significado: any): Observable<any> {
    return this.http.post(this.baseURL, significado);
  }

  // Obtener todos los significados de una palabra en particular
  obtenerSignificadosPorPalabra(idPalabraFrase: number): Observable<any> {
    return this.http.get(`${this.baseURL}/porPalabra/${idPalabraFrase}`);
  }

  // Actualizar un significado
  actualizarSignificado(idSignificado: number, significado: any): Observable<any> {
    return this.http.put(`${this.baseURL}/${idSignificado}`, significado);
  }

  // Eliminar un significado
  eliminarSignificado(idSignificado: number): Observable<any> {
    return this.http.delete(`${this.baseURL}/${idSignificado}`);
  }
}
