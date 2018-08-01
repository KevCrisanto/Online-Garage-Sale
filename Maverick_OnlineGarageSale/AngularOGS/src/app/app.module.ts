import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { LocationStrategy, HashLocationStrategy } from '@angular/common';
import { CardModule } from 'ngx-card/ngx-card';
import { SmartTableModule } 'smart-table-ng';
import { AppComponent } from './app.component';
import { CreditCardComponent } from './components/credit-card/credit-card.component';
import { HttpClientModule } from '@angular/common/http';
import { FormsModule } from '@angular/forms';
import { LoginComponent } from './components/login/login.component';
import { LoginService } from './services/login.service';
import { FilesComponent } from './components/files/files.component';
import { NavbarComponent } from './components/navbar/navbar.component';

import { FontAwesomeModule } from '@fortawesome/angular-fontawesome';
import { library } from '@fortawesome/fontawesome-svg-core';
import { faSearch, faShoppingCart } from '@fortawesome/free-solid-svg-icons';
import { ItemsComponent } from './components/items/items.component';
import { ItemsListComponent } from './components/items/items-list/items-list.component';
import { ItemDetailComponent } from './components/items/item-detail/item-detail.component';
import { CardService } from './services/card.service';
import { TransactionHistoryComponent } from './components/transaction-history/transaction-history.component';

library.add(faShoppingCart, faSearch);

@NgModule({
  declarations: [
    AppComponent,
    CreditCardComponent,
    LoginComponent,
    FilesComponent,
    NavbarComponent,
    ItemsComponent,
    ItemsListComponent,
    ItemDetailComponent,
    TransactionHistoryComponent
  ],
  imports: [
    BrowserModule,
    CardModule,
    HttpClientModule,
    FormsModule,
    FontAwesomeModule
  ],
  providers: [
    LoginService,
    CardService,
    { provide: LocationStrategy, useClass: HashLocationStrategy }
  ],
  bootstrap: [AppComponent]
})
export class AppModule {}