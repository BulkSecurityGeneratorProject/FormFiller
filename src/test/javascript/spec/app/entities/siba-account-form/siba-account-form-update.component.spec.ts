/* tslint:disable max-line-length */
import { ComponentFixture, TestBed, fakeAsync, tick } from '@angular/core/testing';
import { HttpResponse } from '@angular/common/http';
import { Observable, of } from 'rxjs';

import { FormfillerTestModule } from '../../../test.module';
import { SibaAccountFormUpdateComponent } from 'app/entities/siba-account-form/siba-account-form-update.component';
import { SibaAccountFormService } from 'app/entities/siba-account-form/siba-account-form.service';
import { SibaAccountForm } from 'app/shared/model/siba-account-form.model';

describe('Component Tests', () => {
    describe('SibaAccountForm Management Update Component', () => {
        let comp: SibaAccountFormUpdateComponent;
        let fixture: ComponentFixture<SibaAccountFormUpdateComponent>;
        let service: SibaAccountFormService;

        beforeEach(() => {
            TestBed.configureTestingModule({
                imports: [FormfillerTestModule],
                declarations: [SibaAccountFormUpdateComponent]
            })
                .overrideTemplate(SibaAccountFormUpdateComponent, '')
                .compileComponents();

            fixture = TestBed.createComponent(SibaAccountFormUpdateComponent);
            comp = fixture.componentInstance;
            service = fixture.debugElement.injector.get(SibaAccountFormService);
        });

        describe('save', () => {
            it('Should call update service on save for existing entity', fakeAsync(() => {
                // GIVEN
                const entity = new SibaAccountForm(123);
                spyOn(service, 'update').and.returnValue(of(new HttpResponse({ body: entity })));
                comp.sibaAccountForm = entity;
                // WHEN
                comp.save();
                tick(); // simulate async

                // THEN
                expect(service.update).toHaveBeenCalledWith(entity);
                expect(comp.isSaving).toEqual(false);
            }));

            it('Should call create service on save for new entity', fakeAsync(() => {
                // GIVEN
                const entity = new SibaAccountForm();
                spyOn(service, 'create').and.returnValue(of(new HttpResponse({ body: entity })));
                comp.sibaAccountForm = entity;
                // WHEN
                comp.save();
                tick(); // simulate async

                // THEN
                expect(service.create).toHaveBeenCalledWith(entity);
                expect(comp.isSaving).toEqual(false);
            }));
        });
    });
});
