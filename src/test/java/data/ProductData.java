package data;

public class ProductData {
    private final String name;
    private final String description;
    private final double price;


    public ProductData(String name, String description, double price) {
        this.name = name;
        this.description = description;
        this.price = price;
    }

    // Getters
    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public double getPrice() {
        return price;
    }

    //Static product data
    public static final ProductData BACKPACK = new ProductData(
            "Sauce Labs Backpack",
            "carry.allTheThings() with the sleek, streamlined Sly Pack that melds uncompromising style with unequaled laptop and tablet protection.",
            29.99
    );

    public static final ProductData BIKE_LIGHT = new ProductData(
            "Sauce Labs Bike Light",
            "A red light isn't the desired state in testing but it sure helps when riding your bike at night. Water-resistant with 3 lighting modes, 1 AAA battery included.",
            9.99
    );

    public static final ProductData BOLT_T_SHIRT = new ProductData(
            "Sauce Labs Bolt T-Shirt",
            "Get your testing superhero on with the Sauce Labs bolt T-shirt. From American Apparel, 100% ringspun combed cotton, heather gray with red bolt.",
            15.99
    );
}
