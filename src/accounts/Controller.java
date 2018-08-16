package accounts;


import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXCheckBox;
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
import tray.notification.NotificationType;
import tray.notification.TrayNotification;

import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ResourceBundle;

/**
 * Created by Ketter Collins on 21/05/2018.
 */
public class Controller implements Initializable {
    private static double xOffset = 0;
    private static double yOffset = 0;
    private dbCon con;
    private ObservableList<AccountsDetails> accData;
    int temp;
    private int salesID;


    @FXML
    void closebtnclicked(ActionEvent event) {
        try {
            System.exit(1);
        } catch (InternalError error) {
            System.out.println("Close Button failure:" + error);
        }

    }

    @FXML
    private AnchorPane mainAnchor;

    @FXML
    private Label lbSurname;

    @FXML
    private JFXButton closebtn;

    @FXML
    private AnchorPane lbInfo;

    @FXML
    private JFXTextField amountTf;

    @FXML
    private JFXTextField balanceTf;

    @FXML
    private JFXTextField customerTf;

    @FXML
    private JFXButton confirmBtn;

    @FXML
    private JFXCheckBox paidCb;

    @FXML
    private JFXTextField salesIDTf;

    @FXML
    private JFXTextField accIDTf;

    @FXML
    private JFXTextField productTf;

    @FXML
    private TableView<AccountsDetails> accountsTableView;

    @FXML
    private TableColumn<AccountsDetails, String> accIDCol;

    @FXML
    private TableColumn<AccountsDetails, String> salesIDCol;

    @FXML
    private TableColumn<AccountsDetails, String> productCol;

    @FXML
    private TableColumn<AccountsDetails, String> quantityCol;

    @FXML
    private TableColumn<AccountsDetails, String> priceCol;

    @FXML
    private TableColumn<AccountsDetails, String> dateOfPurchaseCol;

    @FXML
    private TableColumn<AccountsDetails, String> dateOfPaymentCol;

    @FXML
    private TableColumn<AccountsDetails, String> customerCol;

    @FXML
    private TableColumn<AccountsDetails, String> amountPaidCol;

    @FXML
    private TableColumn<AccountsDetails, String> balanceCol;

    @FXML
    private TableColumn<AccountsDetails, String> statusCol;

    @FXML
    private JFXTextField searchSalesIDTf;
    @FXML
    private JFXTextField searchAccIDTf;
    @FXML
    private JFXTextField searchProductTf;
    @FXML
    private JFXTextField searchCustomerTf;

    @FXML
    private Label lb1;

    @FXML
    private Label lb2;

    @FXML
    private JFXDatePicker dateDp;

    @FXML
    private JFXButton salesBtn;

    @FXML
    private JFXButton purchaseBtn;
    @FXML
    private JFXButton loadBtn;

    @FXML
    private JFXButton inventoryBtn;

    @FXML
    private JFXButton reportsBtn;

    @FXML
    private JFXButton settingsBtn;

    @FXML
    private JFXButton accountsBtn;

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
    void loadClicked(ActionEvent event) throws IOException, SQLException {
        AccountsDetails getSelectedRow = accountsTableView.getSelectionModel().getSelectedItem();
        String sqlQuery = "select * from accounts where (accID= '" + getSelectedRow.getAccID() + "');";
        temp = getSelectedRow.getAccID();
        Connection con = dbCon.getConnection();
        Statement stmt = con.createStatement();
        ResultSet rs = stmt.executeQuery(sqlQuery);
        try {while (rs.next()) {

                accIDTf.setText(String.valueOf(rs.getInt(1)));
                salesIDTf.setText(String.valueOf(rs.getInt(2)));
                productTf.setText(String.valueOf(rs.getInt(3)));
                customerTf.setText(rs.getString(8));
                balanceTf.setText(rs.getString(10));
                String status =(rs.getString(11));
                 if (status=="PENDING")
                {
                    paidCb.setSelected(false);
                }else if (status=="PAID"){
                    paidCb.setSelected(true);
                }

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

    }


    @FXML
    void confirmClicked(ActionEvent event) throws SQLException {

        String status;
        if (paidCb.isSelected()) {
            status = "PAID";
        } else {
            status = "PENDING";
        }

        Connection con = dbCon.getConnection();
        Statement stmt = con.createStatement();

        AccountsDetails getSelectedRow = accountsTableView.getSelectionModel().getSelectedItem();
        String query = "select * from accounts where(accID=" + getSelectedRow.getAccID() + ");";


            try {
                stmt.executeUpdate("update accounts set " +
                        "accID = " + Integer.parseInt(accIDTf.getText())+ "," +
                        "saleID = " + Integer.parseInt(salesIDTf.getText()) + "," +
                        "product = " + Integer.parseInt(productTf.getText()) + "," +
                        "customer = '" + customerTf.getText() + "'," +
                        "amountPaid = '" + amountTf.getText() + "'," +

                        "dateOfPayment= '" + dateDp.getValue() + "'," +

                        "balance = '" + balanceTf.getText() + "'," +
                        "status = '" + status +
                        "' where accID = " + temp + ";");

                NotificationType notificationType = NotificationType.SUCCESS;
                TrayNotification tray = new TrayNotification();
                tray.setTitle("SAVED!");
                tray.setMessage("Payment has been Successfully Saved.");
                tray.setNotificationType(notificationType);
                tray.showAndDismiss(Duration.millis(3000));

            } catch (Exception e) {
                NotificationType notificationType = NotificationType.ERROR;
                TrayNotification tray = new TrayNotification();
                tray.setTitle("WARNING! Please Try Again");
                tray.setMessage(String.valueOf(e));
                System.out.println(e);
                tray.setNotificationType(notificationType);
                tray.showAndDismiss(Duration.millis(3000));
            }

            finally {

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



            accountsTableView.setItems(getDataFromSqlAndAddToObservableList("SELECT * FROM accounts;"));


        }





    @FXML
    void searchAccID(KeyEvent event) throws SQLException {
        String temp = searchAccIDTf.getText();
        String sql = "select * from accounts where AccID like '%" + temp + "%';";
        accountsTableView.setItems(getDataFromSqlAndAddToObservableList(sql));

    }

    @FXML
    void searchCustomer(KeyEvent event) throws SQLException {
        String temp = searchCustomerTf.getText();
        String sql = "select * from accounts where customer like '%" + temp + "%';";
        accountsTableView.setItems(getDataFromSqlAndAddToObservableList(sql));

    }

    @FXML
    void searchProduct(KeyEvent event) throws SQLException {
        String temp = searchProductTf.getText();
        String sql = "select * from accounts where product like '%" + temp + "%';";
        accountsTableView.setItems(getDataFromSqlAndAddToObservableList(sql));

    }

    @FXML
    void searchSalesID(KeyEvent event) throws SQLException {
        String temp = searchSalesIDTf.getText();
        String sql = "select * from accounts where saleID like '%" + temp + "%';";
        accountsTableView.setItems(getDataFromSqlAndAddToObservableList(sql));

    }


    @Override
    public void initialize(URL location, ResourceBundle resources){
        try {
            observableListToTableView();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
    private void observableListToTableView() throws SQLException {
        con = new dbCon();
        Connection conn = con.getConnection();
        accData = FXCollections.observableArrayList();
        Statement stmt = null;
        ResultSet rs = null;
        try {
            rs = conn.createStatement().executeQuery("select * from accounts");
            while (rs.next()) {
                accData.add(new AccountsDetails(
                        rs.getInt(1),
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
                accIDCol.setCellValueFactory(new PropertyValueFactory<AccountsDetails, String>("accID"));
                salesIDCol.setCellValueFactory(new PropertyValueFactory<AccountsDetails, String>("salesID"));
                productCol.setCellValueFactory(new PropertyValueFactory<AccountsDetails, String>("product"));
                quantityCol.setCellValueFactory(new PropertyValueFactory<AccountsDetails, String>("quantity"));
                priceCol.setCellValueFactory(new PropertyValueFactory<AccountsDetails, String>("price"));
                dateOfPurchaseCol.setCellValueFactory(new PropertyValueFactory<AccountsDetails, String>("dateOfPurchase"));
                dateOfPaymentCol.setCellValueFactory(new PropertyValueFactory<AccountsDetails, String>("dateOfPayment"));
                customerCol.setCellValueFactory(new PropertyValueFactory<AccountsDetails, String>("customer"));
                amountPaidCol.setCellValueFactory(new PropertyValueFactory<AccountsDetails, String>("amountPaid"));
                balanceCol.setCellValueFactory(new PropertyValueFactory<AccountsDetails, String>("balance"));
                statusCol.setCellValueFactory(new PropertyValueFactory<AccountsDetails, String>("status"));
                accountsTableView.setItems(accData);


            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (rs != null) {
                rs.close();
            }
            if (stmt != null) {
                stmt.close();
            }
            if (conn != null) {
                conn.close();
            }

        }

    }
    private ObservableList<AccountsDetails> getDataFromSqlAndAddToObservableList(String query) throws SQLException {
    ObservableList<AccountsDetails>accountsData=FXCollections.observableArrayList();
        Connection con = dbCon.getConnection();
        Statement stmt = con.createStatement();
        ResultSet rs = stmt.executeQuery(query);
        try{
            while (rs.next()){
                accountsData.add(new AccountsDetails(
                        rs.getInt(1),
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
                accountsTableView.setItems(accountsData);
            }
        }catch (Exception e){
            e.printStackTrace();
        }finally{
            if (rs != null) {
                rs.close();
            }
            if (stmt != null) {
                stmt.close();
            }
            if (con != null) {
                con.close();

            }
            return accountsData;
        }
        }

        }


