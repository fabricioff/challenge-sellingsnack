import { NgModule } from '@angular/core';
import { IngredientTableComponent } from './ingredient-table/ingredient-table.component';
import { SnacksListComponent } from './snack-list/snacks-list.component';
import { BrowserModule } from '@angular/platform-browser';
import { FormsModule } from '@angular/forms';

@NgModule ({
  declarations: [
    SnacksListComponent,
    IngredientTableComponent
  ],
  imports: [
    BrowserModule,
    FormsModule
  ],
  exports: [
    SnacksListComponent,
    IngredientTableComponent
  ]
})
export class SnacksModule {

}
