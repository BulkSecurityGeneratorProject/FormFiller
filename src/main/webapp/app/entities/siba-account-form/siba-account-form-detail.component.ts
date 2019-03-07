import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';

import { ISibaAccountForm } from 'app/shared/model/siba-account-form.model';

@Component({
    selector: 'jhi-siba-account-form-detail',
    templateUrl: './siba-account-form-detail.component.html'
})
export class SibaAccountFormDetailComponent implements OnInit {
    sibaAccountForm: ISibaAccountForm;

    constructor(protected activatedRoute: ActivatedRoute) {}

    ngOnInit() {
        this.activatedRoute.data.subscribe(({ sibaAccountForm }) => {
            this.sibaAccountForm = sibaAccountForm;
        });
    }

    previousState() {
        window.history.back();
    }
}
