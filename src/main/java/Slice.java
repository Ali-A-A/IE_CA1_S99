import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Slice {
    private final List<Restaurant> restaurants = new ArrayList<>();
    private final int inputMode;

    Slice(int inputMode) {
        this.inputMode = inputMode;
    }


    private void whichCommand(String commandName , String data) {
        if(commandName.equals("addRestaurant")) {
            addRestaurant(data);
        } else if(commandName.equals("addFood")) {
            addFood(data);
        } else if(commandName.equals("getRestaurants")) {
            showAllRestaurants();
        } else if(commandName.equals("getRestaurant")) {
            showRestaurant(data);
        }
    }

    public void showRestaurant(String data) {
        Name name = new Gson().fromJson(data , Name.class);
        Restaurant target = null;
        for(Restaurant restaurant : restaurants) {
            if(restaurant.getName().equals(name.getName())) {
                target = restaurant;
            }
        }
        if(target != null) {
            String restaurantJson = new Gson().toJson(target);
            if(inputMode == 0) System.out.println(restaurantJson);
        } else {
            if(inputMode == 0) System.out.println("Not Found");
        }
    }

    public void showAllRestaurants() {
        for(Restaurant restaurant : restaurants) {
            if(inputMode == 0) System.out.println(restaurant.getName());
        }
    }

    public void addFood(String data) {
        Food food = new Gson().fromJson(data , Food.class);
        int resIndex = findRestaurant(food.getRestaurantName());
        if(resIndex == -1) {
            if(inputMode == 0) System.out.println("Restaurant Not Found");
        } else {
            restaurants.get(resIndex).addFood(food);
        }
    }

    public void addRestaurant(String resInfo) {
        restaurants.add(new Gson().fromJson(resInfo , Restaurant.class));
    }

    private int findRestaurant(String resName) {
        for(int i = 0 ; i < restaurants.size() ; i++) {
            if(restaurants.get(i).getName().equals(resName)) return i;
        }
        return -1;
    }

    public void runApp() {
        CommandParser commandParser = new CommandParser();
        Scanner in = new Scanner(System.in);
        while(in.hasNext()) {
            String[] command = commandParser.parse(in);
            if(command.length == 1) whichCommand(command[0] , "");
            else whichCommand(command[0] , command[1]);
        }
    }
}
