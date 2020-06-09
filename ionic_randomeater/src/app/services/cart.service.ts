import { Injectable } from '@angular/core';
import { Drink } from '../models/drink';
import { Food } from '../models/food';

@Injectable({
    providedIn: 'root'
})
export class CartService {
    totalAmount: number = 0
    drinks: Drink[] = [];
    food: Food[] = [];

    addDrink(drink: Drink) {
        this.totalAmount += drink.amount;
        drink.price = this.calculatePrice(drink.size, drink.amount)
        this.drinks.push(drink);
    }

    addFood(food: Food) {
        this.totalAmount += food.amount;
        this.food.push(food);
    }

    calculatePrice(size: number, amount: number): number {
        let standardPrice: number;
        switch (size) {
            case 0:
                standardPrice = 6;
                break;
            case 1:
                standardPrice = 8
                break;
            case 2:
                standardPrice = 10
                break;
            default:
            standardPrice = 1000;
            break;
        }
        return standardPrice * amount;
    }

    getDrinks(): Drink[] {
        return this.drinks;
    }

    getFood() {
        return this.food;
    }

    removeDrink(index: number) {
        this.totalAmount -= this.drinks[index].amount;
        this.drinks.splice(index, 1);
    }

    removeFood(index: number) {
        this.totalAmount -= this.food[index].amount;
        this.food.splice(index, 1)
    }

    clearAll() {
        this.totalAmount = 0;
        this.drinks = [];
        this.food = [];
    }

    getCartAmount(): number {
        return this.totalAmount;
    }
}