import { Component, OnInit } from '@angular/core';
import { SnackService } from '../services/snack.service';
import { Snack } from '../models/Snack.model';
import { Ingredient } from '../models/Ingredient.model';
import { Promotion } from '../models/Promotion.model';


@Component({
  selector: 'app-snacks-list',
  templateUrl: './snacks-list.component.html',
  styleUrls: ['./snacks-list.component.css']
})
export class SnacksListComponent implements OnInit {

  snacksNames: Array<string>;
  snacksSelected: Snack;
  priceSnack: number;
  ingredients: Array<Ingredient>;
  promotions: Array<Promotion>;

  constructor(private snackService: SnackService) { }

  ngOnInit() {
    this.listSnacksNames();
    this.listPromotions();
  }

  listSnacksNames() {
    this.snackService.getSnacksNames()
      .subscribe(dados => {
        this.snacksNames = dados;
        console.log(`Snacks Names:`);
        console.log(this.snacksNames);
      });
  }

  listPromotions() {
    this.snackService.getPromotions()
      .subscribe(resp => {
        console.log('String of Promotions:');
        console.log(resp);
          //const promotion: Promotion  = Promotion.parse(data);
          //this.promotions.push(promotion);
      });
  }

  calTotalSnack() {
    this.ingredients.forEach((i: Ingredient) => {
      console.log(i.price);
      this.priceSnack += i.price;
    });
    console.log(this.priceSnack);
  }

  onSelect(snackName: string): void {
    this.snackService.getSnack(snackName)
      .subscribe( resp => {
        console.log('String of Snack:');
        console.log(resp);

        this.snacksSelected = Snack.parse(resp);
        this.ingredients = this.snacksSelected.ingredients;
        console.log(this.ingredients);

        this.calTotalSnack();
    });
  }

}
