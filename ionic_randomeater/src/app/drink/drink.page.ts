import { Component, Input } from '@angular/core';
import { ModalController, NavParams } from '@ionic/angular';
import { Allergy } from '../models/allergy';
import { Drink } from '../models/drink';
import { CartService } from '../services/cart.service';
import { Area } from '../models/area';

@Component({
  selector: 'app-drink',
  templateUrl: './drink.page.html',
  styleUrls: ['./drink.page.scss'],
})
export class DrinkPage {
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

  randomize() {
    let randomNumber : number =  Math.floor(Math.random() * this.areas.length);
    this.selectedAreas.push(this.areas[randomNumber].id)
  }

  async dismissModal() {
    await this.modalCtrl.dismiss();
  }

  async save(drink: Drink) {
    this.cartService.addDrink(drink);
    this.dismissModal();
  }

  async orderDrink() {
    let drink = new Drink();
    if (this.selectedAllergies != null) {
      drink.allergies = this.selectedAllergies;
    }
    drink.areas = this.selectedAreas;
    drink.size = this.selectedSize;
    drink.amount = this.selectedAmount;

    this.save(drink);
  }
}
