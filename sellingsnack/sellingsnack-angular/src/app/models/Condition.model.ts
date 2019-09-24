import { Ingredient } from './Ingredient.model';

export class Condition {
    ingredient: Ingredient;
    hasIngredient: boolean;

    constructor(ingredient: Ingredient, hasIngredient: boolean) {
        this.ingredient = ingredient;
        this.hasIngredient = hasIngredient;
    }

    static parse(data) {
        console.log('Condition Parsing....');

        return new Condition(data.ingredient, data.hasIngredient);
    }

}