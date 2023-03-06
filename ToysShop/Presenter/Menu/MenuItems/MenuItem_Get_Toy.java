package ToysShop.Presenter.Menu.MenuItems;

import java.io.DataOutputStream;
import java.io.FileOutputStream;

import ToysShop.Model.Shop.Interface.IShop;
import ToysShop.Presenter.Menu.MenuItems.Interface.IMenuItem;
import ToysShop.View.Interface.IView;

/**
 * Пункт меню "Получить приз"
 */
public class MenuItem_Get_Toy implements IMenuItem {
    private String _name = "get";
    private IShop _shop;
    private IView _view;

    public MenuItem_Get_Toy(IShop shop, IView view) {
        _shop = shop;
        _view = view;
    }

    @Override
    public String get_command_name() {
        return _name;
    }

    @Override
    public String get_description() {
        return "Получение приза";
    }

    @Override
    public void exercute() {
        try {
            String toy_name = _shop.get_name(_shop.get_prize());
            _view.print("\nВаш приз: " + toy_name + "!");

            save("Prizes.txt", toy_name);
            _view.print("\n Выполнено.\n");

        } catch (Exception e) {
            _view.print("\n" + e.getMessage());
        }
        _view.print("\n" + "Для продолжения нажмите <Enter>");
        _view.input();
    }

    /**
     * Сохранение приза в файле
     * @param file_path
     */
    public void save(String file_path, String toy_name) {
        try (DataOutputStream ds = new DataOutputStream(new FileOutputStream(file_path, true))) {
            ds.writeBytes(toy_name + "\n");
        } catch (Exception ex) {
            throw new RuntimeException("Внимание! Ошибка записи файла!");
        }
    }
}
