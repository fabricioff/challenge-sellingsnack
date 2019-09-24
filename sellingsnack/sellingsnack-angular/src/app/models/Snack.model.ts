import { Ingredient } from './Ingredient.model';

export class Snack  {
    id: number;
    name: string;
    ingredients: Array<Ingredient> = new Array<Ingredient>();

    constructor(id: number, name: string, ingredients: Array<Ingredient>) {
        this.id = id;
        this.name = name;
        this.ingredients = ingredients;
    }

    static parse(json) {
        console.log('Snack Parsing....');
        const ingredientList: Array<Ingredient> = new Array<Ingredient>();

        const data = JSON.parse(json);
        console.log(data);

        data.ingredients.forEach((i: any) => {
            const ingredient: Ingredient = Ingredient.parse(i);
            console.log(ingredient);
            ingredientList.push(ingredient);
        });

        return new Snack(data.id, data.name, ingredientList);
    }
}
