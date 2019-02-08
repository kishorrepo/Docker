import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { QuickhealComponent } from './quickheal.component';

describe('QuickhealComponent', () => {
  let component: QuickhealComponent;
  let fixture: ComponentFixture<QuickhealComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ QuickhealComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(QuickhealComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
