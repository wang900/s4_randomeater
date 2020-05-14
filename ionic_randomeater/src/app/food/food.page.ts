import { Component, OnInit } from '@angular/core';
import { ModalController } from '@ionic/angular';

@Component({
  selector: 'app-food',
  templateUrl: './food.page.html',
  styleUrls: ['./food.page.scss'],
})
export class FoodPage implements OnInit {
  modalCtrl: ModalController
  
  constructor(modalCtrl: ModalController) { 
    this.modalCtrl = modalCtrl;
  }

  ngOnInit() {
  }

  async dismissModal() {
      await this.modalCtrl.dismiss();
  }
}
