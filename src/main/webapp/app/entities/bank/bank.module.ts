import { NgModule, CUSTOM_ELEMENTS_SCHEMA } from '@angular/core';
import { RouterModule } from '@angular/router';
import { JhiLanguageService } from 'ng-jhipster';
import { JhiLanguageHelper } from 'app/core';

import { FormfillerSharedModule } from 'app/shared';
import {
    BankComponent,
    BankDetailComponent,
    BankUpdateComponent,
    BankDeletePopupComponent,
    BankDeleteDialogComponent,
    bankRoute,
    bankPopupRoute
} from './';

const ENTITY_STATES = [...bankRoute, ...bankPopupRoute];

@NgModule({
    imports: [FormfillerSharedModule, RouterModule.forChild(ENTITY_STATES)],
    declarations: [BankComponent, BankDetailComponent, BankUpdateComponent, BankDeleteDialogComponent, BankDeletePopupComponent],
    entryComponents: [BankComponent, BankUpdateComponent, BankDeleteDialogComponent, BankDeletePopupComponent],
    providers: [{ provide: JhiLanguageService, useClass: JhiLanguageService }],
    schemas: [CUSTOM_ELEMENTS_SCHEMA]
})
export class FormfillerBankModule {
    constructor(private languageService: JhiLanguageService, private languageHelper: JhiLanguageHelper) {
        this.languageHelper.language.subscribe((languageKey: string) => {
            if (languageKey !== undefined) {
                this.languageService.changeLanguage(languageKey);
            }
        });
    }
}
