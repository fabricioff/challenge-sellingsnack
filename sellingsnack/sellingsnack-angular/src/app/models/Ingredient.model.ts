

export class Ingredient {
    id: number;
    name: string;
    price: number;

    constructor(id: number, name: string, price: number) {
        this.id = id;
        this.name = name;
        this.price = price;
    }

    static parse(data) {
        return new Ingredient(data.id, data.name, data.price);
    }

}
