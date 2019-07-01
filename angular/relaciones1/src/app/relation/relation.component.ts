import { Component, OnInit, Input } from '@angular/core';
import { RelationInfo } from '../dtos/relation-info';
import { UnitInfo } from '../dtos/unit-info';
import { UnitService } from '../unit.service';
import { LoginService } from '../login.service';
import { RelationService } from '../relation.service';


@Component({
  selector: 'app-relation',
  templateUrl: './relation.component.html',
  styleUrls: ['./relation.component.scss']
})
export class RelationComponent implements OnInit {

  @Input() unitId: number;
  @Input() name: string;
  @Input() relatedUnits: UnitInfo[];
  @Input() type:string;
  units:UnitInfo[];
  opositeUnit: RelationInfo[];
  newRelationOpId:number;
  showAddRelationForm:boolean;
  
  
  
  constructor(
    private relationService: RelationService,
    public loginService:LoginService,
    private unitService: UnitService

  ) { }

  ngOnInit() {
    this.showAddRelationForm = false;
    this.newRelationOpId = null;
    this.unitService.getUnits().subscribe(
      units => {
        this.units = units;

      }
    )
      
    
  }



  addRelation() {
    let relation: RelationInfo;
    relation = new RelationInfo();
    relation.opositeUnitId = this.newRelationOpId;
    relation.type = this.type;
    this.relationService.addRelation(this.unitId,relation)
      .subscribe(unit =>{
        this.showAddRelationForm = false;
        this.relatedUnits = [];
        unit.relations.filter(relation => relation.type === this.type)
          .forEach(relation => this.unitService.getUnit(relation.opositeUnitId)
            .subscribe(unit => this.relatedUnits.push(unit)));

      })
  }

  deleteRelation(id:number){
    this.relationService.deleteRelation(this.unitId, id)
      .subscribe(unit => {
        this.relatedUnits = [];
        unit.relations.filter(relation => relation.type === this.type)
          .forEach(relation => this.unitService.getUnit(relation.opositeUnitId)
            .subscribe(unit => this.relatedUnits.push(unit)));
      })

  }

}
