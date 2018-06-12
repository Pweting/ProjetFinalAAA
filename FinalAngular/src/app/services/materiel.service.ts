import { Materiel } from './../model/materiel';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class MaterielService {

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

  public save(value: Materiel): Observable<any> {
    return this.http.post<any>(`${this.url}/{materiel}`, value);
  }

  public update(value: Materiel): Observable<Materiel> {
    return this.http.put<Materiel>(`${this.url}/{materiel}`, value);
  }
}
