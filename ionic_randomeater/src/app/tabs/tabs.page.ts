import { Component, OnInit, OnChanges, AfterContentChecked } from '@angular/core';
import { Router } from '@angular/router';
import { CartService } from '../services/cart.service';

@Component({
  selector: 'app-tabs',
  templateUrl: 'tabs.page.html',
  styleUrls: ['tabs.page.scss']
})
export class TabsPage implements OnInit {
  router: Router;
  cartService: CartService;
  amount: number;

  constructor(router : Router, cartService: CartService) { 
    this.router = router;
    this.cartService = cartService;
  }
  ngOnInit(): void {
    this.refreshAmount();
  }

  refreshAmount() {
    this.amount = this.cartService.getCartAmount();
  }

  toHome() {
    this.refreshAmount();
    this.router.navigate(['/home']);
  }

  toOrder() {
    this.refreshAmount();
    this.router.navigate(['/orders']);
  }

  toLogin() {
    this.refreshAmount();
    this.router.navigate(['/login']);
  }

  toCart() {
    this.refreshAmount();
    this.router.navigate(['/cart']);
  }
}
