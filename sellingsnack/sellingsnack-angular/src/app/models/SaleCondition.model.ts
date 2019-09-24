import { Ingredient } from './Ingredient.model';

export class SaleCondition {
    ingredient: Ingredient;
    amountIngredient: number;

    constructor(ingredient: Ingredient, amountIngredient: number) {
        this.ingredient = ingredient;
        this.amountIngredient = amountIngredient;
    }

    static parse(data) {
        console.log('Condition Parsing....');
        console.log(data);

        return new SaleCondition(data.ingredient, data.amountIngredient);
    }

}
