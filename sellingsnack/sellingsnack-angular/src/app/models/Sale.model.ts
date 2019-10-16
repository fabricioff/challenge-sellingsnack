import { Item } from './Item.model';
import { TypeDeduction } from './TypeDeduction.model';

export class Sale {
    id: number;
    name: string;
    description: string;
    deduction: number;
    conditions: Array<Item>;
    deductionType: TypeDeduction;

    constructor(id: number, name: string, description: string, deduction: number,
                deductionType: TypeDeduction, conditions: Array<Item>) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.deduction = deduction;
        this.conditions = conditions;
        this.deductionType = deductionType;
    }

    static parse(data) {
        const conditionList: Array<Item> = new Array<Item>();
        data.conditions.forEach((c: any) => {
            const condition: Item = Item.parse(c);
            conditionList.push(condition);
        });

        return new Sale(data.id, data.name, data.description, data.deduction, data.typeDeduction, conditionList);
    }
}
