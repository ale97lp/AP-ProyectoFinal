import { Component, OnInit } from '@angular/core';
import { Acercade } from 'src/app/model/acercade';
import { persona } from 'src/app/model/persona.model';
import { SAcercadeService } from 'src/app/service/acercade.service';
import { PersonaService } from 'src/app/service/persona.service';
import { TokenService } from 'src/app/service/token.service';

@Component({
  selector: 'app-acerca-de',
  templateUrl: './acerca-de.component.html',
  styleUrls: ['./acerca-de.component.css']
})
export class AcercaDeComponent implements OnInit {
  persona: persona = new persona("","","");
  acercademi: Acercade[] = [];

  constructor(public personaService: PersonaService, private acercadeS: SAcercadeService, private tokenService: TokenService) { }

  isLogged = false;

  ngOnInit(): void {
    this.personaService.getPersona().subscribe(data => {this.persona = data});
    
    this.cargarAcercade();
    if(this.tokenService.getToken()){
      this.isLogged = true;
    } else {
      this.isLogged = false;
    }
  }

  cargarAcercade(): void{
    this.acercadeS.lista().subscribe(
      data =>{
        this.acercademi = data;
      }
    )
  }

}
