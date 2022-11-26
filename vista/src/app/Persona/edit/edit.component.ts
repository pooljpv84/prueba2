import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Persona } from 'src/app/Modelo/Persona';
import { ServiceService } from 'src/app/Service/service.service';

@Component({
  selector: 'app-edit',
  templateUrl: './edit.component.html',
  styleUrls: ['./edit.component.css']
})
export class EditComponent implements OnInit {
  modelPersona: Persona=new Persona();
  constructor(private service:ServiceService,private router:Router) { }

  ngOnInit(): void {
    this.Editar();
  }

  Editar(){
    let id=localStorage.getItem("id");
    this.service.getPersonaId(+id!)
    .subscribe(data=>{
      this.modelPersona=data;
    })

  }

  Actualizar(persona:Persona){
    this.service.updatePersona(persona)
    .subscribe(data=>{
      this.modelPersona=data
      alert("Se actualizo la persona")
      this.router.navigate(["listar"]);
    })
  }

}
