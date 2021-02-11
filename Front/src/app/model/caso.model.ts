import {Cliente} from './cliente.model';
import {Usuario} from './usuario.model';
import {EstadoDeCaso} from './enums/EstadoDeCaso';
import {PrioridadCaso} from './enums/PrioridadCaso';
import {CategoriaCaso} from './enums/CategoriaCaso';
import {Comentario} from './comentario.model';
import DateTimeFormat = Intl.DateTimeFormat;

export class Caso{
  constructor(public id: number,
              public cliente: Cliente,
              public prioridad: PrioridadCaso,
              public categoria: CategoriaCaso,
              public titulo: string,
              public descripcion: string,
              public resolucion: string,
              public usuarioAsignado: Usuario,
              public estado: EstadoDeCaso,
              public fechaApertura: Date,
              public fechaCierre: Date,
              public comentarios: Comentario[]) {
  }

}
