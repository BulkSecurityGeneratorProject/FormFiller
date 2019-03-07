import { Component, OnInit, OnDestroy } from '@angular/core';
import { HttpErrorResponse, HttpResponse } from '@angular/common/http';
import { Subscription } from 'rxjs';
import { filter, map } from 'rxjs/operators';
import { JhiEventManager, JhiAlertService } from 'ng-jhipster';

import { ISibaAccountForm } from 'app/shared/model/siba-account-form.model';
import { AccountService } from 'app/core';
import { SibaAccountFormService } from './siba-account-form.service';

@Component({
    selector: 'jhi-siba-account-form',
    templateUrl: './siba-account-form.component.html'
})
export class SibaAccountFormComponent implements OnInit, OnDestroy {
    sibaAccountForms: ISibaAccountForm[];
    currentAccount: any;
    eventSubscriber: Subscription;

    constructor(
        protected sibaAccountFormService: SibaAccountFormService,
        protected jhiAlertService: JhiAlertService,
        protected eventManager: JhiEventManager,
        protected accountService: AccountService
    ) {}

    loadAll() {
        this.sibaAccountFormService
            .query()
            .pipe(
                filter((res: HttpResponse<ISibaAccountForm[]>) => res.ok),
                map((res: HttpResponse<ISibaAccountForm[]>) => res.body)
            )
            .subscribe(
                (res: ISibaAccountForm[]) => {
                    this.sibaAccountForms = res;
                },
                (res: HttpErrorResponse) => this.onError(res.message)
            );
    }

    ngOnInit() {
        this.loadAll();
        this.accountService.identity().then(account => {
            this.currentAccount = account;
        });
        this.registerChangeInSibaAccountForms();
    }

    ngOnDestroy() {
        this.eventManager.destroy(this.eventSubscriber);
    }

    trackId(index: number, item: ISibaAccountForm) {
        return item.id;
    }

    registerChangeInSibaAccountForms() {
        this.eventSubscriber = this.eventManager.subscribe('sibaAccountFormListModification', response => this.loadAll());
    }

    protected onError(errorMessage: string) {
        this.jhiAlertService.error(errorMessage, null, null);
    }
}
