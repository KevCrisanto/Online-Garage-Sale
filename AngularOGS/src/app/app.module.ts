import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import {CardModule} from 'ngx-card/ngx-card';
import { AppComponent } from './app.component';
import { CreditCardComponent } from './components/credit-card/credit-card.component';
import { HttpClientModule } from '@angular/common/http';

@NgModule({
  declarations: [
    AppComponent,
    CreditCardComponent
  ],
  imports: [
    BrowserModule,
    CardModule,
    HttpClientModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
