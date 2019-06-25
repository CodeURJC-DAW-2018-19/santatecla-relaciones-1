import { Component, OnInit, Input } from '@angular/core';

@Component({
  selector: 'app-relations',
  templateUrl: './relations.component.html',
  styleUrls: ['./relations.component.scss']
})
export class RelationsComponent implements OnInit {

  @Input() unitName: string;
  
  constructor() { }

  ngOnInit() {
  }

}
