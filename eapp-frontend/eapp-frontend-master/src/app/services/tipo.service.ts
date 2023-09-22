import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';

const BASE_URL = 'http://localhost:8080/tipos';

@Injectable({
  providedIn: 'root'
})
export class TipoService {
    constructor(private http: HttpClient) {}

    obtenerTipos() {
        return this.http.get(`${BASE_URL}/`);
    }
}
