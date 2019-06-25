import { Component, OnInit } from '@angular/core';
import { RelationInfo } from '../dtos/relation-info';

@Component({
  selector: 'app-unit',
  templateUrl: './unit.component.html',
  styleUrls: ['./unit.component.scss']
})
export class UnitComponent implements OnInit {

  id: number;
  name: string;
  relations: RelationInfo[];

  constructor() { }

  ngOnInit() {
  }

}
