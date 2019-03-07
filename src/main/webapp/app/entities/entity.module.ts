import { NgModule, CUSTOM_ELEMENTS_SCHEMA } from '@angular/core';
import { RouterModule } from '@angular/router';

@NgModule({
    imports: [
        RouterModule.forChild([
            {
                path: 'bank',
                loadChildren: './bank/bank.module#FormfillerBankModule'
            },
            {
                path: 'branch',
                loadChildren: './branch/branch.module#FormfillerBranchModule'
            },
            {
                path: 'address',
                loadChildren: './address/address.module#FormfillerAddressModule'
            },
            {
                path: 'customer',
                loadChildren: './customer/customer.module#FormfillerCustomerModule'
            },
            {
                path: 'siba-account-form',
                loadChildren: './siba-account-form/siba-account-form.module#FormfillerSibaAccountFormModule'
            },
            {
                path: 'bank',
                loadChildren: './bank/bank.module#FormfillerBankModule'
            },
            {
                path: 'branch',
                loadChildren: './branch/branch.module#FormfillerBranchModule'
            },
            {
                path: 'customer',
                loadChildren: './customer/customer.module#FormfillerCustomerModule'
            },
            {
                path: 'siba-account-form',
                loadChildren: './siba-account-form/siba-account-form.module#FormfillerSibaAccountFormModule'
            },
            {
                path: 'bank',
                loadChildren: './bank/bank.module#FormfillerBankModule'
            },
            {
                path: 'branch',
                loadChildren: './branch/branch.module#FormfillerBranchModule'
            },
            {
                path: 'customer',
                loadChildren: './customer/customer.module#FormfillerCustomerModule'
            },
            {
                path: 'siba-account-form',
                loadChildren: './siba-account-form/siba-account-form.module#FormfillerSibaAccountFormModule'
            }
            /* jhipster-needle-add-entity-route - JHipster will add entity modules routes here */
        ])
    ],
    declarations: [],
    entryComponents: [],
    providers: [],
    schemas: [CUSTOM_ELEMENTS_SCHEMA]
})
export class FormfillerEntityModule {}
