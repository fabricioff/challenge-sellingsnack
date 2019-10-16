import { Component, OnInit } from '@angular/core';

import { SnackService } from '../../services/snack.service';
import { Snack } from '../../models/Snack.model';
import { Ingredient } from '../../models/Ingredient.model';
import { Sale } from '../../models/Sale.model';


@Component({
  selector: 'app-snacks-list',
  templateUrl: './snacks-list.component.html',
  styleUrls: ['./snacks-list.component.css']
})
export class SnacksListComponent implements OnInit {

  displayedColumns: string[] = ['quantity', 'snack', 'price', 'priceQuantity', 'actions'];

  snacksNames: Array<string> = new Array<string>();
  selectedSnack: Snack;
  allIngredients: Array<Ingredient> = new Array<Ingredient>();
  availableSales: Array<Sale> = new Array<Sale>();

  constructor(private snackService: SnackService) { }

  ngOnInit() {
    this.listSnacksNames();
    this.listIngredients();
    this.listSales();
  }

  listSnacksNames() {
    this.snackService.getSnacksNames()
      .subscribe(data => this.snacksNames = data);
  }

  listIngredients() {
    this.snackService.getIngredients()
      .subscribe(data => {
        data.forEach((i: any) => {
          const ingredient: Ingredient = Ingredient.parse(i);
          this.allIngredients.push(ingredient);
        });
      });
  }

  listSales() {
    this.snackService.getSales()
      .subscribe(data => {
        data.forEach((d: any) => {
          const sale = Sale.parse(d);
          this.availableSales.push(sale);
        });
      });
  }

  onSelect(snackName: string): void {
    this.snackService.getSnack(snackName)
      .subscribe( data => {
        this.selectedSnack = Snack.parse(data);
        console.log(this.selectedSnack);
    });
  }

}
