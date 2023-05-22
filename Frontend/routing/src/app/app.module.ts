import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { TermekekComponent } from './Components/termekek/termekek.component';
import { TermekeladasComponent } from './Components/termekeladas/termekeladas.component';
import { FelhasznalokComponent } from './Components/felhasznalok/felhasznalok.component';

@NgModule({
  declarations: [
    AppComponent,
    TermekekComponent,
    TermekeladasComponent,
    FelhasznalokComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
