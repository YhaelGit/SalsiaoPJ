package org.example.salsiaopj;

import javafx.fxml.FXML;
import javafx.scene.control.ToggleButton;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.VBox;
import javafx.scene.shape.Circle;
import java.net.URL;
import javafx.application.Platform;
import javafx.scene.shape.Circle;




public class HelloController {

    @FXML private ImageView logoImage;

    @FXML private ToggleButton segInventory;

    @FXML private VBox viewInventory;
    @FXML private VBox viewOrder;
    @FXML private VBox viewSupplier;
    @FXML private VBox viewReception;
    @FXML private VBox viewIngredient;
    @FXML private VBox viewPayment;
    @FXML private VBox viewInvoice;

    @FXML
    private void initialize() {

        URL logoUrl = getClass().getResource("/imagenes/logo-salsiao.jpeg");
        if (logoUrl == null) {
            throw new IllegalStateException(
                    "Logo NO encontrado en classpath: /imagenes/logo-salsiao.jpeg. " +
                            "Verifica que exista en src/main/resources/imagenes/"
            );
        }

        logoImage.setImage(new Image(logoUrl.toExternalForm()));

        javafx.application.Platform.runLater(() -> {
            double w = logoImage.getFitWidth()  > 0 ? logoImage.getFitWidth()  : logoImage.getBoundsInLocal().getWidth();
            double h = logoImage.getFitHeight() > 0 ? logoImage.getFitHeight() : logoImage.getBoundsInLocal().getHeight();
            double r = Math.min(w, h) / 2.0;

            logoImage.setClip(new javafx.scene.shape.Circle(w / 2.0, h / 2.0, r));
        });

        if (segInventory != null) segInventory.setSelected(true);
        showOnly(viewInventory);
    }

    private void showOnly(VBox target) {
        VBox[] all = { viewInventory, viewOrder, viewSupplier, viewReception, viewIngredient, viewPayment, viewInvoice };
        for (VBox v : all) {
            boolean on = (v == target);
            v.setVisible(on);
            v.setManaged(on);
        }
    }

    @FXML private void showInventory()  { showOnly(viewInventory); }
    @FXML private void showOrder()      { showOnly(viewOrder); }
    @FXML private void showSupplier()   { showOnly(viewSupplier); }
    @FXML private void showReception()  { showOnly(viewReception); }
    @FXML private void showIngredient() { showOnly(viewIngredient); }
    @FXML private void showPayment()    { showOnly(viewPayment); }
    @FXML private void showInvoice()    { showOnly(viewInvoice); }
}
