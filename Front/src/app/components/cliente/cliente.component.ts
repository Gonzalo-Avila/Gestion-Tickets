import { Component, OnInit } from '@angular/core';
import {Caso} from '../../model/caso.model';
import {ActivatedRoute, Router} from '@angular/router';
import {Data} from '../../services/data.service';
import {Cliente} from '../../model/cliente.model';

@Component({
  selector: 'app-cliente',
  templateUrl: './cliente.component.html',
  styleUrls: ['./cliente.component.css']
})
export class ClienteComponent implements OnInit {

  idCliente: number;
  cliente: Cliente;
  constructor(private route: ActivatedRoute, private data: Data, private router: Router) { }

  ngOnInit(): void {

    this.idCliente = this.route.snapshot.params['idcliente'];
    this.data.obtenerCliente(this.idCliente).subscribe(
      (cliente: Cliente) => this.cliente = cliente
    );
  }
  redirigirAContacto(idContacto): void{
    this.router.navigate(['contactos/' + idContacto]);
  }


}
