package ToysShop.Presenter.Menu.MenuItems;

import ToysShop.Model.Shop.Interface.IShop;
import ToysShop.Presenter.Menu.MenuItems.Interface.IMenuItem;
import ToysShop.View.Interface.IView;

/**
 * Пункт меню "Добавление новой игрушки"
 */
public class MenuItem_Add_new_toy implements IMenuItem {
    private String _name = "new_toy";
    private IShop _shop;
    private IView _view;
    
    public MenuItem_Add_new_toy(IShop shop, IView view) {
        _shop = shop;
        _view = view;
    }

    @Override
    public String get_command_name() {
        return _name;
    }

    @Override
    public String get_description() {
        return "Добавление новой игрушки";
    }

    @Override
    public void exercute() {
        try {
            _view.print("\nВведите имя игрушки для редактирования: ");
            String input = _view.input();
            String new_name  = input;

            _view.print("\nВведите количество игрушек: ");
            input = _view.input();
            int new_count = Integer.parseInt(input);

            _view.print("\n Введите новое значение веса, %: ");
            input = _view.input();
            double new_rate = Double.parseDouble(input);
            _shop.add_new_toy(new_name, new_count, new_rate); 
            _view.print("\n Выполнено.\n");
        } catch (Exception e) {
            _view.print("\n" + e.getMessage());
        }
        _view.print("\n" + "Для продолжения нажмите <Enter>");
        _view.input();
    }
}
