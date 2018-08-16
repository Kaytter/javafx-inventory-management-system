package settings;


import com.jfoenix.controls.*;
import db.dbCon;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.util.Duration;
import tray.animations.AnimationType;
import tray.notification.NotificationType;
import tray.notification.TrayNotification;

import java.io.IOException;
import java.net.URL;
import java.sql.*;
import java.util.ResourceBundle;
/**
 * Created by Ketter Collins on 21/05/2018.
 */
public class Controller implements Initializable {
    private static double xOffset = 0;
    private static double yOffset = 0;


    @FXML
    void closebtnclicked(ActionEvent event) {
        try {
            System.exit(1);
        } catch (InternalError error) {
            System.out.println("Close Button failure:" + error);
        }

    }
    @FXML
    private JFXHamburger hamburger;

    @FXML
    private JFXDrawer drawer;



    @FXML
    private AnchorPane mainAnchor;

    @FXML
    private Label lbSurname;
    @FXML
    private Label lb1;
    @FXML
    private Label lb2;




    @FXML
    private JFXButton closebtn;

    @FXML
    private AnchorPane lbInfo;
    @FXML
    private JFXButton salesBtn;

    @FXML
    private JFXButton purchaseBtn;

    @FXML
    private JFXButton inventoryBtn;

    @FXML
    private JFXButton reportsBtn;

    @FXML
    private JFXButton settingsBtn;

    @FXML
    private JFXPasswordField passwordTf;

    @FXML
    private JFXPasswordField cPasswordTf;

    @FXML
    private JFXTextField usernameTf;
    @FXML
    private JFXTextField employeeIdTf;

    @FXML
    private JFXButton addBtn;

    @FXML
    private JFXCheckBox adminCbox;
    @FXML
    private TableView<userDetails> userTableView;


    @FXML
    private JFXButton editBtn;
    @FXML
    private JFXButton accountsBtn;

    @FXML
    private JFXTextField sNameTf;

    @FXML
    private JFXTextField fNameTf;

    @FXML
    private JFXButton deleteBtn;

    String usernameLabel;

  private String temp;
  private boolean editClicked;

    private boolean isNewAdd=true;
    private String tempId;
   /* @FXML
    private JFXTreeTableView<User> adminTreeView;*/
   @FXML
   void editClicked(ActionEvent event) throws SQLException {


       Connection con = dbCon.getConnection();
       Statement stmt = con.createStatement();


       editBtn.setText("SAVE");
       ResultSet rsEdit = null;

       if (editClicked == false) {
           userDetails getSelectedRow = userTableView.getSelectionModel().getSelectedItem();

           String query = "select * from Users where(employee_id=" + getSelectedRow.getemployeeID() + ");";
            System.out.println("before");
           rsEdit = stmt.executeQuery(query);
           System.out.println("after");

           temp = getSelectedRow.getemployeeID();
           try {
               while (rsEdit.next()) {
                   usernameTf.setText(rsEdit.getString(1));
                   passwordTf.setText(rsEdit.getString(2));
                   fNameTf.setText(rsEdit.getString(4));
                   sNameTf.setText((rsEdit.getString(5)));
                   employeeIdTf.setText(rsEdit.getString(6));



                   editClicked = true;
               }
           } catch (Exception e) {
               System.out.println("Edit Error:" + e);
               e.printStackTrace();
           }

       } else if (editClicked == true) {
           try {
               stmt.executeUpdate("UPDATE purchase SET " +
                       "username = '" + usernameTf.getText() + "'," +
                       "password = '" + passwordTf.getText() + "'," +
                       "firstName = '" + fNameTf.getText() + "'," +
                       "surname = '" + sNameTf.getText() + "'," +
                       "employee_id = '" + employeeIdTf.getText() + "'where employee_id =" + temp + ";");
               editClicked = false;
               editBtn.setText("EDIT");
               NotificationType notification = NotificationType.SUCCESS;
               TrayNotification tray = new TrayNotification();
               tray.setAnimationType(AnimationType.FADE);
               tray.setTitle("EDIT SUCCESSFUL");
               tray.setMessage("Record has been successfully updated");
               tray.setNotificationType(notification);
               tray.showAndDismiss(Duration.millis(1000));

           } catch (SQLException e) {
               System.out.println("Edit true error:" + e);
               NotificationType notification = NotificationType.ERROR;
               TrayNotification tray = new TrayNotification();
               tray.setAnimationType(AnimationType.FADE);
               tray.setTitle("EDIT UNSUCCESSFUL");
               tray.setMessage("Record has NOT been updated");
               tray.setNotificationType(notification);
               tray.showAndDismiss(Duration.millis(2000));
           }

       }
       userTableView.setItems(getDataFromSqlAddToObservableList("select * from Users"));

       if (rsEdit != null) {
           rsEdit.close();
       }
       if (stmt != null) {
           stmt.close();
       }
       if (con != null) {
           con.close();
       }




   }

    @FXML
    void addClicked(ActionEvent event) throws SQLException {
        String userType;
        isFieldsFilled();
        Connection con=dbCon.getConnection();
        Statement stmt=con.createStatement();
        if (adminCbox.isSelected()==true) {
            userType = "admin";
        } else userType="user";

        if (isNewAdd==true) {
            try {
                String sql = "INSERT INTO Users (employee_id,surname,firstname,password,userType,username) VALUES" +
                        "('" + employeeIdTf.getText() + "','" + sNameTf.getText() + "','" + fNameTf.getText() + "','" + passwordTf.getText() +
                        "','" + userType + "','" + usernameTf.getText() + "');";
                stmt = con.createStatement();


                stmt.executeUpdate(sql);

                NotificationType notificationType = NotificationType.SUCCESS;
                TrayNotification tray = new TrayNotification();
                tray.setTitle("SAVED!");
                tray.setMessage("New User Successfully added!  .");
                tray.setNotificationType(notificationType);
                tray.showAndDismiss(Duration.millis(3000));


                userTableView.setItems(getDataFromSqlAddToObservableList("select * from Users"));
            } catch (SQLFeatureNotSupportedException e) {

                NotificationType notificationTypeEr = NotificationType.ERROR;
                TrayNotification trayEr = new TrayNotification();
                trayEr.setTitle("ERROR");
                trayEr.setMessage("User NOT added. Try Again.");
                trayEr.setNotificationType(notificationTypeEr);
                trayEr.showAndDismiss(Duration.millis(3000));
                addBtn.setText("ADD");

            }

        }  else {
            if (isNewAdd == false) {
                    try {
                        if (adminCbox.isSelected() == true) {
                            userType = "admin";
                        } else {
                            userType = "user";
                        }
                         String sqlEdit = "UPDATE Users set " +
                                "firstname= '" + fNameTf.getText() + "'," +"surname= '"+ sNameTf.getText() + "',"
                              //  +"employee_id= '"+ employeeIdTf.getText() + "',"
                                +"username= '"+ usernameTf.getText() +
                                "password= '"+ passwordTf.getText() + "'," + "userType= '" + userType +
                                "'where employee_id= '" + employeeIdTf.getText() + " '";
                        String sql="update Users set firstname= " + fNameTf.getText()+"',"+ "'where employee_id="+tempId+";";


                        stmt.executeUpdate(sqlEdit);

                        addBtn.setText("ADD");

                        NotificationType notificationType1 = NotificationType.SUCCESS;
                        TrayNotification tray1 = new TrayNotification();
                        tray1.setTitle("SAVED!");
                        tray1.setMessage("UPDATE SUCCESSFUL.");
                        tray1.setNotificationType(notificationType1);
                        tray1.showAndDismiss(Duration.millis(3000));


                    } catch (SQLException e) {
                        e.printStackTrace();
                        addBtn.setText("ADD");


                        NotificationType notificationType2 = NotificationType.ERROR;
                        TrayNotification tray2 = new TrayNotification();
                        tray2.setTitle("ERROR");
                        tray2.setMessage("Update was NOT added. Try Again.");
                        tray2.setNotificationType(notificationType2);
                        tray2.showAndDismiss(Duration.millis(3000));

                    }finally {

                        if (stmt != null) {
                            stmt.close();
                        }
                        if (con != null) {
                            con.close();
                        }
                    }
                   // isSaveEdit = false;


                }}
            }

    public void setUsernameLabel(String usernameLabel) {
        this.usernameLabel = usernameLabel;

    }

    @FXML
    void deleteClicked(ActionEvent event) throws SQLException {
        Statement stmt = null;
        Connection con = dbCon.getConnection();
        stmt = con.createStatement();
        try {
            userDetails getSeleectedRow = (userDetails) userTableView.getSelectionModel().getSelectedItem();
            String sql = "delete from Users where employee_id='" + getSeleectedRow.getemployeeID() + "';";


            stmt.executeUpdate(sql);
            userTableView.setItems(getDataFromSqlAddToObservableList("select * from Users"));

            NotificationType notification = NotificationType.SUCCESS;
            TrayNotification tray = new TrayNotification();
            tray.setTitle("DELETE");
            tray.setMessage("The selected row had been succesfully Deleted!  ");
            tray.setNotificationType(notification);
            tray.showAndDismiss(Duration.millis(3000));
        } catch (Exception e) {
            NotificationType notification = NotificationType.ERROR;
            TrayNotification tray = new TrayNotification();
            tray.setTitle("ERROR");
            tray.setMessage("Try Again!    ");
            tray.setNotificationType(notification);
            tray.showAndDismiss(Duration.millis(3000));
        } finally {

            if (stmt != null) {
                stmt.close();
            }
            if (con!=null){
                con.close();
            }
            }
        }
    @FXML
    private JFXTextField searchTf;
    @FXML
    void searchEmployeeID(KeyEvent event) throws SQLException {
        String temp = searchTf.getText();
        String sql = "select * from Users where employee_id like '%" + temp + "%';";
        userTableView.setItems(getDataFromSqlAddToObservableList(sql));

    }

    @FXML
    private TableColumn<userDetails, String> employeeIDColumn;

    @FXML
    private TableColumn<userDetails, String> firstNameColumn;

    @FXML
    private TableColumn<userDetails, String> surnameColumn;

    @FXML
    private TableColumn<userDetails, String> userNameColumn;

    @FXML
    private TableColumn<userDetails, String> passwordColumn;

    @FXML
    private TableColumn<userDetails, String> userTypeColumn;
    @FXML
    void inventoryClicked(ActionEvent event) throws IOException {
        Parent invParent = FXMLLoader.load(getClass().getResource("/inventory/inventory.fxml"));
        Scene invScene = new Scene(invParent);
        invScene.setFill(Color.TRANSPARENT);
        Stage invStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        invStage.setScene(invScene);
        invStage.centerOnScreen();
        invStage.show();
        invParent.setOnMousePressed(e -> {
            xOffset = e.getSceneX();
            yOffset = e.getSceneY();
        });
        invParent.setOnMouseDragged(e -> {
            invStage.setX(e.getScreenX() - xOffset);
            invStage.setY(e.getScreenY() - yOffset);
        });

    }
    @FXML
    void accountsClicked(ActionEvent event) throws IOException {
        Parent invParent = FXMLLoader.load(getClass().getResource("/accounts/accounts.fxml"));
        Scene invScene = new Scene(invParent);
        invScene.setFill(Color.TRANSPARENT);
        Stage invStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        invStage.setScene(invScene);
        invStage.centerOnScreen();
        invStage.show();
        invParent.setOnMousePressed(e -> {
            xOffset = e.getSceneX();
            yOffset = e.getSceneY();
        });
        invParent.setOnMouseDragged(e -> {
            invStage.setX(e.getScreenX() - xOffset);
            invStage.setY(e.getScreenY() - yOffset);
        });

    }
    @FXML
    void reportsClicked(ActionEvent event) throws IOException {
        Parent invParent = FXMLLoader.load(getClass().getResource("/reports/reports.fxml"));
        Scene invScene = new Scene(invParent);
        invScene.setFill(Color.TRANSPARENT);
        Stage invStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        invStage.setScene(invScene);
        invStage.centerOnScreen();
        invStage.show();
        invParent.setOnMousePressed(e -> {
            xOffset = e.getSceneX();
            yOffset = e.getSceneY();
        });
        invParent.setOnMouseDragged(e -> {
            invStage.setX(e.getScreenX() - xOffset);
            invStage.setY(e.getScreenY() - yOffset);
        });


    }

    @FXML
    void salesClicked(ActionEvent event) throws IOException {
        Parent invParent = FXMLLoader.load(getClass().getResource("/sales/sales.fxml"));
        Scene invScene = new Scene(invParent);
        invScene.setFill(Color.TRANSPARENT);
        Stage invStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        invStage.setScene(invScene);
        invStage.centerOnScreen();
        invStage.show();
        invParent.setOnMousePressed(e -> {
            xOffset = e.getSceneX();
            yOffset = e.getSceneY();
        });
        invParent.setOnMouseDragged(e -> {
            invStage.setX(e.getScreenX() - xOffset);
            invStage.setY(e.getScreenY() - yOffset);
        });

    }



    @FXML
    void settingsClicked(ActionEvent event) throws IOException {
        Parent invParent = FXMLLoader.load(getClass().getResource("/settings/settings.fxml"));
        Scene invScene = new Scene(invParent);
        invScene.setFill(Color.TRANSPARENT);
        Stage invStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        invStage.setScene(invScene);
        invStage.centerOnScreen();
        invStage.show();
        invParent.setOnMousePressed(e -> {
            xOffset = e.getSceneX();
            yOffset = e.getSceneY();
        });
        invParent.setOnMouseDragged(e -> {
            invStage.setX(e.getScreenX() - xOffset);
            invStage.setY(e.getScreenY() - yOffset);
        });

    }
    @FXML
    void purchaseClicked(ActionEvent event) throws IOException {
        Parent invParent = FXMLLoader.load(getClass().getResource("/purchase/purchase.fxml"));
        Scene invScene = new Scene(invParent);
        invScene.setFill(Color.TRANSPARENT);
        Stage invStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        invStage.setScene(invScene);
        invStage.centerOnScreen();
        invStage.show();
        invParent.setOnMousePressed(e -> {
            xOffset = e.getSceneX();
            yOffset = e.getSceneY();
        });
        invParent.setOnMouseDragged(e -> {
            invStage.setX(e.getScreenX() - xOffset);
            invStage.setY(e.getScreenY() - yOffset);
        });

    }
    private ObservableList<userDetails>data;
    private dbCon con;

    @Override
    public void initialize(URL location, ResourceBundle resources) {


           observableListToTableView();

    }
    private boolean isFieldsFilled(){
        boolean filled;
        if (employeeIdTf.getText().isEmpty()||fNameTf.getText().isEmpty()||sNameTf.getText().isEmpty()
                || usernameTf.getText().isEmpty()||passwordTf.getText().isEmpty()||cPasswordTf.getText().isEmpty()){
            NotificationType notificationType=NotificationType.INFORMATION;
            TrayNotification trayNotification=new TrayNotification();
            trayNotification.setTitle("ATTENTION");
            trayNotification.setMessage("All fields MUST be filled!");
            trayNotification.setNotificationType(notificationType);
            trayNotification.showAndDismiss(Duration.millis(3000));
            filled=false;

        }
        else filled=true;
        return filled;
    }
    private ObservableList getDataFromSqlAddToObservableList(String query) throws SQLException {
        ObservableList<userDetails> settingsTable=FXCollections.observableArrayList();
        Connection con=dbCon.getConnection();
        Statement stmt=con.createStatement();
        ResultSet rs=stmt.executeQuery(query);

         {
        }
        try {
            while (rs.next()) {
                settingsTable.add(new userDetails(
                        rs.getString("employee_id"),
                        rs.getString("firstname"),
                        rs.getString("surname"),
                        rs.getString("username"),
                        rs.getString("password"),
                        rs.getString("userType")
                ));

                userTableView.setItems(null);
                userTableView.setItems(settingsTable);


            }
        }catch (SQLException e){
            e.printStackTrace();
        }
        finally  {

            if (rs != null) {
            try {
                rs.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        if (stmt != null) {
            try {
                stmt.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        if (con != null) {
            try {
                con.close();
            } catch (Exception e) {
                e.printStackTrace();
            }


        }

    }
    return settingsTable;
    }

    private void observableListToTableView(){
        con=new dbCon();

        data=FXCollections.observableArrayList();
        Connection con = dbCon.getConnection();
        Statement statement = null;



        try {
            ResultSet rs = con.createStatement().executeQuery("select * from Users");
            while (rs.next()) {
                data.add(new userDetails(rs.getString(6), rs.getString(4), rs.getString(5), rs.getString(2),
                        rs.getString(1), rs.getString(3)));


                employeeIDColumn.setCellValueFactory(new PropertyValueFactory<userDetails, String>("employeeID"));
                firstNameColumn.setCellValueFactory(new PropertyValueFactory<userDetails, String>("firstName"));
                surnameColumn.setCellValueFactory(new PropertyValueFactory<userDetails, String>("surname"));
                userNameColumn.setCellValueFactory(new PropertyValueFactory<userDetails, String>("username"));
                passwordColumn.setCellValueFactory(new PropertyValueFactory<userDetails, String>("password"));
                userTypeColumn.setCellValueFactory(new PropertyValueFactory<userDetails, String>("userType"));

                userTableView.setItems(null);
                userTableView.setItems(data);

            }
            if (rs != null) {
                rs.close();
            }
            if (statement != null) {
                statement.close();
            }
            if (con != null) {
                con.close();
            }
        } catch (SQLException e) {
            System.err.print("SQL Error");
        }

    }}












/* JFXTreeTableColumn<User,String> fNameCol=new JFXTreeTableColumn<>("First Name");
        fNameCol.setPrefWidth(150);
        fNameCol.setCellValueFactory(new Callback<TreeTableColumn.CellDataFeatures<User, String>, ObservableValue<String>>() {
            @Override
            public ObservableValue<String> call(TreeTableColumn.CellDataFeatures<User, String> param) {
                return param.getValue().getValue().fName;
            }});

        JFXTreeTableColumn<User,String> sNameCol=new JFXTreeTableColumn<>("Surname");
        sNameCol.setPrefWidth(150);
        sNameCol.setCellValueFactory(new Callback<TreeTableColumn.CellDataFeatures<User, String>, ObservableValue<String>>() {
            @Override
            public ObservableValue<String> call(TreeTableColumn.CellDataFeatures<User, String> param) {
                return param.getValue().getValue().sName;
            }});

        JFXTreeTableColumn<User,String> usernameCol=new JFXTreeTableColumn<>("Username");
        usernameCol.setPrefWidth(150);
        usernameCol.setCellValueFactory(new Callback<TreeTableColumn.CellDataFeatures<User, String>, ObservableValue<String>>() {
            @Override
            public ObservableValue<String> call(TreeTableColumn.CellDataFeatures<User, String> param) {
                return param.getValue().getValue().userName;
            }});

        JFXTreeTableColumn<User,String> passwordCol=new JFXTreeTableColumn<>("Password");
        passwordCol.setPrefWidth(150);
        passwordCol.setCellValueFactory(new Callback<TreeTableColumn.CellDataFeatures<User, String>, ObservableValue<String>>() {
            @Override
            public ObservableValue<String> call(TreeTableColumn.CellDataFeatures<User, String> param) {
                return param.getValue().getValue().password;
            }});
        JFXTreeTableColumn<User,String> userTypeCol=new JFXTreeTableColumn<>("User Type");
        userTypeCol.setPrefWidth(150);
        userTypeCol.setCellValueFactory(new Callback<TreeTableColumn.CellDataFeatures<User, String>, ObservableValue<String>>() {
            @Override
            public ObservableValue<String> call(TreeTableColumn.CellDataFeatures<User, String> param) {
                return param.getValue().getValue().userType;
            }});



        ObservableList<User> users= FXCollections.observableArrayList();
        users.add(new User("Collins","Ketter","cketter","kiprotich","admin"));
        users.add(new User("Brian","Sambu","Bsambu","sambu","admin"));
        users.add(new User("Carter","Wayne","Cwayne","Weezy","admin"));
        users.add(new User("Martha","Stewart","mstewart","missG","user"));
        users.add(new User("Fridah","Jebichi","FridahJ","jfrid","admin"));

        final TreeItem<User> root=new RecursiveTreeItem<User>(users,RecursiveTreeObject::getChildren);
        adminTreeView.getColumns().setAll(fNameCol,sNameCol,usernameCol,passwordCol,userTypeCol);
        adminTreeView.setRoot(root);
        adminTreeView.setShowRoot(false);*/
/*
class User extends RecursiveTreeObject<User> {

        StringProperty userName;
        StringProperty password;
        StringProperty fName;
        StringProperty sName;
        StringProperty userType;

        public User(String fName,String sName, String userName, String password, String userType){
            this.fName=new SimpleStringProperty(fName);
            this.sName=new SimpleStringProperty(sName);
            this.userName=new SimpleStringProperty(userName);
            this.password=new SimpleStringProperty(password);
            this.userType=new SimpleStringProperty(userType);
 */

