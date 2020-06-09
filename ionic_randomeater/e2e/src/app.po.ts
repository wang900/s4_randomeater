import { browser, by, element } from 'protractor';

export class AppPage {
  navigateTo(url: string) {
    return browser.get('/' + url);
  }

  getWelcomeMessage() {
    return element(by.css('h1')).getText();
  }

  getPageTitle() {
    return element(by.css('ion-title')).getText();
  }

  getPageNavBar() {
    return element(by.css('ion-tabs'));
  }

  getHomeButton() {
    return element(by.css('[tab="home"]'));
  }

  getOrderButton() {
    return element(by.css('[tab="orders"]'));
  }

  getLoginButton() {
    return element(by.css('[tab="login"]'));
  }

  getCartButton() {
    return element(by.css('[tab="cart"]'));
  }
}
