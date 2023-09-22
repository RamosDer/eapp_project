import { PalabraFrase } from './palabraFrase.model';

export interface Significado {
    idSignificado?: number;
    descripcion: string;
    palabraFrase: PalabraFrase;
    fechaRegistro?: Date;
}