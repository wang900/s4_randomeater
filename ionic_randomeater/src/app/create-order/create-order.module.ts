import { IonicModule } from '@ionic/angular';
import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { FormsModule } from '@angular/forms';
import { CreateOrderPage } from './create-order.page';
import { ExploreContainerComponentModule } from '../explore-container/explore-container.module';

import { CreateOrderPageRoutingModule } from './create-order-routing.module';

@NgModule({
  imports: [
    IonicModule,
    CommonModule,
    FormsModule,
    ExploreContainerComponentModule,
    CreateOrderPageRoutingModule
  ],
  declarations: [CreateOrderPage]
})
export class CreateOrderPageModule {}
