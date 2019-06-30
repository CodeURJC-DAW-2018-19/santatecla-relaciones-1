import { Component, OnInit, Input } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { UnitComponent } from '../unit/unit.component';
import { RecordInfo } from '../dtos/record-info';
import { RecordService } from '../record.service';
import { UnitInfo } from '../dtos/unit-info';

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
    private recordService: RecordService
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
