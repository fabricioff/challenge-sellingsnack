import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';//'selenium-webdriver/http';

@Injectable({
  providedIn: 'root'
})
export class SnackService {

  WebServiceUrl = 'http://localhost:8080/sellingsnack-ws';
  snacksNamesUrl = `${this.WebServiceUrl}/snack`;
  findSnackObjectkUrl = `${this.snacksNamesUrl}/find`;
  promotionsUrl = `${this.WebServiceUrl}/promotion`;

  constructor(private http: HttpClient) { }

  getSnacksNames() {
    return this.http.get<any[]>(`${this.snacksNamesUrl}`);
  }

  getSnack(snackName: string) {
    const urlFind = `${this.findSnackObjectkUrl}/${snackName}`;
    console.log(`Searching: ${snackName}`);
    console.log(urlFind);

    return this.http.get<any>(urlFind);
  }

  getPromotions() {
    return this.http.get<any[]>(this.promotionsUrl);
  }

}
