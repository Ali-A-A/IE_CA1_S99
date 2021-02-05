import java.util.ArrayList;
import java.util.List;

public class Restaurant {

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    public List<Food> getFoods() {
        return menu;
    }

    public void addFood(Food food) {
        menu.add(food);
    }

    private String name;
    private String description;
    private Location location;
    private final List<Food> menu = new ArrayList<>();
}
