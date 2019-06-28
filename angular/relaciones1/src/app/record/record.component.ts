import { Component, OnInit, Input } from '@angular/core';

@Component({
  selector: 'app-record',
  templateUrl: './record.component.html',
  styleUrls: ['./record.component.scss']
})
export class RecordComponent implements OnInit {


  @Input() unitId:number;
  @Input() type:string;
  @Input() value:string;
  
  constructor() { }

  ngOnInit() {
  }

}
