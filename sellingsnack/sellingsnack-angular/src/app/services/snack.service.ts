import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';//'selenium-webdriver/http';

@Injectable({
  providedIn: 'root'
})
export class SnackService {

  BASE_ENDPOINT = 'http://localhost:8080/sellingsnack-ws';
  SNACK_NAME_ENDPOINT = `${this.BASE_ENDPOINT}/snack`;
  FIND_SNACK_ENDPOINT = `${this.SNACK_NAME_ENDPOINT}/find`;
  INGREDIENT_ENDPOINT = `${this.BASE_ENDPOINT}/ingredient`;
  SALE_ENDPOINT = `${this.BASE_ENDPOINT}/sale`;

  constructor(private http: HttpClient) { }

  getSnacksNames() {
    return this.http.get<any[]>(`${this.SNACK_NAME_ENDPOINT}`);
  }

  getSnack(snackName: string) {
    const urlFind = `${this.FIND_SNACK_ENDPOINT}/${snackName}`;
    console.log(`Searching: ${snackName}`);
    console.log(urlFind);

    return this.http.get<any>(urlFind);
  }

  getSales() {
    return this.http.get<any[]>(this.SALE_ENDPOINT);
  }

  getIngredientes() {
    return this.http.get<any[]>(this.INGREDIENT_ENDPOINT);
  }

}
