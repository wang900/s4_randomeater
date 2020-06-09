import { AppPage } from './app.po';

describe('new App', () => {
  let page: AppPage;

  beforeEach(() => {
    page = new AppPage();
  });

  it('should display welcome message', () => {
    page.navigateTo('');
    expect(page.getWelcomeMessage()).toEqual('Too much choice? Eat random, and be stress free!');
  });

  it('should display home tab button', () => {
    expect(page.getHomeButton().getText()).toEqual('Home');
  });

  it('should display orders tab button', () => {
    expect(page.getOrderButton().getText()).toEqual('Order');
  });

  it('should display login tab button', () => {
    expect(page.getLoginButton().getText()).toEqual('Login');
  });

  it('should display cart tab button', () => {
    expect(page.getCartButton().getText()).toEqual('0Cart');
  });

  it('should display navbar', () => {
    expect(page.getPageNavBar()).toBeDefined();
  });



  it('should display order message', () => {
    page.navigateTo('orders');
    expect(page.getPageTitle()).toEqual('Order');
  });
});
