import {Usuario} from './usuario.model';

export class Comentario{
  constructor(public usuario: Usuario,
              public fecha: Date,
              public cuerpo: string) {
  }
}
