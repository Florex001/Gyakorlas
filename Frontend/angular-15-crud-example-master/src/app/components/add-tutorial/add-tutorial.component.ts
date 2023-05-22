import { Component } from '@angular/core';
import { Tutorial } from 'src/app/models/tutorial.model';
import { TutorialService } from 'src/app/services/tutorial.service';

@Component({
  selector: 'app-add-tutorial',
  templateUrl: './add-tutorial.component.html',
  styleUrls: ['./add-tutorial.component.css']
})
export class AddTutorialComponent {
  // Tutorial objektum inicializálása üres értékekkel
  tutorial: Tutorial = {
    title: '',
    description: '',
    published: false
  };

  // submitted változó inicializálása hamis értékkel
  submitted = false;

  constructor(private tutorialService: TutorialService) { }

  // A tutoriál mentését végző függvény
  saveTutorial(): void {
    // Adatok összeállítása az űrlap mezőiből
    const data = {
      title: this.tutorial.title,
      description: this.tutorial.description
    };

    // TutorialService segítségével a tutorialService.create metódust hívjuk meg, hogy létrehozzunk egy új tutoriált
    // Az Observable-t visszaadó create metódusra feliratkozunk a subscribe() segítségével
    // Ha a kérés sikeres, a next callback függvény fut le, és a választ kiírjuk a konzolra
    // Ha hiba történik a kérés során, az error callback függvény fut le, és a hibát kiírjuk a konzolra
    this.tutorialService.create(data)
      .subscribe({
        next: (res) => {
          console.log(res);
          this.submitted = true;
        },
        error: (e) => console.error(e)
      });
  }

  // Az űrlapban megadott adatok törlése és a submitted változó visszaállítása
  newTutorial(): void {
    this.submitted = false;
    this.tutorial = {
      title: '',
      description: '',
      published: false
    };
  }
}
