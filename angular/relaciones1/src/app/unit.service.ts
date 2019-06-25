import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { UnitInfo } from './dtos/unit-info';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class UnitService {

  baseUrl: string = "https://localhost:8443";

  constructor(
    private http: HttpClient
  ) { }

  getUnit (id: number): Observable<UnitInfo> {
    return this.http.get<UnitInfo>(this.baseUrl + '/unit/' + id);
  }
}
