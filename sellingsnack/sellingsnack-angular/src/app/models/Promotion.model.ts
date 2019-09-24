import { Condition } from './Condition.model';

export class Promotion {
    id: number;
    name: string;
    deduction: number;
    condictions: Array<Condition>;

    constructor(id: number, name: string, deduction: number, condictions: Array<Condition>) {
        this.id = id;
        this.name = name;
        this.deduction = deduction;
        this.condictions = condictions;
    }

    static parse(json) {
        console.log('Promotion Parsing....');
        const conditionList: Array<Condition> = new Array<Condition>();

        const data = JSON.parse(json);
        console.log(data);

        data.conditions.forEach((c: any) => {
            const condition: Condition = Condition.parse(c);
            console.log(condition);
            conditionList.push(condition);
        });

        return new Promotion(data.id, data.name, (data.deduction * 100), conditionList);
    }
}