import { Component, OnInit, Input } from '@angular/core';
import { RelationInfo } from '../dtos/relation-info';
import { UnitInfo } from '../dtos/unit-info';

@Component({
  selector: 'app-relation',
  templateUrl: './relation.component.html',
  styleUrls: ['./relation.component.scss']
})
export class RelationComponent implements OnInit {

  @Input() id: number;
  @Input() name: string;
  @Input() relations: RelationInfo[];

  relatedUnits: UnitInfo[];
  
  constructor() { }

  ngOnInit() {
    this.relations.forEach(relation => {
      this.relatedUnits.push();
    });
  }

}
