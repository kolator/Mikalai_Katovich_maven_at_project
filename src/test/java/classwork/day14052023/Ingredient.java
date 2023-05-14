package classwork.day14052023;

public class Ingredient {

    private String itemdescription;
    private int quantity;

    public Ingredient(String itemDescription, int quantity) {
        this.itemdescription = itemDescription;
        this.quantity = quantity;
    }

    public String getItemDescription() {
        return itemdescription;
    }

    public void setItemDescription(String itemDescription) {
        this.itemdescription = itemDescription;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
    @Override
    public String toString() {
        return "Ingredient{" +
                "itemdescription='" + itemdescription + '\'' +
                ", quantity=" + quantity +
                '}';
    }
}
