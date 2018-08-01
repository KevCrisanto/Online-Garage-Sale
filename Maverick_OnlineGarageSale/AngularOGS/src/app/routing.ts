import { TransactionsComponent } from './components/transactions/transactions.component';
import { ItemsListComponent } from './components/items/items-list/items-list.component';
import { CreditCardComponent } from './components/credit-card/credit-card.component';
import { LoginComponent } from './components/login/login.component';


import { Routes } from '@angular/router';


export const approutes: Routes = [
    {
        path: 'login',
        component: LoginComponent
    },
    {
        path: 'credit-card',
        component: CreditCardComponent
    },
    {
        path: 'item-list',
        component: ItemsListComponent
    },
    {
        path: 'transactions',
        component: TransactionsComponent

    },
    {
        //The URL mapping
        path: '',
        redirectTo: '/login',
        pathMatch: 'full'
    },
    {
        /*

        */
        path: '**',
        component: LoginComponent
    }
]