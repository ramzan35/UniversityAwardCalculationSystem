/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javafxapplication2;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javax.swing.*;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class Referrels2Controller implements Initializable {

@FXML
private TextField refM1ict1,refM1ict2,refM2ict1,refM2ict2,txtmarks1,txtmarks2,txtcredits1,txtcredits2;

@FXML
private Button btnNext,btnEnter;

int ref2m1ict1=0,ref2m1ict2=0,refmarks1=0,ref2m2ict1=0,ref2m2ict2=0,refmarks2=0;
int m2ref = 0;  
int j = 1;int p;
boolean fg1 = false;
boolean fg2 = false;
boolean fg3 = false;
boolean fgg1 = true;
boolean fgg2 = true;
boolean fgg3 = true;
static int error4 = 0;
@FXML
  private void handleButtonAction1(ActionEvent event) throws IOException {
        try{
           ref2m1ict1 = Integer.parseInt(refM1ict1.getText());
           ref2m1ict2 = Integer.parseInt(refM1ict2.getText());
           int validation1 = validate(ref2m1ict1,ref2m1ict2);
           
           ref2m2ict1 = Integer.parseInt(refM2ict1.getText());
           ref2m2ict2 = Integer.parseInt(refM2ict2.getText());
           int validation2 = validate(ref2m2ict1,ref2m2ict2);
           int validation = validation1+validation2;
           if(validation>=1){
            error4 = 0;
               Alert alert = new Alert(AlertType.INFORMATION);
               alert.setTitle("Error");
               alert.setContentText("Please enter the valid marks");
               alert.showAndWait();              
        }
           else{
           refmarks1 = (ref2m1ict1+ref2m1ict2)/2; 
           txtmarks1.setText(String.valueOf(refmarks1));
           int refcredit1 = MainController.calcredits(ref2m1ict1,ref2m1ict2,refmarks1);
           m2ref += referrel(ref2m1ict1, ref2m1ict2,refmarks1);
           txtcredits1.setText(String.valueOf(refcredit1));

           refmarks2 = (ref2m2ict1+ref2m2ict2)/2; 
           txtmarks2.setText(String.valueOf(refmarks2));
           int refcredit2 = MainController.calcredits(ref2m2ict1,ref2m2ict2,refmarks2);
           m2ref += referrel(ref2m2ict1, ref2m2ict2 ,refmarks2);
           txtcredits2.setText(String.valueOf(refcredit2));

                }
           }
      catch(NumberFormatException e){
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
               alert.setTitle("Error");
               alert.setContentText("Please enter valid marks");
               alert.showAndWait();
        }
           
}
  public static int referrel(int t1, int t2, int m3) {                        
        //t1=ict1 & t2 = ict2 & m3 = moduleMarks
	int referrel = 0;	
            if (t1 < 30 || t2 < 30) {                
			referrel++;
		} else if (m3 < 40) {
			referrel++;
		}           System.out.println(referrel);
		return referrel;
	} 
  public static int validate( int t1, int t2) {
     if(t1>100 || t1<0){
         error4++;
     }
     else if(t2>100 || t2<0){
         error4++;
     }return error4;
 }

@FXML
  private void handleButtonAction2(ActionEvent event) throws IOException {  
     // JOptionPane.showMessageDialog(null,"Test1","test",JOptionPane.INFORMATION_MESSAGE);
      if(m2ref == 0){
            if(fgg1 == true){
                for(int i = 0; i<6;i++){
                if(MainController.moduleMarks1[i]<40 || MainController.level4ict1[i]<30||MainController.level4ict2[i]<30){
                MainController.moduleMarks1[i] = 40; MainController.level4ict1[i]=30;MainController.level4ict2[i]=30;  
                fg1=true; fgg2=false; fgg3=false;}} 
                }
            if(fgg2 == true){
                for(int i = 0; i<6;i++){
                if(Main2Controller.mMarks2[i]<40 || Main2Controller.level5ict1[i]<30||Main2Controller.level5ict2[i]<30){
                Main2Controller.mMarks2[i] = 40;Main2Controller.level5ict1[i]=30;Main2Controller.level5ict2[i]=30; 
                fg2 = true; fgg3=false;}
                }}
            if(fgg3 == true){
                for(int i = 0; i<6;i++){
                if(Main4Controller.mMarks3[i]<40 || Main4Controller.level6ict1[i]<30||Main4Controller.level6ict2[i]<30){       
                Main4Controller.mMarks3[i] = 40;Main4Controller.level6ict1[i]=30;Main4Controller.level6ict2[i]=30; j++;
                fg3=true; }
                }}
                if(fg1 == true){
                     ((Node)event.getSource()).getScene().getWindow().hide();
            Stage stage3 = new Stage(); 
            Parent root = FXMLLoader.load(getClass().getResource("Main2.fxml"));
            Scene scene1 = new Scene(root);
            stage3.setScene(scene1);
            stage3.show();
            }
            else if(fg2 == true){
                 ((Node)event.getSource()).getScene().getWindow().hide();
            Stage stage3 = new Stage(); 
            Parent root = FXMLLoader.load(getClass().getResource("Main4.fxml"));
            Scene scene1 = new Scene(root);
            stage3.setScene(scene1);
            stage3.show();    
            }
            else if(fg3 == true){
                 ((Node)event.getSource()).getScene().getWindow().hide();
            Stage stage3 = new Stage(); 
            Parent root = FXMLLoader.load(getClass().getResource("Award.fxml"));
            Scene scene1 = new Scene(root);
            stage3.setScene(scene1);
            stage3.show();    
            }    
      }
      else if(m2ref == 2){
           ((Node)event.getSource()).getScene().getWindow().hide();
            Stage stage3 = new Stage(); 
            Parent root = FXMLLoader.load(getClass().getResource("Disqualified.fxml"));
            Scene scene1 = new Scene(root);
            stage3.setScene(scene1);
            stage3.show();
      }
      else{ 
           ((Node)event.getSource()).getScene().getWindow().hide();
            Stage stage6 = new Stage(); 
            Parent root = FXMLLoader.load(getClass().getResource("Retake1.fxml"));
            Scene scene1 = new Scene(root);
            stage6.setScene(scene1);
            stage6.show();   
      }      
  }
    @Override 
    public void initialize(URL url, ResourceBundle rb) {        
    } 
 }