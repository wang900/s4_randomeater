import { Component, Input } from '@angular/core';
import { ModalController, NavParams } from '@ionic/angular';
import { CartService } from '../services/cart.service';
import { Allergy } from '../models/allergy';
import { Food } from '../models/food';
import { Area } from '../models/area';

@Component({
  selector: 'app-food',
  templateUrl: './food.page.html',
  styleUrls: ['./food.page.scss'],
})
export class FoodPage {
  @Input() allergies: Allergy[] = [];
  @Input() areas: Area[] = [];

  selectedAllergies: number[] = [];
  selectedAreas: number[] = [];
  selectedSize: number;
  selectedAmount: number = 1;

  constructor(private modalCtrl: ModalController,
    private cartService: CartService,
    public navParams: NavParams) {
  }

  async dismissModal() {
    await this.modalCtrl.dismiss();
  }

  async save(food: Food) {
    this.cartService.addFood(food);
    this.dismissModal();
  }

  async orderFood() {
    let food = new Food()
    if (this.selectedAllergies != null) {
      food.allergies = this.selectedAllergies;
    }
    food.areas = this.selectedAreas;
    food.size = this.selectedSize;
    food.amount = this.selectedAmount;

    this.save(food);
  }

}
