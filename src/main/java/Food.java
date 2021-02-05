public class Food {
    private String name;
    private String description;
    private double popularity;
    private double price;
    private String restaurantName;

    public String getRestaurantName() {
        return restaurantName;
    }

    @Override
    public String toString() {
        return this.name + " " + this.description;
    }

}
