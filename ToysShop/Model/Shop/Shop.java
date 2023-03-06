package ToysShop.Model.Shop;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Deque;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Queue;
import java.util.Set;

import ToysShop.Model.Shop.Interface.IShop;
import ToysShop.Model.Toy.Toy;
import ToysShop.Model.Toy.Interface.IToy;

public class Shop implements IShop {
    private HashMap<Integer, IToy> _toys;
    private Queue<Integer> _prizeQueue;

    public Shop() {
        _toys = new HashMap<>();
        _prizeQueue = new ArrayDeque<Integer>();
    }

    @Override
    public void add_new_toy(String name, int count, double rate) throws RuntimeException {
        Toy new_toy = new Toy();
        new_toy.set_name(name);
        new_toy.set_count(count);
        new_toy.set_rate(rate);
        _toys.put(new_toy.get_id(), new_toy);
    }

    @Override
    public Collection<IToy> get_Toys() {
        return _toys.values();
    }

    @Override
    public void edit_Toy(int id, int count, double rate) throws RuntimeException {
        if(count < 0) throw new RuntimeException("Неверное значение. число игрушек не может быть < 0 !");
        if(rate <0 || rate >100)
            throw new RuntimeException("Неверное значение частоты выпадения игрушки!");        
        _toys.get(id).set_count(count);
        _toys.get(id).set_rate(rate);
    }

    @Override
    public List<IToy> get_prize_Queue() {
        var items =_prizeQueue.toArray();
        List<IToy> list = new ArrayList<>();
        for (Object it : items) 
            list.add((IToy) it);
        return list;
    }

    @Override
    public int draw() throws RuntimeException {
        double summ_rate = 0;
        for (IToy toy : _toys.values()) 
            if (toy.get_count() != 0)   // игрушки должны быть в наличии для розыгрыша
                summ_rate += toy.get_rate(); //подсчитываем суммарное значение частоты выпадения
        if(summ_rate == 0) 
            throw new RuntimeException("Ошибка! Нет игрушек для розыгрыша!");
        double draw_random = Math.random() * summ_rate;
        // найдем выигрышную игрушку
        summ_rate = 0;
        for (IToy toy : _toys.values()) {
            if (toy.get_count() == 0  || toy.get_rate() == 0) continue;  // игрушки должны быть в наличии для розыгрыша
            summ_rate += toy.get_rate(); 
            if(draw_random < summ_rate){//есть!
                toy.set_count(toy.get_count() - 1); //уменьшаем количество предметов для резервирования...
                _prizeQueue.add(toy.get_id());  // добавляем в очередь выигрышей.
                return toy.get_id();
            }
        }
        return 0;  //сюда не должны попасть...
    }

    @Override
    public int get_prize() throws RuntimeException {
        if(_prizeQueue.isEmpty())
            throw new RuntimeException("Ошибка. Разыгранных элементов нет!");
        return _prizeQueue.remove();
    }

    @Override
    public String get_name(int id) throws RuntimeException {
        if (_toys.get(id) == null) 
            throw new RuntimeException("Ошибка! Несуществующий id!");        
        return _toys.get(id).get_name();
    }

    @Override
    public IToy get_Toy(int id) throws RuntimeException {
        if (_toys.get(id) == null) 
            throw new RuntimeException("Ошибка! Несуществующий id!");
        return _toys.get(id);
    }

}