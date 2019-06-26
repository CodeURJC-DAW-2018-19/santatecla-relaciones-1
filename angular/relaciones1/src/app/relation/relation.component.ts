import { Component, OnInit, Input } from '@angular/core';
import { RelationInfo } from '../dtos/relation-info';
import { UnitInfo } from '../dtos/unit-info';
import { UnitService } from '../unit.service';
import { Observable, of } from 'rxjs';

@Component({
  selector: 'app-relation',
  templateUrl: './relation.component.html',
  styleUrls: ['./relation.component.scss']
})
export class RelationComponent implements OnInit {

  @Input() unitId: number;
  @Input() name: string;
  @Input() relatedUnits: UnitInfo[];
  
  constructor(
  ) { }

  ngOnInit() {
  }

}
