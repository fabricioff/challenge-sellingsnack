//import { Ingredient } from './Ingredient';

export class Snack {
    id: number;
    name: string;
    //ingredients: Array<Ingredient>;

    constructor(id: number, name: string, ingredients: Array<any>) {
        this.id = id;
        this.name = name;
        //this.ingredients = ingredients;
    }
}
