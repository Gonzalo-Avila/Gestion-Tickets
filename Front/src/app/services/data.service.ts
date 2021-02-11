import {Injectable} from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {Caso} from '../model/caso.model';
import {Observable} from 'rxjs';
import {Cliente} from '../model/cliente.model';

@Injectable()
export class Data {

  constructor(private clienteHTTP: HttpClient) { }
  obtenerListadoDeCasos(): Observable<unknown>{
    return this.clienteHTTP.get('http://localhost:8080/casos');
  }
  obtenerCaso(idCaso): Observable<unknown>{
    return this.clienteHTTP.get('http://localhost:8080/casos/' + idCaso.toString());
  }
  crearCaso(caso: Caso): Observable<unknown>{
    return this.clienteHTTP.post('http://localhost:8080/casos/', caso);
  }
  actualizarCaso(caso: Caso): void{
    this.clienteHTTP.put('http://localhost:8080/casos/' + caso.id.toString(), caso).subscribe(
      response => console.log(response),
      error => console.log(error)
    );
  }
  obtenerListadoDeClientes(): Observable<unknown>{
    return this.clienteHTTP.get('http://localhost:8080/clientes');
  }
  obtenerCliente(idCliente): Observable<unknown>{
    return this.clienteHTTP.get('http://localhost:8080/clientes/' + idCliente.toString());
  }
  crearCliente(cliente: Cliente): Observable<unknown>{
    return this.clienteHTTP.post('http://localhost:8080/clientes/', cliente);
  }
  obtenerListadoDeContactos(): Observable<unknown>{
    return this.clienteHTTP.get('http://localhost:8080/contactos');
  }
  obtenerContacto(idContacto): Observable<unknown>{
    return this.clienteHTTP.get('http://localhost:8080/contactos/' + idContacto.toString());
  }
  obtenerCategoriasDisponibles(): Observable<unknown>{
    return this.clienteHTTP.get('http://localhost:8080/categorias');
  }
  obtenerEstadosDisponibles(): Observable<unknown>{
    return this.clienteHTTP.get('http://localhost:8080/estados');
  }
  obtenerPrioridadesDisponibles(): Observable<unknown>{
    return this.clienteHTTP.get('http://localhost:8080/prioridades');
  }
  obtenerUsuariosDisponibles(): Observable<unknown>{
    return this.clienteHTTP.get('http://localhost:8080/usuarios');
  }


}
