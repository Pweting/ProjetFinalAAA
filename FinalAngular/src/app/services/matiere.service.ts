import {Matiere} from '../model/matiere';
import {HttpClient} from '@angular/common/http';
import {Injectable} from '@angular/core';
import {Observable} from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class MatiereService {

  private url: string = 'http://localhost:8080/finalaaa/rest/matiere';

  constructor(private http: HttpClient) {}

  public list(): Observable<Matiere[]> {
    return this.http.get<Matiere[]>(`${this.url}`);
  }

  public findById(id: number): Observable<Matiere> {
    return this.http.get<Matiere>(`${this.url}/${id}`);
  }


  public delete(id: number): Observable<any> {
    return this.http.delete(`${this.url}/${id}`);
  }

  public save(m: Matiere): Observable<any> {
    const o = {

    };
    return this.http.post<any>(`${this.url}/matiere`, o);
  }

  public update(m: Matiere): Observable<Matiere> {
    return this.http.put<Matiere>(`${this.url}/matiere`, m);
  }
}
