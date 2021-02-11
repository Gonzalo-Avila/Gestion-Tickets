import { Component } from '@angular/core';
import {Router} from '@angular/router';

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.css']
})
export class HomeComponent {

  constructor(private router: Router) { }

  redirigirACasos(): void{
    this.router.navigate(['casos']);
  }
  redirigirAClientes(): void{
    this.router.navigate(['clientes']);
  }

}
