import { Component, OnInit } from '@angular/core';
import {ActivatedRoute, Router} from '@angular/router';
import {Data} from '../../services/data.service';
import {Cliente} from '../../model/cliente.model';
import {Contacto} from '../../model/contacto.model';

@Component({
  selector: 'app-nuevocliente',
  templateUrl: './nuevocliente.component.html',
  styleUrls: ['./nuevocliente.component.css']
})
export class NuevoclienteComponent implements OnInit {
  // Datos del back
  contactosDisponibles: Contacto[];
  // Valores del input
  razonSocialElegida: string;
  direccionElegida: string;
  informacionElegida: string;
  encargadoElegido;
  // Cliente a crear
  nuevoCliente: Cliente;
  // Cliente
  clienteCreado: Cliente;
  // Validaciones
  camposinvalidos: boolean;

  constructor(private route: ActivatedRoute, private dataprovider: Data, private router: Router){
    this.dataprovider.obtenerListadoDeContactos().subscribe(
      (contactos: Contacto[]) => this.contactosDisponibles = contactos
    );
    this.encargadoElegido = '';
    this.razonSocialElegida = '';
    this.direccionElegida = '';
    this.informacionElegida = '';
    this.camposinvalidos = false;
    this.nuevoCliente = new Cliente(null, '', '', null, [], '');
    this.clienteCreado = new Cliente(null, '', '', null, [], '');
  }
  camposValidos(): boolean{
    return this.razonSocialElegida !== null && this.razonSocialElegida !== '' && this.encargadoElegido !== null && this.encargadoElegido !== '';
  }
  ngOnInit(): void {
  }
  crearCliente(): void {
    if (this.camposValidos()){
      console.log(this.razonSocialElegida);
      console.log(this.encargadoElegido);
      const encargado = this.contactosDisponibles.find(c => c.id = this.encargadoElegido);
      this.nuevoCliente.razonSocial = this.razonSocialElegida;
      this.nuevoCliente.direccion = this.direccionElegida;
      this.nuevoCliente.informacion = this.informacionElegida;
      this.nuevoCliente.encargado = encargado;
      this.nuevoCliente.contactos.push(encargado);
      console.log(this.nuevoCliente.encargado.id);
      this.dataprovider.crearCliente(this.nuevoCliente).subscribe(
        (cliente: Cliente) => console.log('Se creó el cliente ' + cliente.id + ' ' + cliente.razonSocial),
        error => console.log('Hubo un error creando el cliente: ' + error)
      );
      this.router.navigate(['clientes']);
    }
    else{
      this.camposinvalidos = true;
    }
  }
  cancelar(): void {
    this.router.navigate(['clientes']);
  }

}
