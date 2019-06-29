import { Component, OnInit, Input } from '@angular/core';
import { RecordInfo } from '../dtos/record-info'

@Component({
  selector: 'app-record',
  templateUrl: './record.component.html',
  styleUrls: ['./record.component.scss']
})
export class RecordComponent implements OnInit {

  @Input() unitId: number;
  @Input() key: string;
  @Input() value: string;

  constructor(
  ) { }

  ngOnInit() {
  }

}
