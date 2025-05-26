package ru.practicum.dinner;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;

public class DinnerConstructor {

    private final HashMap<String, ArrayList<String>> dinnerMap;
    private final Random rand;

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
                ArrayList<String> category = dinnerMap.get(dish);
                ArrayList<String> combo = combos.get(i);

                int randomIndex = rand.nextInt(category.size());
                combo.add(category.get(randomIndex));
            }

        }

        for (int i = 0; i < combos.size(); i++) {
            System.out.println("Комбо " + (i + 1));
            System.out.println(combos.get(i));
        }
    }
}
