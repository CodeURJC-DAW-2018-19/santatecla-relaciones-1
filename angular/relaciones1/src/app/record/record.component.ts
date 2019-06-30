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
  @ViewChild('recordDialog', {static:false}) recordDialog: TemplateRef<any>;
  dialogRef: MatDialogRef<any,any>;


  constructor(
    private route: ActivatedRoute,
    private recordService: RecordService,
    public dialog: MatDialog,
    public loginService: LoginService
  ) { }

  editRecord(unitId: number, value: string){
    this.recordService.editRecord(unitId, value);
  }

  openRecordDialog() {
    this.dialogRef = this.dialog.open(this.recordDialog, {
      width: '50%',
      height: '50%',
    });
  }

}
