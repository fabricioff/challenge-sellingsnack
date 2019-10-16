import { Ingredient } from './Ingredient.model';
import { Item } from './Item.model';

export class Snack  {
    id: number;
    name: string;
    ingredients: Array<Item> = new Array<Item>();

    constructor(id: number, name: string, ingredients: Array<Item>) {
        this.id = id;
        this.name = name;
        this.ingredients = ingredients;
    }

    static parse(data) {
        const ingredientList: Array<Item> = new Array<Item>();
        data.ingredients.forEach((i) => {
            const item: Item = Item.parse(i);
            ingredientList.push(item);
        });
        return new Snack(data.id, data.name, ingredientList);
    }
}
