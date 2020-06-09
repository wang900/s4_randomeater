import { Component, OnInit } from '@angular/core';
import { ModalController, LoadingController } from '@ionic/angular';
import { DrinkPage } from '../drink/drink.page';
import { FoodPage } from '../food/food.page';
import { Drink } from '../models/drink';
import { NavigationExtras } from '@angular/router';
import { Food } from '../models/food';
import { CartService } from '../services/cart.service';
import { Allergy } from '../models/allergy';
import { Area } from '../models/area';
import { AreaService } from '../services/area.service';
import { AllergyService } from '../services/allergy.service';


@Component({
  selector: 'app-create-order',
  templateUrl: 'create-order.page.html',
  styleUrls: ['create-order.page.scss']
})
export class CreateOrderPage implements OnInit {
  allergies: Allergy[] = [];
  areas: Area[] = [];

  drinks : Drink[] = [];
  foods : Food[] = [];
  navigationExtras : NavigationExtras;

  constructor(private modalController : ModalController, 
    private cartService : CartService,
    private loadingController: LoadingController,
    private areaService: AreaService,
    private allergyService: AllergyService) {
  }

  ngOnInit() {
    this.getInfo();
  }

  async getInfo(): Promise<void> {
    const loading = await this.loadingController.create({
      message: "Please wait...",
    });
    await loading.present();
    this.getAllergies();
    this.getAreas();
    await loading.dismiss();
  }

  async getAllergies() {
    this.allergyService.getAllergies()
    .subscribe(allergies => this.allergies = allergies);
  }

  async getAreas() {
    this.areaService.getAreas()
    .subscribe(areas => this.areas = areas);
  }

  async presentDrinkModal() {
    const modal = await this.modalController.create({
      component: DrinkPage,
      componentProps: {
        'allergies': this.allergies,
        'areas': this.areas
      }
    });

  modal.onDidDismiss()
    .then(() => {
      this.cartService.getCartAmount();
   });
    return await modal.present();
  }

  async presentFoodModal() {
    const modal = await this.modalController.create({
      component: FoodPage,
      componentProps: {
        'allergies': this.allergies,
        'areas': this.areas
      }
    });
    return await modal.present();
  }
}
