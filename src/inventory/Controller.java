package inventory;


import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXComboBox;
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
import java.util.Collections;
import java.util.ResourceBundle;


public class Controller implements Initializable {
    private dbCon con;
    private ObservableList<InventoryDetails> invData;
    private ObservableList<DeliveryDetails> deliveryData;
    boolean editClicked = false;
    boolean addClicked = false;
    private static double xOffset = 0;
    private static double yOffset = 0;
    @FXML
    private AnchorPane mainAnchor;

    @FXML
    private Label lbUserSurname;

    @FXML
    private JFXButton closebtn;

    @FXML
    private AnchorPane lbInfo;

    @FXML
    private JFXTextField categoryTf;

    @FXML
    private JFXButton addInvBtn;

    @FXML
    private JFXButton editInvBtn;

    @FXML
    private JFXTextField productTf;

    @FXML
    private JFXTextField productIDTf;

    @FXML
    private JFXButton deleteInvBtn;

    @FXML
    private Label newProductLb;
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
    private TableView<InventoryDetails> inventoryTableView;

    @FXML
    private TableColumn<InventoryDetails, String> invProductIDCol;

    @FXML
    private TableColumn<InventoryDetails, String> invProductCol;

    @FXML
    private TableColumn<InventoryDetails, String> invCategoryCol;

    @FXML
    private TableColumn<InventoryDetails, String> invQuantityCol;

    @FXML
    private TableColumn<InventoryDetails, String> invPriceCol;

    @FXML
    private TableColumn<InventoryDetails, String> invVendorCol;

    @FXML
    private JFXButton searchInvBtn;

    @FXML
    private TableView<DeliveryDetails> deliveryTableView;

    @FXML
    private TableColumn<DeliveryDetails, String> deliveryIDCol;

    @FXML
    private TableColumn<DeliveryDetails, String> productCol;

    @FXML
    private TableColumn<DeliveryDetails, String> quantityCol;

    @FXML
    private TableColumn<DeliveryDetails, String> dateCol;

    @FXML
    private TableColumn<DeliveryDetails, String> statusCol;

    @FXML
    private TableColumn<DeliveryDetails, String> vendorCol;

    @FXML
    private JFXTextField descriptionTf;

    @FXML
    private JFXTextField quantityTf;
    @FXML
    private JFXTextField priceTf;

    @FXML
    private JFXTextField vendorTf;

    @FXML
    private JFXButton searchDelBtn;

    @FXML
    private JFXTextField deliveryIdTf;

    @FXML
    private JFXTextField productDelTf;

    @FXML
    private JFXTextField quantityDelTf;

    @FXML
    private JFXDatePicker datedp;

    @FXML
    private JFXTextField statustf;
    @FXML
    private JFXTextField vendorDelTf;

    @FXML
    private Label newProductLb1;

    @FXML
    private JFXButton addDelBtn;

    @FXML
    private JFXButton editDelBtn;

    @FXML
    private JFXButton deleteDelBtn;
    @FXML
    private JFXButton accountsBtn;

    @FXML
    private JFXTextField searchDelTf;


    @FXML
    private JFXComboBox productCb;
    String temp;


    public Label getLbUserSurname() {
        return lbUserSurname;
    }


    @FXML
    void setCbValues(ActionEvent event) throws SQLException {


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
        Parent reParent = FXMLLoader.load(getClass().getResource("/reports/reports.fxml"));
        Scene reScene = new Scene(reParent);
        reScene.setFill(Color.TRANSPARENT);
        Stage reStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        reStage.setScene(reScene);
        reStage.centerOnScreen();
        reStage.show();
        reParent.setOnMousePressed(e -> {
            xOffset = e.getSceneX();
            yOffset = e.getSceneY();
        });
        reParent.setOnMouseDragged(e -> {
            reStage.setX(e.getScreenX() - xOffset);
            reStage.setY(e.getScreenY() - yOffset);
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
    void addDelClicked(ActionEvent event) throws SQLException {
        Connection delCon = dbCon.getConnection();
        Statement delStmt = delCon.createStatement();



        try {
            delStmt.executeUpdate("insert into deliveries (deliveryID,product,quantity,deliveryDate,status,vendor) values" +
                    "('" + deliveryIdTf.getText() + "','" + productDelTf.getText() + "','" + quantityDelTf.getText() + "','" + datedp.getValue() + "','" +
                        statustf.getText() + "','" + vendorDelTf.getText() + "');");

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
        } finally {
            if (delStmt != null) {
                delStmt.close();
            }
            if (delCon != null) {
                delCon.close();

            }
        }
        deliveryTableView.setItems(getDelDataFromObservableListToSql("select * from deliveries"));
        SetComboBoxValues();
        deTableClear();

    }

    @FXML
    void addInvClicked(ActionEvent event) throws SQLException {
        Connection invCon = dbCon.getConnection();
        Statement invStmt = invCon.createStatement();
        addClicked = true;


        try {

                    invStmt.executeUpdate("insert into inventory (productID,product,category,description,quantity,price,vendor) values" +
                    "('" + productIDTf.getText() + "','" + productCb.getValue().toString() + "','" + categoryTf.getText() + "','" + descriptionTf.getText() + "','" +
                    quantityTf.getText() + "','" + priceTf.getText() + "','" + vendorTf.getText() + "');");

            NotificationType notificationType = NotificationType.SUCCESS;
            TrayNotification invAddNotication = new TrayNotification();
            invAddNotication.setTitle("SAVE SUCCESSFUL");
            invAddNotication.setMessage("Product has been added to the Inventory Successfully");
            invAddNotication.setNotificationType(notificationType);
            invAddNotication.showAndDismiss(Duration.millis(3000));

        } catch (Exception e) {
            System.out.print(e);
            NotificationType notificationType = NotificationType.ERROR;
            TrayNotification invAddNotication = new TrayNotification();
            invAddNotication.setTitle("ERROR");
            invAddNotication.setMessage("Please ensure the ProductID is UNIQUE");
            invAddNotication.setNotificationType(notificationType);
            invAddNotication.showAndDismiss(Duration.millis(3000));
        } finally {
            if (invStmt != null) {
                invStmt.close();
            }
            if (invCon != null) {
                invCon.close();
                addClicked = false;
            }

        }

        inventoryTableView.setItems(getInvDataFromObservableListToSql("select * from inventory"));
    }


    @FXML
    void closebtnclicked(ActionEvent event) {
        try {
            System.exit(1);
        } catch (InternalError error) {
            System.out.println("Close Button failure:" + error);
        }

    }

    @FXML
    void deleteDelClicked(ActionEvent event) throws SQLException {
        Connection DeleteCon = dbCon.getConnection();
        Statement stmt;
        stmt = DeleteCon.createStatement();
        try {
            DeliveryDetails getSelectedRow = (DeliveryDetails) deliveryTableView.getSelectionModel().getSelectedItem();
            String sql = "Delete from deliveries where deliveryID= '" + getSelectedRow.getDeliveryID() + "';";
            stmt.executeUpdate(sql);
            deliveryTableView.setItems(getDelDataFromObservableListToSql("select * from deliveries"));

            NotificationType notification = NotificationType.SUCCESS;
            TrayNotification tray = new TrayNotification();
            tray.setTitle("DELETE SUCCESSFUL");
            tray.setMessage("The selected Row has been succesfully deleted");
            tray.setAnimationType(AnimationType.SLIDE);
            tray.showAndDismiss(Duration.millis(3000));
            tray.setNotificationType(notification);

        } catch (SQLException e) {
            NotificationType notification = NotificationType.CUSTOM;
            TrayNotification tray = new TrayNotification();
            tray.setTitle("ERROR");
            tray.setMessage("Try Again!");
            tray.setNotificationType(notification);
            tray.showAndDismiss(Duration.millis(3000));

        }finally {
            if (stmt!=null){stmt.close();}
            if (DeleteCon!=null){DeleteCon.close();}
        }

    }

    @FXML
    void deleteInvClicked(ActionEvent event) throws SQLException {
        Connection invDelCon = dbCon.getConnection();
        Statement stmt;
        stmt = invDelCon.createStatement();
        try {
            InventoryDetails getSelectedRow = (InventoryDetails) inventoryTableView.getSelectionModel().getSelectedItem();
            String sql = "Delete from inventory where productID= '" + getSelectedRow.getProductID() + "';";
            stmt.executeUpdate(sql);
            inventoryTableView.setItems(getInvDataFromObservableListToSql("select * from inventory"));

            NotificationType notification = NotificationType.SUCCESS;
            TrayNotification tray = new TrayNotification();
            tray.setTitle("DELETE SUCCESSFUL");
            tray.setMessage("The selected Row has been succesfully deleted");
            tray.setAnimationType(AnimationType.SLIDE);
            tray.showAndDismiss(Duration.millis(3000));
            tray.setNotificationType(notification);

        } catch (SQLException e) {
            NotificationType notification = NotificationType.CUSTOM;
            TrayNotification tray = new TrayNotification();
            tray.setTitle("ERROR");
            tray.setMessage("Try Again!    ");
            tray.setNotificationType(notification);
            tray.showAndDismiss(Duration.millis(3000));

        }


    }

    @FXML
    void editDelClicked(ActionEvent event) throws SQLException {
        Connection con = dbCon.getConnection();
        Statement stmt = con.createStatement();


        editDelBtn.setText("SAVE");
        ResultSet rsEdit = null;

        if (editClicked == false) {
            DeliveryDetails getSelectedRow = deliveryTableView.getSelectionModel().getSelectedItem();

            String query = "select * from deliveries where(deliveryID=" + getSelectedRow.getDeliveryID() + ");";

            rsEdit = stmt.executeQuery(query);

            temp = getSelectedRow.getDeliveryID();
            try {
                while (rsEdit.next()) {
                    deliveryIdTf.setText(rsEdit.getString(1));
                    productDelTf.setText(rsEdit.getString(2));
                    quantityDelTf.setText(rsEdit.getString(3));
                    datedp.setValue(LocalDate.parse(rsEdit.getString(4)));
                    statustf.setText(rsEdit.getString(5));
                    vendorDelTf.setText(rsEdit.getString(6));

                    editClicked = true;
                }
            } catch (Exception e) {
                System.out.println("Edit Error:" + e);
            }

        } else if (editClicked == true) {
            try {
                stmt.executeUpdate("UPDATE deliveries SET " +
                        "deliveryID = '" + deliveryIdTf.getText() + "'," +
                        "product = '" + productDelTf.getText() + "'," +
                        "quantity = '" + quantityDelTf.getText() + "'," +
                        "deliveryDate = '" + datedp.getValue() + "'," +
                        "status = '" + statustf.getText() + "'," +
                        "vendor = '" + vendorDelTf.getText() + "'where deliveryID =" + temp + ";");
                editClicked = false;
                editDelBtn.setText("EDIT");
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
        deliveryTableView.setItems(getDelDataFromObservableListToSql("select * from deliveries"));

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
    void editInvClicked(ActionEvent event) throws SQLException {
       
        Connection con = dbCon.getConnection();
        Statement stmt = con.createStatement();


        editInvBtn.setText("SAVE");
        ResultSet rsEdit = null;

        if (editClicked == false) {
            InventoryDetails getSelectedRow = inventoryTableView.getSelectionModel().getSelectedItem();
            System.out.println("Before");
            String query = "select * from inventory where(productID=" + getSelectedRow.getProductID() + ");";

            rsEdit = stmt.executeQuery(query);
            System.out.println("After");
            temp = getSelectedRow.getProductID();
            try {
                while (rsEdit.next()) {
                    productIDTf.setText(rsEdit.getString(1));
                    productCb.setValue(rsEdit.getString(2));
                    categoryTf.setText(rsEdit.getString(3));
                    descriptionTf.setText(rsEdit.getString(4));
                    quantityTf.setText(rsEdit.getString(5));
                    priceTf.setText(rsEdit.getString(6));
                    vendorTf.setText(rsEdit.getString(7));
                    editClicked = true;
                }
            } catch (Exception e) {
                System.out.println("Edit Error:" + e);
            }

        } else if (editClicked == true) {
            try {
                stmt.executeUpdate("UPDATE inventory SET " +
                        "productID = '" + productIDTf.getText() + "'," +
                        "product = '" + productCb.getValue() + "'," +
                        "category = '" + categoryTf.getText() + "'," +
                        "description = '" + descriptionTf.getText() + "'," +
                        "quantity = '" + quantityTf.getText() + "'," +
                        "price = '" + priceTf.getText() + "'," +
                        "vendor = '" + vendorTf.getText() + "'where productID =" + temp + ";");
                editClicked = false;
                editInvBtn.setText("EDIT");
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
        inventoryTableView.setItems(getInvDataFromObservableListToSql("select * from inventory"));

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
    void searchDelClicked(ActionEvent event) throws SQLException {
        String temp = searchDelTf.getText();
        String sql = "select * from deliveries where product like '%" + temp + "%';";
        deliveryTableView.setItems(getDelDataFromObservableListToSql(sql));

    }

    @FXML
    private JFXTextField searchInvTf;
    @FXML
    void invSearchProduct(KeyEvent event) throws SQLException {
        String temp = searchInvTf.getText();
        String sql = "select * from inventory where product like '%" + temp + "%';";
        inventoryTableView.setItems(getInvDataFromObservableListToSql(sql));

    }
    @FXML
    void deliverySearchProduct(KeyEvent event) throws SQLException {
        String temp = searchDelTf.getText();
        String sql = "select * from deliveries where product like '%" + temp + "%';";
        deliveryTableView.setItems(getDelDataFromObservableListToSql(sql));
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        try {
            InvObservableListToTableView();
            DelObservableListToTableView();
            SetComboBoxValues();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private void InvObservableListToTableView() throws SQLException {
        con = new dbCon();
        Connection connection = con.getConnection();
        invData = FXCollections.observableArrayList();
        Statement stmt = null;
        ResultSet rs = null;
        try {
            rs = connection.createStatement().executeQuery("select * from inventory");

            while (rs.next()) {
                invData.add(new InventoryDetails(rs.getString(1), rs.getString(2), rs.getString(3),
                        rs.getString(5), rs.getString(6), rs.getString(7), rs.getString(4)));
                invProductIDCol.setCellValueFactory(new PropertyValueFactory<InventoryDetails, String>("productID"));
                invProductCol.setCellValueFactory(new PropertyValueFactory<InventoryDetails, String>("product"));
                invCategoryCol.setCellValueFactory(new PropertyValueFactory<InventoryDetails, String>("pCategory"));
                invQuantityCol.setCellValueFactory(new PropertyValueFactory<InventoryDetails, String>("quantity"));
                invPriceCol.setCellValueFactory(new PropertyValueFactory<InventoryDetails, String>("price"));
                invVendorCol.setCellValueFactory(new PropertyValueFactory<InventoryDetails, String>("vendor"));

                inventoryTableView.setItems(null);
                inventoryTableView.setItems(invData);


            }

        } catch (SQLException e) {
            System.err.print(e);
        } finally {
            if (rs != null) {
                rs.close();
            }
            if (stmt != null) {
                stmt.close();
            }
            if (connection != null) {
                connection.close();
            }
        }

        inventoryTableView.setItems(getInvDataFromObservableListToSql("select * from inventory;"));

    }

    private ObservableList<InventoryDetails> getInvDataFromObservableListToSql(String query) throws SQLException {
        ObservableList<InventoryDetails> invTableData = FXCollections.observableArrayList();
        Connection con = dbCon.getConnection();
        Statement stmt = con.createStatement();
        ResultSet rs = stmt.executeQuery(query);
        try {
            while (rs.next()) {
                invTableData.add(new InventoryDetails(
                        rs.getString(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getString(5),
                        rs.getString(6),
                        rs.getString(7),
                        rs.getString(4)
                ));
                inventoryTableView.setItems(invTableData);

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


        return invTableData;

    }

    private void DelObservableListToTableView() throws SQLException {
        con = new dbCon();
        Connection con = dbCon.getConnection();
        Statement stmt = null;
        ResultSet rs = null;
        deliveryData = FXCollections.observableArrayList();
        try {
            rs = con.createStatement().executeQuery("select * from deliveries");
            while (rs.next()) {
                deliveryData.add(new DeliveryDetails(rs.getString(1), rs.getString(2), rs.getString(3),
                        rs.getString(4), rs.getString(5), rs.getString(6)));
                deliveryIDCol.setCellValueFactory(new PropertyValueFactory<DeliveryDetails, String>("deliveryID"));
                productCol.setCellValueFactory(new PropertyValueFactory<DeliveryDetails, String>("product"));
                quantityCol.setCellValueFactory(new PropertyValueFactory<DeliveryDetails, String>("quantity"));
                dateCol.setCellValueFactory(new PropertyValueFactory<DeliveryDetails, String>("deliveryDate"));
                statusCol.setCellValueFactory(new PropertyValueFactory<DeliveryDetails, String>("status"));
                vendorCol.setCellValueFactory(new PropertyValueFactory<DeliveryDetails, String>("vendor"));

                deliveryTableView.setItems(deliveryData);


            }
        } catch (SQLException e) {
            System.out.println("DelObsrervableListToTableView" + e);
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
        deliveryTableView.setItems(getDelDataFromObservableListToSql("select * from deliveries"));

    }

    private ObservableList<DeliveryDetails> getDelDataFromObservableListToSql(String query) throws SQLException {
        ObservableList<DeliveryDetails> deliveryData = FXCollections.observableArrayList();
        Connection con = dbCon.getConnection();
        Statement stmt = con.createStatement();
        ResultSet rs = stmt.executeQuery(query);
        try {
            while (rs.next()) {
                deliveryData.add(new DeliveryDetails(
                        rs.getString(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getString(4),
                        rs.getString(5),
                        rs.getString(6)

                ));
                deliveryTableView.setItems(deliveryData);
            }
        } catch (SQLException e) {
            System.out.println("getDelDataFromObservableListToSql error:" + e);

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
            return deliveryData;
        }


    }
    private void SetComboBoxValues() throws SQLException {
        ObservableList comboBoxData=FXCollections.observableArrayList();
        Connection conCb=dbCon.getConnection();
        Statement stmtCb=conCb.createStatement();
        ResultSet rs=stmtCb.executeQuery("select product from deliveries where status='DELIVERED';");
        try {
            while (rs.next()){
                comboBoxData.add(new InventoryCbValues(rs.getString("product")).getProduct());
            }
        }catch(SQLException e)
        {
            e.printStackTrace();
        }finally{
            if(rs!=null){
                rs.close();
            }
            if (stmtCb!=null){
                stmtCb.close();
            }
            if (conCb!=null){
                conCb.close();
            }

        }
        Collections.sort(comboBoxData); //Sort in Alphabetic Order.
        productCb.setItems(comboBoxData);
    }
    public void deTableClear(){
        descriptionTf.clear();
        deliveryIdTf.clear();
        productDelTf.clear();
        quantityDelTf.clear();
        vendorTf.clear();
        statustf.clear();
    }



}

























