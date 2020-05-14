import { HttpClient } from '@angular/common/http';
import { CustomCacheService } from './custom-cache.service';

export class ServiceBase {
    constructor(
        private cache : CustomCacheService,
        public http : HttpClient
    ) {
        
    }

    loadFromCache(key : string, object : any) : any {
        return this.cache.loadFromCache(key, object);
    }

    public clearCache(key : string) {
    this.cache.clearCache(key);
    }

    clearAll() {
    this.cache.clearAll();
    }

    protected baseUrl : string = "http://localhost:8091/";
}
