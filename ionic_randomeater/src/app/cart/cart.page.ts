import { Component, OnInit } from '@angular/core';
import { CartService } from '../services/cart.service';
import { Drink } from '../models/drink';
import { Food } from '../models/food';
import { Router } from '@angular/router';

@Component({
  selector: 'app-cart',
  templateUrl: './cart.page.html',
  styleUrls: ['./cart.page.scss'],
})
export class CartPage implements OnInit {
  private drinkList: Drink[] = [];
  private foodList: Food[] = [];
  constructor(private cartService: CartService,
    private router: Router) {
  }

  checkOut() {
    this.router.navigateByUrl("check-out")
  }

  ngOnInit() {
    this.drinkList = this.cartService.getDrinks();
    this.foodList = this.cartService.getFood();
  }

}
