import { TestBed } from '@angular/core/testing';

import { RelationService } from './relation.service';

describe('RelationService', () => {
  beforeEach(() => TestBed.configureTestingModule({}));

  it('should be created', () => {
    const service: RelationService = TestBed.get(RelationService);
    expect(service).toBeTruthy();
  });
});
