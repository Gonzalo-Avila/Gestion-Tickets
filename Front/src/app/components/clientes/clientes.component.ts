import { Component, OnInit } from '@angular/core';
import {Caso} from '../../model/caso.model';
import {Data} from '../../services/data.service';
import {Router} from '@angular/router';
import {Cliente} from '../../model/cliente.model';
import {FiltroclientesPipe} from '../../pipes/filtroclientes.pipe';

@Component({
  selector: 'app-clientes',
  templateUrl: './clientes.component.html',
  styleUrls: ['./clientes.component.css']
})
export class ClientesComponent implements OnInit {

  clientes: Cliente[] = [];
  filtro = '';
  constructor(private dataprovider: Data, private filterPipe: FiltroclientesPipe, private router: Router) {}

  ngOnInit(): void {
    this.dataprovider.obtenerListadoDeClientes().subscribe(
      (clientes: Cliente[]) => this.clientes = clientes
    );
  }
  clientesFiltrados(): Cliente[]{
    return this.filterPipe.transform(this.clientes, this.filtro);
  }
  //Mejor usar href
  redirigirACliente(idCliente: number): void{
    this.router.navigate(['clientes/' + idCliente]);
  }
  redirigirAHome(): void{
    this.router.navigate(['']);
  }
  nuevoCliente(): void{
    this.router.navigate(['clientes/nuevo']);
  }

}
