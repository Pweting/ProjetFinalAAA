import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Formation } from '../model/formation';

@Injectable({
  providedIn: 'root'
})
export class FormationService {

  private url: string = 'http://localhost:8080/finalaaa/rest/formation';

  constructor(private http: HttpClient) { }

  public list(): Observable<Formation[]> {
    return this.http.get<Formation[]>(`${this.url}`);
  }

  public findById(id: number): Observable<Formation> {
    return this.http.get<Formation>(`${this.url}/${id}`);
  }

  public FormationWithStagiaire(id: number): Observable<Formation> {
    return this.http.get<Formation>(`${this.url}/{stagiaires}`);
  }

  public FormationWithModule(id: number): Observable<Formation> {
    return this.http.get<Formation>(`${this.url}/{modules}`);
  }

  public delete(id: number): Observable<any> {
    return this.http.delete(`${this.url}/${id}`);
  }

  public save(f: Formation): Observable<any> {
    return this.http.post<any>(`${this.url}/{formation}`, f);
  }

  public update(f: Formation): Observable<Formation> {
    return this.http.put<Formation>(`${this.url}/{formation}`, f);
  }
}
