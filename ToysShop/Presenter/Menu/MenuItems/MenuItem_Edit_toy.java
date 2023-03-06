package ToysShop.Presenter.Menu.MenuItems;

import ToysShop.Model.Shop.Interface.IShop;
import ToysShop.Presenter.Menu.MenuItems.Interface.IMenuItem;
import ToysShop.View.View;
import ToysShop.View.Interface.IView;

/**
 * Пункт меню "Редактирование параметров игрушки"
 */
public class MenuItem_Edit_toy implements IMenuItem {
    private String _name = "edit_toy";
    private IShop _shop;
    private IView _view;

    public MenuItem_Edit_toy(IShop shop, IView view) {
        _shop = shop;
        _view = view;
    }

    @Override
    public String get_command_name() {
        return _name;
    }

    @Override
    public String get_description() {
        return "Редактирование параметров игрушки";
    }

    @Override
    public void exercute() {
        _view.print("\nВведите id игрушки для редактирования: ");
        try {
            String input = _view.input();
            int id = Integer.parseInt(input);
            _view.print("\n" + _shop.get_Toy(id).toString());
            _view.print("\n Введите новое количество игрушек: ");
            input = _view.input();
            int new_count = Integer.parseInt(input);

            _view.print("\n Введите новое значение веса, %: ");
            input = _view.input();
            double new_rate = Double.parseDouble(input);
            _shop.edit_Toy(id, new_count, new_rate);
            _view.print("\n Выполнено.\n");

        } catch (Exception e) {
            _view.print("\n" + e.getMessage());
        }
        _view.print("\n" + "Для продолжения нажмите <Enter>");
        _view.input();
    }

}
