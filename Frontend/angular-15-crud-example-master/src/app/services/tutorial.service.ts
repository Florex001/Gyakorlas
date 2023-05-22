import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Tutorial } from '../models/tutorial.model';

const baseUrl = 'http://localhost:8080/api/tutorials';

@Injectable({
  providedIn: 'root'
})
export class TutorialService {

  constructor(private http: HttpClient) { }

  // Az összes tutorial lekérése
  getAll(): Observable<Tutorial[]> {
    return this.http.get<Tutorial[]>(baseUrl);
  }

  // Egy tutorial lekérése az azonosító alapján
  get(id: any): Observable<Tutorial> {
    return this.http.get<Tutorial>(`${baseUrl}/${id}`);
  }

  // Új tutorial létrehozása
  create(data: any): Observable<any> {
    return this.http.post(baseUrl, data);
  }

  // Tutorial frissítése az azonosító alapján
  update(id: any, data: any): Observable<any> {
    return this.http.put(`${baseUrl}/${id}`, data);
  }

  // Tutorial törlése az azonosító alapján
  delete(id: any): Observable<any> {
    return this.http.delete(`${baseUrl}/${id}`);
  }

  // Az összes tutorial törlése
  deleteAll(): Observable<any> {
    return this.http.delete(baseUrl);
  }

  // Cím alapján történő tutorial keresése
  findByTitle(title: any): Observable<Tutorial[]> {
    return this.http.get<Tutorial[]>(`${baseUrl}?title=${title}`);
  }
}
