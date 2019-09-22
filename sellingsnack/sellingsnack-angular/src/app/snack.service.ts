import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';//'selenium-webdriver/http';

@Injectable({
  providedIn: 'root'
})
export class SnackService {

  snacksUrl = 'http://localhost:8080/sellingsnack-ws/snack/';

  constructor(private http: HttpClient) { }

  listar() {
    return this.http.get<any[]>(`${this.snacksUrl}`);
  }

}
