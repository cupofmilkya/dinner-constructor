package ru.practicum.dinner;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;

public class DinnerConstructor {

    HashMap<String, ArrayList<String>> dinnerMap;
    Random rand;

    public DinnerConstructor() {
        dinnerMap = new HashMap<>();
        rand = new Random();
    }

    public void addNewDish(String dishType, String dishName) {
        if (dinnerMap.containsKey(dishType)) {
            dinnerMap.get(dishType).add(dishName);
        } else {
            dinnerMap.put(dishType, new ArrayList<>());
            dinnerMap.get(dishType).add(dishName);
        }
    }

    public boolean checkDishType(String dishType) {
        return dinnerMap.containsKey(dishType);
    }

    public void generateDishCombo(int numberOfCombos, ArrayList<String> dishes) {
        ArrayList<ArrayList<String>> combos = new ArrayList<>();

        for (int i = 0; i < numberOfCombos; i++) {
            combos.add(new ArrayList<>());

            for (String dish : dishes) {
                int randomIndex = rand.nextInt(dinnerMap.get(dish).size());
                combos.get(i).add(dinnerMap.get(dish).get(randomIndex));
            }

        }

        for (int i = 0; i < combos.size(); i++) {
            System.out.println("Комбо " + (i + 1));
            System.out.println(combos.get(i));
        }
    }
}
