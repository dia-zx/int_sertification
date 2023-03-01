package ToysShop.Model.Toy;

import ToysShop.Model.Toy.Interface.IToy;

/**
 * Toy
 */
public class Toy implements IToy {
    private int _id;
    private static int id_count = 0;
    private String _name;
    private int _count;
    private double _rate;

    public Toy() {
        // формируем уникальный id
        _id = id_count;
        id_count++;
    }

    @Override
    public int get_id() {
        return _id;
    }

    @Override
    public String get_name() {
        return _name;
    }

    @Override
    public void set_name(String name) {
        _name = name;
    }

    @Override
    public int get_count() {
        return _count;
    }

    @Override
    public void set_count(int count) throws RuntimeException {
        if(count < 0) throw new RuntimeException("Неверное значение. число игрушек не может быть < 0 !");
        _count = count;
    }

    @Override
    public double get_rate() {
        return _rate;
    }

    @Override
    public void set_rate(double rate) throws RuntimeException {
        if(rate <0 || rate >100)
            throw new RuntimeException("Неверное значение частоты выпадения игрушки!");
        _rate = rate;
    }

    @Override
    public String toString() {
        return "ID: " + _id + " имя: " + _name + " количество: " + _count + " rate: " + _rate;
    }

}