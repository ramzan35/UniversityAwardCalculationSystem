/**
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javafxapplication2;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Modality;
import javafx.stage.Stage;


/*
  * @author Ramzan
  * This is  STUDENT AWARD CALCULATION SYSTEM for University of Gugsi
 */
public class FXMLDocumentController implements Initializable {
    
    @FXML
    private TextField txtusername,txtpassword,txtmict1,txtmict2,txtmm1;
    
    @FXML
    private Label lblstatus;
    
    @FXML
    private void handleButtonAction(ActionEvent event) throws IOException {
       if(txtusername.getText().equals("g") && txtpassword.getText().equals("g")){
           lblstatus.setText("Login Success");
           ((Node)event.getSource()).getScene().getWindow().hide();
           Stage stage1 = new Stage(); 
           Parent root = FXMLLoader.load(getClass().getResource("Main1.fxml"));
           Scene scene1 = new Scene(root);
           stage1.setScene(scene1);
           stage1.show();   
       }
       else{
           lblstatus.setText("Login Failed"); 
       }      
    }   
    @Override
    public void initialize(URL url, ResourceBundle rb) {      
    }    
    
}
