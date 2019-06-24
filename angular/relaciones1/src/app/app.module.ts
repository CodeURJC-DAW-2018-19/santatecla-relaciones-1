import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { RelationComponent } from './relation/relation.component';
import { RecordComponent } from './record/record.component';
import { RelationsComponent } from './relations/relations.component';
import { RecordsComponent } from './records/records.component';
import { UnitComponent } from './unit/unit.component';

@NgModule({
  declarations: [
    AppComponent,
    RelationComponent,
    RecordComponent,
    RelationsComponent,
    RecordsComponent,
    UnitComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
