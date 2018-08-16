package accounts;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

/**
 * Created by Ketter Collins on 07/08/2018.
 */
public class AccountsDetails {
    public int getAccID() {
        return accID.get();
    }

    public IntegerProperty AccIDProperty() {
        return accID;
    }

    public void setAccID(int accID) {
        this.accID.set(accID);
    }

    public String getSalesID() {
        return salesID.get();
    }

    public StringProperty salesIDProperty() {
        return salesID;
    }

    public void setSalesID(String salesID) {
        this.salesID.set(salesID);
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

    public String getPrice() {
        return price.get();
    }

    public StringProperty priceProperty() {
        return price;
    }

    public void setPrice(String price) {
        this.price.set(price);
    }

    public String getDateOfPurchase() {
        return dateOfPurchase.get();
    }

    public StringProperty dateOfPurchaseProperty() {
        return dateOfPurchase;
    }

    public void setDateOfPurchase(String dateOfPurchase) {
        this.dateOfPurchase.set(dateOfPurchase);
    }

    public String getDateOfPayment() {
        return dateOfPayment.get();
    }

    public StringProperty dateOfPaymentProperty() {
        return dateOfPayment;
    }

    public void setDateOfPayment(String dateOfPayment) {
        this.dateOfPayment.set(dateOfPayment);
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

    public String getAmountPaid() {
        return amountPaid.get();
    }

    public StringProperty amountPaidProperty() {
        return amountPaid;
    }

    public void setAmountPaid(String amountPaid) {
        this.amountPaid.set(amountPaid);
    }

    public String getBalance() {
        return balance.get();
    }

    public StringProperty balanceProperty() {
        return balance;
    }

    public void setBalance(String balance) {
        this.balance.set(balance);
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

    public final IntegerProperty accID;
    public final StringProperty salesID;
    public final StringProperty product;
    public final StringProperty quantity;
    public final StringProperty price;
    public final StringProperty dateOfPurchase;
    public final StringProperty dateOfPayment;
    public final StringProperty customer;
    public final StringProperty amountPaid;
    public final StringProperty balance;
    public final StringProperty status;


    public AccountsDetails(int accID,String salesID,String product,String quantity,String price,String dateOfPurchase
            ,String dateOfPayment,String customer,String amountPaid,String balance,String status){
        this.accID=new SimpleIntegerProperty(accID);
        this.salesID=new SimpleStringProperty(salesID);
        this.product=new SimpleStringProperty(product);
        this.quantity=new SimpleStringProperty(quantity);
        this.price=new SimpleStringProperty(price);
        this.dateOfPurchase=new SimpleStringProperty(dateOfPurchase);
        this.dateOfPayment=new SimpleStringProperty(dateOfPayment);
        this.customer=new SimpleStringProperty(customer);
        this.amountPaid=new SimpleStringProperty(amountPaid);
        this.balance=new SimpleStringProperty(balance);
        this.status=new SimpleStringProperty(status);


    }


}
