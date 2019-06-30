import { Component, OnInit } from '@angular/core';
import { UnitService } from '../unit.service';
import { UnitInfo } from '../dtos/unit-info';

@Component({
  selector: 'app-units',
  templateUrl: './units.component.html',
  styleUrls: ['./units.component.scss']
})
export class UnitsComponent implements OnInit {

  units: UnitInfo[];
  loading: boolean;
  showAddUnitForm: boolean;
  newUnit: string;
  
  constructor(
    private unitService: UnitService
  ) { }

  ngOnInit() {
    this.loading = true;
    this.showAddUnitForm = false;
    this.unitService.getUnits()
      .subscribe(response => {
        this.units = response;
        this.loading = false;
      });
  }

  OnSubmit() {
    this.addUnit();
  }

  deleteUnit(id: number) {
    this.loading = true;
    this.unitService.deleteUnit(id)
      .subscribe(response => {
        this.units = response;
        this.loading = false;
      });
  }

  addUnit () {
    this.loading = true;
    let unit: UnitInfo;
    unit = new UnitInfo();
    unit.name = this.newUnit;
    this.unitService.addUnit(unit)
      .subscribe(units => {
        this.newUnit = '';
        this.showAddUnitForm = false;
        this.units = units;
        this.loading = false;
      });
  }
}
