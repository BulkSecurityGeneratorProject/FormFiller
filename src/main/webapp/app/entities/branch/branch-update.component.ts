import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { HttpResponse, HttpErrorResponse } from '@angular/common/http';
import { Observable } from 'rxjs';
import { filter, map } from 'rxjs/operators';
import { JhiAlertService } from 'ng-jhipster';
import { IBranch } from 'app/shared/model/branch.model';
import { BranchService } from './branch.service';
import { IBank } from 'app/shared/model/bank.model';
import { BankService } from 'app/entities/bank';
import { IAddress } from 'app/shared/model/address.model';
import { AddressService } from 'app/entities/address';

@Component({
    selector: 'jhi-branch-update',
    templateUrl: './branch-update.component.html'
})
export class BranchUpdateComponent implements OnInit {
    branch: IBranch;
    isSaving: boolean;

    banks: IBank[];

    addresses: IAddress[];

    constructor(
        protected jhiAlertService: JhiAlertService,
        protected branchService: BranchService,
        protected bankService: BankService,
        protected addressService: AddressService,
        protected activatedRoute: ActivatedRoute
    ) {}

    ngOnInit() {
        this.isSaving = false;
        this.activatedRoute.data.subscribe(({ branch }) => {
            this.branch = branch;
        });
        this.bankService
            .query()
            .pipe(
                filter((mayBeOk: HttpResponse<IBank[]>) => mayBeOk.ok),
                map((response: HttpResponse<IBank[]>) => response.body)
            )
            .subscribe((res: IBank[]) => (this.banks = res), (res: HttpErrorResponse) => this.onError(res.message));
        this.addressService
            .query({ filter: 'branch-is-null' })
            .pipe(
                filter((mayBeOk: HttpResponse<IAddress[]>) => mayBeOk.ok),
                map((response: HttpResponse<IAddress[]>) => response.body)
            )
            .subscribe(
                (res: IAddress[]) => {
                    if (!this.branch.address || !this.branch.address.id) {
                        this.addresses = res;
                    } else {
                        this.addressService
                            .find(this.branch.address.id)
                            .pipe(
                                filter((subResMayBeOk: HttpResponse<IAddress>) => subResMayBeOk.ok),
                                map((subResponse: HttpResponse<IAddress>) => subResponse.body)
                            )
                            .subscribe(
                                (subRes: IAddress) => (this.addresses = [subRes].concat(res)),
                                (subRes: HttpErrorResponse) => this.onError(subRes.message)
                            );
                    }
                },
                (res: HttpErrorResponse) => this.onError(res.message)
            );
    }

    previousState() {
        window.history.back();
    }

    save() {
        this.isSaving = true;
        if (this.branch.id !== undefined) {
            this.subscribeToSaveResponse(this.branchService.update(this.branch));
        } else {
            this.subscribeToSaveResponse(this.branchService.create(this.branch));
        }
    }

    protected subscribeToSaveResponse(result: Observable<HttpResponse<IBranch>>) {
        result.subscribe((res: HttpResponse<IBranch>) => this.onSaveSuccess(), (res: HttpErrorResponse) => this.onSaveError());
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

    trackBankById(index: number, item: IBank) {
        return item.id;
    }

    trackAddressById(index: number, item: IAddress) {
        return item.id;
    }
}
