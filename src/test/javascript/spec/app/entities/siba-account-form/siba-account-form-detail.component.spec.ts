/* tslint:disable max-line-length */
import { ComponentFixture, TestBed } from '@angular/core/testing';
import { ActivatedRoute } from '@angular/router';
import { of } from 'rxjs';

import { FormfillerTestModule } from '../../../test.module';
import { SibaAccountFormDetailComponent } from 'app/entities/siba-account-form/siba-account-form-detail.component';
import { SibaAccountForm } from 'app/shared/model/siba-account-form.model';

describe('Component Tests', () => {
    describe('SibaAccountForm Management Detail Component', () => {
        let comp: SibaAccountFormDetailComponent;
        let fixture: ComponentFixture<SibaAccountFormDetailComponent>;
        const route = ({ data: of({ sibaAccountForm: new SibaAccountForm(123) }) } as any) as ActivatedRoute;

        beforeEach(() => {
            TestBed.configureTestingModule({
                imports: [FormfillerTestModule],
                declarations: [SibaAccountFormDetailComponent],
                providers: [{ provide: ActivatedRoute, useValue: route }]
            })
                .overrideTemplate(SibaAccountFormDetailComponent, '')
                .compileComponents();
            fixture = TestBed.createComponent(SibaAccountFormDetailComponent);
            comp = fixture.componentInstance;
        });

        describe('OnInit', () => {
            it('Should call load all on init', () => {
                // GIVEN

                // WHEN
                comp.ngOnInit();

                // THEN
                expect(comp.sibaAccountForm).toEqual(jasmine.objectContaining({ id: 123 }));
            });
        });
    });
});
