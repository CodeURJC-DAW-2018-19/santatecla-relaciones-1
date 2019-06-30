import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Observable } from 'rxjs';
import { catchError } from 'rxjs/operators';
import { RecordInfo } from './dtos/record-info';
import { UnitInfo } from './dtos/unit-info'
import { Injectable } from '@angular/core';

const URL = '/https://localhost:8443';
const httpOptions = {
    headers: new HttpHeaders({
      'Content-Type':  'application/json',
      'Authorization': 'my-auth-token'
    })
  };

@Injectable({
    providedIn: 'root'
  })
export class RecordService{
    constructor(private http: HttpClient){}
    
    addRecord(unitId: number, record: RecordInfo) {
		if(unitId !== undefined || record.value !== null){
			return this.http.post<RecordInfo>(URL + '/unit/'+ unitId, record)
			.pipe(catchError((error) => this.handleError(error)));
		}
    }

    editRecord(unitId: number, value: string): Observable<{}>{
        this.http.delete(URL + '/unit/' + unitId, httpOptions)
            .pipe(catchError((error) => this.handleError(error)));
        return this.http.post(URL + '/unit/' + unitId, value)
            .pipe(catchError((error) => this.handleError(error)));
    }
    
    private handleError(error: any) {
		console.error(error);
		return Observable.throw("Server error (" + error.status + "): " + error.text())
	}
}