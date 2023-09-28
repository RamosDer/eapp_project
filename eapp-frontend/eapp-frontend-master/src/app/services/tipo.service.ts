import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Tipo } from '../modelos/tipo.model';

const BASE_URL = 'http://localhost:8080/tipos';

@Injectable({
  providedIn: 'root'
})
export class TipoService {
    constructor(private http: HttpClient) {}

    obtenerTipos(): Observable<Tipo[]> {
        return this.http.get<Tipo[]>(`${BASE_URL}/`);
    }
}
