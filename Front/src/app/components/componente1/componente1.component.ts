import {Component} from '@angular/core';

@Component({
  selector: 'app-componente1',
  templateUrl: './componente1.component.html',
})

export class Componente1Component{
  variable1 = 'Esto es una variable String';
  variable2 = 25;

  getMensaje(): string{
    return 'Esto es un metodo';
  }
}
