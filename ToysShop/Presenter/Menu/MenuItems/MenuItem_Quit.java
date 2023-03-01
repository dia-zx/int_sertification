package ToysShop.Presenter.Menu.MenuItems;

import ToysShop.Presenter.Menu.MenuItems.Interface.IMenuItem;

/**
 * Пункт меню "Выход из программы"
 */
public class MenuItem_Quit implements IMenuItem {
    private String _name = "quit";


    @Override
    public String get_command_name() {
        return _name;
    }

    @Override
    public String get_description() {
        return "Выход из программы.";
    }

    @Override
    public void exercute() {
        System.exit(0);   
    }
    
}
