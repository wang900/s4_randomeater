import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { CustomCacheService } from './custom-cache.service';
import { ServiceBase } from './service-base';
import { map } from 'rxjs/operators';
import { Observable } from 'rxjs';
import { Allergy } from '../models/allergy';

@Injectable({
  providedIn: 'root'
})
export class AllergyService extends ServiceBase {

  constructor(
    http: HttpClient,
    cache : CustomCacheService
  ) { 
    super(cache, http);
  }

  getAllergyById(id : number) : Observable<Allergy> {
    return this.loadFromCache(
      `allergys[${id}]`,
      this.http.get(`${this.baseUrl}allergies/${id}`)
        .pipe(map(result => result["result"][0]))
    );
  }

  getAllergies() : Observable<Allergy[]> {
    return this.loadFromCache(
      `allergies`,
      this.http.get(`${this.baseUrl}allergies/`)
        .pipe(map(result => result["result"]))
    );
  }
}
