import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

public class Restaurant {
    private String name;
    private String location;
    public LocalTime openingTime;
    public LocalTime closingTime;
    private List<Item> menu = new ArrayList<Item>();

    private List<Item> order = new ArrayList<Item>();

    public Restaurant(String name, String location, LocalTime openingTime, LocalTime closingTime) {
        this.name = name;
        this.location = location;
        this.openingTime = openingTime;
        this.closingTime = closingTime;
    }

    public boolean isRestaurantOpen() {
//        return true;
        //DELETE ABOVE STATEMENT AND WRITE CODE HERE
        if(getCurrentTime().compareTo(this.openingTime) >= 0 && getCurrentTime().compareTo(this.closingTime)<= 0){
            return true;
        }

        return false;
    }

    public LocalTime getCurrentTime(){ return  LocalTime.now(); }

    public List<Item> getMenu() {
        //return null;
        //DELETE ABOVE RETURN STATEMENT AND WRITE CODE HERE
        return menu;
    }

    public List<Item> getOrderList() {
        return order;
    }


    private Item findItemByName(String itemName){
        for(Item item: menu) {
            if(item.getName().equals(itemName))
                return item;
        }
        return null;
    }

    public void addToMenu(String name, int price) {
        Item newItem = new Item(name,price);
        menu.add(newItem);
    }
    
    public void removeFromMenu(String itemName) throws itemNotFoundException {

        Item itemToBeRemoved = findItemByName(itemName);
        if (itemToBeRemoved == null)
            throw new itemNotFoundException(itemName);

        menu.remove(itemToBeRemoved);
    }
    public void displayDetails(){
        System.out.println("Restaurant:"+ name + "\n"
                +"Location:"+ location + "\n"
                +"Opening time:"+ openingTime +"\n"
                +"Closing time:"+ closingTime +"\n"
                +"Menu:"+"\n"+getMenu());

    }

    public void addToOrder(String itemName) {

        Item itemToBeAddedToOrder = findItemByName(itemName);
        order.add(itemToBeAddedToOrder);
    }


    public int calculateOrderTotal(List<Item> list){
        int totalAmount = 0;
        for(Item item: list){
            totalAmount = totalAmount + item.getPrice();
        }


        return totalAmount;
    }


    public String getName() {
        return name;
    }

}
