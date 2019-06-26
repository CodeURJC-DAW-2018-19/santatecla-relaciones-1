import { Component, OnInit, Input } from '@angular/core';
import { RelationInfo } from '../dtos/relation-info';
import { UnitInfo } from '../dtos/unit-info';

@Component({
  selector: 'app-relations',
  templateUrl: './relations.component.html',
  styleUrls: ['./relations.component.scss']
})
export class RelationsComponent implements OnInit {

  @Input() unitId: number;
  @Input() unitName: string;

  @Input() children: UnitInfo[];
  @Input() parents: UnitInfo[];

  

  constructor() {
  }

  ngOnInit() {
  }

}
