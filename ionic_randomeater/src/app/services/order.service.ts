import { Injectable } from '@angular/core';
import { Order } from '../models/order';
import { Observable, of } from 'rxjs';
import { HttpClient } from '@angular/common/http';
import { map } from 'rxjs/operators';
import { CustomCacheService } from './custom-cache.service';
import { ServiceBase } from './service-base';

@Injectable({
  providedIn: 'root'
})
export class OrderService extends ServiceBase {

  private Orders: Order[];

  constructor(
    http: HttpClient,
    cache : CustomCacheService
  ) { 
    super(cache, http);
  }

  getOrders(): Observable<Order[]> {
    return this.loadFromCache(
      "orders", 
      this.http.get(`${this.baseUrl}orders/`)
        .pipe(map(results => results["result"]))
    );
  }

  getOrderById(id : number) : Observable<Order> {
    return this.loadFromCache(
      `order[${id}]`,
      this.http.get(`${this.baseUrl}orders/${id}`)
        .pipe(map(result => result["result"][0]))
    );
  }

  searchOrders(search : string) : Observable<Order[]> {
    return this.loadFromCache(
      `medsearch[${search}]`,
      this.http.get(`${this.baseUrl}orders/search?search=${search}`)
        .pipe(map(results => results["result"]))
    );
  }
  
}
