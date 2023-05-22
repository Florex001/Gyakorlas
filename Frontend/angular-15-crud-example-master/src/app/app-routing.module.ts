import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { TutorialsListComponent } from './components/tutorials-list/tutorials-list.component';
import { TutorialDetailsComponent } from './components/tutorial-details/tutorial-details.component';
import { AddTutorialComponent } from './components/add-tutorial/add-tutorial.component';

const routes: Routes = [
  // Alapértelmezett útvonal átirányítása a 'tutorials' útvonalra
  { path: '', redirectTo: 'tutorials', pathMatch: 'full' },

  // 'tutorials' útvonal és a hozzá tartozó komponens
  { path: 'tutorials', component: TutorialsListComponent },

  // 'tutorials/:id' útvonal és a hozzá tartozó komponens
  { path: 'tutorials/:id', component: TutorialDetailsComponent },

  // 'add' útvonal és a hozzá tartozó komponens
  { path: 'add', component: AddTutorialComponent }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
