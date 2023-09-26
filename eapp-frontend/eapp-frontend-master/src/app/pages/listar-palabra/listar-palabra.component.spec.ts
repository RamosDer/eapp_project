import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ListarPalabraComponent } from './listar-palabra.component';


describe('ListarPalabraComponent', () => {
  let component: ListarPalabraComponent;
  let fixture: ComponentFixture<ListarPalabraComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ ListarPalabraComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(ListarPalabraComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
