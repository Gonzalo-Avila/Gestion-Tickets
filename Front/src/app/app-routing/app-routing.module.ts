import { NgModule } from '@angular/core';
import {RouterModule, Routes} from '@angular/router';
import {CasosComponent} from '../components/casos/casos.component';
import {HomeComponent} from '../components/home/home.component';
import {CasoComponent} from '../components/caso/caso.component';
import {ClientesComponent} from '../components/clientes/clientes.component';
import {ClienteComponent} from '../components/cliente/cliente.component';
import {NuevocasoComponent} from '../components/nuevocaso/nuevocaso.component';
import {NuevoclienteComponent} from '../components/nuevocliente/nuevocliente.component';

const routes: Routes = [
  {path: '', component: HomeComponent},
  {path: 'casos', component: CasosComponent},
  {path: 'casos/nuevo', component: NuevocasoComponent},
  {path: 'casos/:idcaso', component: CasoComponent},
  {path: 'clientes', component: ClientesComponent},
  {path: 'clientes/nuevo', component: NuevoclienteComponent},
  {path: 'clientes/:idcliente', component: ClienteComponent}
];

@NgModule({
  imports: [
    RouterModule.forRoot(
      routes
    )
  ],
  exports: [
    RouterModule
  ]
})
export class AppRoutingModule { }
