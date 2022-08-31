import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Acercade } from '../model/acercade';

@Injectable({
  providedIn: 'root'
})
export class SAcercadeService {
  acercURL = 'http://localhost:8080/acercademi/';

  constructor(private httpClient : HttpClient) { }

  public lista(): Observable<Acercade[]>{
    return this.httpClient.get<Acercade[]>(this.acercURL + 'lista');
  }

  public detail(id: number): Observable<Acercade>{
    return this.httpClient.get<Acercade>(this.acercURL + `detail/${id}`);
  }

  public save(acercade: Acercade): Observable<any>{
    return this.httpClient.post<any>(this.acercURL + 'create', acercade);
  }

  public update(id: number, acercade: Acercade): Observable<any>{
    return this.httpClient.put<any>(this.acercURL + `update/${id}`, acercade);
  }

}