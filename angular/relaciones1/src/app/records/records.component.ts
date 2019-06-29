import { Component, OnInit, Input } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { UnitComponent } from '../unit/unit.component';
import { RecordInfo } from '../dtos/record-info';

@Component({
  selector: 'app-records',
  templateUrl: './records.component.html',
  styleUrls: ['./records.component.scss']
})
export class RecordsComponent implements OnInit {

  @Input() unitId: number;
  @Input() records: RecordInfo[];

  constructor(
  ) { }

  ngOnInit() {
    
  }

}
