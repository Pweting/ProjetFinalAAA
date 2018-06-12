import { RhService } from './services/rh.service';
import { MaterielService } from './services/materiel.service';
import { FormationService } from './services/formation.service';
import { routes } from './routes';
import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { HttpClientModule } from '@angular/common/http';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';

import { AppComponent } from './app.component';
import { DashboardComponent } from './dashboard/dashboard.component';
import { RouterModule } from '@angular/router';
import { FormationComponent } from './formation/formation.component';
import { RhComponent } from './rh/rh.component';
import { MatiereComponent } from './matiere/matiere.component';
import { MaterielComponent } from './materiel/materiel.component';
import { CalendarComponent } from './calendar/calendar.component';


@NgModule({
  declarations: [
    AppComponent,
    DashboardComponent,
    FormationComponent,
    RhComponent,
    MatiereComponent,
    MaterielComponent
  ],
  imports: [
    BrowserModule, RouterModule.forRoot(routes), HttpClientModule,
    FormsModule, ReactiveFormsModule
  ],
  providers: [FormationService, MaterielService, RhService],
  bootstrap: [AppComponent]
})
export class AppModule { }
