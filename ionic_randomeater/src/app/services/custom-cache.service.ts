import { Injectable } from '@angular/core';
import { CacheService } from "ionic-cache";

@Injectable({
  providedIn: 'root'
})
export class CustomCacheService {

  constructor(
    private cache : CacheService
  ) { }

  loadFromCache(key : string, object : any) : any {
    return this.cache.loadFromObservable(key, object);
  }

  clearCache(key : string) {
    this.cache.clearGroup(key);
  }

  clearAll() {
    this.cache.clearAll();
  }
}
