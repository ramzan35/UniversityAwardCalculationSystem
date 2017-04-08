/*

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
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class Main1Controller implements Initializable {
    
    @FXML
    private TextField stdID,stdname;
    
    @FXML
    public Button btn1,next;
    
    @FXML
    private Label lblStatus;
    
    static String name,index ; 
    
     @FXML
    private void handleButtonAction1(ActionEvent event) throws IOException {
    index = stdID.getText();                
    name = stdname.getText();
    }
    
     @FXML
    private void handleButtonAction2(ActionEvent event) throws IOException {
           if(stdID.getText().length()!=0 && stdname.getText().length()!=0){
           ((Node)event.getSource()).getScene().getWindow().hide();
           index = stdID.getText();
           name = stdname.getText();
           Stage stage1 = new Stage(); 
           Parent root = FXMLLoader.load(getClass().getResource("Main.fxml"));
           Scene scene2 = new Scene(root);
           stage1.setScene(scene2);
           stage1.show();
           }
           else{
               lblStatus.setText("Inputs are invalid please enter valid inputs" );
               }
    }
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
}
}