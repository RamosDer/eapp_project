import { Categoria } from './categoria.model'

export interface Tipo {
    idTipo?: number;
    descripcion: string;
    codTipo: string;
    categoriaId?: number;
    categoria?: Categoria;
}
