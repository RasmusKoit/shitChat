package shitChat;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.net.URI;
import java.net.URISyntaxException;

public class Main extends Application {

    private Stage primaryStage;
    public Client client;
    public String userName;
    public ChatController chat;

    @Override
    public void start(Stage primaryStage) throws Exception{
        this.primaryStage = primaryStage;


        FXMLLoader loader = new FXMLLoader(getClass().getResource("login.fxml"));
        Parent root = loader.load();
        loader.<loginController>getController().setMain(this);




        primaryStage.setTitle("shitChat");
        primaryStage.setScene(new Scene(root, 300, 275));
        primaryStage.show();
    }

    public void showChat() throws Exception {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("chat.fxml"));
        Parent parent = loader.load();
        this.primaryStage.setScene(new Scene(parent));
        this.chat = loader.<ChatController>getController();
        this.chat.setMain(this);
    }

    public void connect(URI server, String userName) throws URISyntaxException {
        this.client = new Client(server, this);
        this.client.connect();
        this.userName = userName;
    }

    public static void main(String[] args) {
        launch(args);
    }
}
