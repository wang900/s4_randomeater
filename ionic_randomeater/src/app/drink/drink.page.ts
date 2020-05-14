import { Component, OnInit } from '@angular/core';
import { ModalController, LoadingController } from '@ionic/angular';
import { AllergyService } from '../services/allergy.service';
import { Allergy } from '../models/allergy';
import { Drink } from '../models/drink';

@Component({
  selector: 'app-drink',
  templateUrl: './drink.page.html',
  styleUrls: ['./drink.page.scss'],
})
export class DrinkPage implements OnInit {

  modalCtrl: ModalController
  allergies: Allergy[] = [];
  loadingController: LoadingController;
  drinks : Drink[] = []

  selectedAllergies: string[] = [];
  selectedAreas: string[] = [];
  selectedSize: number;
  selectedAmount: number;

  constructor(modalCtrl: ModalController,
    private allergyService: AllergyService,
    loadingController: LoadingController) {
    this.modalCtrl = modalCtrl;
    this.loadingController = loadingController;
  }

  ngOnInit() {
    this.getAllergies();
  }

  optionsAllergies(allergies : string[]) {
    this.selectedAllergies = allergies;
  }


  optionsAreas(areas : string[]) {
    this.selectedAreas = areas;
  }

  optionsSize(size : number) {
    this.selectedSize = size;
  }

  async dismissModal() {
    await this.modalCtrl.dismiss(null);
  }

  async save(drink : Drink){
    await this.modalCtrl.dismiss(drink);
  }

  async getAllergies(): Promise<void> {
    const loading = await this.loadingController.create({
      message: "Please wait...",
    });
    await loading.present();
    this.allergyService.getAllergies()
      .subscribe(allergies => this.allergies = allergies);
    await loading.dismiss();
  }

  async orderDrink() {
    let drink = new Drink()
    
    drink.allergies = this.selectedAllergies;
    drink.areas = this.selectedAreas;
    drink.size = this.selectedSize;
    drink.amount = this.selectedAmount;

    console.log(drink.areas[0] + drink.allergies[0])
    //this.save(drink);
  }
}
