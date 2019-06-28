import { Injectable } from "@angular/core";
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Observable } from 'rxjs';
import { catchError } from 'rxjs/operators';
import { RecordInfo } from './dtos/record-info';
import { UnitInfo } from './dtos/unit-info'

const URL = '/';

@Injectable()
export class RecordService{
    constructor(private http: HttpClient){}

    getRecords(unitId:number){
        return this.http.get<RecordInfo[]>(URL + '/unit/' + unitId)
        .pipe(catchError((error) => this.handleError(error)));
    }
    
    addRecord(unit: UnitInfo, record: RecordInfo) {
		if(unit !== undefined || record.value !== null){
			return this.http.post<RecordInfo>(URL + '/unit/'+ unit.id, record)
			.pipe(catchError((error) => this.handleError(error)));
		}
    }

    /*modifyRecord(unit: UnitInfo, record: RecordInfo){
        this.http.delete(URL + unit.id)
            .pipe(catchError((error) => this.handleError(error)));
        return this.http.post(URL + unit.id, record)
            .pipe(catchError((error) => this.handleError(error)));
    }*/
    
    private handleError(error: any) {
		console.error(error);
		return Observable.throw("Server error (" + error.status + "): " + error.text())
	}
}