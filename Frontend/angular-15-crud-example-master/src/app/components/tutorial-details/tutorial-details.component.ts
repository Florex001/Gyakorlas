import { Component, Input, OnInit } from '@angular/core';
import { TutorialService } from 'src/app/services/tutorial.service';
import { ActivatedRoute, Router } from '@angular/router';
import { Tutorial } from 'src/app/models/tutorial.model';

@Component({
  selector: 'app-tutorial-details',
  templateUrl: './tutorial-details.component.html',
  styleUrls: ['./tutorial-details.component.css']
})
export class TutorialDetailsComponent implements OnInit {

  @Input() viewMode = false;

  // Az aktuális tutoriál, amelyet megjelenítünk vagy szerkesztünk
  @Input() currentTutorial: Tutorial = {
    title: '',
    description: '',
    published: false
  };
  
  // Üzenet, amely a műveletek eredményét jelzi
  message = '';

  constructor(
    private tutorialService: TutorialService,
    private route: ActivatedRoute,
    private router: Router) { }

  ngOnInit(): void {
    // Az ngOnInit() metódus futása a komponens inicializálásakor
    // Ha nem viewMode-ban vagyunk (nem csak megtekintésre szolgál a komponens), akkor az aktuális tutoriál adatainak lekérése
    if (!this.viewMode) {
      this.message = '';
      this.getTutorial(this.route.snapshot.params["id"]);
    }
  }

  // Az aktuális tutoriál adatainak lekérése a megadott azonosító alapján
  getTutorial(id: string): void {
    this.tutorialService.get(id)
      .subscribe({
        next: (data) => {
          this.currentTutorial = data;
          console.log(data);
        },
        error: (e) => console.error(e)
      });
  }

  // A tutoriál közzétételének frissítése
  updatePublished(status: boolean): void {
    const data = {
      title: this.currentTutorial.title,
      description: this.currentTutorial.description,
      published: status
    };

    this.message = '';

    // A tutorialService segítségével frissítjük a tutoriál közzétételi állapotát a data objektummal
    // Az Observable-t visszaadó update metódusra feliratkozunk a subscribe() segítségével
    // Ha a kérés sikeres, a next callback függvény fut le, beállítja az új közzétételi állapotot, és üzenetet jelenít meg
    // Ha hiba történik a kérés során, az error callback függvény fut le, és a hibát kiírja a konzolra
    this.tutorialService.update(this.currentTutorial.id, data)
      .subscribe({
        next: (res) => {
          console.log(res);
          this.currentTutorial.published = status;
          this.message = res.message ? res.message : 'The status was updated successfully!';
        },
        error: (e) => console.error(e)
      });
  }

  // A tutoriál frissítése az aktuális tutoriál adataival
  updateTutorial(): void {
    this.message = '';

    // A tutorialService segítségével frissítjük a tutoriált az aktuális tutori
    // Az Observable-t visszaadó update metódusra feliratkozunk a subscribe() segítségével
    // Ha a kérés sikeres, a next callback függvény fut le, és üzenetet jelenít meg
    // Ha hiba történik a kérés során, az error callback függvény fut le, és a hibát kiírja a konzolra
    this.tutorialService.update(this.currentTutorial.id, this.currentTutorial)
    .subscribe({
    next: (res) => {
    console.log(res);
    this.message = res.message ? res.message : 'This tutorial was updated successfully!';
    },
    error: (e) => console.error(e)
    });
    }
    
    // A tutoriál törlése
    deleteTutorial(): void {
    // A tutorialService segítségével töröljük a tutoriált az aktuális tutoriál azonosítója alapján
    // Az Observable-t visszaadó delete metódusra feliratkozunk a subscribe() segítségével
    // Ha a kérés sikeres, a next callback függvény fut le, átirányítunk az '/tutorials' útvonalra
    // Ha hiba történik a kérés során, az error callback függvény fut le, és a hibát kiírja a konzolra
    this.tutorialService.delete(this.currentTutorial.id)
    .subscribe({
    next: (res) => {
    console.log(res);
    this.router.navigate(['/tutorials']);
    },
    error: (e) => console.error(e)
    });
    }
    
    }