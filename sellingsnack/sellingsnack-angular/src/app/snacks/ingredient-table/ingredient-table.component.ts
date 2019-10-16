import { Component, OnInit, Input, OnChanges, SimpleChanges } from '@angular/core';
import { Snack } from 'src/app/models/Snack.model';
import { Sale } from 'src/app/models/Sale.model';
import { Item } from 'src/app/models/Item.model';
import { TypeDeduction } from 'src/app/models/TypeDeduction.model';
import { Ingredient } from 'src/app/models/Ingredient.model';

@Component({
  selector: 'app-ingredient-table',
  templateUrl: './ingredient-table.component.html',
  styleUrls: ['./ingredient-table.component.css']
})
export class IngredientTableComponent implements OnInit, OnChanges {

  @Input() snack: Snack;
  @Input() sales: Array<Sale>;
  @Input() listIngredients: Array<Ingredient>;

  saleFound: Sale;
  priceSnack: number;
  deduction: number;
  payment: number;

  ingredientNameSelected: string;
  quantitySelected: number;

  constructor() {}

  ngOnInit() {}

  ngOnChanges(changes: SimpleChanges): void {
    this.calcPriceSnack(this.snack);
    this.verifySale(this.snack);
  }

  calcPriceSnack(snack: Snack) {
    this.priceSnack = 0;
    snack.ingredients.forEach((item: Item) => {
      this.priceSnack += (item.ingredient.price * item.quantity);
    });
  }

  verifySale(snack: Snack) {
    this.saleFound = null;
    this.deduction = 0;

    this.sales.forEach((sale: Sale) => {
      sale.conditions.forEach(condition => {
        snack.ingredients.filter(item => {
          if (item.ingredient.name === condition.ingredient.name) {
            if ((item.quantity === condition.quantity)) {
              return true;
            }
          }
          return false;
        }).forEach(item => {
          console.log(`Atende a promoção: ${sale.name}`);
          this.saleFound = sale;
          if (sale.deductionType === TypeDeduction.INGREDIENT) {
            this.deduction = (item.ingredient.price * item.quantity) * sale.deduction;
          } else if (sale.deductionType === TypeDeduction.SNACK) {
            this.deduction = this.priceSnack * sale.deduction;
          }
        });
      });
    });

    this.payment = this.priceSnack - this.deduction;
  }

  removeItem(item: Item) {
    if (item != null) {
      console.log(`Removendo ingrediente: ${item.ingredient.name}`);
      this.snack.ingredients = this.snack.ingredients.filter((value: Item, key) => {
        return value.ingredient.name !== item.ingredient.name;
      });
    }
  }

  onRemove(item: Item) {
    this.removeItem(item);

    this.calcPriceSnack(this.snack);
    this.verifySale(this.snack);
  }

  addItemToSnack() {
    console.log(`Adicionando Ingrediente: ${this.quantitySelected}x ${this.ingredientNameSelected}`);
    const ingredientSelected: Ingredient = this.listIngredients.find(i => i.name === this.ingredientNameSelected);
    let itemFound: Item = null;

    // Verifica se o item ja existe para acrescentar quantidade
    itemFound = this.snack.ingredients.find((i: Item) => i.ingredient.name === this.ingredientNameSelected);
    if (itemFound == null) {
      itemFound = new Item(ingredientSelected, this.quantitySelected);
    } else {
      this.removeItem(itemFound);
      itemFound.quantity += this.quantitySelected;
    }

    this.snack.ingredients.push(itemFound);

    this.calcPriceSnack(this.snack);
    this.verifySale(this.snack);

    this.ingredientNameSelected = null;
    this.quantitySelected = null;
  }

}
