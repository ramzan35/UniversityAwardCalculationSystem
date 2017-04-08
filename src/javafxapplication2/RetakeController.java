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
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class RetakeController extends MainController implements Initializable{

@FXML
private Label mmarks1,lblrefferel1;

@FXML
private Button btnnext3,btnenter;

@FXML
private TextField textict1,textict2,txtmarks,txtcredits;

int retict1=0,retict2=0,retmarks=0;
boolean flag1=false;
boolean flag2=false;
boolean flag3=false;
boolean flag11=true;
boolean flag22=true;
boolean flag33=true;
int mret = 0;
static int error2 = 0;

@FXML
  private void handleButtonAction1(ActionEvent event) throws IOException {
           try{
           retict1 = Integer.parseInt(textict1.getText());
           retict2 = Integer.parseInt(textict2.getText());
           int validation = validate(retict1,retict2);
           if(validation>=1){
           error = 0;
               Alert alert = new Alert(AlertType.INFORMATION);
               alert.setTitle("Error");
               alert.setContentText("Please enter the valid marks");
               alert.showAndWait();              
        } 
           else{ 
           retmarks = (retict1+retict2)/2; 
           txtmarks.setText(String.valueOf(retmarks));
           int retcredit = MainController.calcredits(retmarks,retict1,retict2);
           mret += referrel(retmarks,retict1, retict2);
           txtcredits.setText(String.valueOf(retcredit));
           retake++;
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
         error2++;
     }
     else if(t2>100 || t2<0){
         error2++;
     }return error2;
 } 
    
    
@FXML
  private void handleButtonAction2(ActionEvent event) throws IOException {
           if(mret != 1){
           if(flag11==true){
            for(int i = 0; i<6;i++){
                if(MainController.moduleMarks1[i]<40 || MainController.level4ict1[i]<30||MainController.level4ict2[i]<30){
                 MainController.moduleMarks1[i] = 40; MainController.level4ict1[i]=30;MainController.level4ict2[i]=30;
                flag1=true;flag22=false;flag33=false;}}}
           if(flag22==true){
            for(int i = 0; i<6;i++){
                if(Main2Controller.mMarks2[i]<40 || Main2Controller.level5ict1[i]<30||Main2Controller.level5ict2[i]<30){
                 Main2Controller.mMarks2[i] = 40;Main2Controller.level5ict1[i]=30;Main2Controller.level5ict2[i]=30;
                 flag2=true;flag33=false;}}}
           if(flag33==true){
            for(int i = 0; i<6;i++){
                if(Main4Controller.mMarks3[i]<40 || Main4Controller.level6ict1[i]<30||Main4Controller.level6ict2[i]<30){
                 Main4Controller.mMarks3[i] = 40;Main4Controller.level6ict1[i]=30;Main4Controller.level6ict2[i]=30;
                flag3=true;}}}
           
            if(flag1==true){
            Stage stage3 = new Stage(); 
            Parent root = FXMLLoader.load(getClass().getResource("Main2.fxml"));
            Scene scene1 = new Scene(root);
            stage3.setScene(scene1);
            stage3.show();
            }
            else if(flag2==true){
            Stage stage3 = new Stage(); 
            Parent root = FXMLLoader.load(getClass().getResource("Main4.fxml"));
            Scene scene1 = new Scene(root);
            stage3.setScene(scene1);
            stage3.show();    
            }
            else if(flag3==true){
            Stage stage3 = new Stage(); 
            Parent root = FXMLLoader.load(getClass().getResource("Award.fxml"));
            Scene scene1 = new Scene(root);
            stage3.setScene(scene1);
            stage3.show();    
            }
            }
           else{ 
            ((Node)event.getSource()).getScene().getWindow().hide();
           Stage stage4 = new Stage(); 
           Parent root = FXMLLoader.load(getClass().getResource("Referrels1.fxml"));
           Scene scene1 = new Scene(root);
           stage4.setScene(scene1);
           stage4.show();  
           }
            for(int i = 0;i<6;i++){
                System.out.println(moduleMarks1[i]);
            }
  }
    @Override
    public void initialize(URL url, ResourceBundle rb) {       
}   
}