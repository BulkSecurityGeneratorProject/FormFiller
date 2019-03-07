import { NgModule, CUSTOM_ELEMENTS_SCHEMA } from '@angular/core';
import { RouterModule } from '@angular/router';
import { JhiLanguageService } from 'ng-jhipster';
import { JhiLanguageHelper } from 'app/core';

import { FormfillerSharedModule } from 'app/shared';
import {
    SibaAccountFormComponent,
    SibaAccountFormDetailComponent,
    SibaAccountFormUpdateComponent,
    SibaAccountFormDeletePopupComponent,
    SibaAccountFormDeleteDialogComponent,
    sibaAccountFormRoute,
    sibaAccountFormPopupRoute
} from './';

const ENTITY_STATES = [...sibaAccountFormRoute, ...sibaAccountFormPopupRoute];

@NgModule({
    imports: [FormfillerSharedModule, RouterModule.forChild(ENTITY_STATES)],
    declarations: [
        SibaAccountFormComponent,
        SibaAccountFormDetailComponent,
        SibaAccountFormUpdateComponent,
        SibaAccountFormDeleteDialogComponent,
        SibaAccountFormDeletePopupComponent
    ],
    entryComponents: [
        SibaAccountFormComponent,
        SibaAccountFormUpdateComponent,
        SibaAccountFormDeleteDialogComponent,
        SibaAccountFormDeletePopupComponent
    ],
    providers: [{ provide: JhiLanguageService, useClass: JhiLanguageService }],
    schemas: [CUSTOM_ELEMENTS_SCHEMA]
})
export class FormfillerSibaAccountFormModule {
    constructor(private languageService: JhiLanguageService, private languageHelper: JhiLanguageHelper) {
        this.languageHelper.language.subscribe((languageKey: string) => {
            if (languageKey !== undefined) {
                this.languageService.changeLanguage(languageKey);
            }
        });
    }
}
