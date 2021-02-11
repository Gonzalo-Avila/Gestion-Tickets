import { Pipe, PipeTransform } from '@angular/core';
import {Caso} from '../model/caso.model';

@Pipe({ name: 'appFiltroCasos' })
export class FiltrocasosPipe implements PipeTransform {

  transform(casos: Caso[], searchText: string): Caso[] {

    if (!casos) {
      return [];
    }
    if (!searchText) {
      return casos;
    }
    searchText = searchText.toLocaleLowerCase();

    return casos.filter(it => {
       return it.id.toLocaleString().includes(searchText) ||
         (it.titulo != null && it.titulo.toLocaleLowerCase().includes(searchText)) ||
         (it.estado != null && it.estado.toString().toLocaleLowerCase().includes(searchText)) ||
         (it.cliente != null && it.cliente.razonSocial.toLocaleLowerCase().includes(searchText));
    });
  }
}
