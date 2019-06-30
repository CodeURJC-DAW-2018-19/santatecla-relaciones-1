import { Injectable } from '@angular/core';
import { HttpHeaders, HttpClient } from '@angular/common/http';
import { UnitInfo } from './dtos/unit-info';
import { RelationInfo } from './dtos/relation-info';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class RelationService {

  baseUrl: string = "https://localhost:8443";
  httpOptions = {
    headers: new HttpHeaders({ 'Content-Type': 'application/json'})
  }

  constructor(
    private http:HttpClient
  ) { }

  addRelation (unitId: number, relation:RelationInfo):Observable<UnitInfo> {
    if(unitId!== undefined || relation.opositeUnitId !== undefined || relation.type !== null){
      let data = {
        id: unitId,
        relation: relation
      }
      return this.http.post<UnitInfo>(this.baseUrl + '/addRelation', JSON.stringify(data), this.httpOptions);
    }
  }

  deleteRelation (id: number, relatedId:number): Observable<UnitInfo>{
    return this.http.delete<UnitInfo>(this.baseUrl + '/deleteRelation/' + id + '/' + relatedId);
  }
}
