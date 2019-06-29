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
import { UnitsComponent } from './units/units.component';
import { LoginComponent } from './login/login.component';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import {
  MatButtonModule,
  MatListModule,
  MatIconModule,
  MatCardModule,
  MatMenuModule,
  MatInputModule,
  MatButtonToggleModule,
  MatProgressSpinnerModule,
  MatSelectModule,
  MatSlideToggleModule,
  MatDialogModule,
  MatSnackBarModule,
  MatToolbarModule,
  MatTabsModule,
  MatSidenavModule,
  MatTooltipModule,
  MatRippleModule,
  MatRadioModule,
  MatGridListModule,
  MatDatepickerModule,
  MatNativeDateModule,
  MatSliderModule,
  MatAutocompleteModule
} from '@angular/material';
import { FormsModule } from '@angular/forms';
import { LoginService } from './login.service';
import { BasicAuthInterceptor } from './login/auth.interceptor';
import { ErrorInterceptor } from './login/error.interceptor';
import { LoadingComponent } from './loading/loading.component';


@NgModule({
  declarations: [
    AppComponent,
    RelationComponent,
    RecordComponent,
    RelationsComponent,
    RecordsComponent,
    UnitComponent,
    UnitsComponent,
    LoginComponent,
    LoadingComponent
  ],
  imports: [
    BrowserModule,
    BrowserAnimationsModule,
    AppRoutingModule,
    HttpClientModule,

    MatButtonModule,
    MatListModule,
    MatIconModule,
    MatCardModule,
    MatMenuModule,
    MatInputModule,
    MatSelectModule,
    MatButtonToggleModule,
    MatSlideToggleModule,
    MatProgressSpinnerModule,
    MatDialogModule,
    MatSnackBarModule,
    MatToolbarModule,
    MatTabsModule,
    MatSidenavModule,
    MatTooltipModule,
    MatRippleModule,
    MatRadioModule,
    MatGridListModule,
    MatDatepickerModule,
    MatNativeDateModule,
    MatSliderModule,
    MatAutocompleteModule,
    MatInputModule,
    FormsModule,
  ],
  providers: [LoginService,
    { provide: HTTP_INTERCEPTORS, useClass: BasicAuthInterceptor, multi: true },
    { provide: HTTP_INTERCEPTORS, useClass: ErrorInterceptor, multi: true },
  ],
  bootstrap: [AppComponent]
})
export class AppModule { }
