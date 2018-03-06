package shitChat;

import javafx.fxml.FXML;
import javafx.scene.control.TextField;

import java.net.URI;

public class loginController {

    private Main main;

    @FXML private TextField server;
    @FXML private TextField userName;

    @FXML private void doLogin() throws Exception {
        this.main.showChat();
        this.main.connect(new URI(this.server.getText()), this.userName.getText());
    }

    public void setMain(Main main) {
        this.main = main;
    }
}
