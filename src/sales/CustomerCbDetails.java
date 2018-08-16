package sales;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

/**
 * Created by Ketter Collins on 09/08/2018.
 */
public class CustomerCbDetails {


    public String getName() {
        return name.get();
    }

    public StringProperty nameProperty() {
        return name;
    }

    public void setName(String name) {
        this.name.set(name);
    }

    public  StringProperty name;
    public CustomerCbDetails(String name){
        this.name=new SimpleStringProperty(name);
    }
}
