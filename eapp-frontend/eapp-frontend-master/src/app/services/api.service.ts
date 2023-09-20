import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';

const BASE_URL = 'http://localhost:8080/palabrasfrases';

@Injectable({
  providedIn: 'root'
})
export class ApiService {
    constructor(private http: HttpClient) {}

    registrarPalabra(palabra: any) {
        return this.http.post(`${BASE_URL}/`, palabra);
    }

    actualizarAprendido(id: number, aprendido: boolean) {
        return this.http.put(`${BASE_URL}/actualizarAprendido/${id}?aprendido=${aprendido}`, {});
    }
}
