import { routes } from './routes';
import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppComponent } from './app.component';
import { DashboardComponent } from './dashboard/dashboard.component';
import { RouterModule } from '@angular/router';
import { FormationComponent } from './formation/formation.component';
import { RhComponent } from './rh/rh.component';
import { MatiereComponent } from './matiere/matiere.component';

@NgModule({
  declarations: [
    AppComponent,
    DashboardComponent,
    FormationComponent,
    RhComponent,
    MatiereComponent
  ],
  imports: [
    BrowserModule, RouterModule.forRoot(routes)
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
