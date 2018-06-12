import { FormationComponent } from './formation/formation.component';
import { DashboardComponent } from './dashboard/dashboard.component';
import { MatiereComponent } from './matiere/matiere.component';
import { RhComponent } from './rh/rh.component';
import { Routes } from '@angular/router';


export const routes: Routes = [
    { path: '', component: DashboardComponent },
    { path: 'formation', component: FormationComponent },
    { path: 'matiere', component: MatiereComponent },
    { path: 'rh', component: RhComponent }
];
