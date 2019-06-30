import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders, HttpParams } from '@angular/common/http';
import { UnitInfo } from './dtos/unit-info';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class UnitService {

  baseUrl: string = "https://localhost:8443";
  httpOptions = {
    headers: new HttpHeaders({ 'Content-Type': 'application/json' })
  }

  constructor(
    private http: HttpClient
  ) { }

  getUnit (id: number): Observable<UnitInfo> {
    return this.http.get<UnitInfo>(this.baseUrl + '/unit/' + id);
  }

  getUnits (): Observable<UnitInfo[]> {
    return this.http.get<UnitInfo[]>(this.baseUrl + '/units')
  }

  deleteUnit (id: number): Observable<UnitInfo[]> {
    return this.http.delete<UnitInfo[]>(this.baseUrl + '/deleteUnit/' + id);
  }

  addUnit (unit: UnitInfo): Observable<UnitInfo[]> {
    return this.http.post<UnitInfo[]>(this.baseUrl + '/addUnit', JSON.stringify(unit), this.httpOptions);
  } 
}
