import { Component, OnInit, OnDestroy } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';

import { NgbActiveModal, NgbModal, NgbModalRef } from '@ng-bootstrap/ng-bootstrap';
import { JhiEventManager } from 'ng-jhipster';

import { ISibaAccountForm } from 'app/shared/model/siba-account-form.model';
import { SibaAccountFormService } from './siba-account-form.service';

@Component({
    selector: 'jhi-siba-account-form-delete-dialog',
    templateUrl: './siba-account-form-delete-dialog.component.html'
})
export class SibaAccountFormDeleteDialogComponent {
    sibaAccountForm: ISibaAccountForm;

    constructor(
        protected sibaAccountFormService: SibaAccountFormService,
        public activeModal: NgbActiveModal,
        protected eventManager: JhiEventManager
    ) {}

    clear() {
        this.activeModal.dismiss('cancel');
    }

    confirmDelete(id: number) {
        this.sibaAccountFormService.delete(id).subscribe(response => {
            this.eventManager.broadcast({
                name: 'sibaAccountFormListModification',
                content: 'Deleted an sibaAccountForm'
            });
            this.activeModal.dismiss(true);
        });
    }
}

@Component({
    selector: 'jhi-siba-account-form-delete-popup',
    template: ''
})
export class SibaAccountFormDeletePopupComponent implements OnInit, OnDestroy {
    protected ngbModalRef: NgbModalRef;

    constructor(protected activatedRoute: ActivatedRoute, protected router: Router, protected modalService: NgbModal) {}

    ngOnInit() {
        this.activatedRoute.data.subscribe(({ sibaAccountForm }) => {
            setTimeout(() => {
                this.ngbModalRef = this.modalService.open(SibaAccountFormDeleteDialogComponent as Component, {
                    size: 'lg',
                    backdrop: 'static'
                });
                this.ngbModalRef.componentInstance.sibaAccountForm = sibaAccountForm;
                this.ngbModalRef.result.then(
                    result => {
                        this.router.navigate(['/siba-account-form', { outlets: { popup: null } }]);
                        this.ngbModalRef = null;
                    },
                    reason => {
                        this.router.navigate(['/siba-account-form', { outlets: { popup: null } }]);
                        this.ngbModalRef = null;
                    }
                );
            }, 0);
        });
    }

    ngOnDestroy() {
        this.ngbModalRef = null;
    }
}
