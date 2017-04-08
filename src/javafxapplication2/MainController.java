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
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

//Level four
public class MainController implements Initializable {

    @FXML
    private TextField m1ict1,m1ict2,m2ict1,m2ict2,m3ict1,m3ict2,m4ict1,m4ict2,m5ict1,m5ict2,m6ict1,m6ict2;
    
    @FXML
    private Label lblmm1,lblmm2,lblmm3,lblmm4,lblmm5,lblmm6,lblrefferel,
            lblm1c,lblm2c,lblm3c,lblm4c,lblm5c,lblm6c,lblstatus,lblstatus11;
    @FXML
    private Label lblx6,lblx5,lblx4,lblx3,lblx2,lblx1;
    
    
    @FXML
    private Button btnenter,btnnext,btnexit;
    
    static int referrels = 0; 
    static int credit = 0;
    static int[] moduleMarks1 = new int[6]; 
    static int[] level4ict1 = new int[6];
    static int[] level4ict2 = new int[6];
    static int c_count = 0;                 //c_count = condoned credit count
    static int i = 0;                       //i = count
    static int error = 0;                   //error is used as a validation counter
    static int retake;
    
    public void calcuatelvl4(ActionEvent event)throws Exception{
        try{
        int mM1ict1 = Integer.parseInt(m1ict1.getText());
        level4ict1[0] = mM1ict1;
        int mM1ict2 = Integer.parseInt(m1ict2.getText());
        level4ict2[0] = mM1ict2;
        int mM2ict1 = Integer.parseInt(m2ict1.getText());
        level4ict1[1] = mM2ict1;
        int mM2ict2 = Integer.parseInt(m2ict2.getText());
        level4ict2[1] = mM2ict2;
        int mM3ict1 = Integer.parseInt(m3ict1.getText());
        level4ict1[2] = mM3ict1;
        int mM3ict2 = Integer.parseInt(m3ict2.getText());
        level4ict2[2] = mM3ict2;
        int mM4ict1 = Integer.parseInt(m4ict1.getText());
        level4ict1[3] = mM4ict1;
        int mM4ict2 = Integer.parseInt(m4ict2.getText());
        level4ict2[3] = mM4ict2;
        int mM5ict1 = Integer.parseInt(m5ict1.getText());
        level4ict1[4] = mM5ict1;
        int mM5ict2 = Integer.parseInt(m5ict2.getText());
        level4ict2[4] = mM5ict2;
        int mM6ict1 = Integer.parseInt(m6ict1.getText());
        level4ict1[5] = mM6ict1;
        int mM6ict2= Integer.parseInt(m6ict2.getText());
        level4ict2[5] = mM6ict2;
        
        
        int validate = validation(level4ict1,level4ict2);
        if(validate>=1){
            error = 0;
               Alert alert = new Alert(AlertType.INFORMATION);
               alert.setTitle("Error");
               alert.setContentText("Please enter the valid marks");
               alert.showAndWait();              
        } 
        else{
        int m1modulemarks = calmoduleMarks(mM1ict1,mM1ict2);        
        lblmm1.setText(String.valueOf(m1modulemarks));
        referrels += referrel(mM1ict1,mM1ict2,m1modulemarks);
        System.out.println(referrels);
        int c = calcredits(m1modulemarks,mM1ict1,mM1ict2);
        lblm1c.setText(String.valueOf(c));
        credit += c;
          
        int m2modulemarks = calmoduleMarks(mM2ict1,mM2ict2);
        lblmm2.setText(String.valueOf(m2modulemarks));
        referrels += referrel(mM2ict1,mM2ict2,m2modulemarks);
        System.out.println(referrels);
        c = calcredits(m2modulemarks,mM2ict1,mM2ict2);
        lblm2c.setText(String.valueOf(c));
        credit += c;
        
        int m3modulemarks = calmoduleMarks(mM3ict1,mM3ict2);
        lblmm3.setText(String.valueOf(m3modulemarks));
        referrels += referrel(mM3ict1,mM3ict2,m3modulemarks);
        System.out.println(referrels);
        c = calcredits(m3modulemarks,mM3ict1,mM3ict2);
        lblm3c.setText(String.valueOf(c));
        credit += c;
        
        int m4modulemarks = calmoduleMarks(mM4ict1,mM4ict2);
        lblmm4.setText(String.valueOf(m4modulemarks));
        referrels += referrel(mM4ict1,mM4ict2,m4modulemarks);
        System.out.println(referrels);
        c = calcredits(m4modulemarks,mM4ict1,mM4ict2);
        lblm4c.setText(String.valueOf(c));
        credit += c;
        
        int m5modulemarks = calmoduleMarks(mM5ict1,mM5ict2);
        lblmm5.setText(String.valueOf(m5modulemarks));
        referrels += referrel(mM5ict1,mM5ict2,m5modulemarks);
        System.out.println(referrels);
        c = calcredits(m5modulemarks,mM5ict1,mM5ict2);
        lblm5c.setText(String.valueOf(c));
        credit += c;
        
        int m6modulemarks = calmoduleMarks(mM6ict1,mM6ict2);
        lblmm6.setText(String.valueOf(m6modulemarks));
        referrels += referrel(mM6ict1,mM6ict2,m6modulemarks);
        System.out.println(referrels);
        c = calcredits(m6modulemarks,mM6ict1,mM6ict2);
        lblm6c.setText(String.valueOf(c));
        credit += c;
       
        int condoned1 = condonedcredits(level4ict1,level4ict2,moduleMarks1);
        if(condoned1>=0){            
          switch(condoned1){
              case 0 : lblx1.setText("Condoned"); break;  
                
              case 1 : lblx2.setText("Condoned"); break;                 
                
              case 2 : lblx3.setText("Condoned"); break;                  

              case 3 : lblx4.setText("Condoned"); break;                   
                
              case 4 : lblx5.setText("Condoned");  break;       
                
              case 5 : lblx6.setText("Condoned");  break; 
                }
        }
          int condoned2 = condonedcredits(level4ict1,level4ict2,moduleMarks1);
          if(condoned2>=0){     
          switch(condoned2){
              case 0 : lblx1.setText("Condoned"); break;  
                
              case 1 : lblx2.setText("Condoned"); break;                 
                
              case 2 : lblx3.setText("Condoned"); break;                  

              case 3 : lblx4.setText("Condoned"); break;                   
                
              case 4 : lblx5.setText("Condoned");  break;       
                
              case 5 : lblx6.setText("Condoned");  break; 
                }
          }
        if(referrels>=1){
        lblstatus.setText(" Student should do "+referrels+" referrels" );}   
        }
    }catch(NumberFormatException e){
               Alert alert = new Alert(Alert.AlertType.INFORMATION);
               alert.setTitle("Error");
               alert.setContentText("Please enter valid marks");
               alert.showAndWait();
        }
    }
        public void Next(ActionEvent event)throws Exception{
           if(referrels>=0 || credit ==120){
           if(referrels == 1){
           ((Node)event.getSource()).getScene().getWindow().hide();
           Stage stage1 = new Stage(); 
           Parent root = FXMLLoader.load(getClass().getResource("Referrels.fxml"));
           Scene scene1 = new Scene(root);
           stage1.setScene(scene1);
           stage1.show();
               }
               else if(referrels == 2){
           ((Node)event.getSource()).getScene().getWindow().hide();
           Stage stage1 = new Stage(); 
           Parent root = FXMLLoader.load(getClass().getResource("Referrels2.fxml"));
           Scene scene1 = new Scene(root);
           stage1.setScene(scene1);
           stage1.show();           
               }
              else if(referrels == 3){
           ((Node)event.getSource()).getScene().getWindow().hide();
           Stage stage1 = new Stage(); 
           Parent root = FXMLLoader.load(getClass().getResource("Referrels3.fxml"));
           Scene scene1 = new Scene(root);
           stage1.setScene(scene1);
           stage1.show();
               }          
               if(credit == 120){
           ((Node)event.getSource()).getScene().getWindow().hide();
           Stage stage1 = new Stage(); 
           Parent root = FXMLLoader.load(getClass().getResource("Main2.fxml"));
           Scene scene1 = new Scene(root);
           stage1.setScene(scene1);
           stage1.show();    
               }
           else if (referrels>3){                           //maximum attempt for credit in a level is 180
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
            if(credit == 120){
               Alert alert = new Alert(Alert.AlertType.INFORMATION);
               alert.setTitle("Notification");
               alert.setContentText(Main1Controller.index+" left with a CertHE");
               alert.showAndWait();
            }
            else
                System.exit(0);
            
        }
        
        public static int referrel(int t1, int t2, int m3) {                        
        //t1=ict1 & t2 = ict2 & m3 = moduleMarks
	int referrel1 = 0;	
            if (t1 < 30 || t2 < 30) {                
			referrel1++;
		} else if (m3 < 40) {
			referrel1++;
		}System.out.println(referrel1);
		return referrel1;
                
	} 
        public static int calcredits(int m,int t1, int t2) {
            //t1=ict1 & t2 = ict2 & m = moduleMarks
             int c = 0;
                if(t1<0 || t1>100 || t2<0 || t2>100){
                    //ict1 and ict2 marks range should be in range of 0-100
                    error++;
                }
                else{
		if (m >= 40 && t1>=30 && t2>=30) {
			c = 20;    
		} else 
			c = 0;  
        }       return c;
        }
        public static int calmoduleMarks(int a,int b){                  
            //a = ict1Marks && b = ict2Marks
            int moduleMarks = 0;  
            moduleMarks = (a+b)/2;
            moduleMarks1[i] = moduleMarks;
            i++;
            return moduleMarks;
        }
        
        /**a student should able get 40 credits 
         * and particular module marks in a range of 30-40 
         * to get for condoned credits
         * and also condoned credits will offer after initial attempt rather than referrals or retake 
         */
        
        public static int condonedcredits(int[] q,int[] r,int[] p){                   
        //p = moduleMarks  q = ict1 r = ict2
         int maxNumber = 0; 
         int index = -1;             
         if(credit >= 40){
         for(int iu =0;iu < 6;iu++){                                                
            // "iu" is just used as loop counter
           if((p[iu] < 40 && p[iu] > 29) || ((r[iu] < 30 || q[iu] < 30 ) && (p[iu] >= 40)  )){               
               if(p[iu] >= maxNumber){                 
                maxNumber = p[iu];
                index = iu;                
                 } 
                  }
                  if(iu == 5 && index >= 0 ){                     
                    moduleMarks1[index] = 40; level4ict1[index] = 30; level4ict2[index] = 30;
                    p[index] = 40; q[index] = 30; r[index] = 30;  
                    referrels--; c_count++; credit += 20;
                    
             } 
           }
        }
       return index;
      }
        
        public static int validation(int[] arr1,int[] arr2){                    
            //arr1 = ict1Marks && arr2 = ict2Marks
            for(int val1 : arr1){
                if(val1<0 || val1>100){
                   error++; 
                }
            }
            for(int val2 : arr2){
                if(val2<0 || val2>100){
                   error++; 
                }
            }
            return error;
        }
   @Override
    public void initialize(URL url, ResourceBundle rb) {
    }  
}

 

