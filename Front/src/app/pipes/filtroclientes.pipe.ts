import { Pipe, PipeTransform } from '@angular/core';
import {Cliente} from '../model/cliente.model';

@Pipe({ name: 'appFiltroClientes' })
export class FiltroclientesPipe implements PipeTransform {

  transform(clientes: Cliente[], searchText: string): Cliente[] {

    if (!clientes) {
      return [];
    }
    if (!searchText) {
      return clientes;
    }
    searchText = searchText.toLocaleLowerCase();

    return clientes.filter(it => {
       return it.id.toLocaleString().includes(searchText) ||
         (it.razonSocial != null && it.razonSocial.toLocaleLowerCase().includes(searchText)) ||
         (it.direccion != null && it.direccion.toLocaleLowerCase().includes(searchText)) ||
         (it.encargado != null && (it.encargado.nombre.toLocaleLowerCase().includes(searchText) ||
         it.encargado.apellido.toLocaleLowerCase().includes(searchText)));
    });
  }
}
