package Products;

public class Item {
    public static int itemID = 0;

    private String name;
    private int price;
    private String category;
    private String description;
    private String brand;
    private String discountCode;
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
        itemID++;
        this.itemID = itemID;
    }

    public Item( String name, int price, String category, String description, String brand, String discountCode, int quantity) {
        itemID++;
        this.itemID = itemID;
        this.name = name;
        this.price = price;
        this.category = category;
        this.description = description;
        this.brand = brand;
        this.discountCode = discountCode;
        this.quantity = quantity;
    }
    public int getItemID() {
        return itemID;
    }


    public void setName(String name) {
        this.name = name;
    }

    public void setPrice(int newPrice) {
        this.price = newPrice;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getBrand() {
        return brand;
    }

    public int getPrice() {
        return price;
    }

    public String getName() {
        return name;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getDiscountCode() {
        return discountCode;
    }

    public void setDiscountCode(String discountCode) {
        this.discountCode = discountCode;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String getCategory( ){
        return category;
    }


    public void setItemInfo(String name, int price, String category, String description, String brand, String discountCode, int quantity) {
        this.name = name;
        this.price = price;
        this.category = category;
        this.description = description;
        this.brand = brand;
        this.discountCode = discountCode;
        this.quantity = quantity;
    }


}
