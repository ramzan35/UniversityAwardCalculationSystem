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
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javax.swing.JOptionPane;

/**
 * FXML Controller class
 *
 * @author HOME
 */
public class Referrels3Controller implements Initializable {
@FXML
private TextField refMM1ict1,refMM1ict2,refMM2ict1,refMM2ict2,
refMM3ict1,refMM3ict2,txtmarksS1,txtmarksS2,txtmarksS3,txtcreditsS1,txtcreditsS2,txtcreditsS3;

@FXML
private Button btnNext3,btnEnter3;

int ref3m1ict1=0,ref3m1ict2=0,ref3marks1=0,ref3m2ict1=0,ref3m2ict2=0,ref3marks2=0,
        ref3m3ict1=0,ref3m3ict2=0,ref3marks3=0;
int m3ref = 0;
boolean fgl1 = false;
boolean fgl2 = false;
boolean fgl3 = false;
boolean fgll1 = true;
boolean fgll2 = true;
boolean fgll3 = true;
int j = 1;
static int error5 =0;
@FXML
  private void handleButtonAction1(ActionEvent event) throws IOException {
      try{
           ref3m1ict1 = Integer.parseInt(refMM1ict1.getText());
           ref3m1ict2 = Integer.parseInt(refMM1ict2.getText());
           int validation1 = validate(ref3m1ict1,ref3m1ict2);
           ref3m2ict1 = Integer.parseInt(refMM2ict1.getText());
           ref3m2ict2 = Integer.parseInt(refMM2ict2.getText());
           int validation2 = validate(ref3m2ict1,ref3m2ict2);
           ref3m3ict1 = Integer.parseInt(refMM3ict1.getText());
           ref3m3ict2 = Integer.parseInt(refMM3ict2.getText());
           int validation3 = validate(ref3m3ict1,ref3m3ict2);
           int validation = validation1+validation2+validation3;
           if(validation>=1){
            error5 = 0;
               Alert alert = new Alert(AlertType.INFORMATION);
               alert.setTitle("Error");
               alert.setContentText("Please enter the valid marks");
               alert.showAndWait();              
        }
           else{ 
           ref3marks1 = (ref3m1ict1+ref3m1ict2)/2; 
           txtmarksS1.setText(String.valueOf(ref3marks1));
           int ref3credit1 = MainController.calcredits(ref3marks1,ref3m1ict1,ref3m1ict2);
           m3ref += referrel(ref3m1ict1, ref3m1ict2,ref3marks1);
           txtcreditsS1.setText(String.valueOf(ref3credit1));
           
           ref3marks2 = (ref3m2ict1+ref3m2ict2)/2; 
           txtmarksS2.setText(String.valueOf(ref3marks2));
           int ref3credit2 = MainController.calcredits(ref3marks2,ref3m2ict1,ref3m2ict2);
           m3ref += referrel(ref3m2ict1, ref3m2ict2,ref3marks2);
           txtcreditsS2.setText(String.valueOf(ref3credit2));
                    
           ref3marks3 = (ref3m3ict1+ref3m3ict2)/2; 
           txtmarksS3.setText(String.valueOf(ref3marks3));
           int ref3credit3 = MainController.calcredits(ref3marks3,ref3m3ict1,ref3m3ict2);
           m3ref += referrel(ref3m3ict1, ref3m3ict2,ref3marks3);
           txtcreditsS3.setText(String.valueOf(ref3credit3));
                }
         }
      catch(NumberFormatException e){
               Alert alert = new Alert(Alert.AlertType.INFORMATION);
               alert.setTitle("Error");
               alert.setContentText("Please enter valid marks");
               alert.showAndWait();
        }
  }
           public static int referrel( int m3,int t1, int t2) {                        
        //t1=ict1 & t2 = ict2 & m3 = moduleMarks
	int referrel = 0;	
            if (t1 < 30 || t2 < 30) {                
			referrel++;
		} else if (m3 < 40) {
			referrel++;
		}
		return referrel;
	} 
           public static int validate( int t1, int t2) {
     if(t1>100 || t1<0){
         error5++;
     }
     else if(t2>100 || t2<0){
         error5++;
     }return error5;
 }
   
@FXML
  private void handleButtonAction2(ActionEvent event) throws IOException {
   if(m3ref==0){
          if(fgll1 == true){
                for(int i = 0; i<6;i++){
                if(MainController.moduleMarks1[i]<40 || MainController.level4ict1[i]<30||MainController.level4ict2[i]<30){
                MainController.moduleMarks1[i] = 40; MainController.level4ict1[i]=30;MainController.level4ict2[i]=30;j++; 
                fgl1=true;fgll2=false;fgll3=false;
}}} 
          if(fgll2 == true){
                for(int i = 0; i<6;i++){
                if(Main2Controller.mMarks2[i]<40 || Main2Controller.level5ict1[i]<30||Main2Controller.level5ict2[i]<30){
                Main2Controller.mMarks2[i] = 40;Main2Controller.level5ict1[i]=30;Main2Controller.level5ict2[i]=30; j++;
                fgl2=true; fgll3=false;
}}}
          if(fgll3 == true){
                for(int i = 0; i<6;i++){
                if(Main4Controller.mMarks3[i]<40 || Main4Controller.level6ict1[i]<30||Main4Controller.level6ict2[i]<30){
                Main4Controller.mMarks3[i] = 40;Main4Controller.level6ict1[i]=30;Main4Controller.level6ict2[i]=30; j++;
                fgl3=true;
}}}
            if(fgl1 == true){
            Stage stage3 = new Stage(); 
            Parent root = FXMLLoader.load(getClass().getResource("Main2.fxml"));
            Scene scene1 = new Scene(root);
            stage3.setScene(scene1);
            stage3.show();
            }
            else if(fgl2==true){
            Stage stage3 = new Stage(); 
            Parent root = FXMLLoader.load(getClass().getResource("Main4.fxml"));
            Scene scene1 = new Scene(root);
            stage3.setScene(scene1);
            stage3.show();    
            }
            else if(fgl3==true){
            Stage stage3 = new Stage(); 
            Parent root = FXMLLoader.load(getClass().getResource("Award.fxml"));
            Scene scene1 = new Scene(root);
            stage3.setScene(scene1);
            stage3.show();    
            }    
      }
   else{
           ((Node)event.getSource()).getScene().getWindow().hide();
           Stage stage1 = new Stage(); 
           Parent root = FXMLLoader.load(getClass().getResource("Disqualified.fxml"));
           Scene scene1 = new Scene(root);
           stage1.setScene(scene1);
           stage1.show();
   }
  }  

    @Override
    public void initialize(URL url, ResourceBundle rb) {
    }    
    
}
