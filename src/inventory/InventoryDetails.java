package inventory;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

/**
 * Created by Ketter Collins on 06/07/2018.
 */
public class InventoryDetails {
    private final StringProperty productID;
    private final StringProperty product;
    private final StringProperty pCategory;


    private final StringProperty description;
    private final StringProperty quantity;
    private final StringProperty price;
    private final StringProperty vendor;
    public String getProductID() {
        return productID.get();
    }

    public StringProperty productIDProperty() {
        return productID;
    }

    public void setProductID(String productID) {
        this.productID.set(productID);
    }

    public String getProduct() {
        return product.get();
    }

    public StringProperty productProperty() {
        return product;
    }

    public void setProduct(String product) {
        this.product.set(product);
    }

    public String getpCategory() {
        return pCategory.get();
    }

    public StringProperty pCategoryProperty() {
        return pCategory;
    }

    public void setpCategory(String pCategory) {
        this.pCategory.set(pCategory);
    }

    public String getDescription() {
        return description.get();
    }

    public StringProperty descriptionProperty() {
        return description;
    }

    public void setDescription(String description) {
        this.description.set(description);
    }


    public String getQuantity() {
        return quantity.get();
    }

    public StringProperty quantityProperty() {
        return quantity;
    }

    public void setQuantity(String quantity) {
        this.quantity.set(quantity);
    }

    public String getPrice() {
        return price.get();
    }

    public StringProperty priceProperty() {
        return price;
    }

    public void setPrice(String price) {
        this.price.set(price);
    }

    public String getVendor() {
        return vendor.get();
    }

    public StringProperty vendorProperty() {
        return vendor;
    }

    public void setVendor(String vendor) {
        this.vendor.set(vendor);
    }
public InventoryDetails(String productID, String product, String pCategory, String quantity, String price, String vendor,String description ){
this.productID=new SimpleStringProperty(productID);
this.product=new SimpleStringProperty(product);
this.pCategory=new SimpleStringProperty(pCategory);
this.description=new SimpleStringProperty(description);
this.quantity=new SimpleStringProperty(quantity);
this.price=new SimpleStringProperty(price);
this.vendor=new SimpleStringProperty(vendor);
}



}
