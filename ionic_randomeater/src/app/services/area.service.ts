import { Injectable } from '@angular/core';
import { ServiceBase } from './service-base';
import { HttpClient } from '@angular/common/http';
import { CustomCacheService } from './custom-cache.service';
import { Observable } from 'rxjs';
import { Area } from '../models/area';
import { map } from 'rxjs/operators';

@Injectable({
    providedIn: 'root'
  })
  export class AreaService extends ServiceBase {
  
    constructor(
      http: HttpClient,
      cache : CustomCacheService
    ) { 
      super(cache, http);
    }
  
    getAreaById(id : number) : Observable<Area> {
      return this.loadFromCache(
        `areas[${id}]`,
        this.http.get(`${this.baseUrl}areas/${id}`)
          .pipe(map(result => result["result"][0]))
      );
    }
  
    getAreas() : Observable<Area[]> {
      return this.loadFromCache(
        `areas`,
        this.http.get(`${this.baseUrl}areas/`)
          .pipe(map(result => result["result"]))
      );
    }
  }