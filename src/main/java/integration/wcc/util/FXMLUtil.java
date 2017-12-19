package integration.wcc.util;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;

import java.io.IOException;

/**
 * Created by DOM on 26/03/2017.
 * email: douglas.janerson@gmail.com
 */
public abstract class FXMLUtil {

    public static Parent getFxml(String fxmlName) {
        String fxml = fxmlName.endsWith(".fxml") ? fxmlName : fxmlName.concat(".fxml");
        Parent p = null;
        try {
            p = FXMLLoader.load(FXMLUtil.class.getClass().getResource("/fxml/" + fxml));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return p;
    }
}
