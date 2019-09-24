import { Component, OnInit } from '@angular/core';
import { SnackService } from '../services/snack.service';
import { Snack } from '../models/Snack.model';
import { Ingredient } from '../models/Ingredient.model';
import { Sale } from '../models/Sale.model';


@Component({
  selector: 'app-snacks-list',
  templateUrl: './snacks-list.component.html',
  styleUrls: ['./snacks-list.component.css']
})
export class SnacksListComponent implements OnInit {

  snacksNames: Array<string> = new Array<string>();
  snacksSelected: Snack;
  priceSnack: number;
  ingredients: Array<Ingredient> = new Array<Ingredient>();
  sales: Array<Sale> = new Array<Sale>();
  deductionSnack: number;
  payment: number = 0;

  constructor(private snackService: SnackService) { }

  ngOnInit() {
    this.listSnacksNames();
    this.listSales();
  }

  listSnacksNames() {
    this.snackService.getSnacksNames()
      .subscribe(data => {
        this.snacksNames = data;
        console.log(`Snacks Names:`);
        console.log(this.snacksNames);
      });
  }

  listSales() {
    this.snackService.getSales()
      .subscribe(data => {
        console.log('String of Sales:');
        console.log(data);

        data.forEach((d: any) => {
          console.log(d);

          const sale = Sale.parse(d);
          console.log(sale);

          this.sales.push(sale);
        });
      });
  }

  calcTotalSnack() {
    this.priceSnack = 0;
    this.ingredients.forEach((i: Ingredient) => {
      console.log(i.price);
      this.priceSnack += i.price;
    });
    console.log(this.priceSnack);
  }

  verifySale() {
    let verifiedDeduction = 0;
    ///*Buscando por promoção...
    this.sales.forEach((sale) => {
      sale.condictions.forEach((condition) => {
        let count = 0;
        let ingredientsFound = this.snacksSelected.ingredients.filter((i) => {
          if (condition.ingredient.name === i.name) {
            console.log(`Encontrou o ingrediente: ${i.name}`);
            count++;
            if (count === condition.amountIngredient) {
              console.log(`Atende a promoção: ${sale.name}`);

            }
            return true;
          }
          return false;
        });

      });
    });

    //--*/

    this.payment = this.priceSnack - verifiedDeduction;
  }

  onSelect(snackName: string): void {
    this.snackService.getSnack(snackName)
      .subscribe( data => {
        console.log('String of Snack:');
        console.log(data);

        this.snacksSelected = Snack.parse(data);
        this.ingredients = this.snacksSelected.ingredients;
        console.log(this.ingredients);

        this.calcTotalSnack();
        this.verifySale();
    });
  }

}
