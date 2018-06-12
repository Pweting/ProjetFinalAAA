import {RH} from '../model/rh';
import {HttpClient} from '@angular/common/http';
import {Injectable} from '@angular/core';
import {Observable} from 'rxjs';

@Injectable({
  providedIn: 'root'
})

export class RhService {

  private url: string = 'http://localhost:8080/finalaaa/rest/rh';

  constructor(private http: HttpClient) {}

  public list(): Observable<RH[]> {
    return this.http.get<RH[]>(`${this.url}`);
  }

  public findById(id: number): Observable<RH> {
    return this.http.get<RH>(`${this.url}/${id}`);
  }

  public delete(id: number): Observable<any> {
    return this.http.delete(`${this.url}/${id}`);
  }

  public saveFormateur(r: RH): Observable<RH> {
    return this.http.put<RH>(`${this.url}/formateur`, r);
  }
  public RHWithFormateur(id: number): Observable<RH> {
    return this.http.get<RH>(`${this.url}/{formateur}`);
  }
  public createFormateur(r: RH): Observable<any> {
    return this.http.post<RH>(`${this.url}/formateur`, r);
  }

  public saveStagiaire(r: RH): Observable<RH> {
    return this.http.put<RH>(`${this.url}/stagiaire`, r);
  }
  public RHWithStagiaire(id: number): Observable<RH> {
    return this.http.get<RH>(`${this.url}/{stagiaire}`);
  }
  public createStagiaire(r: RH): Observable<any> {
    return this.http.post<RH>(`${this.url}/stagiaire`, r);
  }

  public saveGestionnaire(r: RH): Observable<RH> {
    return this.http.put<RH>(`${this.url}/gestionnaire`, r);
  }
  public RHWithGestionnaire(id: number): Observable<RH> {
    return this.http.get<RH>(`${this.url}/{gestionnaire}`);
  }
  public createGestionnaire(r: RH): Observable<any> {
    return this.http.post<RH>(`${this.url}/gestionnaire`, r);
  }
  public saveTechnicien(r: RH): Observable<RH> {
    return this.http.put<RH>(`${this.url}/technicien`, r);
  }
  public RHWithTechnicien(id: number): Observable<RH> {
    return this.http.get<RH>(`${this.url}/{technicien}`);
  }
  public createTechnicien(r: RH): Observable<any> {
    return this.http.post<RH>(`${this.url}/technicien`, r);
  }
}
