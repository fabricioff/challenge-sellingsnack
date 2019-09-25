import { SaleCondition } from './SaleCondition.model';
import { TypeDeduction } from './TypeDeduction.model';

export class Sale {
    id: number;
    name: string;
    description: string;
    deduction: number;
    condictions: Array<SaleCondition>;
    deductionType: TypeDeduction;

    constructor(id: number, name: string, description: string, deduction: number,
                deductionType: TypeDeduction, condictions: Array<SaleCondition>) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.deduction = deduction;
        this.condictions = condictions;
        this.deductionType = deductionType;
    }

    static parse(data) {
        console.log('Sale Parsing....');
        const conditionList: Array<SaleCondition> = new Array<SaleCondition>();

        data.conditions.forEach((c: any) => {
            const condition: SaleCondition = SaleCondition.parse(c);
            console.log(condition);
            conditionList.push(condition);
        });

        return new Sale(data.id, data.name, data.description, data.deduction, data.typeDeduction, conditionList);
    }
}
