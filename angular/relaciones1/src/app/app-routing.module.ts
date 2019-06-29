import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { UnitComponent } from './unit/unit.component';
import { UnitsComponent } from './units/units.component';

const routes: Routes = [
  { path: '', component: UnitsComponent},
  { path: 'unit/:id', component: UnitComponent }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
