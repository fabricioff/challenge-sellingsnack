import { Ingredient } from './Ingredient.model';

export class Item {
    ingredient: Ingredient;
    quantity: number;

    constructor(ingredient: Ingredient, quantity: number) {
        this.ingredient = ingredient;
        this.quantity = quantity;
    }

    static parse(data) {
        return new Item(data.ingredient, data.quantity);
    }

}
