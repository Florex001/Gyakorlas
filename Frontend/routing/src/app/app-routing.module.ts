import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { AppComponent } from './app.component';
import { FelhasznalokComponent } from './Components/felhasznalok/felhasznalok.component';
import { TermekekComponent } from './Components/termekek/termekek.component';
import { TermekeladasComponent } from './Components/termekeladas/termekeladas.component';

const routes: Routes = [
  {path: '', redirectTo: 'termekek', pathMatch: 'full'},
  {path: 'felhasznalok', component: FelhasznalokComponent},
  {path: 'termekek', component: TermekekComponent},
  {path: 'termekeladas', component: TermekeladasComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
