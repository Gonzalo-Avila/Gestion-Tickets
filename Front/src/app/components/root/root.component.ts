import {Component} from '@angular/core';
import {ActivatedRoute, Router} from '@angular/router';
import {Data} from '../../services/data.service';

@Component({
  selector: 'app-root',
  templateUrl: './root.component.html',
  styleUrls: ['./root.component.css']
})

export class RootComponent{
  constructor(private route: ActivatedRoute, private dataprovider: Data, private router: Router) {
  }
  redirigirAHome(): void{
    this.router.navigate(['']);
  }

}
