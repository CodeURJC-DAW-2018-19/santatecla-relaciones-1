import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { HttpClientModule, HTTP_INTERCEPTORS } from '@angular/common/http';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { RelationComponent } from './relation/relation.component';
import { RecordComponent } from './record/record.component';
import { RelationsComponent } from './relations/relations.component';
import { RecordsComponent } from './records/records.component';
import { UnitComponent } from './unit/unit.component';
import { LoginComponent } from './login/login.component';
import { LoginService } from './login.service';
import { BasicAuthInterceptor } from './login/auth.interceptor';
import { ErrorInterceptor } from './login/error.interceptor';

@NgModule({
  declarations: [
    AppComponent,
    RelationComponent,
    RecordComponent,
    RelationsComponent,
    RecordsComponent,
    UnitComponent,
    LoginComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule
  ],
  providers: [LoginService,
    { provide: HTTP_INTERCEPTORS, useClass: BasicAuthInterceptor, multi:true },
    { provide: HTTP_INTERCEPTORS, useClass: ErrorInterceptor, multi:true }
  ],
  bootstrap: [AppComponent]
})
export class AppModule { }
