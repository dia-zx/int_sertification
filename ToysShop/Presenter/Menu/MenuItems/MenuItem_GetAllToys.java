package ToysShop.Presenter.Menu.MenuItems;

import ToysShop.Model.Shop.Interface.IShop;
import ToysShop.Model.Toy.Interface.IToy;
import ToysShop.Presenter.Menu.MenuItems.Interface.IMenuItem;
import ToysShop.View.Interface.IView;

/**
 * Пункт меню "Список всех игрушек в магазине".
 */
public class MenuItem_GetAllToys implements IMenuItem {
    private String _name = "get_toys";
    private IShop _shop;
    private IView _view;

    public MenuItem_GetAllToys(IShop shop, IView view) {
        _shop = shop;
        _view = view;
    }

    @Override
    public String get_command_name() {
        return _name;
    }

    @Override
    public String get_description() {
        return "Вывести список игрушек в магазине";
    }

    @Override
    public void exercute() {
        _view.print("\n");
        for (IToy toy : _shop.get_Toys()) // выводим полный список игрушек
            _view.print(toy.toString());
        _view.print("\n Нажмите <Enter>");
        _view.input();
    }

}
