import { Component, OnInit, Input } from '@angular/core';
import { RelationInfo } from '../dtos/relation-info';
import { UnitInfo } from '../dtos/unit-info';
import { UnitService } from '../unit.service';

@Component({
  selector: 'app-relation',
  templateUrl: './relation.component.html',
  styleUrls: ['./relation.component.scss']
})
export class RelationComponent implements OnInit {

  @Input() id: number;
  @Input() name: string;
  // @Input() relations: RelationInfo[];

  relatedUnits: UnitInfo[];
  
  constructor(
    private unitService: UnitService
  ) { }

  ngOnInit() {
    // this.relations.forEach(relation => {
    //   this.unitService.getUnit(relation.opositeUnitId)
    //     .subscribe(unitInfo => this.relatedUnits.push(unitInfo));
    // });

    this.unitService.getUnit(this.id)
      .subscribe(res => {
        console.log(res)
      })
  }

}
