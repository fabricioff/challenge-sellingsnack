import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { HttpClientModule } from '@angular/common/http'

import { AppComponent } from './app.component';
import { SnacksListComponent } from './snacks-list/snacks-list.component';
import { SnackService } from './snack.service'

@NgModule({
  declarations: [
    AppComponent,
    SnacksListComponent
  ],
  imports: [
    BrowserModule,
    HttpClientModule
  ],
  providers: [ SnackService ],
  bootstrap: [AppComponent]
})
export class AppModule { }
