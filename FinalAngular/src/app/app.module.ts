import { HttpClientModule } from '@angular/common/http';
import { NgModule } from '@angular/core';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { BrowserModule } from '@angular/platform-browser';
import { RouterModule } from '@angular/router';
import { AppComponent } from './app.component';
import { DashboardComponent } from './dashboard/dashboard.component';
import { DemoUtilsComponent } from './demo-utils/demo-utils.component';
import { DemoModule } from './demo/module';
import { EditComponent } from './formation/edit/edit.component';
import { FormationComponent } from './formation/formation.component';
import { MaterielComponent } from './materiel/materiel.component';
import { MatiereComponent } from './matiere/matiere.component';
import { RhDetailComponent } from './rh/rh-detail.component';
import { RhComponent } from './rh/rh.component';
import { routes } from './routes';
import { FormationService } from './services/formation.service';
import { MaterielService } from './services/materiel.service';
import { RhService } from './services/rh.service';
import { EditMaterielComponent } from './materiel/edit-materiel/edit-materiel.component';
import { EditMatiereComponent } from './matiere/edit-matiere/edit-matiere.component';



@NgModule({
  declarations: [
    AppComponent,
    DashboardComponent,
    FormationComponent,
    RhComponent,
    MatiereComponent,
    MaterielComponent,
    DemoUtilsComponent,
    RhDetailComponent,
    EditComponent,
    EditMaterielComponent,
    EditMatiereComponent
  ],
  imports: [
    BrowserModule, RouterModule.forRoot(routes), HttpClientModule,
    FormsModule, ReactiveFormsModule, DemoModule
  ],
  providers: [FormationService, MaterielService, RhService],
  bootstrap: [AppComponent]
})
export class AppModule { }
