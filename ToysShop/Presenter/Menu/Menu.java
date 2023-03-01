package ToysShop.Presenter.Menu;

import java.util.HashMap;
import java.util.Map;

import ToysShop.Presenter.Menu.MenuItems.Interface.IMenuItem;
import ToysShop.View.Interface.IView;

public class Menu {
    private Map<String, IMenuItem> _menuItems = new HashMap();
    private IView _view;

    public Menu(IView view) {
        _view = view;
    }

    /**
     * Добавление пункта меню
     * @param menuitem
     */
    public void AddMenuItem(IMenuItem menuitem){
        _menuItems.put(menuitem.get_command_name(), menuitem);
    }
    
    /**
     * управление меню..
     */
    public IMenuItem exercute() {
        do {
            _view.print("");
            _view.print("------------------- меню ------------------");
            for (IMenuItem item : _menuItems.values()) {
                _view.print(item.get_command_name() + " - " + item.get_description());
            }
            _view.print("-------------------------------------------");
            _view.print("Введите команду");
            String input = _view.input();
            if (_menuItems.containsKey(input)) {
               _menuItems.get(input).exercute();
            }
            else
            _view.print("неверная команда!");
        } while (true);
    }
}
