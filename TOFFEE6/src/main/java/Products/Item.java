package Products;

public class Item {
    public int itemID;
    private String name;
    private double price;
    private int quantity;
    private Boolean Available = true;
    private Boolean Loose ;

    public Boolean getAvailablity() {
        return Available;
    }

    public void setAvailablity(Boolean available) {
        Available = available;
    }

    public Boolean isLoose() {
        return Loose;
    }

    public void setLoose(Boolean loose) {
        Loose = loose;
    }

    public Item() {

    }

    public Item(int id, String name, double price, int quantity) {
        this.itemID = id;
        this.name = name;
        this.price = price;
        this.quantity = quantity;
        this.Available = true;
        this.Loose = true;
    }

    public int getItemID() {
        return itemID;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPrice(double newPrice) {
        this.price = newPrice;
    }

    public double getPrice() {
        return price;
    }

    public String getName() {
        return name;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public void setItemInfo(int id, String name, double price, int quantity) {
        this.itemID = id;
        this.name = name;
        this.price = price;
        this.quantity = quantity;
    }
}
