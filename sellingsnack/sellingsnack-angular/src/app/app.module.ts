import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { FormsModule } from '@angular/forms';

import { HttpClientModule } from '@angular/common/http';

import { AppComponent } from './app.component';
import { SnackService } from './services/snack.service';
import { SnacksModule } from './snacks/snacks.module';


@NgModule({
  declarations: [ AppComponent ],
  imports: [
    BrowserModule,
    FormsModule,
    HttpClientModule,
    SnacksModule
  ],
  providers: [ SnackService ],
  bootstrap: [AppComponent]
})
export class AppModule { }
