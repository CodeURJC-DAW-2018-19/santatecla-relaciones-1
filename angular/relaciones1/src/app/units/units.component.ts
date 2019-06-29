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
  
  constructor(
    private unitService: UnitService
  ) { }

  ngOnInit() {
    this.loading = true;
    this.unitService.getUnits()
      .subscribe(response => {
        this.units = response;
        this.loading = false;
      });
  }

}
