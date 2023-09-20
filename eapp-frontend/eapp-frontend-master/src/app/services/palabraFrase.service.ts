import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class PalabraFraseService {

  private apiUrl = 'http://localhost:8080/palabras'; // Ajusta esto según la URL de tu backend
  private apiSignificadosUrl = 'http://localhost:8080/significados';

  constructor(private http: HttpClient) { }

  registrarPalabra(palabra: any) {  // aquí estamos usando 'any' pero es mejor usar un modelo si lo tuvieras
    return this.http.post(this.apiUrl, palabra);
  }

  agregarSignificado(significado: any) {
    return this.http.post(this.apiSignificadosUrl, significado);
  }

}
