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
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import static javafxapplication2.MainController.moduleMarks1;

public class ReferrelsController extends MainController implements Initializable{

@FXML
private Label mmarks1,lblrefferel1;

@FXML
private Button btnnext3,btnenter;

@FXML
public TextField textictT1,textictT2,txtTmarks,txtTcredits;

int refictT1=0,refictT2=0,refTmarks=0;
int mref =0;
static int error1 = 0;
boolean flag1 = false;
boolean flag2 = false;
boolean flag3 = false;
boolean flagg1 = true;
boolean flagg2 = true;
boolean flagg3 = true;

@FXML
  private void handleButtonAction1(ActionEvent event) throws IOException {  
            try{
           refictT1 = Integer.parseInt(textictT1.getText());        
           refictT2 = Integer.parseInt(textictT2.getText());
           int validation = validate(refictT1,refictT2);
           if(validation>=1){
            error1 = 0;
               Alert alert = new Alert(Alert.AlertType.INFORMATION);
               alert.setTitle("Error");
               alert.setContentText("Please enter the valid marks");
               alert.showAndWait();              
        } 
           else{
           refTmarks = (refictT1+refictT2)/2; 
           txtTmarks.setText(String.valueOf(refTmarks));
           int refTcredit = MainController.calcredits(refTmarks,refictT1,refictT2);
           mref = referrel(refTmarks,refictT1, refictT2);
           txtTcredits.setText(String.valueOf(refTcredit));
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
         error1++;
     }
     else if(t2>100 || t2<0){
         error1++;
     }return error1;
 } 
    
    
@FXML
  private void handleButtonAction2(ActionEvent event) throws IOException {
            if(mref != 1){
            if(flagg1==true){    
            for(int i = 0; i<6;i++){
                if(MainController.moduleMarks1[i]<40 || MainController.level4ict1[i]<30||MainController.level4ict2[i]<30){
                 MainController.moduleMarks1[i] = 40; MainController.level4ict1[i]=30;MainController.level4ict2[i]=30;
                flag1=true; flagg2 = false; flagg3 = false;}}}
            if(flagg2==true){
            for(int i = 0; i<6;i++){
                if(Main2Controller.mMarks2[i]<40 || Main2Controller.level5ict1[i]<30||Main2Controller.level5ict2[i]<30){
                 Main2Controller.mMarks2[i] = 40;Main2Controller.level5ict1[i]=30;Main2Controller.level5ict2[i]=30;
                 flag2=true;flagg3 = false;}}}
            if(flagg3==true){
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
           Parent root = FXMLLoader.load(getClass().getResource("Retake.fxml"));
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