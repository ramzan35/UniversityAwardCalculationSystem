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
import javafx.stage.Modality;
import javafx.stage.Stage;
import static javafxapplication2.Main1Controller.index;

/**
 * FXML Controller class
 *
 * @author HOME
 */
public class AwardController extends MainController implements Initializable {

        @FXML
        private Button btnnext,btncontinue,btnexit;
        
        @FXML
        private Label lblname,lblD,lblaward,lblreferrels,lblretake,lblcondoned,lbltype,lblavg;
        
        String award;
        int finalReffrrels;
        @FXML
        private void handleButtonAction1(ActionEvent event) throws IOException {
            if (Main4Controller.FinalmarkForAward >= 70) {
                award = "B.Sc.  1st class Honours Degree";
            } else if (Main4Controller.FinalmarkForAward >= 60) {
                award = "B.Sc.  2nd class Honours upper devision Degree";
            } else if (Main4Controller.FinalmarkForAward >= 50) {
                award = "B.Sc.  2nd class Honours lower devision Degree";
            } else if (Main4Controller.FinalmarkForAward >= 40) {
                award = "B.Sc.  3rd class Honours Degree";
            }
            finalReffrrels = MainController.referrels + Main2Controller.referrels2 + Main4Controller.referrels3;
            lblname.setText("Name \t  " + Main1Controller.name);
            lblD.setText("Student ID  \t  " + Main1Controller.index);
            lblaward.setText(award);
            if (finalReffrrels == 0 && Main4Controller.FinalmarkForAward > 70) {
                if (Main4Controller.FinalmarkForAward > 90) {
                    lbltype.setText("Distinction");
                } else {
                    lbltype.setText("Merit");
                }
            }
            lblavg.setText("Average :" + Main4Controller.FinalmarkForAward);

            lblreferrels.setText(String.valueOf("Referrels \t  " + finalReffrrels));

            lblretake.setText(String.valueOf("Retake \t  " + MainController.retake));

            lblcondoned.setText("condoned creidits \t  " + String.valueOf(MainController.c_count));
 
    }
    
        @FXML
        private void handleButtonAction2(ActionEvent event) throws IOException {
            System.exit(0);
        }
        
    @Override
    public void initialize(URL url, ResourceBundle rb) {
    }    
    
}
