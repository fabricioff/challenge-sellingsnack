import { Component, OnInit } from '@angular/core';
import { SnackService } from '../services/snack.service';
import { Snack } from '../models/Snack.model';
import { Ingredient } from '../models/Ingredient.model';
import { Sale } from '../models/Sale.model';
import { TypeDeduction } from '../models/TypeDeduction.model';


@Component({
  selector: 'app-snacks-list',
  templateUrl: './snacks-list.component.html',
  styleUrls: ['./snacks-list.component.css']
})
export class SnacksListComponent implements OnInit {

  snacksNames: Array<string> = new Array<string>();
  snacksSelected: Snack;
  priceSnack: number;
  allIngredients: Array<Ingredient> = new Array<Ingredient>();
  snackIngredients: Array<Ingredient> = new Array<Ingredient>();
  sales: Array<Sale> = new Array<Sale>();
  deductionSnack: number;
  payment: number;
  snackIsSale: boolean;

  constructor(private snackService: SnackService) { }

  ngOnInit() {
    this.listSnacksNames();
    this.listIngredients();
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

  listIngredients() {
    this.snackService.getIngredientes()
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
    this.snackIngredients.forEach((i: Ingredient) => {
      console.log(i.price);
      this.priceSnack += i.price;
    });
    console.log(this.priceSnack);
  }

  verifySale() {
    this.payment = 0;
    this.deductionSnack = 0;
    this.snackIsSale = false;
    //Buscando por promoção...
    this.sales.forEach((sale) => {
      sale.condictions.forEach((condition) => {
        let count = 0;
        this.snacksSelected.ingredients.filter((i) => {
          if (condition.ingredient.name === i.name) {
            console.log(`Encontrou o ingrediente: ${i.name}`);
            count++;
            if (count === condition.amountIngredient) {
              console.log(`Atende a promoção: ${sale.name}`);
              if (sale.deductionType === TypeDeduction.INGREDIENT) {
                this.deductionSnack = (i.price * condition.amountIngredient) * sale.deduction;
              } else if (sale.deductionType === TypeDeduction.SNACK) {
                this.deductionSnack = this.priceSnack * sale.deduction;
              }
              this.snackIsSale = true;
            }
            return true;
          }
          return false;
        });
      });
    });

    this.payment = this.priceSnack - this.deductionSnack;
  }

  onSelect(snackName: string): void {
    this.snackService.getSnack(snackName)
      .subscribe( data => {
        console.log('String of Snack:');
        console.log(data);

        this.snacksSelected = Snack.parse(data);
        this.snackIngredients = this.snacksSelected.ingredients;
        console.log(this.snackIngredients);

        this.calcTotalSnack();
        this.verifySale();
    });
  }

}
