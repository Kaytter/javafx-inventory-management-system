package purchase;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

/**
 * Created by Ketter Collins on 09/07/2018.
 */
public class PurchaseDetails {

    public String getPrID() {
        return prID.get();
    }

    public StringProperty prIDProperty() {
        return prID;
    }

    public void setPrID(String prID) {
        this.prID.set(prID);
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

    public String getQuantity() {
        return quantity.get();
    }

    public StringProperty quantityProperty() {
        return quantity;
    }

    public void setQuantity(String quantity) {
        this.quantity.set(quantity);
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

    public String getPrice() {
        return price.get();
    }

    public StringProperty priceProperty() {
        return price;
    }

    public void setPrice(String price) {
        this.price.set(price);
    }

    public String getTotalAmount() {
        return totalAmount.get();
    }

    public StringProperty totalAmountProperty() {
        return totalAmount;
    }

    public void setTotalAmount(String totalAmount) {
        this.totalAmount.set(totalAmount);
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

    public String getBalance() {
        return balance.get();
    }

    public StringProperty balanceProperty() {
        return balance;
    }

    public void setBalance(String balance) {
        this.balance.set(balance);
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

    public String getProcurementDate() {
        return procurementDate.get();
    }

    public StringProperty procurementDateProperty() {
        return procurementDate;
    }

    public void setProcurementDate(String procurementDate) {
        this.procurementDate.set(procurementDate);
    }

    private final StringProperty prID;
    private final StringProperty product;
    private final StringProperty pCategory;
    private final StringProperty quantity;
    private final StringProperty vendor;
    private final StringProperty price;
    private final StringProperty totalAmount;
    private final StringProperty status;
    private final StringProperty balance;
    private final StringProperty deliveryDate;
    private final StringProperty procurementDate;


    public PurchaseDetails(String prID, String product, String pCategory, String quantity, String vendor, String price,
                           String totalAmount, String status, String balance, String deliveryDate, String procurementDate){
        this.prID=new SimpleStringProperty(prID);
        this.product=new SimpleStringProperty(product);
        this.pCategory=new SimpleStringProperty(pCategory);
        this.quantity=new SimpleStringProperty(quantity);
        this.vendor=new SimpleStringProperty(vendor);
        this.price=new SimpleStringProperty(price);
        this.totalAmount=new SimpleStringProperty(totalAmount);
        this.status=new SimpleStringProperty(status);
        this.balance=new SimpleStringProperty(balance);
        this.deliveryDate=new SimpleStringProperty(deliveryDate);
        this.procurementDate=new SimpleStringProperty(procurementDate);



    }

}
