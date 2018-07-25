import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { CardModule } from 'ngx-card/ngx-card';

import { AppComponent } from './app.component';
import { CreditCardCheckComponent } from './components/credit-card-check/credit-card-check.component';

@NgModule({
  declarations: [
    AppComponent,
    CreditCardCheckComponent
  ],
  imports: [
    BrowserModule,
    CardModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
