import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { CustomCacheService } from './custom-cache.service';
import { ServiceBase } from './service-base';
import { map } from 'rxjs/operators';
import { Observable } from 'rxjs';
import { Account } from '../models/account';

@Injectable({
  providedIn: 'root'
})
export class AccountService extends ServiceBase {

  constructor(
    http: HttpClient,
    cache : CustomCacheService
  ) { 
    super(cache, http);
  }

  login(account: Account) : Observable<Account> {
    return this.http.post(`${this.baseUrl}accounts/login`, account)
        .pipe(map(result => result["result"][0])
    );
  }

//TODO: finish register
  registerCuster() : Observable<Account> {
    return this.http.get(`${this.baseUrl}accounts/customers/register`)
        .pipe(map(result => result["result"])
    );
  }
}
