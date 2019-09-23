import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';//'selenium-webdriver/http';

@Injectable({
  providedIn: 'root'
})
export class SnackService {

  WebServiceUrl = 'http://localhost:8080/sellingsnack-ws';
  snacksUrl = `${this.WebServiceUrl}/snack`;
  ingredientskUrl = `${this.snacksUrl}/find`;

  constructor(private http: HttpClient) { }

  listar() {
    return this.http.get<any[]>(`${this.snacksUrl}`);
  }

  getIngredients(snackName: string) {
    const urlFind = `${this.ingredientskUrl}/${snackName}`;
    console.log(`Searching: ${snackName}`);
    console.log(urlFind);
    return this.http.get<any[]>(urlFind);
  }

}
