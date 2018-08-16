package inventory;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

/**
 * Created by Ketter Collins on 07/07/2018.
 */
public class DeliveryDetails {
    public String getDeliveryID() {
        return deliveryID.get();
    }

    public StringProperty deliveryIDProperty() {
        return deliveryID;
    }

    public void setDeliveryID(String deliveryID) {
        this.deliveryID.set(deliveryID);
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

    public String getQuantity() {
        return quantity.get();
    }

    public StringProperty quantityProperty() {
        return quantity;
    }

    public void setQuantity(String quantity) {
        this.quantity.set(quantity);
    }

    public String getDeliveryDate() {
        return deliveryDate.get();
    }

    public StringProperty deliveryDateProperty() {
        return deliveryDate;
    }

    public void setDeliveryDate(String deliveryDate) {
        this.deliveryDate.set(deliveryDate);
    }

    public String getStatus() {
        return status.get();
    }

    public StringProperty statusProperty() {
        return status;
    }

    public void setStatus(String status) {
        this.status.set(status);
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

    private final StringProperty deliveryID;
    private final StringProperty product;
    private final StringProperty quantity;
    private final StringProperty deliveryDate;
    private final StringProperty status;
    private final StringProperty vendor;

    public DeliveryDetails(String deliveryID,String product,String quantity,String deliveryDate,String status,String vendor){

        this.deliveryID=new SimpleStringProperty(deliveryID);
        this.product=new SimpleStringProperty(product);
        this.quantity=new SimpleStringProperty(quantity);
        this.deliveryDate=new SimpleStringProperty(deliveryDate);
        this.status=new SimpleStringProperty(status);
        this.vendor=new SimpleStringProperty(vendor);


    }


}
