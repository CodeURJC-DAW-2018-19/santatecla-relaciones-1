import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Observable } from 'rxjs';
import { catchError } from 'rxjs/operators';
import { RecordInfo } from './dtos/record-info';
import { UnitInfo } from './dtos/unit-info'
import { Injectable } from '@angular/core';
import { UniqueSelectionDispatcher } from '@angular/cdk/collections';

@Injectable({
    providedIn: 'root'
  })
export class RecordService{

  baseUrl: string = "https://localhost:8443";
  httpOptions = {
    headers: new HttpHeaders({ 'Content-Type': 'application/json' })
  }
    constructor(private http: HttpClient){}
    
    addRecord(unitId: number, record: RecordInfo): Observable<UnitInfo> {
		  if(unitId !== undefined || record.value !== null){
        let data = {
          id: unitId,
          record: record
        }
			  return this.http.post<UnitInfo>(this.baseUrl + '/addRecord', JSON.stringify(data), this.httpOptions)
			  .pipe(catchError((error) => this.handleError(error)));
		  }
    }

    editRecord(id: number, unitId: number, value: string): Observable<UnitInfo>{
      let data = {
        id: id,
        unitId: unitId,
        value: value
      }
        return this.http.put<UnitInfo>(this.baseUrl + '/editRecord',JSON.stringify(data), this.httpOptions)
            .pipe(catchError((error) => this.handleError(error)));
    }
    
    private handleError(error: any) {
		  console.error(error);
		  return Observable.throw("Server error (" + error.status + "): " + error.text())
	  }
}