import { Tipo } from './tipo.model'; // Asegúrate de que la ruta es correcta.

export interface PalabraFrase {
    idPalabraFrase?: number;
    contenido: string;
    dificultad: string;
    aprendido: boolean;
    fechaRegistro?: Date;
    tipo: Tipo;
}
