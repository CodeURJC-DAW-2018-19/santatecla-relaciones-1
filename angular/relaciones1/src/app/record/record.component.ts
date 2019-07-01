import { Component, OnInit, Input, ViewChild, TemplateRef } from '@angular/core';
import { RecordInfo } from '../dtos/record-info'
import { RecordService } from '../record.service';
import { ActivatedRoute } from '@angular/router';
import { UnitInfo } from '../dtos/unit-info';
import { MatDialogRef, MatDialog } from '@angular/material';
import { LoginService } from '../login.service';

@Component({
  selector: 'app-record',
  templateUrl: './record.component.html',
  styleUrls: ['./record.component.scss']
})
export class RecordComponent {

  @Input() id: number;
  @Input() key: string;
  @Input() value: string;
  @Input() unitId: number;
  newValue: string;
  showEditRecordForm: boolean;

  constructor(
    private recordService: RecordService,
    public loginService: LoginService,
  ) { }

  ngOnInit() {
    this.showEditRecordForm = false;
  }

  editRecord() {
    let value: string;
    value = this.newValue;
    this.recordService.editRecord(this.id,this.unitId,value)
      .subscribe(unit => {
        this.newValue = '';
        this.value = unit.records.filter(record => record.id === this.id)[0].value;
        this.showEditRecordForm = false;
      });
  }

}
