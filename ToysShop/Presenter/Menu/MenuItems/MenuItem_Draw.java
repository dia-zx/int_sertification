package ToysShop.Presenter.Menu.MenuItems;

import ToysShop.Model.Shop.Interface.IShop;
import ToysShop.Presenter.Menu.MenuItems.Interface.IMenuItem;
import ToysShop.View.Interface.IView;

/**
 * Пункт меню "Розыгрыш игрушки"
 */
public class MenuItem_Draw implements IMenuItem{
    private String _name = "draw";
    private IShop _shop;
    private IView _view;

    public MenuItem_Draw(IShop shop, IView view) {
        _shop = shop;
        _view = view;
    }


    @Override
    public String get_command_name() {
        return _name;
    }

    @Override
    public String get_description() {
        return "Розыгрыш игрушки";
    }

    @Override
    public void exercute() {
        try {
            _view.print("\n*************************** ");
            int win_id = _shop.draw();
            _view.print("\nПризовая игрушка: " + _shop.get_name(win_id) + "!");

            _view.print("\n Выполнено.\n");
        } catch (Exception e) {
            _view.print("\n" + e.getMessage());
        }
        _view.print("\n" + "Для продолжения нажмите <Enter>");
        _view.input();
    }
    
}
