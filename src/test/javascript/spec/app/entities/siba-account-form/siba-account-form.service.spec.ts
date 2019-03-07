/* tslint:disable max-line-length */
import { TestBed, getTestBed } from '@angular/core/testing';
import { HttpClientTestingModule, HttpTestingController } from '@angular/common/http/testing';
import { HttpClient, HttpResponse } from '@angular/common/http';
import { of } from 'rxjs';
import { take, map } from 'rxjs/operators';
import * as moment from 'moment';
import { DATE_FORMAT } from 'app/shared/constants/input.constants';
import { SibaAccountFormService } from 'app/entities/siba-account-form/siba-account-form.service';
import { ISibaAccountForm, SibaAccountForm } from 'app/shared/model/siba-account-form.model';

describe('Service Tests', () => {
    describe('SibaAccountForm Service', () => {
        let injector: TestBed;
        let service: SibaAccountFormService;
        let httpMock: HttpTestingController;
        let elemDefault: ISibaAccountForm;
        let currentDate: moment.Moment;
        beforeEach(() => {
            TestBed.configureTestingModule({
                imports: [HttpClientTestingModule]
            });
            injector = getTestBed();
            service = injector.get(SibaAccountFormService);
            httpMock = injector.get(HttpTestingController);
            currentDate = moment();

            elemDefault = new SibaAccountForm(
                0,
                currentDate,
                'AAAAAAA',
                'AAAAAAA',
                'AAAAAAA',
                'AAAAAAA',
                'AAAAAAA',
                'AAAAAAA',
                'AAAAAAA',
                'AAAAAAA',
                'AAAAAAA',
                'AAAAAAA',
                'AAAAAAA',
                'AAAAAAA',
                'AAAAAAA',
                'AAAAAAA',
                'AAAAAAA',
                'AAAAAAA',
                'AAAAAAA',
                'AAAAAAA',
                'AAAAAAA',
                'AAAAAAA',
                'AAAAAAA',
                'AAAAAAA',
                'AAAAAAA',
                'AAAAAAA',
                'AAAAAAA',
                'AAAAAAA',
                'AAAAAAA',
                'AAAAAAA',
                'AAAAAAA',
                'AAAAAAA',
                'AAAAAAA',
                'AAAAAAA'
            );
        });

        describe('Service methods', async () => {
            it('should find an element', async () => {
                const returnedFromService = Object.assign(
                    {
                        registerDate: currentDate.format(DATE_FORMAT)
                    },
                    elemDefault
                );
                service
                    .find(123)
                    .pipe(take(1))
                    .subscribe(resp => expect(resp).toMatchObject({ body: elemDefault }));

                const req = httpMock.expectOne({ method: 'GET' });
                req.flush(JSON.stringify(returnedFromService));
            });

            it('should create a SibaAccountForm', async () => {
                const returnedFromService = Object.assign(
                    {
                        id: 0,
                        registerDate: currentDate.format(DATE_FORMAT)
                    },
                    elemDefault
                );
                const expected = Object.assign(
                    {
                        registerDate: currentDate
                    },
                    returnedFromService
                );
                service
                    .create(new SibaAccountForm(null))
                    .pipe(take(1))
                    .subscribe(resp => expect(resp).toMatchObject({ body: expected }));
                const req = httpMock.expectOne({ method: 'POST' });
                req.flush(JSON.stringify(returnedFromService));
            });

            it('should update a SibaAccountForm', async () => {
                const returnedFromService = Object.assign(
                    {
                        registerDate: currentDate.format(DATE_FORMAT),
                        registrationNumber: 'BBBBBB',
                        registrationPlace: 'BBBBBB',
                        registrationCapital: 'BBBBBB',
                        activityType: 'BBBBBB',
                        longTime: 'BBBBBB',
                        boardManagementLong: 'BBBBBB',
                        phoneNumber1: 'BBBBBB',
                        phoneNumber2: 'BBBBBB',
                        faxNumber: 'BBBBBB',
                        zipCode: 'BBBBBB',
                        emailAddress: 'BBBBBB',
                        plainAddress: 'BBBBBB',
                        accountRegistrationPurpose: 'BBBBBB',
                        fullName1: 'BBBBBB',
                        fullName2: 'BBBBBB',
                        fullName3: 'BBBBBB',
                        fullName4: 'BBBBBB',
                        fullName5: 'BBBBBB',
                        fullName6: 'BBBBBB',
                        customerNumber1: 'BBBBBB',
                        customerNumber2: 'BBBBBB',
                        customerNumber3: 'BBBBBB',
                        customerNumber4: 'BBBBBB',
                        customerNumber5: 'BBBBBB',
                        customerNumber6: 'BBBBBB',
                        sendingBillCycle: 'BBBBBB',
                        howToSendBill: 'BBBBBB',
                        otherServices: 'BBBBBB',
                        accountType: 'BBBBBB',
                        letterNumber: 'BBBBBB',
                        letterDate: 'BBBBBB',
                        letterOrganization: 'BBBBBB'
                    },
                    elemDefault
                );

                const expected = Object.assign(
                    {
                        registerDate: currentDate
                    },
                    returnedFromService
                );
                service
                    .update(expected)
                    .pipe(take(1))
                    .subscribe(resp => expect(resp).toMatchObject({ body: expected }));
                const req = httpMock.expectOne({ method: 'PUT' });
                req.flush(JSON.stringify(returnedFromService));
            });

            it('should return a list of SibaAccountForm', async () => {
                const returnedFromService = Object.assign(
                    {
                        registerDate: currentDate.format(DATE_FORMAT),
                        registrationNumber: 'BBBBBB',
                        registrationPlace: 'BBBBBB',
                        registrationCapital: 'BBBBBB',
                        activityType: 'BBBBBB',
                        longTime: 'BBBBBB',
                        boardManagementLong: 'BBBBBB',
                        phoneNumber1: 'BBBBBB',
                        phoneNumber2: 'BBBBBB',
                        faxNumber: 'BBBBBB',
                        zipCode: 'BBBBBB',
                        emailAddress: 'BBBBBB',
                        plainAddress: 'BBBBBB',
                        accountRegistrationPurpose: 'BBBBBB',
                        fullName1: 'BBBBBB',
                        fullName2: 'BBBBBB',
                        fullName3: 'BBBBBB',
                        fullName4: 'BBBBBB',
                        fullName5: 'BBBBBB',
                        fullName6: 'BBBBBB',
                        customerNumber1: 'BBBBBB',
                        customerNumber2: 'BBBBBB',
                        customerNumber3: 'BBBBBB',
                        customerNumber4: 'BBBBBB',
                        customerNumber5: 'BBBBBB',
                        customerNumber6: 'BBBBBB',
                        sendingBillCycle: 'BBBBBB',
                        howToSendBill: 'BBBBBB',
                        otherServices: 'BBBBBB',
                        accountType: 'BBBBBB',
                        letterNumber: 'BBBBBB',
                        letterDate: 'BBBBBB',
                        letterOrganization: 'BBBBBB'
                    },
                    elemDefault
                );
                const expected = Object.assign(
                    {
                        registerDate: currentDate
                    },
                    returnedFromService
                );
                service
                    .query(expected)
                    .pipe(
                        take(1),
                        map(resp => resp.body)
                    )
                    .subscribe(body => expect(body).toContainEqual(expected));
                const req = httpMock.expectOne({ method: 'GET' });
                req.flush(JSON.stringify([returnedFromService]));
                httpMock.verify();
            });

            it('should delete a SibaAccountForm', async () => {
                const rxPromise = service.delete(123).subscribe(resp => expect(resp.ok));

                const req = httpMock.expectOne({ method: 'DELETE' });
                req.flush({ status: 200 });
            });
        });

        afterEach(() => {
            httpMock.verify();
        });
    });
});
