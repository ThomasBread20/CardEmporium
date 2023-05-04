package it.uniroma2.ispw.cardemporium.business;

import it.uniroma2.ispw.cardemporium.ui.ProfiloAdminview;
import it.uniroma2.ispw.cardemporium.ui.Profiloview;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;


import java.io.IOException;

import javafx.event.ActionEvent;

public class InitProfileButton {
    static DataSingleton info = DataSingleton.getInstance();
    public static void InitProfileUser(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(InitProfileButton.class.getResource("schermata_utenteProfilo.fxml"));
        Parent viewRegister = loader.load();
        Scene viewRegisterScene = new Scene(viewRegister);

        Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
        Profiloview profiloview = loader.getController();

        profiloview.initData(
                info.getUsername(),
                info.getName(),
                info.getSurname(),
                String.valueOf(info.getData()),
                info.getRole()
        );
        window.setScene(viewRegisterScene);
        window.show();
    }
   public InitProfileButton(){}

   public static void InitProfileAdmin(ActionEvent actionEvent) throws IOException {
       FXMLLoader loader = new FXMLLoader(InitProfileButton.class.getResource("schermata_utenteProfiloAdmin.fxml"));
       Parent viewregister = loader.load();
       Scene viewregisterscene = new Scene(viewregister);
       Stage window = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
       ProfiloAdminview profiloadminview = loader.getController();
       profiloadminview.initData(
               info.getUsername(),
               info.getName(),
               info.getSurname(),
               String.valueOf(info.getData()),
               info.getRole()
       );
       window.setScene(viewregisterscene);
       window.show();
   }
}
