import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Proyectos } from 'src/app/model/proyectos';
import { ProyectosService } from 'src/app/service/proyectos.service';

@Component({
  selector: 'app-new-proyectos',
  templateUrl: './new-proyectos.component.html',
  styleUrls: ['./new-proyectos.component.css']
})
export class NewProyectosComponent implements OnInit {
  nombrePr: string;
  descripcionPr: string;

  constructor(private proyectosS: ProyectosService, private router: Router) { }

  ngOnInit(): void {
  }

    onCreate(): void{
      const proyectos = new Proyectos(this.nombrePr, this.descripcionPr);
      this.proyectosS.save(proyectos).subscribe(data =>{alert("Proyecto añadido correctamente");
      this.router.navigate(['']);
    }, err=>{
      alert("Falló");
      this.router.navigate(['']);
      }
    )
  }
}
