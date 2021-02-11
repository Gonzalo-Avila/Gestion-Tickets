import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import {FormBuilder,  FormsModule} from '@angular/forms';
import {HttpClient, HttpClientModule} from '@angular/common/http';

import {AppRoutingModule} from './app-routing/app-routing.module';

import { HomeComponent } from './components/home/home.component';
import {Componente1Component} from './components/componente1/componente1.component';
import {RootComponent} from './components/root/root.component';
import { CasoComponent } from './components/caso/caso.component';
import { CasosComponent } from './components/casos/casos.component';
import { NuevocasoComponent } from './components/nuevocaso/nuevocaso.component';
import { ClienteComponent } from './components/cliente/cliente.component';
import { ClientesComponent } from './components/clientes/clientes.component';
import { NuevoclienteComponent } from './components/nuevocliente/nuevocliente.component';
import { ContactoComponent } from './components/contacto/contacto.component';
import { ContactosComponent } from './components/contactos/contactos.component';

import {Data} from './services/data.service';

import {FiltrocasosPipe} from './pipes/filtrocasos.pipe';
import {FiltroclientesPipe} from './pipes/filtroclientes.pipe';

@NgModule({
  declarations: [
    RootComponent,
    Componente1Component,
    CasosComponent,
    ClientesComponent,
    ContactosComponent,
    FiltrocasosPipe,
    FiltroclientesPipe,
    HomeComponent,
    CasoComponent,
    ClienteComponent,
    NuevocasoComponent,
    NuevoclienteComponent,
    ContactoComponent
  ],
  imports: [
    BrowserModule,
    HttpClientModule,
    FormsModule,
    AppRoutingModule
  ],
  providers: [Data, HttpClient, FiltrocasosPipe, FiltroclientesPipe, FormBuilder],
  bootstrap: [RootComponent]
})
export class AppModule { }
