export class Usuario{
  constructor(public id: number,
              public username: string,
              public password: string,
              public nombre: string,
              public apellido: string,
              public email: string,
              public telefono: string,
              public rol: string,
              public fechaAlta: Date)
  {
  }

}
