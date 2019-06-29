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
  
  constructor(
    private unitService: UnitService
  ) { }

  ngOnInit() {
    this.unitService.getUnits()
      .subscribe(response => {
        this.units = response;
      });
  }

}
