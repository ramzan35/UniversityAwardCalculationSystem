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
import static javafxapplication2.Main2Controller.level5ict1;
import static javafxapplication2.MainController.validation;
import javax.swing.JOptionPane;

/**
 * FXML Controller class
 *
 * @author home
 */
//Level six
public class Main4Controller extends Main2Controller implements Initializable {
     @FXML
    private TextField m13ict1,m13ict2,m14ict1,m14ict2,m15ict1,m15ict2,m16ict1,m16ict2,m17ict1,m17ict2,m18ict1,m18ict2;
    
    @FXML
    private Label lblmm13,lblmm14,lblmm15,lblmm16,lblmm17,lblmm18,lblm13c,lblm14c,lblm15c,lblm16c,lblm17c,lblm18c,lblstatus;
    
    @FXML
    private Button btnenter,btnnext;
    
    static int referrels3 = 0; 
    static int[] mMarks3 = new int[6];
    static int FinalmarkForAward;           //marks for award  
    static int[] level6ict1 = new int[6];
    static int[] level6ict2 = new int[6];
    static int i = 0;
    static int level5ModuleMarks;           // total valid marks of level5 for award
    static int level6ModuleMarks;           // total valid marks of level5 for award
    
    public void calcuatelvl6(ActionEvent event)throws Exception{
        Main2Controller.credit = 240;
        try{
        int mM13ict1 = Integer.parseInt(m13ict1.getText());
        level6ict1[0] = mM13ict1;
        int mM13ict2 = Integer.parseInt(m13ict2.getText());
        level6ict2[0] = mM13ict2;
        int mM14ict1 = Integer.parseInt(m14ict1.getText());
        level6ict1[1] = mM14ict1;
        int mM14ict2 = Integer.parseInt(m14ict2.getText());
        level6ict2[1] = mM14ict2;
        int mM15ict1 = Integer.parseInt(m15ict1.getText());
        level6ict1[2] = mM15ict1;
        int mM15ict2 = Integer.parseInt(m15ict2.getText());
        level6ict2[2] = mM15ict2;
        int mM16ict1 = Integer.parseInt(m16ict1.getText());
        level6ict1[3] =  mM16ict1;
        int mM16ict2 = Integer.parseInt(m16ict2.getText());
        level6ict2[3] = mM16ict2;
        int mM17ict1 = Integer.parseInt(m17ict1.getText());
        level6ict1[4] = mM17ict1;
        int mM17ict2 = Integer.parseInt(m17ict2.getText());
        level6ict2[4] = mM17ict2;
        int mM18ict1 = Integer.parseInt(m18ict1.getText());
        level6ict1[5] = mM18ict1;
        int mM18ict2= Integer.parseInt(m18ict2.getText());
        level6ict2[5] = mM18ict2;
        
        int validate = validation(level6ict1,level6ict2);
        if(validate>=1){
            error = 0;
               Alert alert = new Alert(Alert.AlertType.INFORMATION);
               alert.setTitle("Error");
               alert.setContentText("Please enter the valid marks");
               alert.showAndWait();              
        } 
        else{
        int m13modulemarks = calmoduleMarks3(mM13ict1,mM13ict2);
        lblmm13.setText(String.valueOf(m13modulemarks));
        referrels3 += MainController.referrel(mM13ict1,mM13ict2,m13modulemarks);
        int c3 = MainController.calcredits(m13modulemarks,mM13ict1,mM13ict2);
        lblm13c.setText(String.valueOf(c3));
        credit += c3;
                
        int m14modulemarks = calmoduleMarks3(mM14ict1,mM14ict2);
        lblmm14.setText(String.valueOf(m14modulemarks));
        referrels3 += MainController.referrel(mM14ict1,mM14ict2,m14modulemarks);
        c3 = MainController.calcredits(m14modulemarks,mM14ict1,mM14ict2);
        lblm14c.setText(String.valueOf(c3));
        credit += c3;      
       
        int m15modulemarks = calmoduleMarks3(mM15ict1,mM15ict2);
        lblmm15.setText(String.valueOf(m15modulemarks));
        referrels3 += MainController.referrel(mM15ict1,mM15ict2,m15modulemarks);
        c3 = MainController.calcredits(m15modulemarks,mM15ict1,mM15ict2);
        lblm15c.setText(String.valueOf(c3));
        credit += c3;
               
        int m16modulemarks = calmoduleMarks3(mM16ict1,mM16ict2);
        lblmm16.setText(String.valueOf(m16modulemarks));
        referrels3 += MainController.referrel(mM16ict1,mM16ict2,m16modulemarks);
        c3 = MainController.calcredits(m16modulemarks,mM16ict1,mM16ict2);
        lblm16c.setText(String.valueOf(c3));
        credit += c3;       
        
        int m17modulemarks = calmoduleMarks3(mM17ict1,mM17ict2);
        lblmm17.setText(String.valueOf(m17modulemarks));
        referrels3 += MainController.referrel(mM17ict1,mM17ict2,m17modulemarks);
        c3 = MainController.calcredits(m17modulemarks,mM17ict1,mM17ict2);
        lblm17c.setText(String.valueOf(c3));
        credit += c3;       
        
        int m18modulemarks = calmoduleMarks3(mM18ict1,mM18ict2);
        lblmm18.setText(String.valueOf(m18modulemarks));
        referrels3 += MainController.referrel(mM18ict1,mM18ict2,m18modulemarks);
        c3 = MainController.calcredits(m18modulemarks,mM18ict1,mM18ict2);
        lblm18c.setText(String.valueOf(c3));
        credit += c3;
        if(referrels3>=1){
        lblstatus.setText(" Student should do "+referrels3+" referrels" );}
        
        FinalmarkForAward = merge(Main2Controller.mMarks2, mMarks3);
    }
    }
    catch(NumberFormatException e){
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
               alert.setTitle("Error");
               alert.setContentText("Please enter valid marks");
               alert.showAndWait();
        }
    }
     public void Next(ActionEvent event)throws Exception{
           
               if(referrels3 == 1){
                    ((Node)event.getSource()).getScene().getWindow().hide();
           Stage stage1 = new Stage(); 
           Parent root = FXMLLoader.load(getClass().getResource("Referrels.fxml"));
           Scene scene1 = new Scene(root);
           stage1.setScene(scene1);
           stage1.show();
               }
               else if(referrels3 == 2){
                    ((Node)event.getSource()).getScene().getWindow().hide();
                
           Stage stage1 = new Stage(); 
           Parent root = FXMLLoader.load(getClass().getResource("Referrels2.fxml"));
           Scene scene1 = new Scene(root);
           stage1.setScene(scene1);
           Referrels2Controller rf = new Referrels2Controller();
           stage1.show();
                }
              else if(referrels3 == 3){
                   ((Node)event.getSource()).getScene().getWindow().hide();
           Stage stage1 = new Stage(); 
           Parent root = FXMLLoader.load(getClass().getResource("Referrels3.fxml"));
           Scene scene1 = new Scene(root);
           stage1.setScene(scene1);
           stage1.show();
               }
           else if(referrels3 == 0){
                ((Node)event.getSource()).getScene().getWindow().hide();
           Stage stage1 = new Stage(); 
           Parent root = FXMLLoader.load(getClass().getResource("Award.fxml"));
           Scene scene1 = new Scene(root);
           stage1.setScene(scene1);
           
           stage1.show();   
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
     private static int merge(int[] g, int[] h) {                       //g = L5 module Marks & h = L6 module Marks
         /**
          * award is calculated from the module marks of level5 and level6
          * in award calculation least performed module mark will be dropped
          * level5 module mark weighted one third of award marks
          * level6 module mark weighted two third of award marks
          * if there is two lowest module marks from both level6 module marks will be disregarded
          */
   
         int finalMark;                                                   
         int level5MinMarks = 100;                                      //searching the minimum module mark of level5
         for(int s = 0; s<6; s++){
            if(g[s]<level5MinMarks){
                level5MinMarks = g[s];
            }
        }
         int level6MinMarks = 100;                                      //searching the minimum module mark of level5
         for(int f = 0; f<6;f++){
            if(h[f]<level6MinMarks){
                level6MinMarks = h[f];
            }
        }
         if(level6MinMarks > level5MinMarks){                          //bubble sorting for level5 module marks
             for(int f =0; f<(g.length-1); f++){
			for(int j = 0; j < ((g.length-1)-f); j++){ 
			  if(g[j] < g[j+1]){
			    int temp = g[j];
					g[j] = g[j+1];
					g[j+1] = temp;
				}
			}  
		}
             for(int val =0;val<5;val++){
                 level5ModuleMarks += g[val];
	}
             for(int val =0;val<6;val++){
                 level6ModuleMarks += h[val];
	}
            
             finalMark = (((level5ModuleMarks)/3)+((2*(level6ModuleMarks)/3)))/6;   
        }
         else if(level5MinMarks>level6MinMarks){                        //bubble sorting for level6 module marks
             for(int f =0; f<(h.length-1); f++){
			for(int j = 0; j < ((h.length-1)-f); j++){ 
			  if(h[j] < h[j+1]){
			    int temp = h[j];
					h[j] = h[j+1];
					h[j+1] = temp;
				}
			} 
		}
             for(int val =0; val<6; val++){
                 level5ModuleMarks += g[val];
	}
             for(int val =0;val<5;val++){
                 level6ModuleMarks += h[val];
	}
             finalMark = (((level5ModuleMarks)/3)+((2*(level6ModuleMarks)/3)))/6;       
     }   
         else{
              for(int val =0; val<6; val++){
                 level5ModuleMarks += g[val];
	}
             for(int val =0;val<5;val++){
                 level6ModuleMarks += h[val];
	 }
              finalMark = (((level5ModuleMarks)/3)+((2*(level6ModuleMarks)/3)))/6; 
         }
         return finalMark;
     }
   public static int calmoduleMarks3(int a,int b){
            int moduleMarks = (a+b)/2;
            mMarks3[i] = moduleMarks;
           // level6ict1[i] = a;
           // level6ict2[i] = b;
            i++;
            return moduleMarks;
        }
    @Override
    public void initialize(URL url, ResourceBundle rb) {
    }     
}
