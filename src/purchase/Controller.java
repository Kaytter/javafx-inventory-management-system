package purchase;


import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXDatePicker;
import com.jfoenix.controls.JFXTextField;
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
import java.time.LocalDate;
import java.util.ResourceBundle;


/**
 * Created by Ketter Collins on 21/05/2018.
 */
public class Controller implements Initializable  {
    private dbCon con;
    private ObservableList<PurchaseDetails>purchaseData;
    private ObservableList<VendorDetails>vendorData;
    private static double xOffset = 0;
    private static double yOffset = 0;
    private boolean editClicked=false;
    String temp;
    @FXML
    private AnchorPane mainAnchor;

    @FXML
    private Label dateTime;

    @FXML
    private Label lbSurname;

    @FXML
    private JFXButton closebtn;

    @FXML
    private JFXTextField prIDTf;

    @FXML
    private JFXTextField prProductTf;

    @FXML
    private JFXTextField prCategoryTf;

    @FXML
    private JFXTextField prQuantityTf;

    @FXML
    private JFXTextField prVendorTf;

    @FXML
    private JFXTextField prPriceTf;

    @FXML
    private JFXTextField prStatusTf;

    @FXML
    private JFXDatePicker dpPrDate;

    @FXML
    private JFXDatePicker dpDeliveryDate;

    @FXML
    private JFXButton prAddBtn;

    @FXML
    private JFXButton prEditBtin;

    @FXML
    private JFXButton prDeleteBtn;

    @FXML
    private JFXTextField veIDTf;

    @FXML
    private JFXTextField veNameTf;

    @FXML
    private JFXTextField veEmailTf;

    @FXML
    private JFXTextField vePhoneNumberTf;

    @FXML
    private JFXTextField veCategoryTf;

    @FXML
    private JFXButton veAddBtn;

    @FXML
    private JFXButton veEditBtin;

    @FXML
    private JFXButton veDeleteBtn;

    @FXML
    private JFXButton salesBtn;
    @FXML
    private JFXButton accountsBtn;

    @FXML
    private JFXButton purchaseBtn;

    @FXML
    private JFXButton inventoryBtn;

    @FXML
    private JFXButton reportsBtn;

    @FXML
    private JFXButton settingsBtn;

    @FXML
    private TableView<PurchaseDetails> prTableView;

    @FXML
    private TableColumn<PurchaseDetails,String > prIDCol;

    @FXML
    private TableColumn<PurchaseDetails,String > prProductCol;

    @FXML
    private TableColumn<PurchaseDetails,String > prCategoryCol;

    @FXML
    private TableColumn<PurchaseDetails,String > prQuantityCol;

    @FXML
    private TableColumn<PurchaseDetails,String > prVendorCol;

    @FXML
    private TableColumn<PurchaseDetails,String > prPriceCol;

    @FXML
    private TableColumn<PurchaseDetails,String > prTotalPriceCol;

    @FXML
    private TableColumn<PurchaseDetails,String > prStatusCol;

    @FXML
    private TableColumn<PurchaseDetails,String > prBalanceCol;

    @FXML
    private TableColumn<PurchaseDetails,String > prDateCol;

    @FXML
    private TableColumn<PurchaseDetails,String > prDeliveryDateCol;

    @FXML
    private TableView<VendorDetails> veTableView;

    @FXML
    private TableColumn<VendorDetails,String> veIDCol;

    @FXML
    private TableColumn<VendorDetails,String> veNameCol;

    @FXML
    private TableColumn<VendorDetails,String> veEmailCol;

    @FXML
    private TableColumn<VendorDetails,String> vePnumberCol;

    @FXML
    private TableColumn<VendorDetails,String> veCategoryCol;

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
    void prAddClicked(ActionEvent event) throws SQLException {
        Connection prAddCon = dbCon.getConnection();
        Statement prAddStmt = prAddCon.createStatement();

        int quantity=Integer.parseInt(prQuantityTf.getText());
        int price=Integer.parseInt(prPriceTf.getText());
        int total=quantity*price;
        int balance=2000;



        try {
            prAddStmt.executeUpdate("insert into purchase (ID,product,category,quantity,vendor,price,totalAmount,status,balance,deliveryDate,purchaseDate) values" +
                    "('" + prIDTf.getText() + "','" + prProductTf.getText() + "','" + prCategoryTf.getText() + "','" + prQuantityTf.getText() + "','" +
                    prVendorTf.getText() + "','" + prPriceTf.getText()+"','"+total+"','" +prStatusTf.getText() + "','"+balance+"','"+dpDeliveryDate.getValue()+"','"+dpPrDate.getValue() +"');");

            NotificationType notificationType = NotificationType.SUCCESS;
            TrayNotification invAddNotication = new TrayNotification();
            invAddNotication.setTitle("SAVE SUCCESSFUL");
            invAddNotication.setMessage("New Purchase has been added");
            invAddNotication.setNotificationType(notificationType);
            invAddNotication.showAndDismiss(Duration.millis(3000));

        } catch (Exception e) {
            System.out.print(e);
            NotificationType notificationType = NotificationType.ERROR;
            TrayNotification invAddNotication = new TrayNotification();
            invAddNotication.setTitle("ERROR: Entry NOT SAVED");
            invAddNotication.setMessage("Please ensure the ID is UNIQUE");
            invAddNotication.setNotificationType(notificationType);
            invAddNotication.showAndDismiss(Duration.millis(3000));
        } finally {
            if (prAddStmt != null) {
                prAddStmt.close();
            }
            if (prAddCon != null) {
                prAddCon.close();

            }
        }
        prTableView.setItems(getDataFromSqlAddToObservableList("select * from purchase"));
    }



    @FXML
    void prDeleteClicked(ActionEvent event) throws SQLException {
        Statement stmt;
        Connection con = dbCon.getConnection();
        stmt = con.createStatement();
        try {
            PurchaseDetails getSeleectedRow = (PurchaseDetails) prTableView.getSelectionModel().getSelectedItem();
            String sql = "delete from purchase where ID='" + getSeleectedRow.getPrID() + "';";


            stmt.executeUpdate(sql);
            prTableView.setItems(getDataFromSqlAddToObservableList("select * from purchase"));

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

    }}

    @FXML
    void prEditClicked(ActionEvent event) throws SQLException {
        Connection con = dbCon.getConnection();
        Statement stmt = con.createStatement();


        prEditBtin.setText("SAVE");
        ResultSet rsEdit = null;

        if (editClicked == false) {
            PurchaseDetails getSelectedRow = prTableView.getSelectionModel().getSelectedItem();

            String query = "select * from purchase where(ID=" + getSelectedRow.getPrID() + ");";

            rsEdit = stmt.executeQuery(query);

            temp = getSelectedRow.getPrID();
            try {
                while (rsEdit.next()) {
                    prIDTf.setText(rsEdit.getString(1));
                    prProductTf.setText(rsEdit.getString(2));
                    prCategoryTf.setText(rsEdit.getString(3));
                    prQuantityTf.setText((rsEdit.getString(4)));
                    prVendorTf.setText(rsEdit.getString(5));
                    prPriceTf.setText(rsEdit.getString(6));
                    prStatusTf.setText(rsEdit.getString(8));
                    dpDeliveryDate.setValue(LocalDate.parse(rsEdit.getString(10)));
                    dpPrDate.setValue(LocalDate.parse(rsEdit.getString(11)));


                    editClicked = true;
                }
            } catch (Exception e) {
                System.out.println("Edit Error:" + e);
                e.printStackTrace();
            }

        } else if (editClicked == true) {
            try {
                stmt.executeUpdate("UPDATE purchase SET " +
                        "ID = '" + prIDTf.getText() + "'," +
                        "product = '" + prProductTf.getText() + "'," +
                        "category = '" + prCategoryTf.getText() + "'," +
                        "quantity = '" + prQuantityTf.getText() + "'," +
                        "vendor = '" + prVendorTf.getText() + "'," +
                        "price = '" + prPriceTf.getText() + "'," +
                        "status = '" + prStatusTf.getText() + "'," +
                        "deliveryDate = '" + dpDeliveryDate.getValue() + "'," +
                        "purchaseDate = '" + dpPrDate.getValue() + "'where ID =" + temp + ";");
                editClicked = false;
                prEditBtin.setText("EDIT");
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
        prTableView.setItems(getDataFromSqlAddToObservableList("select * from purchase"));

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
    void veAddClicked(ActionEvent event) throws SQLException {
    Connection veConn=dbCon.getConnection();
    Statement stmt=veConn.createStatement();

    try{

            stmt.executeUpdate("insert into vendors(ID,name,email,phoneNumber,productCategory)values" +
                    "('"+veIDTf.getText()+ "','" +veNameTf.getText()+ "','" +veEmailTf.getText()+ "','" +vePhoneNumberTf.getText()
                    + "','" +veCategoryTf.getText()+ "');");

            NotificationType notificationType = NotificationType.SUCCESS;
            TrayNotification invAddNotication = new TrayNotification();
            invAddNotication.setTitle("SAVE SUCCESSFUL");
            invAddNotication.setMessage("New Delivery has been added");
            invAddNotication.setNotificationType(notificationType);
            invAddNotication.showAndDismiss(Duration.millis(3000));

    } catch (Exception e) {
        System.out.print(e);
        NotificationType notificationType = NotificationType.ERROR;
        TrayNotification invAddNotication = new TrayNotification();
        invAddNotication.setTitle("ERROR: Entry NOT SAVED");
        invAddNotication.setMessage("Please ensure the DeliveryID is UNIQUE");
        invAddNotication.setNotificationType(notificationType);
        invAddNotication.showAndDismiss(Duration.millis(3000));

    }finally {
        if (stmt != null) {
            stmt.close();
        }
        if (veConn != null) {
            veConn.close();

        }

    }
    veTableView.setItems(getDataFromSqlAddToVendorObservableList("select * from vendors;"));
    }

    @FXML
    void veDeleteClicked(ActionEvent event) throws SQLException {
        Statement stmt;
        Connection con = dbCon.getConnection();
        stmt = con.createStatement();
        try {
            VendorDetails getSelectedRow = (VendorDetails) veTableView.getSelectionModel().getSelectedItem();
            String sql = "delete from vendors where id='" + getSelectedRow.getId() + "';";


            stmt.executeUpdate(sql);
            veTableView.setItems(getDataFromSqlAddToVendorObservableList("select * from vendors"));

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
    void veEditClicked(ActionEvent event) throws SQLException {
        Connection con = dbCon.getConnection();
        Statement stmt = con.createStatement();


        veEditBtin.setText("SAVE");
        ResultSet rsEdit = null;

        if (editClicked == false) {
            VendorDetails getSelectedRow = veTableView.getSelectionModel().getSelectedItem();

            String query = "select * from vendors where(ID=" + getSelectedRow.getId() + ");";

            rsEdit = stmt.executeQuery(query);

            temp = getSelectedRow.getId();
            try {
                while (rsEdit.next()) {
                    veIDTf.setText(rsEdit.getString(1));
                    veNameTf.setText(rsEdit.getString(2));
                    veEmailTf.setText(rsEdit.getString(3));
                    vePhoneNumberTf.setText((rsEdit.getString(4)));
                    veCategoryTf.setText(rsEdit.getString(5));
                    editClicked = true;
                }
            } catch (Exception e) {
                System.out.println("Edit Error:" + e);
                e.printStackTrace();
            }

        } else if (editClicked == true) {
            try {
                stmt.executeUpdate("UPDATE vendors SET " +
                        "ID = '" + prIDTf.getText() + "'," +
                        "name = '" + prProductTf.getText() + "'," +
                        "email = '" + prCategoryTf.getText() + "'," +
                        "phoneNumber = '" + prQuantityTf.getText() + "'," +
                        "productCategory = '" + dpPrDate.getValue() + "'where ID =" + temp + ";");
                editClicked = false;
                prEditBtin.setText("EDIT");
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
        veTableView.setItems(getDataFromSqlAddToVendorObservableList("select * from vendors"));

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
    private JFXTextField prSearchTf;
    @FXML
    void prSearchProduct(KeyEvent event) throws SQLException {
        String temp = prSearchTf.getText();
        String sql = "select * from purchase where product like '%" + temp + "%';";
        prTableView.setItems(getDataFromSqlAddToObservableList(sql));

    }
    @FXML
    private JFXTextField veSearchTf;
    @FXML
    void veSearchProduct(KeyEvent event) throws SQLException {
        String temp = veSearchTf.getText();
        String sql = "select * from vendors where name like '%" + temp + "%';";
        veTableView.setItems(getDataFromSqlAddToVendorObservableList(sql));

    }
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        try {
            purchaseObservableListToTableView();
            vendorObservableListToTableView();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }





    private void purchaseObservableListToTableView() throws SQLException {
        con = new dbCon();
        Connection prCon = con.getConnection();
        purchaseData = FXCollections.observableArrayList();
        Statement stmt = null;
        ResultSet rs = null;
        try {
            rs = prCon.createStatement().executeQuery("select * from purchase");
            while (rs.next()) {
                purchaseData.add(new PurchaseDetails(rs.getString(1), rs.getString(2), rs.getString(3),
                        rs.getString(4), rs.getString(5), rs.getString(6), rs.getString(7),
                        rs.getString(8), rs.getString(9), rs.getString(10), rs.getString(11))
                );
                prIDCol.setCellValueFactory(new PropertyValueFactory<PurchaseDetails, String>("prID"));
                prProductCol.setCellValueFactory(new PropertyValueFactory<PurchaseDetails, String>("product"));
                prCategoryCol.setCellValueFactory(new PropertyValueFactory<PurchaseDetails, String>("pCategory"));
                prQuantityCol.setCellValueFactory(new PropertyValueFactory<PurchaseDetails, String>("quantity"));
                prVendorCol.setCellValueFactory(new PropertyValueFactory<PurchaseDetails, String>("vendor"));
                prPriceCol.setCellValueFactory(new PropertyValueFactory<PurchaseDetails, String>("price"));
                prTotalPriceCol.setCellValueFactory(new PropertyValueFactory<PurchaseDetails, String>("TotalAmount"));
                prStatusCol.setCellValueFactory(new PropertyValueFactory<PurchaseDetails, String>("status"));
                prBalanceCol.setCellValueFactory(new PropertyValueFactory<PurchaseDetails, String>("balance"));
                prDeliveryDateCol.setCellValueFactory(new PropertyValueFactory<PurchaseDetails, String>("deliveryDate"));
                prDateCol.setCellValueFactory(new PropertyValueFactory<PurchaseDetails, String>("procurementDate"));

                prTableView.setItems(purchaseData);


            }
        } catch (Exception e) {
            System.out.println("Error PR TableView:" + e);

        } finally {
            if (rs != null) {rs.close();}
            if (stmt!=null){stmt.close();}
            if (prCon!=null){prCon.close();}
        }

    }
    private ObservableList getDataFromSqlAddToObservableList(String query) throws SQLException {
        ObservableList<PurchaseDetails> purchaseTable = FXCollections.observableArrayList();
        Connection con = dbCon.getConnection();
        Statement stmt = con.createStatement();
        ResultSet rs = stmt.executeQuery(query);

        try {
            while (rs.next()) {
                purchaseTable.add(new PurchaseDetails(rs.getString(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getString(4),
                        rs.getString(5),
                        rs.getString(6),
                        rs.getString(7),
                        rs.getString(8),
                        rs.getString(9),
                        rs.getString(10),
                        rs.getString(11)
                ));
                prTableView.setItems(null);
                prTableView.setItems(purchaseTable);
            }
        } catch (SQLException e) {
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

        }
        return purchaseTable;


    }
    private void vendorObservableListToTableView() throws SQLException {
        con=new dbCon();
        Connection connection=con.getConnection();
        vendorData=FXCollections.observableArrayList();
        Statement stmt=null;
        ResultSet rs=null;
        try{
            rs=connection.createStatement().executeQuery("select * from vendors");
            while (rs.next()){
                vendorData.add(new VendorDetails(rs.getString(1),rs.getString(2),rs.getString(3),
                        rs.getString(4),rs.getString(5)));
                veIDCol.setCellValueFactory(new PropertyValueFactory<VendorDetails,String>("id"));
                veNameCol.setCellValueFactory(new PropertyValueFactory<VendorDetails,String>("name"));
                veEmailCol.setCellValueFactory(new PropertyValueFactory<VendorDetails,String>("email"));
                vePnumberCol.setCellValueFactory(new PropertyValueFactory<VendorDetails, String>("phoneNumber"));
                veCategoryCol.setCellValueFactory(new PropertyValueFactory<VendorDetails, String>("productCategory"));

                veTableView.setItems(vendorData);

            }
        }catch (Exception e){
            System.out.println("Error Vendor OBL:"+ e);
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
    private ObservableList getDataFromSqlAddToVendorObservableList(String query) throws SQLException {
        ObservableList<VendorDetails> vendorTable = FXCollections.observableArrayList();
        Connection con = dbCon.getConnection();
        Statement stmt = con.createStatement();
        ResultSet rs = stmt.executeQuery(query);

        try {
            while (rs.next()) {
                vendorTable.add(new VendorDetails(rs.getString(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getString(4),
                        rs.getString(5)

                ));
                veTableView.setItems(null);
                veTableView.setItems(vendorTable);
            }
        } catch (SQLException e) {
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

        }
        return vendorTable;


    }}

























