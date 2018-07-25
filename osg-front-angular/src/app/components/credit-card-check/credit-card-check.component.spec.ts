import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { CreditCardCheckComponent } from './credit-card-check.component';

describe('CreditCardCheckComponent', () => {
  let component: CreditCardCheckComponent;
  let fixture: ComponentFixture<CreditCardCheckComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ CreditCardCheckComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(CreditCardCheckComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
