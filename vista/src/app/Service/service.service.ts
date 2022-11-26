import { Injectable } from '@angular/core';
import {HttpClient} from '@angular/common/http';
import { Persona } from '../Modelo/Persona';
import { environment } from 'src/environments/environment';

@Injectable({
  providedIn: 'root'
})
export class ServiceService {

  constructor(private http:HttpClient) { }
  
  getPersonas(){
    return this.http.get<Persona[]>(`${environment.apiUrl}/persona/`);
  }
  createPersona(persona:Persona){
    return this.http.post<Persona>(`${environment.apiUrl}/persona/`, persona);
  }

  getPersonaId(id:number){
    return this.http.get<Persona>(`${environment.apiUrl}/persona/${id}`)
  }

  updatePersona(persona:Persona){
    return this.http.put<Persona>(`${environment.apiUrl}/persona/${persona.id}`,persona)
  }

  deletePersona(persona:Persona){
    return this.http.delete<Persona>(`${environment.apiUrl}/persona/${persona.id}`);
  }

}
