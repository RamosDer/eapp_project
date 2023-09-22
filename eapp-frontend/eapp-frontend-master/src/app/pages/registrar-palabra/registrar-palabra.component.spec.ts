import { ComponentFixture, TestBed } from '@angular/core/testing';

import { RegistrarPalabraComponent } from './registrar-palabra.component';


describe('RegistrarPalabraComponent', () => {
  let component: RegistrarPalabraComponent;
  let fixture: ComponentFixture<RegistrarPalabraComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ RegistrarPalabraComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(RegistrarPalabraComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
