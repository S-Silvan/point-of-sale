import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root',
})
export class OrderService {
  private baseUrl = 'https://pos-customer.herokuapp.com/customer/';
  constructor(private httpClient: HttpClient) {}

  public getOrders(customerId): Observable<any> {
    return this.httpClient.get(this.baseUrl + 'orders/' + customerId);
  }

  public getOrder(orderId): Observable<any> {
    return this.httpClient.get(this.baseUrl + 'order/' + orderId);
  }
}
