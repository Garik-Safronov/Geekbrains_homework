package ru.geekbrains.java3.homework1;

import java.util.ArrayList;
import java.util.List;

public class Box<T extends Fruit> {

    List<T> box = new ArrayList();

    public void addFruit(T fruit) {
        box.add(fruit);
    }

    public float getWeight() {
        float totalWeight = 0.0f;
        for (int i = 0; i < box.size(); i++) {
            totalWeight = totalWeight + box.get(i).getWeight();
        }return totalWeight;
    }

    boolean compare(Box<?> otherBox)  {
        return Math.abs(this.getWeight() - otherBox.getWeight()) < 0.00001f;
    }

    public void removeFruits(Box<T> otherBox) {
        otherBox.box.addAll(this.box);
        this.box.clear();
    }
}
