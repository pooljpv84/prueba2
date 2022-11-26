import { HttpErrorResponse } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Persona } from 'src/app/Modelo/Persona';
import { ServiceService } from 'src/app/Service/service.service';

@Component({
  selector: 'app-add',
  templateUrl: './add.component.html',
  styleUrls: ['./add.component.css']
})
export class AddComponent implements OnInit {

  modelPersona = new Persona();

  constructor(private service:ServiceService,private router:Router) { }

  ngOnInit(): void {
  }

  guardar(persona:Persona){
    try {
      this.service.createPersona(persona)
      .subscribe(data=>{
        alert("Se guardo la persona");
        this.router.navigate(["listar"]);
      })
    } catch (error) {

    }

  }

}
