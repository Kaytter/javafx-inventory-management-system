package sales;

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
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Collections;
import java.util.ResourceBundle;

public class Controller implements Initializable {
    private dbCon con;
    private static double xOffset = 0;
    private static double yOffset = 0;
    private boolean editClicked=false;
    private String temp;
    private int salesID;
    private int unitsRemaining;

    private ObservableList<SalesDetails> salesData;
    private ObservableList<CustomerDetails> customerData;

    @FXML
    private AnchorPane mainAnchor;

    @FXML
    private Label dateTime;

    @FXML
    private Label lbSurname;

    @FXML
    private JFXButton closebtn;

    @FXML
    private TableView<SalesDetails> salesTreeView;

    @FXML
    private TableColumn<SalesDetails, String> salesIdCol;

    @FXML
    private TableColumn<SalesDetails, String> productCol;

    @FXML
    private TableColumn<SalesDetails, String> pCategoryCol;

    @FXML
    private TableColumn<SalesDetails, String> quantityCol;

    @FXML
    private TableColumn<SalesDetails, String> dateCol;

    @FXML
    private TableColumn<SalesDetails, String> amountCol;

    @FXML
    private TableColumn<SalesDetails, String> customerCol;

    @FXML
    private TableColumn<SalesDetails, String> paymentTypeCol;

    @FXML
    private TableColumn<SalesDetails, String> statusCol;

    @FXML
    private JFXButton refreshBtn;

    @FXML
    private JFXTextField searchTf;

    @FXML
    private JFXTextArea descriptionTf;

    @FXML
    private JFXTextField productTf;

    @FXML
    private JFXTextField amountTf;

    @FXML
    private JFXTextField quantityTf;

    @FXML
    private JFXTextField customerTf;

    @FXML
    private JFXCheckBox creditCb;

    @FXML
    private JFXButton sAddBtn;

    @FXML
    private JFXButton sEditBtn;

    @FXML
    private JFXButton sDeleteBtn;

    @FXML
    private JFXDatePicker datedp;

    @FXML
    private JFXButton salesBtn;

    @FXML
    private JFXButton purchaseBtn;

    @FXML
    private JFXButton inventoryBtn;

    @FXML
    private JFXButton reportsBtn;
    @FXML
    private JFXButton accountsBtn;

    @FXML
    private JFXButton settingsBtn;
    @FXML
    private JFXComboBox<SalesDetails> productCb;

    @FXML
    void closebtnclicked(ActionEvent event) {
        try {
            System.exit(1);
        } catch (InternalError error) {
            System.out.println("Close Button failure:" + error);
        }

    }

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

    @FXML
    void sAddBtnClicked(ActionEvent event) throws SQLException, ClassNotFoundException {
        boolean creditSelected = creditCb.isSelected();
        String paymentType;
        String status;
 if (creditSelected==true)
        {            paymentType="Credit";        }
        else
        {            paymentType="Cash";        }
        if (paymentType=="Credit"){status="Pending";}
        else {status="Fully Paid";}
        Connection addCon=dbCon.getConnection();
        Statement stmt=addCon.createStatement();
        try{
            if ( checkStock(String.valueOf(productCb.getValue()),Integer.parseInt(quantityTf.getText())))            {
            stmt.executeUpdate("insert into sales(product,quantity,date,amount,customer,paymentType,status)values" +
                    "('" + productCb.getValue() + "','" + quantityTf.getText() + "','" + datedp.getValue() + "','" + amountTf.getText() + "','" +
                    customerTf.getText() + "','" +paymentType +"','" + status+ "');");
            int id=0;
            ResultSet rs = stmt.getGeneratedKeys();
            if (rs.next())            {                id = rs.getInt( 1);            }
            sendID(id);
            if (status=="Pending")
                try {
                    stmt.executeUpdate("INSERT INTO accounts (saleID,product,quantity,price,dateOfPurchase,dateOfPayment,customer,status,balance) VALUES" +
                            " (" + id + ",'" + productCb.getValue() + "'," + Integer.parseInt(quantityTf.getText()) + "," + Integer.parseInt(amountTf.getText())
                            + ",'" + datedp.getValue() + "','" + " " + "','" + customerTf.getText() + "','PENDING'," + Integer.parseInt(amountTf.getText()) + ");");
                }catch (Exception e){
                e.printStackTrace();
                }

//            stmt.executeUpdate("update inventory set quantity = " + delInvSub( cbItem.getValue().toString().trim(),Integer.parseInt(tfQuantity.getText())) +" where item = '"+ cbItem.getValue().toString() +"';");

            NotificationType notificationType = NotificationType.SUCCESS;
            TrayNotification tray = new TrayNotification();
            tray.setTitle("SAVED!");
            tray.setMessage("The item(s) Has Been Successfully Saved.");
            tray.setNotificationType(notificationType);
            tray.showAndDismiss(Duration.millis(3000));
            }else {
                NotificationType notificationType = NotificationType.NOTICE;
                TrayNotification tray = new TrayNotification();
                tray.setTitle("STOCK LEVELS LOW!");
                tray.setMessage("Only "+ unitsRemaining +" units of the item(s) is/are remaining.");
                tray.setNotificationType(notificationType);
                tray.showAndDismiss(Duration.millis(3000));}
        }catch (Exception e){
            e.printStackTrace();
            NotificationType notificationType = NotificationType.ERROR;
            TrayNotification tray = new TrayNotification();
            tray.setTitle("ERROR");
            tray.setMessage("Internal Error: Please try Again!");
            tray.setNotificationType(notificationType);
            tray.showAndDismiss(Duration.millis(3000));
        }
        salesTreeView.setItems(getSalesDataFromSqlAndAddToObservableList("SELECT * FROM sales;"));
        clearSalesfields();




    }

    private void sendID(int id) {
        this.salesID=id;
    }

    @FXML
    void sDeleteBtnClicked(ActionEvent event) throws SQLException {
        Statement stmt = null;
        Connection con = dbCon.getConnection();
        stmt = con.createStatement();
        try {
            SalesDetails getSeleectedRow = (SalesDetails) salesTreeView.getSelectionModel().getSelectedItem();
            String sql = "delete from sales where ID='" + getSeleectedRow.getID() + "';";


            stmt.executeUpdate(sql);
            salesTreeView.setItems(getSalesDataFromSqlAndAddToObservableList("select * from sales"));

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
    void sEditBtnClicked(ActionEvent event) throws SQLException {
  }


    @FXML
    void searchClicked(ActionEvent event) throws SQLException {
        String temp = searchTf.getText();
        String sql = "select * from sales where product like '%" + temp + "%';";
        salesTreeView.setItems(getSalesDataFromSqlAndAddToObservableList(sql));

    }
    @FXML
    private JFXButton cuAddBtn;

    @FXML
    private JFXButton cuEditBtn;

    @FXML
    private JFXButton cuDeleteBtn;



    @FXML
    void validateSearch(ActionEvent event) {

    }
    @FXML
    private void getAmount() throws SQLException, ClassNotFoundException {
        try {
            int quantity = Integer.parseInt(quantityTf.getText());
            int sellingPrice = 0;
            int amount = 0;
            String item = String.valueOf(productCb.getValue().getAmount());

            Connection con = dbCon.getConnection();
            Statement stmt;
            stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("select price from inventory where product ='" + item + "';");

            try {
                while (rs.next()) {
                    if (rs.getString("price") != null)
                        sellingPrice = Integer.parseInt(rs.getString("price"));
                }
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
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

                amount=quantity*sellingPrice;
                amountTf.setText(String.valueOf(amount));
            }

        } catch (Exception e) {

        }
    }

    @FXML
    private void setTextAreaValues() throws SQLException {
        String item= String.valueOf(productCb.getValue());
        String description=null;
        Connection con=dbCon.getConnection();
        Statement stmt=con.createStatement();
        ResultSet rs=stmt.executeQuery("select description from inventory where product='"+item+"';");
        try{
            while (rs.next()) {
                if (rs.getString("description") != null)
                    description = rs.getString("description");
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
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

            descriptionTf.setText(description);

        }


    }
    @FXML
    private TableView<CustomerDetails> customerTableView;

    @FXML
    private TableColumn<CustomerDetails, String> cuIDCol;

    @FXML
    private TableColumn<CustomerDetails, String> cuNameCol;

    @FXML
    private TableColumn<CustomerDetails, String> cuEmailCol;

    @FXML
    private TableColumn<CustomerDetails, String> cuPnumberCol;
    @FXML
    void cuAddBtnClicked(ActionEvent event) throws SQLException {
        Connection cuAddConn=dbCon.getConnection();
        Statement stmt=cuAddConn.createStatement();

        try{

            stmt.executeUpdate("insert into customers(name,email,phoneNumber)values" +
                    "('"+customerNameTf.getText()+ "','" +customerEmailTf.getText()+ "','" +customerNumberTf.getText()+ "');");

            NotificationType notificationType = NotificationType.SUCCESS;
            TrayNotification invAddNotication = new TrayNotification();
            invAddNotication.setTitle("SAVE SUCCESSFUL");
            invAddNotication.setMessage("New Customer has been added");
            invAddNotication.setNotificationType(notificationType);
            invAddNotication.showAndDismiss(Duration.millis(3000));

        } catch (Exception e) {
            System.out.print(e);
            NotificationType notificationType = NotificationType.ERROR;
            TrayNotification invAddNotication = new TrayNotification();
            invAddNotication.setTitle("ERROR: Entry NOT SAVED");
            invAddNotication.setMessage("Please Try Again!");
            invAddNotication.setNotificationType(notificationType);
            invAddNotication.showAndDismiss(Duration.millis(3000));

        }finally {
            if (stmt != null) {
                stmt.close();
            }
            if (cuAddConn != null) {
                cuAddConn.close();

            }

        }
        customerTableView.setItems(getCustomerDataFromSqlToObservableList("select * from customers;"));
        clearCustomerFields();

    }

    @FXML
    void cuDeleteBtnClicked(ActionEvent event) throws SQLException {
        Statement stmt;
        Connection con = dbCon.getConnection();
        stmt = con.createStatement();
        try {
            CustomerDetails getSelectedRow = (CustomerDetails) customerTableView.getSelectionModel().getSelectedItem();
            String sql = "delete from customers where ID='" + getSelectedRow.getID() + "';";


            stmt.executeUpdate(sql);
            customerTableView.setItems(getCustomerDataFromSqlToObservableList("select * from customers"));

            NotificationType notification = NotificationType.SUCCESS;
            TrayNotification tray = new TrayNotification();
            tray.setTitle("DELETED");
            tray.setMessage("The selected row had been successfully Deleted!  ");
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
    private JFXTextField customerNumberTf;

    @FXML
    private JFXTextField customerNameTf;

    @FXML
    private JFXTextField customerEmailTf;

    @FXML
    void cuEditBtnClicked(ActionEvent event) throws SQLException {
        Connection con = dbCon.getConnection();
        Statement stmt = con.createStatement();


        cuEditBtn.setText("SAVE");
        ResultSet rsEdit = null;

        if (editClicked == false) {
            CustomerDetails getSelectedRow = customerTableView.getSelectionModel().getSelectedItem();

            String query = "select * from customers where(ID=" + getSelectedRow.getID() + ");";

            rsEdit = stmt.executeQuery(query);

            temp = getSelectedRow.getID();
            try {
                while (rsEdit.next()) {

                    customerNameTf.setText(rsEdit.getString(2));
                    customerEmailTf.setText(rsEdit.getString(3));
                    customerNumberTf.setText(rsEdit.getString(4));
                    editClicked = true;
                }
            } catch (Exception e) {
                System.out.println("Edit Error:" + e);
                e.printStackTrace();
            }

        } else if (editClicked == true) {
            try {
                stmt.executeUpdate("UPDATE customers SET " +

                        "name = '" + customerNameTf.getText() + "'," +
                        "email = '" + customerEmailTf.getText() + "'," +
                        "phoneNumber = '" + customerNumberTf.getText() + "'where ID =" + temp + ";");
                editClicked = false;
                cuEditBtn.setText("EDIT");
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
        customerTableView.setItems(getCustomerDataFromSqlToObservableList("select * from customers"));
        clearCustomerFields();


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
    private JFXTextField cuSearchTf;
    @FXML
    void cuSearchKeyRelease(KeyEvent event) throws SQLException {
        String temp = cuSearchTf.getText();
        String sql = "select * from customers where name like '%" + temp + "%';";
        customerTableView.setItems(getCustomerDataFromSqlToObservableList(sql));

    }
    @FXML
    private Label lb1;
    @FXML
    private Label lb2;
    @FXML
    private Label lb3;
    @FXML
    private Label lb4;


    @FXML
    void searchKeyRelease(KeyEvent event) throws SQLException {
        String temp = searchTf.getText();
        String sql = "select * from sales where product like '%" + temp + "%';";
        salesTreeView.setItems(getSalesDataFromSqlAndAddToObservableList(sql));

    }


    private void salesObservableListToTableView() throws SQLException {
        con=new dbCon();
        Connection connection=con.getConnection();
        salesData= FXCollections.observableArrayList();
        Statement stmt=null;
        ResultSet rs=null;
        try
        {
            rs=connection.createStatement().executeQuery("select * from sales");
            while(rs.next()){
                salesData.add(new SalesDetails(rs.getString(1),rs.getString(2),rs.getString(4),
                        rs.getString(5),rs.getString(6),rs.getString(7),rs.getString(8),rs.getString(9)));
                salesIdCol.setCellValueFactory(new PropertyValueFactory<SalesDetails, String>("ID"));
                productCol.setCellValueFactory(new PropertyValueFactory<SalesDetails, String>("product"));

                quantityCol.setCellValueFactory(new PropertyValueFactory<SalesDetails, String>("quantity"));
                dateCol.setCellValueFactory(new PropertyValueFactory<SalesDetails, String>("date"));
                amountCol.setCellValueFactory(new PropertyValueFactory<SalesDetails, String>("amount"));
                customerCol.setCellValueFactory(new PropertyValueFactory<SalesDetails, String>("customer"));
                paymentTypeCol.setCellValueFactory(new PropertyValueFactory<SalesDetails, String>("paymentType"));
                statusCol.setCellValueFactory(new PropertyValueFactory<SalesDetails, String>("status"));

                salesTreeView.setItems(salesData);

            }}catch (Exception e){
            System.out.println("Error Sales TableView:"+ e);
            e.printStackTrace();
        }
        finally {
            if (rs!=null){
                rs.close();
            }
            if (stmt!=null){
                stmt.close();
            }
            if (connection!=null){
                connection.close();
            }
        }



    }
    private void customerObservablelIstToTableView() throws SQLException {
        con=new dbCon();
        Connection conn=con.getConnection();
        customerData=FXCollections.observableArrayList();
        Statement stmt=null;
        ResultSet rs=null;
        try{
            rs=conn.createStatement().executeQuery("select * from customers");
            while (rs.next()){
                customerData.add(new CustomerDetails(rs.getString(1),rs.getString(2),
                        rs.getString(3),rs.getString(4)));
            }
            cuIDCol.setCellValueFactory(new PropertyValueFactory<CustomerDetails, String>("ID"));
            cuNameCol.setCellValueFactory(new PropertyValueFactory<CustomerDetails, String>("name"));
            cuEmailCol.setCellValueFactory(new PropertyValueFactory<CustomerDetails, String>("email"));
            cuPnumberCol.setCellValueFactory(new PropertyValueFactory<CustomerDetails, String>("pNumber"));
            customerTableView.setItems(customerData);

        }catch(Exception e){
            e.printStackTrace();
        }finally{
            if (rs!=null){rs.close();}
            if (stmt!=null){stmt.close();}
            if (conn!=null){conn.close();}
        }


    }
    private  ObservableList<SalesDetails> getSalesDataFromSqlAndAddToObservableList(String query) throws SQLException {

        ObservableList<SalesDetails> salesTableData = FXCollections.observableArrayList();
        Connection con = dbCon.getConnection();
        Statement stmt = con.createStatement();
        ResultSet rs = stmt.executeQuery(query);
        try {
            while (rs.next()) {
                salesTableData.add(new SalesDetails(
                        rs.getString(1),
                        rs.getString(2),
                        rs.getString(4),
                        rs.getString(5),
                        rs.getString(6),
                        rs.getString(7),
                        rs.getString(8),
                        rs.getString(9)

                ));
                salesTreeView.setItems(salesTableData);

            }

        } catch (SQLException e) {
            System.out.print(e);
        } finally {
            if (rs != null) {
                rs.close();
            }
            if (stmt != null) {
                stmt.close();
            }
            if (con != null) {
                con.close();

            }


        }


        return salesTableData;

    }
    private void clearSalesfields(){
        creditCb.setSelected(false);
        quantityTf.clear();
        amountTf.clear();
        customerTf.clear();
        descriptionTf.clear();
        datedp.setValue(null);
        productCb.setItems(null);
    }
    private void clearCustomerFields(){
        customerNumberTf.clear();
        customerNameTf.clear();
        customerEmailTf.clear();

    }
    private ObservableList<CustomerDetails>getCustomerDataFromSqlToObservableList(String query) throws SQLException {
        ObservableList<CustomerDetails> customerTableData = FXCollections.observableArrayList();
        Connection con = dbCon.getConnection();
        Statement stmt = con.createStatement();
        ResultSet rs = stmt.executeQuery(query);
        try {
            while (rs.next()) {
                customerTableData.add(new CustomerDetails(
                        rs.getString(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getString(4)));
                customerTableView.setItems(customerTableData);

            }

        } catch (SQLException e) {
            System.out.print(e);
        } finally {
            if (rs != null) {
                rs.close();
            }
            if (stmt != null) {
                stmt.close();
            }
            if (con != null) {
                con.close();

            }


        }


        return customerTableData;

    }
    private boolean checkStock(String trim, int i) throws SQLException, ClassNotFoundException {
        boolean stock=false;

        int stockAv = 0, request = i;

        Connection con = dbCon.getConnection();
        Statement stmt;
        stmt = con.createStatement();
        ResultSet rs = stmt.executeQuery("select * from inventory where product ='" + trim + "';");
        try {
            while (rs.next()) {
                if (rs.getString("quantity") != null)
                    stockAv = Integer.parseInt(rs.getString("quantity"));
                unitsRemaining=stockAv;
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
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

            if ((stockAv-request) >= 0)
            {
                stock=true;
            }

            return stock;

        }
    }




    @Override
    public void initialize(URL location, ResourceBundle resources) {
        try {
            salesObservableListToTableView();
            customerObservablelIstToTableView();
            setComboBoxValues();
        } catch (SQLException e) {
            e.printStackTrace();
        }


    }
    private void setComboBoxValues() throws SQLException {
        ObservableList comboBoxData=FXCollections.observableArrayList();
        Connection conn=dbCon.getConnection();
        Statement stmt=conn.createStatement();
        ResultSet rs=stmt.executeQuery("select product from inventory; ");
        try{
            while (rs.next()){
                comboBoxData.add(new ProductCbValues(rs.getString("product")).getProduct());
            }
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            if (rs!=null){rs.close();}
            if (stmt!=null){stmt.close();}
            if (conn!=null){conn.close();}
        }
        Collections.sort(comboBoxData);
        productCb.setItems(comboBoxData);
        setTextAreaValues();

    }
}























