import { Component, OnInit, Input } from '@angular/core';
import { RecordInfo } from '../dtos/record-info';
import { RecordService } from '../record.service';
import { UnitInfo } from '../dtos/unit-info';
import { LoginService } from '../login.service';

@Component({
  selector: 'app-records',
  templateUrl: './records.component.html',
  styleUrls: ['./records.component.scss']
})
export class RecordsComponent implements OnInit {

  @Input() unitId: number;
  @Input() records: RecordInfo[];
  @Input() units: UnitInfo[];
  newRecord: string;
  newKey: string;
  showAddRecordForm: boolean;

  constructor(
    private recordService: RecordService,
    private loginService: LoginService,
  ) { }

  ngOnInit() {
    this.showAddRecordForm = false;
  }

  addRecord() {
    let record: RecordInfo;
    record = new RecordInfo();
    record.value = this.newRecord;
    record.key = this.newKey;
    this.recordService.addRecord(this.unitId,record)
      .subscribe(records => {
        this.newRecord = '';
        this.newKey = '';
        this.records = records.records;
        this.showAddRecordForm = false;
      });
  }

}
