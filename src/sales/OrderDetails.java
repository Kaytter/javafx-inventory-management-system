package sales;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

import javax.lang.model.util.SimpleElementVisitor6;

/**
 * Created by Ketter Collins on 21/06/2018.
 */
public class OrderDetails {
    private final StringProperty orderID;
    private final StringProperty date;
    private final StringProperty product;
    private final StringProperty productCategory;
    private final StringProperty quantity;
    private final StringProperty salesRep;
    private final StringProperty customerName;
    private final StringProperty customerID;
    private final StringProperty totalPrice;
    private final StringProperty balance;
    private final StringProperty paymentStatus;


    public String getOrderID() {
        return orderID.get();
    }

    public StringProperty orderIDProperty() {
        return orderID;
    }

    public String getDate() {
        return date.get();
    }

    public StringProperty dateProperty() {
        return date;
    }

    public String getProduct() {
        return product.get();
    }

    public StringProperty productProperty() {
        return product;
    }

    public String getProductCategory() {
        return productCategory.get();
    }

    public StringProperty productCategoryProperty() {
        return productCategory;
    }

    public String getQuantity() {
        return quantity.get();
    }

    public StringProperty quantityProperty() {
        return quantity;
    }

    public String getSalesRep() {
        return salesRep.get();
    }

    public StringProperty salesRepProperty() {
        return salesRep;
    }

    public String getCustomerName() {
        return customerName.get();
    }

    public StringProperty customerNameProperty() {
        return customerName;
    }

    public String getCustomerID() {
        return customerID.get();
    }

    public StringProperty customerIDProperty() {
        return customerID;
    }

    public String getTotalPrice() {
        return totalPrice.get();
    }

    public StringProperty totalPriceProperty() {
        return totalPrice;
    }

    public String getBalance() {
        return balance.get();
    }

    public StringProperty balanceProperty() {
        return balance;
    }

    public String getPaymentStatus() {
        return paymentStatus.get();
    }

    public StringProperty paymentStatusProperty() {
        return paymentStatus;
    }




    public void setOrderID(String orderID) {
        this.orderID.set(orderID);
    }

    public void setDate(String date) {
        this.date.set(date);
    }

    public void setProduct(String product) {
        this.product.set(product);
    }

    public void setProductCategory(String productCategory) {
        this.productCategory.set(productCategory);
    }

    public void setQuantity(String quantity) {
        this.quantity.set(quantity);
    }

    public void setSalesRep(String salesRep) {
        this.salesRep.set(salesRep);
    }

    public void setCustomerName(String customerName) {
        this.customerName.set(customerName);
    }

    public void setCustomerID(String customerID) {
        this.customerID.set(customerID);
    }

    public void setTotalPrice(String totalPrice) {
        this.totalPrice.set(totalPrice);
    }

    public void setBalance(String balance) {
        this.balance.set(balance);
    }

    public void setPaymentStatus(String paymentStatus) {
        this.paymentStatus.set(paymentStatus);
    }



    public OrderDetails(String orderID, String customerName, String product, String productCategory, String salesRep, String customerID, String paymentStatus, String date,String totalPrice,String balance,String quantity){
    this.orderID = new SimpleStringProperty(orderID);
    this.customerName =new SimpleStringProperty(customerName) ;
    this.productCategory = new SimpleStringProperty(productCategory);
    this.date = new SimpleStringProperty(date);
    this.product = new SimpleStringProperty(product);
    this.customerID=new SimpleStringProperty(customerID);
    this.salesRep=new SimpleStringProperty(salesRep);
    this.paymentStatus=new SimpleStringProperty(paymentStatus);
    this.totalPrice=new SimpleStringProperty(totalPrice);
    this.quantity=new SimpleStringProperty(quantity);
    this.balance=new SimpleStringProperty(balance);


}






}
