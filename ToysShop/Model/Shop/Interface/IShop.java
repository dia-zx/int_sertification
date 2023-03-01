package ToysShop.Model.Shop.Interface;

import java.util.Collection;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Set;

import ToysShop.Model.Toy.Interface.IToy;

public interface IShop {
    /**
     * Добавление новой игрушки
     * 
     * @param name  Название игрушки
     * @param count Количество
     * @param rate  Частота выпадения игрушки в % [0..100]
     * @throws RuntimeException count < 0, rate ![0..100]
     */
    public void add_new_toy(String name, int count, double rate) throws RuntimeException;

    /**
     * Список игрушек в магазине
     * 
     * @return
     */
    public Collection<IToy> get_Toys();

    /**
     * Редактирование данных об игрушке
     * 
     * @param id Идентификационный номер игрушки для редактирования
     * @throws RuntimeException несуществующий ID, count < 0, rate ![0..100]
     */
    public void edit_Toy(int id, int count, double rate) throws RuntimeException;

    /**
     * Список игрушек в призовой очереди
     * 
     * @return список игрушек
     */
    public List<IToy> get_prize_Queue();

    /**
     * Розыгрыш призовой игрушки
     * @return id выпавшей игрушки
     * @throws RuntimeException нет игрушек для розыгрыша
     */
    public int draw() throws RuntimeException;

    /**
     * Получение призовой игрушки
     * @return id игрушки
     * @throws RuntimeException нет игрушек в очереди
     */
    public int get_prize() throws NoSuchElementException;

    /**
     * Название игрушки по id
     * @param id
     * @return название
     * @throws RuntimeException Неверный id
     */
    public String get_name(int id) throws RuntimeException;

    /**
     * Получение объекта Toy по id
     * @param id
     * @return
     * @throws RuntimeException Неверный id
     */
    public IToy get_Toy(int id) throws RuntimeException;

}
