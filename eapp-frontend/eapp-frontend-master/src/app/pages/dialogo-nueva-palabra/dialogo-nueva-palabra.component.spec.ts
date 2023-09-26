import { ComponentFixture, TestBed } from '@angular/core/testing';

import { DialogoNuevaPalabraComponent } from './dialogo-nueva-palabra.component';

describe('DialogoNuevaPalabraComponent', () => {
  let component: DialogoNuevaPalabraComponent;
  let fixture: ComponentFixture<DialogoNuevaPalabraComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ DialogoNuevaPalabraComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(DialogoNuevaPalabraComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
