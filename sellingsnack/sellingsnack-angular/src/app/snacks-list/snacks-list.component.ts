import { Component, OnInit } from '@angular/core';
import { SnackService } from '../snack.service';
//import { Ingredient } from 'Ingredient';
//import { Snack } from 'Snack'


@Component({
  selector: 'app-snacks-list',
  templateUrl: './snacks-list.component.html',
  styleUrls: ['./snacks-list.component.css']
})
export class SnacksListComponent implements OnInit {

  selectedSnack: any;
  snacks: Array<any>;
  ingredients: Array<any>;

  constructor(private snackService: SnackService) { }

  ngOnInit() {
    this.listar();
    console.log(`Data in component:`);
    console.log(this.snacks);
  }

  listar() {
    this.snackService.listar()
      .subscribe(dados => this.snacks = dados);
  }

  onSelect(snackName: string): void {
    this.selectedSnack = this.snackService.getIngredients(snackName)
      .subscribe( resp => {
        console.log('Selected Snack:');
        console.log(resp);
        this.selectedSnack = resp;
    });
  }

}
