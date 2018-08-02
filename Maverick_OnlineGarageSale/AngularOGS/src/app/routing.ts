import { ItemDetailComponent } from './components/items/item-detail/item-detail.component';
import { TransactionsComponent } from './components/transactions/transactions.component';
import { ItemsListComponent } from './components/items/items-list/items-list.component';
import { CreditCardComponent } from './components/credit-card/credit-card.component';
import { LoginComponent } from './components/login/login.component';

import { Routes } from '@angular/router';
import { ProfileComponent } from './components/profile/profile.component';


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
        path: 'profile',
        component: ProfileComponent
    },
    {
        path: 'transactions',
        component: TransactionsComponent

    },
    {
        path: 'item-detail',
        // path: 'item-detail/:item',
        component: ItemDetailComponent
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