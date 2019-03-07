/* tslint:disable max-line-length */
import { ComponentFixture, TestBed, inject, fakeAsync, tick } from '@angular/core/testing';
import { NgbActiveModal } from '@ng-bootstrap/ng-bootstrap';
import { Observable, of } from 'rxjs';
import { JhiEventManager } from 'ng-jhipster';

import { FormfillerTestModule } from '../../../test.module';
import { SibaAccountFormDeleteDialogComponent } from 'app/entities/siba-account-form/siba-account-form-delete-dialog.component';
import { SibaAccountFormService } from 'app/entities/siba-account-form/siba-account-form.service';

describe('Component Tests', () => {
    describe('SibaAccountForm Management Delete Component', () => {
        let comp: SibaAccountFormDeleteDialogComponent;
        let fixture: ComponentFixture<SibaAccountFormDeleteDialogComponent>;
        let service: SibaAccountFormService;
        let mockEventManager: any;
        let mockActiveModal: any;

        beforeEach(() => {
            TestBed.configureTestingModule({
                imports: [FormfillerTestModule],
                declarations: [SibaAccountFormDeleteDialogComponent]
            })
                .overrideTemplate(SibaAccountFormDeleteDialogComponent, '')
                .compileComponents();
            fixture = TestBed.createComponent(SibaAccountFormDeleteDialogComponent);
            comp = fixture.componentInstance;
            service = fixture.debugElement.injector.get(SibaAccountFormService);
            mockEventManager = fixture.debugElement.injector.get(JhiEventManager);
            mockActiveModal = fixture.debugElement.injector.get(NgbActiveModal);
        });

        describe('confirmDelete', () => {
            it('Should call delete service on confirmDelete', inject(
                [],
                fakeAsync(() => {
                    // GIVEN
                    spyOn(service, 'delete').and.returnValue(of({}));

                    // WHEN
                    comp.confirmDelete(123);
                    tick();

                    // THEN
                    expect(service.delete).toHaveBeenCalledWith(123);
                    expect(mockActiveModal.dismissSpy).toHaveBeenCalled();
                    expect(mockEventManager.broadcastSpy).toHaveBeenCalled();
                })
            ));
        });
    });
});
