import { MaterielComponent } from './materiel/materiel.component';
import { FormationComponent } from './formation/formation.component';
import { DashboardComponent } from './dashboard/dashboard.component';
import { MatiereComponent } from './matiere/matiere.component';
import { RhComponent } from './rh/rh.component';
import { Routes } from '@angular/router';
import { EditComponent } from './formation/edit/edit.component';


export const routes: Routes = [
    { path: '', component: DashboardComponent },
    { path: 'formation', component: FormationComponent },
    { path: 'formation/edit', component: EditComponent },
    { path: 'matiere', component: MatiereComponent },
    { path: 'rh', component: RhComponent },
    { path: 'materiel', component: MaterielComponent },
];
