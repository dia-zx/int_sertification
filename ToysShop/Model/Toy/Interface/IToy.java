package ToysShop.Model.Toy.Interface;

/**
 * Интерфейс игрушки
 */
public interface IToy {    
    /**
     * получение id
     * @return
     */
    public int get_id();

    /**
     * получить название игрушки
     * @return
     */
    public String get_name();
    /**
     * присвоить название игрушки
     * @param name
     */
    public void set_name(String name);

    /**
     * получить количество игрушек
     * @return
     */
    public int get_count();
    /**
     * задать число игрушек
     * @throws RuntimeException если count < 0
     */
    public void set_count(int count) throws RuntimeException;

    /**
     * получить частоту выпадения в %
     * @return
     */
    public double get_rate();
    /**
     * установить частоту выпадения в %
     * @param rate
     * @throws Exception
     */
    public void set_rate(double rate) throws RuntimeException;    
}
