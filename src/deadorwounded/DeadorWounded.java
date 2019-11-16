/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package deadorwounded;

import java.util.Arrays;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import java.util.Random;

/**
 *
 * @author Mishael Abiola
 */

public class DeadorWounded extends Application {
    
    public VBox vbox;
    public HBox hbox1,hbox2,hbox3,hbox4;
    public Stage stage,stage1;
    public Label l1,l3,l2,l4;
    public TextField p1,p2;
    public String text;
    public TextField a1,a2;
    public PasswordField g1,g2;
    public Button b1;
    public boolean ne = false;
    public String t2,t3;
    public RadioButton rad,rad2,rad3;
    public ToggleGroup ra;
    
    public int dead = 0,wounded = 0;
    public int arr1[]= new int[4];
    public int arr2[]= new int[4];
    public int choice = 0;
    public int cec[] = new int[4];
    
    
    public TextField t1;
            
    public static void think(){
    try{
        for(int i = 0;i<4;i++){
            Thread.sleep(300);
        }
    }catch(Exception fe){}
    }
   
    public void check(String t){
        int ar2[] = new int[4];
        for(int i = 0;i<=t.length()-1;i++){
                ar2[i] = t.charAt(i) - '0';
        }   
            
            for (int i = 0; i <= 3; i++) {

                if (ar2[i] == arr1[i]) {         //at each input, if it equals player 1 own, its 1(one) dead
                    dead++;
                }

                for (int j = 0; j <= 3; j++) {

                    if ((ar2[i] == arr1[j])) {
                        
                        Prompt.display("Good",ar2[i]+" is a good guess");
                        System.out.println(ar2[i] + " is a good guess");
                        
                        if (ar2[i] != arr1[i]) {
                            wounded++;
                        }

                        
                    }

                }

            }
            
            System.out.println(wounded + " wounded");
            System.out.println(dead + " dead");
            String tem = Integer.toString(dead);
            String te = Integer.toString(wounded);
            Prompt.display("Good",tem+" dead and "+te+" wounded");
                        
            
            if(dead == 4){
               ne = true;
            }
            dead = 0;
            wounded = 0;
            
    }
    
    public void check2(String t){
        int ar1[] = new int[4];
        for(int i = 0;i<=t.length()-1;i++){
                ar1[i] = t.charAt(i) - '0';
        }   
            
            for (int i = 0; i <= 3; i++) {

                if (ar1[i] == arr2[i]) {         //at each input, if it equals player 1 own, its 1(one) dead
                    dead++;
                }

                for (int j = 0; j <= 3; j++) {

                    if ((ar1[i] == arr2[j])) {
                        
                        Prompt.display("Good",ar1[i]+" is a good guess");
                        System.out.println(ar1[i] + " is a good guess");
                        
                        if (ar1[i] != arr2[i]) {
                            wounded++;
                        }

                        
                    }

                }

            }
            
            System.out.println(wounded + " wounded");
            System.out.println(dead + " dead");
            String tem = Integer.toString(dead);
            String te = Integer.toString(wounded);
            Prompt.display("Good",tem+" dead and "+te+" wounded");
                        
            
            if(dead == 4){
               ne = true;
            }
            
            dead = 0;
            wounded = 0;
            
    }
    
    public void magic(){
        
        Label l1 = new Label("Your turn " + p2.getText().toUpperCase());
        Label l2 = new Label("Guess "+ p1.getText().toUpperCase()+" numbers");
        t1 = new TextField();
        Button b1 = new Button("CHECK");
        b1.setOnAction(e->{
            check(t1.getText());
            if(ne == false){
                vbox.setVisible(false);
                think();
                magic2();
            }
            else{
                Prompt.display("WELLDONE ",  p2.getText().toUpperCase() + " YOU WIN ");
                System.out.println("You Win");
                stage.close();
            }
        });
        
        hbox1 = new HBox();
        hbox1.setSpacing(20);
        hbox1.getChildren().addAll(l1);
        hbox2 = new HBox();
        hbox2.setSpacing(20);
        hbox2.getChildren().addAll(l2);
        hbox3 = new HBox();
        hbox3.getChildren().addAll(t1);
        vbox = new VBox();
        vbox.setPadding(new Insets(10,10,10,10));
        vbox.setSpacing(20);
        vbox.getChildren().addAll(hbox1,hbox2,hbox3,b1);
        Scene scene = new Scene(vbox);
        stage.setTitle("Dead or Wounded");
        stage.setScene(scene);
        stage.show();
    }
    
    public void comp(){
        
        Random ran = new Random();
       
        for(int i =0;i<=3;i++){
            arr2[i]= ran.nextInt(10);
            System.out.println(arr2[i]);
        }
    } 
    
    public void magic2(){
        
        Label l1 = new Label("Your turn " + p1.getText().toUpperCase());
        Label l2 = new Label("Guess "+ p2.getText().toUpperCase()+" numbers");
        t1 = new TextField();
        Button b1 = new Button("CHECK");
        b1.setOnAction(e->{
            check2(t1.getText());
            if(ne == false){
                vbox.setVisible(false);
                think();
                magic();
            }
            else{
                Prompt.display("WELLDONE ",  p1.getText().toUpperCase() + " YOU WIN ");
                System.out.println("You Win");
                stage.close();
            }
        });
        
        hbox1 = new HBox();
        hbox1.setSpacing(20);
        hbox1.getChildren().addAll(l1);
        hbox2 = new HBox();
        hbox2.setSpacing(20);
        hbox2.getChildren().addAll(l2);
        hbox3 = new HBox();
        hbox3.getChildren().addAll(t1);
        vbox = new VBox();
        vbox.setPadding(new Insets(10,10,10,10));
        vbox.setSpacing(20);
        vbox.getChildren().addAll(hbox1,hbox2,hbox3,b1);
        Scene scene = new Scene(vbox);
        stage.setTitle("Dead or Wounded");
        stage.setScene(scene);
        stage.show();
    }
    
    public void magic3(){
        Label l1 = new Label("Your turn " + p1.getText().toUpperCase());
        Label l2 = new Label("Guess computers numbers");
        t1 = new TextField();
        Button b1 = new Button("CHECK");
        b1.setOnAction(e->{
            check2(t1.getText());
            if(ne == false){
                vbox.setVisible(false);
                think();
                magic3();
            }
            else{
                Prompt.display("WELLDONE ",  p1.getText().toUpperCase() + " YOU WIN ");
                System.out.println("You Win");
                stage.close();
            }
        });
        
        hbox1 = new HBox();
        hbox1.setSpacing(20);
        hbox1.getChildren().addAll(l1);
        hbox2 = new HBox();
        hbox2.setSpacing(20);
        hbox2.getChildren().addAll(l2);
        hbox3 = new HBox();
        hbox3.getChildren().addAll(t1);
        vbox = new VBox();
        vbox.setPadding(new Insets(10,10,10,10));
        vbox.setSpacing(20);
        vbox.getChildren().addAll(hbox1,hbox2,hbox3,b1);
        Scene scene = new Scene(vbox);
        stage.setTitle("Dead or Wounded");
        stage.setScene(scene);
        stage.show();
    
    }
    
    public void magic4(){
        Label l1 = new Label("Your turn " + p1.getText().toUpperCase());
        Label l2 = new Label("Guess computers numbers");
        t1 = new TextField();
        Button b1 = new Button("CHECK");
        b1.setOnAction(e->{
            check2(t1.getText());
            if(ne == false){
                vbox.setVisible(false);
                think();
                magic5();
            }
            else{
                Prompt.display("WELLDONE ",  p1.getText().toUpperCase() + " YOU WIN ");
                System.out.println("You Win");
                stage.close();
            }
        });
        
        hbox1 = new HBox();
        hbox1.setSpacing(20);
        hbox1.getChildren().addAll(l1);
        hbox2 = new HBox();
        hbox2.setSpacing(20);
        hbox2.getChildren().addAll(l2);
        hbox3 = new HBox();
        hbox3.getChildren().addAll(t1);
        vbox = new VBox();
        vbox.setPadding(new Insets(10,10,10,10));
        vbox.setSpacing(20);
        vbox.getChildren().addAll(hbox1,hbox2,hbox3,b1);
        Scene scene = new Scene(vbox);
        stage.setTitle("Dead or Wounded");
        stage.setScene(scene);
        stage.show();
    }
    
    public void gen(){
        int ded;
        String x = a1.getText();
        int[] toa = new int[4];
        int z;
        
        z = a1.getLength();
        System.out.println(z);
        for(int i = 0;i<=x.length()-1;i++){
            toa[i] = x.charAt(i) - '0';
            System.out.println(toa[i]);
        }
        
        Random ran = new Random();
        for(int i=0;i<=3;i++){
            cec[i]= ran.nextInt(10);
            System.out.println(cec[i]);
             
            switch (z) {
                case 4:
                    cec[0] = toa[0];
                    cec[1] = toa[1];
                    cec[2] = toa[2];
                    cec[3] = toa[3];
                    break;
                case 3:
                    cec[0] = toa[0];
                    cec[1] = toa[1];
                    cec[2] = toa[2];
                    break;
                case 2:
                    cec[0] = toa[0];
                    cec[1] = toa[1];
                    break;
                case 1:
                    cec[0] = toa[0];
                    break;
                default:
                    break;
            }
            
        }
        
        for(int i =0;i<=3;i++){
            arr2[i]= cec[i];
            System.out.println(arr2[i]);
        }
        
    }
    
    public void magic5(){
        Label l1 = new Label("Your turn comp");
        Label l2 = new Label("Guess Player numbers");
        Label l3 = new Label("Dead:  ");
        String x = null;
        x = Arrays.toString(arr2);
        t1 = new TextField(x);
        t1.setEditable(false);
        a1 = new TextField();
        Button b1 = new Button("CHECK");
        b1.setOnAction(e->{
            
            if(a1.getText().length()==4){
                Prompt.display("Game Over","COMP WINS ");
                System.out.println("You Win");
                stage.close();
            }
            else{
                vbox.setVisible(false);
                think();
                gen();
                Prompt.display("OK","Your Turn");
                magic4();
            }
        });
        
        hbox1 = new HBox();
        hbox1.setSpacing(20);
        hbox1.getChildren().addAll(l1);
        hbox2 = new HBox();
        hbox2.setSpacing(20);
        hbox2.getChildren().addAll(l2,t1);
        hbox3 = new HBox();
        hbox3.setSpacing(20);
        hbox3.getChildren().addAll(l3,a1);
        vbox = new VBox();
        vbox.setPadding(new Insets(10,10,10,10));
        vbox.setSpacing(20);
        vbox.getChildren().addAll(hbox1,hbox2,hbox3,b1);
        Scene scene = new Scene(vbox);
        stage.setTitle("Dead or Wounded");
        stage.setScene(scene);
        stage.show();
    }
    
    public void begin(){
        Label l1 = new Label();
        Label l2 = new Label();
        l1.setText( p1.getText().toUpperCase());
        g1 = new PasswordField();
        g1.setPromptText("your four numbers");
        l2.setText( p2.getText().toUpperCase());
        g2 = new PasswordField();
        g2.setPromptText("your four numbers");
       l1.setStyle("-fx-text-fill: #FFFFFF");
       l2.setStyle("-fx-text-fill: #FFFFFF");
        Button b1 = new Button();
        b1.setText("Start");
        
        hbox1 = new HBox();
        hbox1.setSpacing(20);
        hbox1.getChildren().addAll(l1,g1);
        hbox2 = new HBox();
        hbox2.setSpacing(20);
        hbox2.getChildren().addAll(l2,g2);
        vbox = new VBox();
        vbox.setPadding(new Insets(10,10,10,10));
        vbox.setSpacing(20);
        vbox.getChildren().addAll(hbox1,hbox2,b1);
        Scene scene = new Scene(vbox, 300, 250);
        b1.setOnAction(e->{
            System.out.println("working");
            change1(g1.getText());
            change2(g2.getText());
            vbox.setVisible(false);
            magic();
        });
        stage.setTitle("Dead or Wounded");
        stage.setScene(scene);
        
        vbox.setStyle("-fx-background-color: #3D4956");
        stage.show();
    }
    
    public void select(){
        stage = new Stage();
        l1 = new Label("Welcome to dead or wounded\nSelect game Mode (g = guesser)");
        l3 = new Label("C vs H[g]");
        rad2 = new RadioButton();
        l4 = new Label("H(g) vs H[g]");
        rad3 = new RadioButton();
        l2 = new Label("C(g) vs H[g]");
        rad = new RadioButton();
        ra = new ToggleGroup();
        ra.getToggles().addAll(rad2,rad3,rad);
        b1 = new Button("PLAY");
        l1.setStyle("-fx-text-fill: #FFFFFF");
        l2.setStyle("-fx-text-fill: #FFFFFF");
        l3.setStyle("-fx-text-fill: #FFFFFF");
        l4.setStyle("-fx-text-fill: #FFFFFF");
        hbox1 = new HBox();
        hbox1.setSpacing(60);
        hbox1.getChildren().addAll(l3,l4,l2);
        hbox2 = new HBox();
        hbox2.setSpacing(80);
        hbox2.getChildren().addAll(rad2,rad3,rad);
        vbox = new VBox();
        vbox.setPadding(new Insets(10,10,10,10));
        vbox.setSpacing(20);
        vbox.getChildren().addAll(l1,hbox1,hbox2,b1);
        
        
        rad.setOnAction(e->{
            choice =1;
        });
        rad2.setOnAction(e->{
            choice =2;
        });
        rad3.setOnAction(e->{
            choice =3;
        });
        b1.setOnAction(e->{
            switch (choice) {
                
                case 1:
                    vbox.setVisible(false);
                    System.out.println(choice);
                    stage.close();
                    welcome3();
                    break;
                    
                case 2:
                    vbox.setVisible(false);
                    System.out.println(choice);
                    stage.close();
                    welcome2();
                    break;
                case 3:
                    vbox.setVisible(false);
                    System.out.println(choice);
                    stage.close();
                    welcome();
                    break;
                default:
                    Prompt.display("Error","Select an Option");
                    break;
            }
            
        });
        Scene scene = new Scene(vbox, 300, 250);
        stage.setTitle("Dead or Wounded");
        stage.setScene(scene);
        
        vbox.setStyle("-fx-background-color: #3D4956");
        stage.show();
    
    }
    
    public void welcome2(){
        stage = new Stage();
        l1 = new Label("Enter your names");
        l2 = new Label("Player 1: ");
        p1 = new TextField();
       
        b1 = new Button("PLAY");
        l1.setStyle("-fx-text-fill: #FFFFFF");
        l2.setStyle("-fx-text-fill: #FFFFFF");
       
        hbox1 = new HBox();
        hbox1.setSpacing(10);
        hbox1.getChildren().addAll(l2,p1);
        vbox = new VBox();
        vbox.setPadding(new Insets(10,10,10,10));
        vbox.setSpacing(20);
        vbox.getChildren().addAll(l1,hbox1,b1);
        b1.setOnAction(e->{
            vbox.setVisible(false);
            System.out.println(p1.getText());
            comp();
            magic3();
        });
        
        Scene scene = new Scene(vbox, 300, 250);
        stage.setTitle("Dead or Wounded");
        stage.setScene(scene);
        
        vbox.setStyle("-fx-background-color: #3D4956");
        stage.show();

    }
    
    public void welcome3(){
    
        stage = new Stage();
        l1 = new Label("Enter your name\n Keep yr number in mind OK!");
        l2 = new Label("Player 1: ");
        p1 = new TextField();
       
        b1 = new Button("PLAY");
        l1.setStyle("-fx-text-fill: #FFFFFF");
        l2.setStyle("-fx-text-fill: #FFFFFF");
       
        hbox1 = new HBox();
        hbox1.setSpacing(10);
        hbox1.getChildren().addAll(l2,p1);
        vbox = new VBox();
        vbox.setPadding(new Insets(10,10,10,10));
        vbox.setSpacing(20);
        vbox.getChildren().addAll(l1,hbox1,b1);
        b1.setOnAction(e->{
            vbox.setVisible(false);
            System.out.println(p1.getText());
            comp();
            magic4();
        });
        
        Scene scene = new Scene(vbox, 300, 250);
        stage.setTitle("Dead or Wounded");
        stage.setScene(scene);
        
        vbox.setStyle("-fx-background-color: #3D4956");
        stage.show();

    }
    
    public void welcome(){
        stage = new Stage();
        l1 = new Label("Enter your names");
        l2 = new Label("Player 1: ");
        p1 = new TextField();
        p1.setPromptText("Name");
        l3 = new Label("Player 2: ");
        p2 = new TextField();
        p2.setPromptText("Name");
        b1 = new Button("PLAY");
        l1.setStyle("-fx-text-fill: #FFFFFF");
        l2.setStyle("-fx-text-fill: #FFFFFF");
        l3.setStyle("-fx-text-fill: #FFFFFF");
        hbox1 = new HBox();
        hbox1.setSpacing(10);
        hbox1.getChildren().addAll(l2,p1);
        hbox2 = new HBox();
        hbox2.setSpacing(10);
        hbox2.getChildren().addAll(l3,p2);
        vbox = new VBox();
        vbox.setPadding(new Insets(10,10,10,10));
        vbox.setSpacing(20);
        vbox.getChildren().addAll(l1,hbox1,hbox2,b1);
        b1.setOnAction(e->{
            vbox.setVisible(false);
            System.out.println(p1.getText());
            System.out.println(p2.getText());
            begin();
        });
        Scene scene = new Scene(vbox, 300, 250);
        stage.setTitle("Dead or Wounded");
        stage.setScene(scene);
        
        vbox.setStyle("-fx-background-color: #3D4956");
        stage.show();
    }
    
    public void nonsense(int com[]){
//       int com[] = new int[4];
//        for(int i = 0;i<=comp.length()-1;i++){
//                com[i] = comp.charAt(i) - '0';
//        }   
//            
            for (int i = 0; i <= 3; i++) {

                if (com[i] == arr1[i]) {         //at each input, if it equals player 1 own, its 1(one) dead
                    dead++;
                }

                for (int j = 0; j <= 3; j++) {

                    if ((com[i] == arr1[j])) {
                        
                        Prompt.display("Good",com[i]+" is a good guess");
                        System.out.println(com[i] + " is a good guess");
                        
                        if (com[i] != arr1[i]) {
                            wounded++;
                        }

                        
                    }

                }

            }
            
            System.out.println(wounded + " wounded");
            System.out.println(dead + " dead");
            String tem = Integer.toString(dead);
            String te = Integer.toString(wounded);
            Prompt.display("Good",tem+" dead and "+te+" wounded");
                        
            
            if(dead == 4){
               ne = true;
            }
            
            dead = 0;
            wounded = 0;
            
       
    }
    
    public void change1(String x){
        System.out.println(x);
        System.out.println("method on!");
        for(int i = 0;i<=x.length()-1;i++){
                arr1[i] = x.charAt(i) - '0';
                System.out.println(arr1[i]);
        }
    }
    
    public void change2(String x){
        System.out.println(x);
        System.out.println("method on!");
        for(int i = 0;i<=x.length()-1;i++){
            arr2[i] = x.charAt(i) - '0';
            System.out.println(arr2[i]);
        }
    }
    
    
    
    @Override
    public void start(Stage primaryStage) {
        
        Button b = new Button();
        b.setText("READY TO DIEEEEE!!!!!");
        StackPane root = new StackPane();
        root.getChildren().add(b);
        Scene scene = new Scene(root, 300, 250);
        b.setOnAction(e->{
          select(); 
          root.setVisible(false);
        });
        primaryStage.setTitle("Dead or Wounded");
        primaryStage.setScene(scene);
        
        root.setStyle("-fx-background-color: #3D4956");
        primaryStage.show();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}
