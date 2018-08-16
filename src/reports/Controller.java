package reports;


import com.jfoenix.controls.JFXButton;
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
import javafx.scene.chart.AreaChart;
import javafx.scene.chart.PieChart;
import javafx.scene.chart.XYChart;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

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
    private ObservableList data;

    @FXML
    private AnchorPane mainAnchor;

    @FXML
    private Label lbSurname;

    @FXML
    private JFXButton closebtn;

    @FXML
    private AnchorPane lbInfo;

    @FXML
    private JFXTextField searchTf;

    @FXML
    private Label lb1;

    @FXML
    private Label lb2;

    @FXML
    private AreaChart<?, ?> areaChart;

    @FXML
    private PieChart piechart;

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
    private JFXButton accountsBtn;

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





    public void loadAreachart() throws SQLException, ClassNotFoundException {


    String  qr= "  SELECT product, MAX(amount) FROM sales GROUP BY amount  LIMIT 5; ";
    Connection con = dbCon.getConnection();
    Statement stmt = con.createStatement();
    ResultSet rs = stmt.executeQuery(qr);

    XYChart.Series series =new XYChart.Series();
        areaChart.getData().clear();
        areaChart.layout();
        try
    {
        while (rs.next())
        {
            series.getData().add(new XYChart.Data(rs.getString(1),rs.getDouble(2)));
        }
    } catch (SQLException e) {
        e.printStackTrace();
    }
        finally {
        if (rs != null)
        {
            try {
                rs.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        if (stmt != null)
        {
            try {
                stmt.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        if (con != null)
        {
            try {
                con.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
        areaChart.getData().add(series);
    }
    public void loadPiechart() throws SQLException, ClassNotFoundException {
    data = FXCollections.observableArrayList();
    String  qr= "  select product, quantity FROM  inventory;";
    Connection con = dbCon.getConnection();
    Statement stmt = con.createStatement();
    ResultSet rs = stmt.executeQuery(qr);

        try
    {
        while (rs.next())
        {
            data.add(new PieChart.Data(rs.getString(1),rs.getDouble(2)));
        }

    }catch (Exception e)
    {

    }
        finally {
        if (rs != null)
        {
            try {
                rs.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        if (stmt != null)
        {
            try {
                stmt.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        if (con != null)
        {
            try {
                con.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

        piechart.getData().addAll(data);}

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        try {
            loadAreachart();
            loadPiechart();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

    }
}