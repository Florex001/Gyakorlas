import { Component, OnInit } from '@angular/core';
import { Tutorial } from 'src/app/models/tutorial.model';
import { TutorialService } from 'src/app/services/tutorial.service';

@Component({
  selector: 'app-tutorials-list',
  templateUrl: './tutorials-list.component.html',
  styleUrls: ['./tutorials-list.component.css']
})
export class TutorialsListComponent implements OnInit {

  // A tutorial objektumok tömbje
  tutorials?: Tutorial[];

  // Az aktuális tutoriál, amelyet kiválasztottunk
  currentTutorial: Tutorial = {};

  // Az aktuális tutoriál indexe a tömbben
  currentIndex = -1;

  // A keresés címe
  title = '';

  constructor(private tutorialService: TutorialService) { }

  ngOnInit(): void {
    // Az ngOnInit() metódus futása a komponens inicializálásakor
    // Az összes tutoriál lekérése
    this.retrieveTutorials();
  }

  // Az összes tutoriál lekérése
  retrieveTutorials(): void {
    this.tutorialService.getAll()
      .subscribe({
        next: (data) => {
          this.tutorials = data;
          console.log(data);
        },
        error: (e) => console.error(e)
      });
  }

  // Lista frissítése
  refreshList(): void {
    this.retrieveTutorials();
    this.currentTutorial = {};
    this.currentIndex = -1;
  }

  // Kiválasztott tutoriál beállítása
  setActiveTutorial(tutorial: Tutorial, index: number): void {
    this.currentTutorial = tutorial;
    this.currentIndex = index;
  }

  // Az összes tutoriál törlése
  removeAllTutorials(): void {
    this.tutorialService.deleteAll()
      .subscribe({
        next: (res) => {
          console.log(res);
          this.refreshList();
        },
        error: (e) => console.error(e)
      });
  }

  // Cím alapján történő keresés
  searchTitle(): void {
    this.currentTutorial = {};
    this.currentIndex = -1;

    this.tutorialService.findByTitle(this.title)
      .subscribe({
        next: (data) => {
          this.tutorials = data;
          console.log(data);
        },
        error: (e) => console.error(e)
      });
  }

}
