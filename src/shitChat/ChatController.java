package shitChat;

import javafx.fxml.FXML;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

/**
 * Created by rakoit on 6.03.18.
 */
public class ChatController {

    private Main main;
    @FXML
    private TextField input;
    @FXML
    private TextArea messages;


    @FXML private void doSend() {
        this.main.client.send(this.main.userName + ": " + input.getText());
    }

    public void showMessage(String message) {
        this.messages.appendText(message + '\n');
    }

    public void setMain(Main main){
        this.main = main;
    }
}
