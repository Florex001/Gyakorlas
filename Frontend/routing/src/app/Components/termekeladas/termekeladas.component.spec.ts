import { ComponentFixture, TestBed } from '@angular/core/testing';

import { TermekeladasComponent } from './termekeladas.component';

describe('TermekeladasComponent', () => {
  let component: TermekeladasComponent;
  let fixture: ComponentFixture<TermekeladasComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [TermekeladasComponent]
    });
    fixture = TestBed.createComponent(TermekeladasComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
