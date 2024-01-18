import javafx.application.Application; // import method from javaFX
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.VBox;
import javafx.scene.layout.HBox;
import javafx.scene.control.Label;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.event.EventHandler;
import javafx.event.ActionEvent;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;

// Charlie Jandura
// 11/9/2023
// Computer Science Lab 12 JavaFX

/** 
 * create a javaFX gui and use a button and text field
 * to control the program logic
 */



public class JanduraLab13 extends Application {
   
   private RadioButton radio0; // private variable
   private RadioButton radio1; // private variable
   private RadioButton radio2; // private variable
   private RadioButton radio3; // private variable
   private TextField cupsField; // private variable
   private Label totalPointsLabel; // private variable
   private Label bonusPointsLabel; // private variable
   
   /** main method used to launch the program
    * no @param
    * no @return
    */
   public static void main(String[]args) {
      launch(args);
   }
   
   
   /** override the start method from jaxaFX
    * @param Stage primaryStage
    * no @return
    */
   @Override
   public void start(Stage primaryStage) {
      
      // create starting labels and initialize with text
      Label cupsLabel = new Label("Enter the number of cups of coffee purchased this month:"); 
      Label wednesdayLabel = new Label("Enter the number of cups purchased on Wednesdays " +
                                            "between 2 and 4:");
                                            
      // create result labels with no text
      totalPointsLabel = new Label();
      bonusPointsLabel = new Label();
      
      // create the cups text field
      cupsField = new TextField();
      
      // create radio buttons
      radio0 = new RadioButton("0 cups");
      radio1 = new RadioButton("1 cup");
      radio2 = new RadioButton("2 cups");
      radio3 = new RadioButton("3 cups");
      
      // create toggle group
      ToggleGroup radioGroup = new ToggleGroup();
      
      // add the radio buttons to the toggle group and set radio 0 to default
      radio0.setToggleGroup(radioGroup);
      radio1.setToggleGroup(radioGroup);
      radio2.setToggleGroup(radioGroup);
      radio3.setToggleGroup(radioGroup);
      radio0.setSelected(true);
      
      // create calcButton
      Button calcButton = new Button("Calculate");
      // register calcButton to ButtonClickHandler
      calcButton.setOnAction(new ButtonClickHandler());
      
      // create HBox1 and 2 and format using correct labels and fields with padding
      HBox hbox1 = new HBox(10, cupsLabel, cupsField);
      hbox1.setPadding(new Insets(10));
      HBox hbox2 = new HBox(10, wednesdayLabel);
      hbox2.setPadding(new Insets(10));
      HBox hbox3 = new HBox(10, radio0, radio1, radio2, radio3);
      hbox3.setPadding(new Insets(10));
      
      // create VBox using hbox's, button, and result labels with padding
      VBox vbox = new VBox(hbox1, hbox2, hbox3, calcButton, totalPointsLabel, bonusPointsLabel);
      vbox.setPadding(new Insets(10));
      
      // create the scene with VBox and set height and width
      Scene scene = new Scene(vbox, 600, 200);
      
      // center VBox in scene
      vbox.setAlignment(Pos.CENTER);
      
      // set scene on primaryStage
      primaryStage.setScene(scene);
      
      // set title on primaryStage
      primaryStage.setTitle("Morning Brew Coffee Shop");
      
      // show window
      primaryStage.show();
   }

   /** Event Handler Class used to listen for button clicks, implements EventHandler
    *  no @param
    *  no @return
    */
   class ButtonClickHandler implements EventHandler<ActionEvent> {
      
      /** Override handle class from javaFX and control program logic
       *  @param ActionEvent event
       *  no @return
       */
      @Override
      public void handle(ActionEvent event) {
         
         // wednesday cups variable
         int wednesdayCups = 0;
         
         // create array of size 1 to pass into existing setPoints method
         double totalCups[] = new double[1];
         // create a new object of class JanduraBonusPoints
         JanduraBonusPoints user = new JanduraBonusPoints();
         
         // parse the cupsField and store data in totalCups
         totalCups[0] = Double.parseDouble(cupsField.getText());
         
         // set points using totalCups and setPoints from JanduraPointsEarnedD
         user.setPoints(totalCups);
         
              
         // check which radio button is selected and set wednesdayPoints to the appropriate value
         if (radio0.isSelected()) {
            wednesdayCups = 0;
         } else if (radio1.isSelected()) {
            wednesdayCups = 1;
         } else if (radio2.isSelected()) {
            wednesdayCups = 2;
         } else {
            wednesdayCups = 3;
         }
         
         // calculate wednesday bonus points
         user.wednesdayBonusPoints(wednesdayCups);
         
         // change result labels using acquired data
         totalPointsLabel.setText(String.format("You bought %s cups of coffee this month and have %.1f points", totalCups[0], user.pointsEarned));
         bonusPointsLabel.setText(String.format("You earned a total of %.1f Bonus points", user.bonusPointsEarned));
         
      } 
   }

}


/** Test cases - Result
 *  6, 3 - 18.9 Points, 1.5 Bonus Points
 *  5, 2 - 15.5 Points, 1.0 Bonus Points
 *  2, 2 - 6.2 Points, 1.0 Bonus Points
 *  3, 1 - 8.7 Points, 0.5 Bonus Points
 *  0, 0 - 0.0 Points, 0.0 Bonus Points
 *  6, 0 - 17.4 Points, 0.0 Bonus Points
 */
