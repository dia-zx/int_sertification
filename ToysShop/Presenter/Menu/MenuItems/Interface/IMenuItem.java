package ToysShop.Presenter.Menu.MenuItems.Interface;

public interface IMenuItem {
    /**
     * название команды (пункта меню), для вызова
     * @return
     */
    public String get_command_name();
    /**
     * Описание команды
     * @return
     */
    public String get_description();

    /**
     * Выполнение команды
     */
    public void exercute();    
}