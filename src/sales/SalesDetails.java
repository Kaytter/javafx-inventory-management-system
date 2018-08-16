package sales;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

/**
 * Created by Ketter Collins on 24/07/2018.
 */
public class SalesDetails {
    public String getID() {
        return ID.get();
    }

    public StringProperty IDProperty() {
        return ID;
    }

    public void setID(String ID) {
        this.ID.set(ID);
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

    public String getDate() {
        return date.get();
    }

    public StringProperty dateProperty() {
        return date;
    }

    public void setDate(String date) {
        this.date.set(date);
    }

    public String getAmount() {
        return amount.get();
    }

    public StringProperty amountProperty() {
        return amount;
    }

    public void setAmount(String amount) {
        this.amount.set(amount);
    }

    public String getCustomer() {
        return customer.get();
    }

    public StringProperty customerProperty() {
        return customer;
    }

    public void setCustomer(String customer) {
        this.customer.set(customer);
    }

    public String getPaymentType() {
        return paymentType.get();
    }

    public StringProperty paymentTypeProperty() {
        return paymentType;
    }

    public void setPaymentType(String paymentType) {
        this.paymentType.set(paymentType);
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

    private final StringProperty ID;
    private final StringProperty product;

    private final StringProperty quantity;
    private final StringProperty date;
    private final StringProperty amount;
    private final StringProperty customer;
    private final StringProperty paymentType;
    private final StringProperty status;

    public SalesDetails(String ID, String product, String quantity, String date,String amount,String
                        customer,String paymentType,String status){

        this.ID=new SimpleStringProperty(ID);
        this.product=new SimpleStringProperty(product);
        this.quantity=new SimpleStringProperty(quantity);
        this.date=new SimpleStringProperty(date);
        this.amount=new SimpleStringProperty(amount);
        this.customer=new SimpleStringProperty(customer);
        this.paymentType=new SimpleStringProperty(paymentType);
        this.status=new SimpleStringProperty(status);
    }


}
