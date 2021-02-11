import {Component} from '@angular/core';
import {Cliente} from '../../model/cliente.model';
import {PrioridadCaso} from '../../model/enums/PrioridadCaso';
import {Usuario} from '../../model/usuario.model';
import {Data} from '../../services/data.service';
import {ActivatedRoute, Router} from '@angular/router';
import {CategoriaCaso} from '../../model/enums/CategoriaCaso';
import {Caso} from '../../model/caso.model';
import {EstadoDeCaso} from '../../model/enums/EstadoDeCaso';

@Component({
  selector: 'app-nuevocaso',
  templateUrl: './nuevocaso.component.html',
  styleUrls: ['./nuevocaso.component.css']
})
export class NuevocasoComponent {

  // Datos del back para el form
  clientesDisponibles: Cliente[];
  prioridadesDisponibles: PrioridadCaso[];
  categoriasDisponibles: CategoriaCaso[];
  usuariosDisponibles: Usuario[];
  // Datos del input
  clienteElegido;
  usuarioElegido;
  prioridadElegida: PrioridadCaso;
  categoriaElegida: CategoriaCaso;
  tituloElegido: string;
  descripcionElegida: string;
  // Caso a crear
  nuevoCaso: Caso;
  // Caso creado
  casoCreado: Caso;
  // Validaciones
  camposinvalidos: boolean;

  constructor(private route: ActivatedRoute, private dataprovider: Data, private router: Router)
  {
    this.dataprovider.obtenerListadoDeClientes().subscribe(
      (clientes: Cliente[]) => this.clientesDisponibles = clientes
    );
    this.dataprovider.obtenerPrioridadesDisponibles().subscribe(
      (prioridades: PrioridadCaso[]) => this.prioridadesDisponibles = prioridades
    );
    this.dataprovider.obtenerCategoriasDisponibles().subscribe(
      (categorias: CategoriaCaso[]) => this.categoriasDisponibles = categorias
    );
    this.dataprovider.obtenerUsuariosDisponibles().subscribe(
      (usuarios: Usuario[]) => this.usuariosDisponibles = usuarios
    );
    this.camposinvalidos = false;
    this.clienteElegido = '';
    this.usuarioElegido = '';
    this.prioridadElegida = PrioridadCaso.ALTA;
    this.categoriaElegida = CategoriaCaso.OTRA;
    this.tituloElegido = '';
    this.descripcionElegida = '';
    this.nuevoCaso = new Caso(null, null, null, null, null, null, null, null, null, null, null, null);
  }
  camposValidos(): boolean{
    return this.tituloElegido !== null && this.tituloElegido !== '';
  }
  crearCaso(): void{
    if (this.camposValidos()){
      this.nuevoCaso.prioridad = this.prioridadElegida;
      this.nuevoCaso.categoria = this.categoriaElegida;
      this.nuevoCaso.titulo = this.tituloElegido;
      this.nuevoCaso.descripcion = this.descripcionElegida;
      this.nuevoCaso.cliente = this.clientesDisponibles.find(c =>  c.id = this.clienteElegido);
      this.nuevoCaso.usuarioAsignado = this.usuariosDisponibles.find(u => u.id = this.usuarioElegido);
      this.nuevoCaso.estado = EstadoDeCaso.PENDIENTE;
      this.nuevoCaso.fechaApertura = new Date();
      this.dataprovider.crearCaso(this.nuevoCaso).subscribe(
        (caso: Caso) => this.casoCreado = caso,
        (error) => console.log('Hubo un error al crear el caso: ' + error)
      );
      this.router.navigate(['casos']);
    }
    else{
      // document.querySelector('form').reportValidity();
      this.camposinvalidos = true;
    }
  }
  cancelar(): void{
    this.router.navigate(['casos']);
  }

}
