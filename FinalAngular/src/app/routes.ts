import {EditMaterielComponent} from './materiel/edit-materiel/edit-materiel.component';
import {MaterielComponent} from './materiel/materiel.component';
import {FormationComponent} from './formation/formation.component';
import {DashboardComponent} from './dashboard/dashboard.component';
import {DemoComponent} from './demo/component';
import {MatiereComponent} from './matiere/matiere.component';
import {RhComponent} from './rh/rh.component';
import {Routes} from '@angular/router';
import {EditComponent} from './formation/edit/edit.component';
import { RhDetailComponent } from './rh/rh-detail.component';


export const routes: Routes = [
  {path: '', component: DashboardComponent},
  {path: 'formation', component: FormationComponent},
  {path: 'formation/edit', component: EditComponent},
  {path: 'formation/edit/:id', component: EditComponent},
  {path: 'materiel/edit', component: EditMaterielComponent},
  {path: 'materiel/edit/:id', component: EditMaterielComponent},
  {path: 'matiere', component: MatiereComponent},
  {path: 'rh', component: RhComponent},
  {path: 'rh/edit', component: RhDetailComponent},
  {path: 'rh/edit/:id', component: RhDetailComponent},
  {path: 'materiel', component: MaterielComponent},
  {path: 'calendar', component: DemoComponent},
];
