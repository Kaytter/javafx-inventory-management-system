package settings;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

/**
 * Created by Ketter Collins on 08/06/2018.
 */
public class userDetails {
    private final StringProperty employeeID;
    private final StringProperty firstName;
    private final StringProperty surname;
    private final StringProperty username;
    private final StringProperty password;
    private final StringProperty userType;

    public userDetails(String employeeID,String firstName,String surname,String password,String username,String userType){
       this.employeeID=new SimpleStringProperty(employeeID);
        this.firstName=new SimpleStringProperty(firstName);
        this.surname=new SimpleStringProperty(surname);
        this.username=new SimpleStringProperty(username);
        this.password=new SimpleStringProperty(password);
        this.userType=new SimpleStringProperty(userType);
    }
    public String getemployeeID() {
        return employeeID.get();
    }
    public String getfirstName() {
        return firstName.get();
    }
    public String getSurname() {
        return surname.get();
    }
    public String getUsername() {
        return username.get();
    }
    public String getPassword() {
        return password.get();
    }
    public String getuserType() {
        return userType.get();
    }



    public void setemployeeID(String value){employeeID.set(value);}
    public void setfirstName(String value){firstName.set(value);}
    public void setSurname(String value){
        surname.set(value);
    }
    public void setPassword(String value){
        password.set(value);
    }
    public void setUsername(String value){
        username.set(value);
    }
    public void setUserType(String value){
        userType.set(value);
    }


    public StringProperty employeeIDProperty(){
        return employeeID;
    }
    public StringProperty firstNameProperty(){
        return firstName;
    }
    public StringProperty surnameProperty(){
        return surname;
    }
    public StringProperty usernameProperty(){
        return username;
    }
    public StringProperty passwordProperty(){
        return password;
    }
    public StringProperty userTypeProperty(){
        return userType;
    }



}

