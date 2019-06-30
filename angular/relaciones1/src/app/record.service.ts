import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Observable } from 'rxjs';
import { catchError } from 'rxjs/operators';
import { RecordInfo } from './dtos/record-info';
import { UnitInfo } from './dtos/unit-info'
import { Injectable } from '@angular/core';

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
			  return this.http.post<UnitInfo>(this.baseUrl + '/add-record', JSON.stringify(data), this.httpOptions)
			  .pipe(catchError((error) => this.handleError(error)));
		  }
    }

    editRecord(unitId: number, value: string): Observable<RecordInfo[]>{
        return this.http.put<RecordInfo[]>(this.baseUrl + '/edit-record',JSON.stringify(value), this.httpOptions)
            .pipe(catchError((error) => this.handleError(error)));
    }
    
    private handleError(error: any) {
		  console.error(error);
		  return Observable.throw("Server error (" + error.status + "): " + error.text())
	  }
}