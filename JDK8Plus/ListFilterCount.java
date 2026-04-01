/*
Consider Order List with OrderId and Item List.
Here, Item List includes Tea, Biscuit, Coffe and Cake.
From Order List, get count of order list which has placed only for combination of Tea and Biscuit.
 */

import java.util.*;

class Item {
    String itemName;

    public Item(String itemName) {
        this.itemName = itemName;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    @Override
    public String toString() {
        return "Item{" +
                "itemName='" + itemName + '\'' +
                '}';
    }
}

class Order {
    int orderId;
    List<Item> itemList;

    public Order(int orderId, List<Item> itemList) {
        this.orderId = orderId;
        this.itemList = itemList;
    }

    public int getOrderId() {
        return orderId;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    public List<Item> getItemList() {
        return itemList;
    }

    public void setItemList(List<Item> itemList) {
        this.itemList = itemList;
    }

    @Override
    public String toString() {
        return "Order{" +
                "orderId=" + orderId +
                ", itemList=" + itemList +
                '}';
    }
}

public class ListFilterCount {
    public static void main(String[] args) {
        Item tea = new Item("Tea");
        Item coffee = new Item("Coffee");
        Item biscuit = new Item("Biscuit");
        Item cake = new Item("Cake");

        List<Item> onlyTea = Arrays.asList(tea);
        List<Item> onlyCoffee = Arrays.asList(coffee);
        List<Item> onlyBiscuit = Arrays.asList(biscuit);
        List<Item> onlyCake = Arrays.asList(cake);
        List<Item> teaBiscuitCombo = Arrays.asList(tea, biscuit);
        List<Item> coffeeCakeCombo = Arrays.asList(coffee, cake);
        List<Item> allInOneCombo = Arrays.asList(tea, coffee, biscuit, cake);

        List<Order> orderList = Arrays.asList(
                new Order(1, teaBiscuitCombo),
                new Order(2, onlyTea),
                new Order(3, onlyCoffee),
                new Order(4, onlyBiscuit),
                new Order(5, onlyCake),
                new Order(6, teaBiscuitCombo),
                new Order(7, coffeeCakeCombo),
                new Order(8, allInOneCombo),
                new Order(9, allInOneCombo),
                new Order(10, coffeeCakeCombo),
                new Order(11, teaBiscuitCombo),
                new Order(12, onlyCake),
                new Order(13, onlyBiscuit),
                new Order(14, onlyCoffee),
                new Order(15, onlyTea),
                new Order(16, teaBiscuitCombo)
        );

        System.out.println("Count of Tea & Biscuit Combo Order: "
                + orderList.stream().filter(
					order -> order.getItemList().size() == 2
					&& order.getItemList().contains(tea) && order.getItemList().contains(biscuit)
				).count());
    }
}

/*
Output
Count of Tea & Biscuit Combo Order: 4
*/

