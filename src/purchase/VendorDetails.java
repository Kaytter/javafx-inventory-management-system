package purchase;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

/**
 * Created by Ketter Collins on 09/07/2018.
 */
public class VendorDetails {
    public String getId() {
        return id.get();
    }

    public StringProperty idProperty() {
        return id;
    }

    public void setId(String id) {
        this.id.set(id);
    }

    public String getName() {
        return name.get();
    }

    public StringProperty nameProperty() {
        return name;
    }

    public void setName(String name) {
        this.name.set(name);
    }

    public String getEmail() {
        return email.get();
    }

    public StringProperty emailProperty() {
        return email;
    }

    public void setEmail(String email) {
        this.email.set(email);
    }

    public String getPhoneNumber() {
        return phoneNumber.get();
    }

    public StringProperty phoneNumberProperty() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber.set(phoneNumber);
    }

    public String getProductCategory() {
        return productCategory.get();
    }

    public StringProperty productCategoryProperty() {
        return productCategory;
    }

    public void setProductCategory(String productCategory) {
        this.productCategory.set(productCategory);
    }

    private final StringProperty id;
    private final StringProperty name;
    private final StringProperty email;
    private final StringProperty phoneNumber;
    private final StringProperty productCategory;


    public VendorDetails(String id,String name,String email,String phoneNumber,String productCategory){
        this.id=new SimpleStringProperty(id);
        this.name=new SimpleStringProperty(name);
        this.email=new SimpleStringProperty(email);
        this.phoneNumber=new SimpleStringProperty(phoneNumber);
        this.productCategory=new SimpleStringProperty(productCategory);


    }


}
