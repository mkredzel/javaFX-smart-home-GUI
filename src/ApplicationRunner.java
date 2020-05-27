
import java.io.File;
import javafx.application.Application;
import javafx.geometry.*;
import javafx.scene.*;
import javafx.scene.control.*;
import javafx.scene.image.*;
import javafx.scene.layout.*;
import javafx.scene.paint.*;
import javafx.scene.shape.*;
import javafx.stage.*;

/**
 * The ApplicationRunner program implements a JavaFX GUI "Smart Home" application. 
 * Program is based on event handling. 
 * 
 * @author Marcel Kredzel
 */
public class ApplicationRunner extends Application {
    
    static String imgBack = System.getProperty("user.dir") + File.separator 
                            + "images" + File.separator  + "back.jpg";
    
    static String imgFront = System.getProperty("user.dir") + File.separator 
                            + "images" + File.separator  + "front.jpg";
    
    static String imgDrive = System.getProperty("user.dir") + File.separator 
                            + "images" + File.separator  + "drive.jpg";
    
    static String imgSide = System.getProperty("user.dir") + File.separator 
                            + "images" + File.separator  + "side.jpg";
    
    static String imgMute = System.getProperty("user.dir") + File.separator 
                            + "images" + File.separator  + "mute-screen.gif";
    
    int statusFront = 1;
    int statusRear = 1;
    int statusSide = 1;
    int statusDrive = 1;
    
    @Override
    public void start(Stage primaryStage) {
        File file1 = new File(imgFront);
        File file2 = new File(imgSide);
        File file3 = new File(imgBack);
        File file4 = new File(imgDrive);
        File file5 = new File(imgMute);
        
        Image image1 = new Image(file1.toURI().toString());
        Image image2 = new Image(file2.toURI().toString());
        Image image3 = new Image(file3.toURI().toString());
        Image image4 = new Image(file4.toURI().toString());
        Image image5 = new Image(file5.toURI().toString());
        
        ImageView iv1 = new ImageView();
        ImageView iv2 = new ImageView();
        ImageView iv3 = new ImageView();
        ImageView iv4 = new ImageView();
        ImageView iv5 = new ImageView();
        
         iv1.setImage(image1);
         iv2.setImage(image2);
         iv3.setImage(image3);
         iv4.setImage(image4);
         iv5.setImage(image5);
        
        Label lightingLabel = new Label("Lighting");
        Label centralHeatingLabel = new Label("Central Heating");
        Label cctvLabel = new Label("CCTV");

        Label hallLabel = new Label("Hall:");
        Label kitchenLabel = new Label("Kitchen:");
        Label diningLabel = new Label("Dining room:");
        Label livingLabel = new Label("Living room:");
        Label landingLabel = new Label("Landing:");
        Label bedroom1Label = new Label("Bedroom 1:");
        Label bedroom2Label = new Label("Bedroom 2:");

        ToggleButton frontBtn = new ToggleButton("Front");
        ToggleButton rearBtn = new ToggleButton("Rear");
        ToggleButton sideBtn = new ToggleButton("Side");
        ToggleButton driveBtn = new ToggleButton("Drive");
       
       // Front Button onclick - change image
       frontBtn.setOnAction((e) -> {
           if(statusFront == 1){
            iv1.setImage(image5);
            statusFront = 0;
           } else {
            iv1.setImage(image1);
            statusFront = 1;
           }
        });
       
       // Rear Button onclick - change image
       rearBtn.setOnAction((e) -> {
            if(statusRear == 1){
            iv2.setImage(image5);
            statusRear = 0;
           } else {
            iv2.setImage(image2);
            statusRear = 1;
           }
        });
       
       // Side Button onclick - change image
       sideBtn.setOnAction((e) -> {
            if(statusSide == 1){
            iv3.setImage(image5);
            statusSide = 0;
           } else {
            iv3.setImage(image3);
            statusSide = 1;
           }
        });
       
       // Drive Button onclick - change image
       driveBtn.setOnAction((e) -> {
            if(statusDrive == 1){
            iv4.setImage(image5);
            statusDrive = 0;
           } else {
            iv4.setImage(image4);
            statusDrive = 1;
           }
        });
        
       GridPane imgs = new GridPane();
        imgs.add(iv1, 0, 0);
        imgs.add(iv2, 0, 1);
        imgs.add(iv3, 1, 0);
        imgs.add(iv4, 1, 1);
        
        imgs.setVgap(5);
        imgs.setHgap(5);
        
        HBox hbox = new HBox(10, frontBtn, rearBtn, sideBtn, driveBtn);
        HBox labelCCTV = new HBox(cctvLabel);
        VBox rightPane = new VBox(20, labelCCTV, imgs, hbox);

        GridPane.setMargin(iv4, new Insets(0, 10, 0, 0));
        HBox.setMargin(cctvLabel, new Insets(10, 180, 0, 0));
        HBox.setMargin(driveBtn, new Insets(0, 80, 0, 0));
        
        HBox labelLighting = new HBox(lightingLabel);
        
        Slider hallSlider = new Slider(0.3, 1, 0.65); 
        Slider kitchenSlider = new Slider(0.3, 1, 0.65);
        Slider diningSlider = new Slider(0.3, 1, 0.65);
        Slider livingSlider = new Slider(0.3, 1, 0.65);
        Slider landingSlider = new Slider(0.3, 1, 0.65);
        Slider bedroom1Slider = new Slider(0.3, 1, 0.65);
        Slider bedroom2Slider = new Slider(0.3, 1, 0.65);
        
        Circle hallCircle = new Circle(15); 
        Circle kitchenCircle = new Circle(15);
        Circle diningCircle = new Circle(15);
        Circle livingCircle = new Circle(15);
        Circle landingCircle = new Circle(15);
        Circle bedroom1Circle = new Circle(15);
        Circle bedroom2Circle = new Circle(15);
        
        hallCircle.setFill(Color.hsb(60, 1, 0.65));
        kitchenCircle.setFill(Color.hsb(60, 1, 0.65));
        diningCircle.setFill(Color.hsb(60, 1, 0.65));
        livingCircle.setFill(Color.hsb(60, 1, 0.65));
        landingCircle.setFill(Color.hsb(60, 1, 0.65));
        bedroom1Circle.setFill(Color.hsb(60, 1, 0.65));
        bedroom2Circle.setFill(Color.hsb(60, 1, 0.65));
        
        // Circles on slider - change color
        hallSlider.valueProperty().addListener((e) -> {
            hallCircle.setFill(Color.hsb(60, 1, hallSlider.getValue()));
        });
        kitchenSlider.valueProperty().addListener((e) -> {
            kitchenCircle.setFill(Color.hsb(60, 1, kitchenSlider.getValue()));
        });
        diningSlider.valueProperty().addListener((e) -> {
            diningCircle.setFill(Color.hsb(60, 1, diningSlider.getValue()));
        });
        livingSlider.valueProperty().addListener((e) -> {
            livingCircle.setFill(Color.hsb(60, 1, livingSlider.getValue()));
        });
        landingSlider.valueProperty().addListener((e) -> {
            landingCircle.setFill(Color.hsb(60, 1, landingSlider.getValue()));
        });
        bedroom1Slider.valueProperty().addListener((e) -> {
            bedroom1Circle.setFill(Color.hsb(60, 1, bedroom1Slider.getValue()));
        });
        bedroom2Slider.valueProperty().addListener((e) -> {
            bedroom2Circle.setFill(Color.hsb(60, 1, bedroom2Slider.getValue()));
        });
        
        GridPane lightingPane = new GridPane();
        lightingPane.add(labelLighting, 0, 0);
        lightingPane.add(hallLabel, 0, 1);
        lightingPane.add(hallSlider, 1, 1);
        lightingPane.add(hallCircle, 2, 1);
        lightingPane.add(kitchenLabel, 0, 2);
        lightingPane.add(kitchenSlider, 1, 2);
        lightingPane.add(kitchenCircle, 2, 2);
        lightingPane.add(diningLabel, 0, 3);
        lightingPane.add(diningSlider, 1, 3);
        lightingPane.add(diningCircle, 2, 3);
        lightingPane.add(livingLabel, 0, 4);
        lightingPane.add(livingSlider, 1, 4);
        lightingPane.add(livingCircle, 2, 4);
        lightingPane.add(landingLabel, 0, 5);
        lightingPane.add(landingSlider, 1, 5);
        lightingPane.add(landingCircle, 2, 5);
        lightingPane.add(bedroom1Label, 0, 6);
        lightingPane.add(bedroom1Slider, 1, 6);
        lightingPane.add(bedroom1Circle, 2, 6);
        lightingPane.add(bedroom2Label, 0, 7);
        lightingPane.add(bedroom2Slider, 1, 7);
        lightingPane.add(bedroom2Circle, 2, 7);
        
        GridPane.setMargin(labelLighting, new Insets(10, 0, 0, 30));
        GridPane.setMargin(hallLabel, new Insets(0, 0, 0, 70));
        GridPane.setMargin(kitchenLabel, new Insets(0, 0, 0, 50));
        GridPane.setMargin(diningLabel, new Insets(0, 0, 0, 20));
        GridPane.setMargin(livingLabel, new Insets(0, 0, 0, 25));
        GridPane.setMargin(landingLabel, new Insets(0, 0, 0, 50));
        GridPane.setMargin(bedroom1Label, new Insets(0, 0, 0, 30));
        GridPane.setMargin(bedroom2Label, new Insets(0, 0, 0, 30));
        
        lightingPane.setVgap(5);
        lightingPane.setHgap(5);
        
        HBox labelHeating = new HBox(centralHeatingLabel);
        
        RadioButton radioButton1 = new RadioButton("Off");
        RadioButton radioButton2 = new RadioButton("Auto");
        RadioButton radioButton3 = new RadioButton("Once");
        RadioButton radioButton4 = new RadioButton("Cont");
        radioButton2.setSelected(true);
        
        ToggleGroup radioGroup = new ToggleGroup();

        radioButton1.setToggleGroup(radioGroup);
        radioButton2.setToggleGroup(radioGroup);
        radioButton3.setToggleGroup(radioGroup);
        radioButton4.setToggleGroup(radioGroup);
        
        Slider heatingSlider = new Slider(0.0, 30.0, 20.0); 
        heatingSlider.setOrientation(Orientation.VERTICAL);
        heatingSlider.setShowTickMarks(false);
        heatingSlider.setShowTickLabels(true);
        heatingSlider.setMajorTickUnit(5);
        heatingSlider.setMinorTickCount(9);    
        heatingSlider.setBlockIncrement(0.5);
        heatingSlider.setSnapToTicks(true);
        
        VBox radioButtons = new VBox(10, labelHeating, radioButton1, radioButton2, radioButton3, radioButton4);
        
        TextField tempValue = new TextField();
        tempValue.setText(String.valueOf(heatingSlider.getValue()));
        tempValue.setStyle("-fx-font-size: 1.5em; -fx-font-weight: bold; -fx-padding: 6px;");
        tempValue.setMaxHeight(15);
        tempValue.setPrefWidth(60);
        
        // On slide - change value of textfield
        heatingSlider.valueProperty().addListener((e) -> {
            tempValue.setText(String.format("%.2f", heatingSlider.getValue()));
        });
        
        // On change of textfield - change value slider
        tempValue.textProperty().addListener((e) -> {
            heatingSlider.setValue(Double.valueOf(tempValue.getText()));
        });
        
        HBox heatingPane = new HBox(10, radioButtons, heatingSlider, tempValue);
        
        heatingPane.setAlignment(Pos.CENTER_RIGHT);
        
        VBox leftPane = new VBox(3, lightingPane, heatingPane);
        
        VBox.setMargin(lightingPane, new Insets(5, 10, 0, 5));
        VBox.setMargin(heatingPane, new Insets(0, 10, 0, 5));
        VBox.setMargin(rightPane, new Insets(20, 0, 0, 0));
        
        lightingPane.setPadding(new Insets(0, 5, 5, 5));
        heatingPane.setPadding(new Insets(0, 0, 0, 0));
        
        lightingPane.setStyle("-fx-border-color: black; -fx-border-radius: 6px; -fx-border-width: 2px;");
        heatingPane.setStyle("-fx-border-color: black; -fx-border-radius: 6px; -fx-border-width: 2px; -fx-padding: 10");
        
        HBox bigPane = new HBox(5, leftPane, rightPane);
        bigPane.setStyle("-fx-border-color: black;-fx-border-width: 4px;");
        labelCCTV.setAlignment(Pos.CENTER_RIGHT);
        imgs.setAlignment(Pos.CENTER_RIGHT);
        hbox.setAlignment(Pos.CENTER_RIGHT);
        
        rightPane.setStyle("-fx-font-size: 1.6em; -fx-font-weight: bold;");
        lightingLabel.setStyle("-fx-font-size: 1.4em; -fx-font-weight: bold;");
        centralHeatingLabel.setStyle("-fx-font-size: 1.4em; -fx-font-weight: bold;");
        
        labelCCTV.setStyle("-fx-font-size: 1.5em;");
        
        frontBtn.setMinWidth(60);
        rearBtn.setMinWidth(60);
        sideBtn.setMinWidth(60);
        driveBtn.setMinWidth(60);

        hallLabel.setStyle("-fx-font-size: 1.2em;");
        kitchenLabel.setStyle("-fx-font-size: 1.2em;");
        diningLabel.setStyle("-fx-font-size: 1.2em;");
        livingLabel.setStyle("-fx-font-size: 1.2em;");
        landingLabel.setStyle("-fx-font-size: 1.2em;");
        bedroom1Label.setStyle("-fx-font-size: 1.2em;");
        bedroom2Label.setStyle("-fx-font-size: 1.2em;");

        Scene scene = new Scene(bigPane, 730, 460);
        primaryStage.setTitle("SmartPad App");
        primaryStage.setResizable(false);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
