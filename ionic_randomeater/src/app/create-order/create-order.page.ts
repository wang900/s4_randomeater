import { Component } from '@angular/core';
import { ModalController } from '@ionic/angular';
import { DrinkPage } from '../drink/drink.page';
import { FoodPage } from '../food/food.page';
import { Drink } from '../models/drink';

@Component({
  selector: 'app-create-order',
  templateUrl: 'create-order.page.html',
  styleUrls: ['create-order.page.scss']
})
export class CreateOrderPage {

  drinks : Drink[] = []

  constructor(public modalController : ModalController) {
  }

  async presentDrinkModal() {
    const modal = await this.modalController.create({
      component: DrinkPage,
      componentProps: { drinks: this.drinks }
    });

    modal.onDidDismiss()
    .then((data) => {
     const drink = data['data']; // Here's your selected drink!
      
  });
    return await modal.present();
  }

  async presentFoodModal() {
    const modal = await this.modalController.create({
      component: FoodPage
    });
    return await modal.present();
  }
}
