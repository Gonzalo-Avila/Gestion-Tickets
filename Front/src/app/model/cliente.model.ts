import {Contacto} from './contacto.model';

export class Cliente{

  constructor(public id: number,
              public razonSocial: string,
              public direccion: string,
              public encargado: Contacto,
              public contactos: Contacto[],
              public informacion: string)
              {
  }

}
