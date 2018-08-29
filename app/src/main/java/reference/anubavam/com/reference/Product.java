package reference.anubavam.com.reference;

public class Product {
    private String title, image;
    private int price, quantity;

    public Product() {
    }

    public Product(String title, int price, int quantity, String image) {
        this.title = title;
        this.price = price;
        this.quantity = quantity;
        this.image = image;
    }


    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}