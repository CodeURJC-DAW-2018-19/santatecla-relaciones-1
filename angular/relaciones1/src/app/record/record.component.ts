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

  @Input() unitId: number;
  @Input() key: string;
  @Input() value: string;

  constructor(
    private recordService: RecordService,
    public loginService: LoginService,
  ) { }

  editRecord(unitId: number, value: string){
    this.recordService.editRecord(unitId, value);
  }

}
