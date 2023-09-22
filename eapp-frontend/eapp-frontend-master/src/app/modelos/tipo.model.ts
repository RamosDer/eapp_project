import { Categoria } from './categoria.model'

export interface Tipo {
    descripcion: string;
    codTipo: string;
    categoriaId?: number;
    categoria?: Categoria;
    fechaRegistro?: Date;
}
