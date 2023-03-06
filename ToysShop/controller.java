package ToysShop;
import ToysShop.Model.Shop.Shop;
import ToysShop.Presenter.Menu.Menu;
import ToysShop.Presenter.Menu.MenuItems.MenuItem_Add_new_toy;
import ToysShop.Presenter.Menu.MenuItems.MenuItem_Draw;
import ToysShop.Presenter.Menu.MenuItems.MenuItem_Edit_toy;
import ToysShop.Presenter.Menu.MenuItems.MenuItem_GetAllToys;
import ToysShop.Presenter.Menu.MenuItems.MenuItem_Get_Toy;
import ToysShop.Presenter.Menu.MenuItems.MenuItem_Quit;
import ToysShop.View.View;

public class controller {
    View _view;
    Shop _shop;
    Menu _menu;
    public controller() {
        
    }

    public void Start(){
        _view = new View();
        _shop = new Shop();
        _menu = new Menu(_view);

        // создаем пункты меню ..
        _menu.AddMenuItem(new MenuItem_Add_new_toy(_shop, _view));
        _menu.AddMenuItem(new MenuItem_Draw(_shop, _view));
        _menu.AddMenuItem(new MenuItem_Edit_toy(_shop, _view));
        _menu.AddMenuItem(new MenuItem_GetAllToys(_shop, _view));
        _menu.AddMenuItem(new MenuItem_Get_Toy(_shop, _view));
        _menu.AddMenuItem(new MenuItem_Quit());

        _menu.exercute();
    }
}
