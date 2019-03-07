import { Injectable } from '@angular/core';
import { HttpResponse } from '@angular/common/http';
import { Resolve, ActivatedRouteSnapshot, RouterStateSnapshot, Routes } from '@angular/router';
import { UserRouteAccessService } from 'app/core';
import { Observable, of } from 'rxjs';
import { filter, map } from 'rxjs/operators';
import { SibaAccountForm } from 'app/shared/model/siba-account-form.model';
import { SibaAccountFormService } from './siba-account-form.service';
import { SibaAccountFormComponent } from './siba-account-form.component';
import { SibaAccountFormDetailComponent } from './siba-account-form-detail.component';
import { SibaAccountFormUpdateComponent } from './siba-account-form-update.component';
import { SibaAccountFormDeletePopupComponent } from './siba-account-form-delete-dialog.component';
import { ISibaAccountForm } from 'app/shared/model/siba-account-form.model';

@Injectable({ providedIn: 'root' })
export class SibaAccountFormResolve implements Resolve<ISibaAccountForm> {
    constructor(private service: SibaAccountFormService) {}

    resolve(route: ActivatedRouteSnapshot, state: RouterStateSnapshot): Observable<ISibaAccountForm> {
        const id = route.params['id'] ? route.params['id'] : null;
        if (id) {
            return this.service.find(id).pipe(
                filter((response: HttpResponse<SibaAccountForm>) => response.ok),
                map((sibaAccountForm: HttpResponse<SibaAccountForm>) => sibaAccountForm.body)
            );
        }
        return of(new SibaAccountForm());
    }
}

export const sibaAccountFormRoute: Routes = [
    {
        path: '',
        component: SibaAccountFormComponent,
        data: {
            authorities: ['ROLE_USER'],
            pageTitle: 'formfillerApp.sibaAccountForm.home.title'
        },
        canActivate: [UserRouteAccessService]
    },
    {
        path: ':id/view',
        component: SibaAccountFormDetailComponent,
        resolve: {
            sibaAccountForm: SibaAccountFormResolve
        },
        data: {
            authorities: ['ROLE_USER'],
            pageTitle: 'formfillerApp.sibaAccountForm.home.title'
        },
        canActivate: [UserRouteAccessService]
    },
    {
        path: 'new',
        component: SibaAccountFormUpdateComponent,
        resolve: {
            sibaAccountForm: SibaAccountFormResolve
        },
        data: {
            authorities: ['ROLE_USER'],
            pageTitle: 'formfillerApp.sibaAccountForm.home.title'
        },
        canActivate: [UserRouteAccessService]
    },
    {
        path: ':id/edit',
        component: SibaAccountFormUpdateComponent,
        resolve: {
            sibaAccountForm: SibaAccountFormResolve
        },
        data: {
            authorities: ['ROLE_USER'],
            pageTitle: 'formfillerApp.sibaAccountForm.home.title'
        },
        canActivate: [UserRouteAccessService]
    }
];

export const sibaAccountFormPopupRoute: Routes = [
    {
        path: ':id/delete',
        component: SibaAccountFormDeletePopupComponent,
        resolve: {
            sibaAccountForm: SibaAccountFormResolve
        },
        data: {
            authorities: ['ROLE_USER'],
            pageTitle: 'formfillerApp.sibaAccountForm.home.title'
        },
        canActivate: [UserRouteAccessService],
        outlet: 'popup'
    }
];
