/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javafxapplication2;

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
import static javafxapplication2.MainController.error;

/**
 * FXML Controller class
 *
 * @author HOME
 */
public class Main2Controller extends MainController implements Initializable {
    
    @FXML
    private TextField m7ict1,m7ict2,m8ict1,m8ict2,m9ict1,m9ict2,m10ict1,m10ict2,m11ict1,m11ict2,m12ict1,m12ict2;
    
    @FXML
    private Label lblmm7,lblmm8,lblmm9,lblmm10,lblmm11,lblmm12,lblm7c,lblm8c,lblm9c,lblm10c,lblm11c,lblm12c,lblstatus;
    
    @FXML
    private Button btnenter,btnnext,btnexit;
    
    static int referrels2 = 0; 
    static int[] mMarks2 = new int[6];
    static int[] level5ict1 = new int[6];
    static int[] level5ict2 = new int[6];
    static int i = 0;

    //Level Five
    public void calcuatelvl5(ActionEvent event)throws Exception{
        MainController.credit = 120;
        try{
        int mM7ict1 = Integer.parseInt(m7ict1.getText());
        level5ict1[0] = mM7ict1;
        int mM7ict2 = Integer.parseInt(m7ict2.getText());
        level5ict2[0] = mM7ict2;
        int mM8ict1 = Integer.parseInt(m8ict1.getText());
        level5ict1[1] = mM8ict1;
        int mM8ict2 = Integer.parseInt(m8ict2.getText());
        level5ict2[1] = mM8ict2;
        int mM9ict1 = Integer.parseInt(m9ict1.getText());
        level5ict1[2] = mM9ict1;
        int mM9ict2 = Integer.parseInt(m9ict2.getText());
        level5ict2[2] = mM9ict2;
        int mM10ict1 = Integer.parseInt(m10ict1.getText());
        level5ict1[3] = mM10ict1;
        int mM10ict2 = Integer.parseInt(m10ict2.getText());
        level5ict2[3] = mM10ict2;
        int mM11ict1 = Integer.parseInt(m11ict1.getText());
        level5ict1[4] = mM11ict1;
        int mM11ict2 = Integer.parseInt(m11ict2.getText());
        level5ict2[4] = mM11ict2;
        int mM12ict1 = Integer.parseInt(m12ict1.getText());
        level5ict1[5] = mM12ict1;
        int mM12ict2= Integer.parseInt(m12ict2.getText());
        level5ict2[5] = mM12ict2;
        
        int validate = validation(level5ict1,level5ict2);
        if(validate>=1){
            error = 0;
               Alert alert = new Alert(Alert.AlertType.INFORMATION);
               alert.setTitle("Error");
               alert.setContentText("Please enter the valid marks");
               alert.showAndWait();              
        } 
        else{
        int m7modulemarks = calmoduleMarks(mM7ict1,mM7ict2);
        lblmm7.setText(String.valueOf(m7modulemarks));
        referrels2 += MainController.referrel(mM7ict1,mM7ict2,m7modulemarks);
        int c1 = MainController.calcredits(m7modulemarks,mM7ict1,mM7ict2);
        lblm7c.setText(String.valueOf(c1));
        credit += c1;
               
        int m8modulemarks = calmoduleMarks(mM8ict1,mM8ict2);
        lblmm8.setText(String.valueOf(m8modulemarks));
        referrels2 += MainController.referrel(mM8ict1,mM8ict2,m8modulemarks);
        c1 = MainController.calcredits(m8modulemarks,mM8ict1,mM8ict2);
        lblm8c.setText(String.valueOf(c1));
        credit += c1;       
        
        int m9modulemarks = calmoduleMarks(mM9ict1,mM9ict2);
        lblmm9.setText(String.valueOf(m9modulemarks));
        referrels2 += MainController.referrel(mM9ict1,mM9ict2,m9modulemarks);
        c1 = MainController.calcredits(m9modulemarks,mM9ict1,mM9ict2);
        lblm9c.setText(String.valueOf(c1));
        credit += c1;       
        
        int m10modulemarks = calmoduleMarks(mM10ict1,mM10ict2);
        lblmm10.setText(String.valueOf(m10modulemarks));
        referrels2 += MainController.referrel(mM10ict1,mM10ict2,m10modulemarks);
        c1 = MainController.calcredits(m10modulemarks,mM10ict1,mM10ict2);
        lblm10c.setText(String.valueOf(c1));
        credit += c1;
                
        int m11modulemarks = calmoduleMarks(mM11ict1,mM11ict2);
        lblmm11.setText(String.valueOf(m11modulemarks));
        referrels2 += MainController.referrel(mM11ict1,mM11ict2,m11modulemarks);
        c1 = MainController.calcredits(m11modulemarks,mM11ict1,mM11ict2);
        lblm11c.setText(String.valueOf(c1));
        credit += c1;
                
        int m12modulemarks = calmoduleMarks(mM12ict1,mM12ict2);
        lblmm12.setText(String.valueOf(m12modulemarks));
        referrels2 += MainController.referrel(mM12ict1,mM12ict2,m12modulemarks);
        c1 = MainController.calcredits(m12modulemarks,mM12ict1,mM12ict2);
        lblm12c.setText(String.valueOf(c1));
        credit += c1;
        if(referrels2>=1){
        lblstatus.setText(" Student should do "+referrels2+" referrels" ); }   
        }
    }catch(NumberFormatException e){
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
               alert.setTitle("Error");
               alert.setContentText("Please enter valid marks");
               alert.showAndWait();
        }
    }
         public void Next(ActionEvent event)throws Exception{
           if(referrels>=0 || credit ==240){
               if(referrels2 == 1){
                    ((Node)event.getSource()).getScene().getWindow().hide();
           Stage stage1 = new Stage(); 
           Parent root = FXMLLoader.load(getClass().getResource("Referrels.fxml"));
           Scene scene1 = new Scene(root);
           stage1.setScene(scene1);
           stage1.show();
               }
               else if(referrels2 == 2){
                    ((Node)event.getSource()).getScene().getWindow().hide();
                    Stage stage1 = new Stage(); 
                    Parent root = FXMLLoader.load(getClass().getResource("Referrels2.fxml"));
                    Scene scene1 = new Scene(root);
                    stage1.setScene(scene1);
                    stage1.show();
                }
              else if(referrels2 == 3){
                   ((Node)event.getSource()).getScene().getWindow().hide();
           Stage stage1 = new Stage(); 
           Parent root = FXMLLoader.load(getClass().getResource("Referrels3.fxml"));
           Scene scene1 = new Scene(root);
           stage1.setScene(scene1);
           stage1.show();
               }
           else if(referrels2 == 0 && credit == 240){
                ((Node)event.getSource()).getScene().getWindow().hide();
           Stage stage1 = new Stage(); 
           Parent root = FXMLLoader.load(getClass().getResource("Main4.fxml"));
           Scene scene1 = new Scene(root);
           stage1.setScene(scene1);
           stage1.show();   
           }
           else if(referrels2>3){
                ((Node)event.getSource()).getScene().getWindow().hide();
           Stage stage1 = new Stage(); 
           Parent root = FXMLLoader.load(getClass().getResource("Disqualified.fxml"));
           Scene scene1 = new Scene(root);
           stage1.setScene(scene1);
           stage1.show();   
              }
        }
}
         public void exit(ActionEvent event)throws Exception{
            if(credit == 240){
                 ((Node)event.getSource()).getScene().getWindow().hide();
               Alert alert = new Alert(Alert.AlertType.INFORMATION);
               alert.setTitle("Notification");
               alert.setContentText(Main1Controller.index+" left with a DipHE");
               alert.showAndWait();
            }
            else if(credit == 120){
               ((Node)event.getSource()).getScene().getWindow().hide();
               Alert alert = new Alert(Alert.AlertType.INFORMATION);
               alert.setTitle("Notification");
               alert.setContentText(Main1Controller.index+" left with a CertHE");
               alert.showAndWait();
            }
            else
                System.exit(0);
            
        }
    public static int calmoduleMarks(int a,int b){
            int moduleMarks = (a+b)/2;
            mMarks2[i] = moduleMarks;            
            i++;
            return moduleMarks;
        }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
    }    
    
}
