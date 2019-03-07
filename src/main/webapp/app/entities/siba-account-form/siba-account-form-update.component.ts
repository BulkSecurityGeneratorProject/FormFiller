import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { HttpResponse, HttpErrorResponse } from '@angular/common/http';
import { Observable } from 'rxjs';
import { filter, map } from 'rxjs/operators';
import * as moment from 'moment';
import { JhiAlertService } from 'ng-jhipster';
import { ISibaAccountForm } from 'app/shared/model/siba-account-form.model';
import { SibaAccountFormService } from './siba-account-form.service';
import { ICustomer } from 'app/shared/model/customer.model';
import { CustomerService } from 'app/entities/customer';

@Component({
    selector: 'jhi-siba-account-form-update',
    templateUrl: './siba-account-form-update.component.html'
})
export class SibaAccountFormUpdateComponent implements OnInit {
    sibaAccountForm: ISibaAccountForm;
    isSaving: boolean;

    customers: ICustomer[];
    registerDateDp: any;

    constructor(
        protected jhiAlertService: JhiAlertService,
        protected sibaAccountFormService: SibaAccountFormService,
        protected customerService: CustomerService,
        protected activatedRoute: ActivatedRoute
    ) {}

    ngOnInit() {
        this.isSaving = false;
        this.activatedRoute.data.subscribe(({ sibaAccountForm }) => {
            this.sibaAccountForm = sibaAccountForm;
        });
        this.customerService
            .query()
            .pipe(
                filter((mayBeOk: HttpResponse<ICustomer[]>) => mayBeOk.ok),
                map((response: HttpResponse<ICustomer[]>) => response.body)
            )
            .subscribe((res: ICustomer[]) => (this.customers = res), (res: HttpErrorResponse) => this.onError(res.message));
    }

    previousState() {
        window.history.back();
    }

    save() {
        this.isSaving = true;
        if (this.sibaAccountForm.id !== undefined) {
            this.subscribeToSaveResponse(this.sibaAccountFormService.update(this.sibaAccountForm));
        } else {
            this.subscribeToSaveResponse(this.sibaAccountFormService.create(this.sibaAccountForm));
        }
    }

    protected subscribeToSaveResponse(result: Observable<HttpResponse<ISibaAccountForm>>) {
        result.subscribe((res: HttpResponse<ISibaAccountForm>) => this.onSaveSuccess(), (res: HttpErrorResponse) => this.onSaveError());
    }

    protected onSaveSuccess() {
        this.isSaving = false;
        this.previousState();
    }

    protected onSaveError() {
        this.isSaving = false;
    }

    protected onError(errorMessage: string) {
        this.jhiAlertService.error(errorMessage, null, null);
    }

    trackCustomerById(index: number, item: ICustomer) {
        return item.id;
    }
}
