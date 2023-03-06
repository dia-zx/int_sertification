package ToysShop.View;

import java.util.Scanner;

import ToysShop.View.Interface.IView;

public class View implements IView{
    @Override
    public void print(String str) {
        System.out.println(str);
    }

    @Override
    public String input() {
        Scanner scanner = new Scanner(System.in,  "866");
        return scanner.nextLine();
    }
}
