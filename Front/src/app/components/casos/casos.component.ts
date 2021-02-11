import {Component, Injectable, OnInit} from '@angular/core';
import {Data} from '../../services/data.service';
import {Caso} from '../../model/caso.model';
import {FiltrocasosPipe} from '../../pipes/filtrocasos.pipe';
import {Router} from '@angular/router';
import {Cliente} from '../../model/cliente.model';
import {PrioridadCaso} from '../../model/enums/PrioridadCaso';
import {CategoriaCaso} from '../../model/enums/CategoriaCaso';
import {Usuario} from '../../model/usuario.model';
import {EstadoDeCaso} from '../../model/enums/EstadoDeCaso';

@Component({
  selector: 'app-casos',
  templateUrl: './casos.component.html',
  styleUrls: ['./casos.component.css']
})

export class CasosComponent implements OnInit{

  casos: Caso[] = [];
  clientesDisponibles: Cliente[];
  prioridadesDisponibles: PrioridadCaso[];
  estadosDisponibles: EstadoDeCaso[];
  // Filtros
  palabraClave;
  cliente;
  prioridad;
  estado;

  constructor(private dataprovider: Data, private filterPipe: FiltrocasosPipe, private router: Router) {

    this.dataprovider.obtenerListadoDeClientes().subscribe(
      (clientes: Cliente[]) => this.clientesDisponibles = clientes
    );
    this.dataprovider.obtenerPrioridadesDisponibles().subscribe(
      (prioridades: PrioridadCaso[]) => this.prioridadesDisponibles = prioridades
    );
    this.dataprovider.obtenerEstadosDisponibles().subscribe(
      (estados: EstadoDeCaso[]) => this.estadosDisponibles = estados
    );
    /*
    dataprovider.obtenerCategoriasDisponibles().subscribe(
      (categorias: CategoriaCaso[]) => this.categoriasDisponibles = categorias
    );
    dataprovider.obtenerUsuariosDisponibles().subscribe(
      (usuarios: Usuario[]) => this.usuariosDisponibles = usuarios
    );*/

    this.dataprovider.obtenerListadoDeCasos().subscribe(
      (casos: Caso[]) => this.casos = casos
    );
    this.palabraClave = '';
    this.cliente = '';
    this.prioridad = '';
    this.estado = '';

  }
  ngOnInit(): void {
  }
  casosFiltrados(): Caso[]{

    return this.filterPipe.transform(this.casos, this.palabraClave).filter(
      caso =>
        (this.estado === '' || caso.estado === this.estado) &&
        (this.prioridad === '' || caso.prioridad === this.prioridad) &&
        (this.cliente === '' || (caso.cliente !== null && caso.cliente.razonSocial === this.cliente)));
  }
  //Preferible usar href
  redirigirACaso(idCaso: number): void{
    this.router.navigate(['casos/' + idCaso]);
  }
  redirigirAHome(): void{
    this.router.navigate(['']);
  }
  nuevoCaso(): void{
    this.router.navigate(['casos/nuevo']);
  }


}
