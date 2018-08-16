package login;
import com.jfoenix.controls.*;
import db.dbCon;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javafx.util.Duration;
import tray.notification.NotificationType;
import tray.notification.TrayNotification;

import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;



public class Controller {
    private static double xOffset = 0;
    private static double yOffset = 0;
    @FXML
    private AnchorPane loginPane;
    @FXML
    private JFXCheckBox adminCb;
    @FXML
    private Label lbLabel;

    @FXML
    private JFXTextField usernameField;

    @FXML
    private JFXPasswordField passwordField;

    @FXML
    private JFXToggleButton adminToggle;

    @FXML
    private JFXButton loginbtn;

    @FXML
    private JFXButton closebtn;

    @FXML
    void closebtnclicked(ActionEvent event) {
        try{
            System.exit(1);
    }
    catch (InternalError error){
        System.out.println("Close Button failure:"+error);
        }
    }
    String usernameLabel;
    @FXML
   public void loginbtnclicked(ActionEvent event) throws IOException, SQLException {

        if(allFieldsFilledUp()){
            String username=usernameField.getText();
            String password=passwordField.getText();
            usernameLabel=username;

            String userType;
            if (adminCb.isSelected())
            {
                userType="admin";
            }
            else
            {
                userType="user";
            }
            if(validCredentials(username,password,userType)){
                NotificationType notificationType=NotificationType.SUCCESS;
                TrayNotification trayNotification=new TrayNotification();
                trayNotification.setTitle("WELCOME");
                trayNotification.setMessage("Log In Successful");
                trayNotification.setNotificationType(notificationType);
                trayNotification.showAndDismiss(Duration.seconds(3));

                lbLabel.setVisible(true);
                lbLabel.setTextFill(Color.RED);
                lbLabel.setText("Valid Credentials!");

                Stage stage=(Stage) loginbtn.getScene().getWindow();
                stage.close();

                Stage salesStage=new Stage();
                loadScene(salesStage);
 }


        }

    }

    @FXML
    void toggleClicked(ActionEvent event) {

    }
    private boolean allFieldsFilledUp(){
        boolean filledUp;
        if(usernameField.getText().trim().isEmpty()) {
            NotificationType notificationType = NotificationType.INFORMATION;
            TrayNotification tray = new TrayNotification();
            tray.setTitle("ATTENTION!");
            tray.setMessage("Username or Password fields is empty.");
            tray.setNotificationType(notificationType);
            tray.showAndDismiss(Duration.seconds(3));
            filledUp = false;
        }
          else filledUp = true;
        return filledUp;
    }
    private boolean validCredentials(String username, String password, String userType) throws SQLException {
        boolean userPassOk=false;
        Connection con = dbCon.getConnection();
        Statement statement;
        statement=con.createStatement();
        ResultSet rs=statement.executeQuery("select * from Users where username='"+username+"'and " +
                "password='"+password+"'and userType='"+userType+"';");
        while (rs.next()){
            if (rs.getString("userName") != null && rs.getString("password") != null&& rs.getString("userType") != null) {
                userPassOk = true;
            }

        }
        if(rs!=null){
            rs.close();
            }
        if (statement!=null){
            statement.close();
            }
        if (con!=null){
            con.close();
        }
        if(!userPassOk){
            lbLabel.setVisible(true);
            lbLabel.setText("Invalid Credentials!");
            lbLabel.setTextFill(Color.RED);
            userPassOk=false;
        }
        return userPassOk;


    }
    public void loadScene(Stage primaryStage) throws IOException {


        AnchorPane root= FXMLLoader.load(getClass().getResource("/sales/sales.fxml"));

        primaryStage.initStyle(StageStyle.TRANSPARENT);
        Scene scene=new Scene(root);

        scene.setFill(Color.TRANSPARENT);
        primaryStage.centerOnScreen();


        //primaryStage.setScene(new Scene(root));
        primaryStage.setScene(scene);
        primaryStage.show();
        root.setOnMousePressed(event -> {
            xOffset = event.getSceneX();
            yOffset = event.getSceneY();
        });
        root.setOnMouseDragged(event -> {
            primaryStage.setX(event.getScreenX() - xOffset);
            primaryStage.setY(event.getScreenY() - yOffset);
        });}

    public String setUsernameLabel(){
        return usernameLabel;
    }
    }





