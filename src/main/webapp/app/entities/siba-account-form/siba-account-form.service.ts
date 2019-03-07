import { Injectable } from '@angular/core';
import { HttpClient, HttpResponse } from '@angular/common/http';
import { Observable } from 'rxjs';
import * as moment from 'moment';
import { DATE_FORMAT } from 'app/shared/constants/input.constants';
import { map } from 'rxjs/operators';

import { SERVER_API_URL } from 'app/app.constants';
import { createRequestOption } from 'app/shared';
import { ISibaAccountForm } from 'app/shared/model/siba-account-form.model';

type EntityResponseType = HttpResponse<ISibaAccountForm>;
type EntityArrayResponseType = HttpResponse<ISibaAccountForm[]>;

@Injectable({ providedIn: 'root' })
export class SibaAccountFormService {
    public resourceUrl = SERVER_API_URL + 'api/siba-account-forms';

    constructor(protected http: HttpClient) {}

    create(sibaAccountForm: ISibaAccountForm): Observable<EntityResponseType> {
        const copy = this.convertDateFromClient(sibaAccountForm);
        return this.http
            .post<ISibaAccountForm>(this.resourceUrl, copy, { observe: 'response' })
            .pipe(map((res: EntityResponseType) => this.convertDateFromServer(res)));
    }

    update(sibaAccountForm: ISibaAccountForm): Observable<EntityResponseType> {
        const copy = this.convertDateFromClient(sibaAccountForm);
        return this.http
            .put<ISibaAccountForm>(this.resourceUrl, copy, { observe: 'response' })
            .pipe(map((res: EntityResponseType) => this.convertDateFromServer(res)));
    }

    find(id: number): Observable<EntityResponseType> {
        return this.http
            .get<ISibaAccountForm>(`${this.resourceUrl}/${id}`, { observe: 'response' })
            .pipe(map((res: EntityResponseType) => this.convertDateFromServer(res)));
    }

    query(req?: any): Observable<EntityArrayResponseType> {
        const options = createRequestOption(req);
        return this.http
            .get<ISibaAccountForm[]>(this.resourceUrl, { params: options, observe: 'response' })
            .pipe(map((res: EntityArrayResponseType) => this.convertDateArrayFromServer(res)));
    }

    delete(id: number): Observable<HttpResponse<any>> {
        return this.http.delete<any>(`${this.resourceUrl}/${id}`, { observe: 'response' });
    }

    protected convertDateFromClient(sibaAccountForm: ISibaAccountForm): ISibaAccountForm {
        const copy: ISibaAccountForm = Object.assign({}, sibaAccountForm, {
            registerDate:
                sibaAccountForm.registerDate != null && sibaAccountForm.registerDate.isValid()
                    ? sibaAccountForm.registerDate.format(DATE_FORMAT)
                    : null
        });
        return copy;
    }

    protected convertDateFromServer(res: EntityResponseType): EntityResponseType {
        if (res.body) {
            res.body.registerDate = res.body.registerDate != null ? moment(res.body.registerDate) : null;
        }
        return res;
    }

    protected convertDateArrayFromServer(res: EntityArrayResponseType): EntityArrayResponseType {
        if (res.body) {
            res.body.forEach((sibaAccountForm: ISibaAccountForm) => {
                sibaAccountForm.registerDate = sibaAccountForm.registerDate != null ? moment(sibaAccountForm.registerDate) : null;
            });
        }
        return res;
    }
}
