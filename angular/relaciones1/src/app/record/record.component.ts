import { Component, OnInit, Input } from '@angular/core';
import { UnitInfo } from '../dtos/unit-info';
import { RecordService } from '../record.service'
import { RecordInfo } from '../dtos/record-info'

@Component({
  selector: 'app-record',
  templateUrl: './record.component.html',
  styleUrls: ['./record.component.scss']
})
export class RecordComponent implements OnInit {

  @Input() unitId: number;
  @Input() name: string;
  @Input() value: string;
  records: RecordInfo[];
  service: RecordService;

  constructor(
  ) { }

  ngOnInit() {
  }

  getRecords(unitId: number) {
    this.service.getRecords(unitId).subscribe();
  }

}
