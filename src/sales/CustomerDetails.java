package sales;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

/**
 * Created by Ketter Collins on 04/08/2018.
 */
public class CustomerDetails {

    public String getID() {
        return ID.get();
    }

    public StringProperty IDProperty() {
        return ID;
    }

    public void setID(String ID) {
        this.ID.set(ID);
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

    public String getpNumber() {
        return pNumber.get();
    }

    public StringProperty pNumberProperty() {
        return pNumber;
    }

    public void setpNumber(String pNumber) {
        this.pNumber.set(pNumber);
    }

    private final StringProperty ID;
    private final StringProperty name;
    private final StringProperty email;
    private final StringProperty pNumber;

    public CustomerDetails(String ID, String name, String email,String pNumber){
        this.ID=new SimpleStringProperty(ID);
        this.name=new SimpleStringProperty(name);
        this.email=new SimpleStringProperty(email);
        this.pNumber=new SimpleStringProperty(pNumber);
    }

}
