import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class RestaurantService {
    private static List<Restaurant> restaurants = new ArrayList<>();

    public Restaurant findRestaurantByName(String restaurantName) {
        for (Restaurant restaurant : restaurants) {
            if (restaurant.getName().equalsIgnoreCase(restaurantName)) return restaurant;
            break;
        }
        return null;
    }


    public Restaurant addRestaurant(String name, String location, LocalTime openingTime, LocalTime closingTime) {
        Restaurant newRestaurant = new Restaurant(name, location, openingTime, closingTime);
        restaurants.add(newRestaurant);
        return newRestaurant;
    }

    public Restaurant removeRestaurant(String restaurantName) throws restaurantNotFoundException {
        Restaurant restaurantToBeRemoved = findRestaurantByName(restaurantName);
        if (restaurantToBeRemoved != null) {
            restaurants.remove(restaurantToBeRemoved);
            return restaurantToBeRemoved;
        }
        throw new restaurantNotFoundException("");
    }

    public List<Restaurant> getRestaurants() {
        return restaurants;
    }

    public Integer getTotalCost(List<Item> selectedItems) {
        Integer totalCost = 0;
        for (Item item : selectedItems) {
            totalCost += item.getPrice();
        }
        return totalCost;
    }
}
