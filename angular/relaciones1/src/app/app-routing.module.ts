import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { UnitComponent } from './unit/unit.component';
import { UnitsComponent } from './units/units.component';
import { LoginComponent } from './login/login.component';

const routes: Routes = [
  { path: '', component: UnitsComponent},
  { path: 'unit/:id', component: UnitComponent },
  { path: 'login', component: LoginComponent},
  { path: 'logout', component: LoginComponent},
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
