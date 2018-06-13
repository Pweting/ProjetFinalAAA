import { VideoProjecteur } from './../model/videoprojecteur';
import { Salle } from './../model/salle';
import { Ordinateur } from './../model/ordinateur';
import { Materiel } from './../model/materiel';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class MaterielService {

  // tslint:disable-next-line:no-inferrable-types
  private url: string = 'http://localhost:8080/finalaaa/rest/materiel';

  constructor(private http: HttpClient) { }

  public list(): Observable<Materiel[]> {
    return this.http.get<Materiel[]>(`${this.url}`);
  }

  public findById(id: number): Observable<Materiel> {
    return this.http.get<Materiel>(`${this.url}/${id}`);
  }

  public delete(id: number): Observable<any> {
    return this.http.delete(`${this.url}/${id}`);
  }

  public saveOrdi(value: Ordinateur): Observable<any> {
    const o = {
      'cout': value.cout,
      'processeur': value.processeur,
      'hdd': value.hdd,
      'ram': value.ram,
      'anneeAchat': value.anneeAchat,
      'type': value.type
    };
    return this.http.post<any>(`${this.url}/ordinateur`, o);
  }
  public saveSalle(value: Salle): Observable<any> {
    const o = {
      'cout': value.cout,
      'nbPersonnes': value.nbPersonnes,
      'type': value.type
    };
    return this.http.post<any>(`${this.url}/salle`, o);
  }
  public saveVideo(value: VideoProjecteur): Observable<any> {
    const o = {
      'cout': value.cout,
      'type': value.type
    };
    return this.http.post<any>(`${this.url}/videoProj`, o);
  }

  public updateOrdi(value: Materiel): Observable<Materiel> {
    return this.http.put<Materiel>(`${this.url}/ordinateur`, value);
  }
  public updateSalle(value: Materiel): Observable<Materiel> {
    return this.http.put<Materiel>(`${this.url}/salle`, value);
  }
  public updateVideo(value: Materiel): Observable<Materiel> {
    return this.http.put<Materiel>(`${this.url}/videoProj`, value);
  }
}
