import { Component, OnInit, Input } from '@angular/core';
import { RelationInfo } from '../dtos/relation-info';
import { RecordInfo } from '../dtos/record-info'
import { UnitService } from '../unit.service';
import { ActivatedRoute } from '@angular/router';
import { UnitInfo } from '../dtos/unit-info';

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
  compositions: UnitInfo[];
  uses: UnitInfo[];
  usedBy: UnitInfo[];
  associatedTo: UnitInfo[];
  associatedBy: UnitInfo[];
  parts: UnitInfo[];
  records: RecordInfo[];
  loading: boolean;
  activeTab: string = 'relations';

  constructor(
    private route: ActivatedRoute,
    private unitService: UnitService) {}

  ngOnInit() {
    const id = this.route.snapshot.paramMap.get('id');

    this.relations = [];
    this.children = [];
    this.parents = [];
    this.records = [];

    if (id) {
      this.id = parseInt(id);
    }
    
    this.loading = true;
    this.unitService.getUnit(this.id)
      .subscribe(res => {
        this.name = res.name;
        this.relations = res.relations;
        this.records = res.records;

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
                  case 'COMPOSITION': {
                    this.compositions.push(unit);
                    break;
                  }
                  case 'USE': {
                    this.uses.push(unit);
                    break;
                  }
                  case 'USE_BY': {
                    this.usedBy.push(unit);
                    break;
                  }
                  case 'ASSOCIATED_TO': {
                    this.associatedTo.push(unit);
                    break;
                  }
                  case 'ASSOCIATED_BY': {
                    this.associatedBy.push(unit);
                    break;
                  }
                  case 'PART': {
                    this.parts.push(unit);
                    break;
                  }
                }
              })
        });

        this.loading = false;
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

  getWhyRecord(): RecordInfo{
    return this.records[0];
  }

}
