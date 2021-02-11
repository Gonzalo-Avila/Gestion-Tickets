import {Component, OnInit} from '@angular/core';
import {ActivatedRoute, Router} from '@angular/router';
import {Data} from '../../services/data.service';
import {Caso} from '../../model/caso.model';
import {EstadoDeCaso} from '../../model/enums/EstadoDeCaso';

@Component({
  selector: 'app-caso',
  templateUrl: './caso.component.html',
  styleUrls: ['./caso.component.css']
})
export class CasoComponent implements OnInit {

  idCaso: number;
  caso: Caso;
  mostrarFormResolucion: boolean;

  constructor(private route: ActivatedRoute, private dataprovider: Data, private router: Router) {
    this.mostrarFormResolucion = false;
  }

  ngOnInit(): void {
    this.mostrarFormResolucion = false;
    this.idCaso = this.route.snapshot.params['idcaso'];
    this.dataprovider.obtenerCaso(this.idCaso).subscribe(
      (caso: Caso) => this.caso = caso
    );
    this.router.onSameUrlNavigation = 'reload';
  }
  cambiarResolucion(event: Event): void{
    this.caso.resolucion = (event.target as HTMLInputElement).value;
  }
  reabrirCaso(): void{
  }
  cerrarCaso(): void{
    this.caso.fechaCierre = new Date();
    this.caso.estado = EstadoDeCaso.CERRADO;
    this.mostrarFormResolucion = false;
    this.dataprovider.actualizarCaso(this.caso);
    this.router.navigate(['casos/' + this.idCaso]);
  }

}
