import { Component, OnInit, Input } from '@angular/core';
import { RelationInfo } from '../dtos/relation-info';
import { UnitService } from '../unit.service';
import { ActivatedRoute } from '@angular/router';
import { UnitInfo } from '../dtos/unit-info';
import { Observable, of } from 'rxjs';

@Component({
  selector: 'app-unit',
  templateUrl: './unit.component.html',
  styleUrls: ['./unit.component.scss']
})
export class UnitComponent implements OnInit {

  @Input() id: number;
  name: string;
  relations: RelationInfo[];
  children: UnitInfo[];
  parents: UnitInfo[];

  activeTab: string = 'relations';

  constructor(
    private route: ActivatedRoute,
    private unitService: UnitService) { }

  ngOnInit() {
    const id = this.route.snapshot.paramMap.get('id');
    const observableRelations = of(this.relations);

    this.relations = [];
    this.children = [];
    this.parents = [];

    if (id) {
      this.id = parseInt(id);
    }
    
    this.unitService.getUnit(this.id)
      .subscribe(res => {
        this.name = res.name;
        this.relations = res.relations;

        this.relations.forEach(relation => {
          this.unitService.getUnit(relation.opositeUnitId)
              .subscribe(unit => {
                switch (relation.type) {
                  case 'CHILD': {
                    this.children.push(unit);
                    break;
                  }
                  case 'PARENT': {
                    this.parents.push(unit);
                    break;
                  }
                }
              })
        });
      });
  }


  setTab(tabName: string) {
    this.activeTab = tabName;
  }

  isInRelations(): boolean {
    return this.activeTab === 'relations';
  }

  isInRecords(): boolean {
    return this.activeTab === 'records';
  }
}
