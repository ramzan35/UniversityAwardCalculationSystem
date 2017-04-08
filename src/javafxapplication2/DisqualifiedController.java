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
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;

/**
 * FXML Controller class
 *
 * @author HOME
 */


public class DisqualifiedController  implements Initializable {

    @FXML
    static public Label lblDisqualified;
    
    @FXML    
    private void handleButtonAction(ActionEvent event) throws IOException {
        if(MainController.credit > 120 && MainController.credit < 240){
               Alert alert = new Alert(Alert.AlertType.INFORMATION);
               alert.setTitle("Notification");
               alert.setContentText(Main1Controller.index+" left with a CertHE");
               alert.showAndWait();
        }
        else if(MainController.credit > 240 && MainController.credit < 300){
               Alert alert = new Alert(Alert.AlertType.INFORMATION);
               alert.setTitle("Notification");
               alert.setContentText(Main1Controller.index+" left with a DipHE");
               alert.showAndWait();
        }
        else if(MainController.credit > 300 && MainController.credit < 360){
               Alert alert = new Alert(Alert.AlertType.INFORMATION);
               alert.setTitle("Notification");
               alert.setContentText(Main1Controller.index+" left with a B.Sc. NonHonours Degree");
               alert.showAndWait();
        }
         System.exit(0);
    }
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    
    
}
