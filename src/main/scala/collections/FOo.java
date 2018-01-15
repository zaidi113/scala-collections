package main.scala.collections;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class FOo {

    public static void main(String[] args) {
        List<String> names = new ArrayList<>();
        names.add("xxxxxxxx");
        names.get(0);
        names.size();
        names.remove(0);
        names.remove("");

        int x = 1;
        int newx =  x + x >> 1;
        System.out.println(newx);
    }
}
