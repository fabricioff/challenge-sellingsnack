import { Component, OnInit } from '@angular/core';
import { SnackService } from '../snack.service';


@Component({
  selector: 'app-snacks-list',
  templateUrl: './snacks-list.component.html',
  styleUrls: ['./snacks-list.component.css']
})
export class SnacksListComponent implements OnInit {

  snacks: Array<any>;

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

}
