import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.BubbleChart;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class WykresSlupkowy extends Application {

    double zuzytaWoda=0;


    String woda = "Twoje zapotrzebowanie na wod? w dniu dzisiejszym";
    String wodaWypita = "Ilo?? wypitej wody";
    String kalorie = "Ilo?? spo?ytych kalorii";
    String kofeina = "Ilo?? spo?ytej kofeiny";


    Text  txtWiek = new Text("Wiek");
    Text  txtWaga = new Text("Waga");
    Text  txtWzrost = new Text("Wzrost");
    Text  txtAktywnosc = new Text("Aktywnosc");
    Text txtIloscNap = new Text("Ilo?? wypitego napoju");
    TextField tfWiek= new TextField();
    TextField tfWaga =new TextField();
    TextField tfWzrost= new TextField();
    TextField tfAktywnosc= new TextField();
    TextField tfIloscNap = new TextField();
    Button btnOblicz = new Button("Oblicz");
    Button kobieta = new Button("Kobieta");
    Button mezczyzna = new Button("M??czyzna");

    @Override public void start(Stage stage) {

        VBox vbox = new VBox();
        GridPane dane = new GridPane();
        dane.setPadding(new Insets(30,30,30,30));
        dane.setVgap(10);
        dane.setHgap(10);
        dane.add(txtWiek,0, 0);
        dane.add(tfWiek,1, 0);
        dane.add(txtWaga,0, 1);
        dane.add(tfWaga,1, 1);
        dane.add(txtWzrost, 0, 2);
        dane.add(tfWzrost, 1, 2);
        dane.add(txtAktywnosc, 0, 3);
        dane.add(tfAktywnosc, 1, 3);
        dane.add(btnOblicz, 2, 3);
        dane.add(txtIloscNap, 2, 0);
        dane.add(tfIloscNap, 3,0 );
        dane.add(kobieta,6,0);
        dane.add(mezczyzna, 7,0);

        btnOblicz.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent event) {

                String strWiek=tfWiek.getText();
                int wiek = Integer.parseInt(strWiek);
                String strWaga=tfWaga.getText();
                double waga = Double.parseDouble(strWaga);
                String strWzrost=tfWzrost.getText();
                double wzrost = Double.parseDouble(strWzrost);
                String strAktywnosc=tfWzrost.getText();
                double aktywnosc = Double.parseDouble(strAktywnosc);
                String strIloscNap =tfIloscNap.getText();
                double iloscNap = Double.parseDouble(strIloscNap);

                System.out.println(waga);
                System.out.println(wzrost);
                System.out.println(wiek);
                System.out.println(aktywnosc);
                System.out.println(iloscNap);
                zuzytaWoda=500;

            }
        });


        stage.setTitle("PROJEKT WODA ");
        final CategoryAxis xAxis = new CategoryAxis();
        final NumberAxis yAxis = new NumberAxis();
        final BarChart<String,Number> bc =
                new BarChart<String,Number>(xAxis,yAxis);
        bc.setTitle("Przelicznik wody");
        xAxis.setLabel("Dane");
        yAxis.setLabel("Warto??");

        XYChart.Series series1 = new XYChart.Series();
        series1.setName("Dane statystyczne \n woda: ml \n kalorie: kcl \n kofeina: mg ");
        series1.getData().add(new XYChart.Data(woda, 10));
        series1.getData().add(new XYChart.Data(wodaWypita, 1500.0));
        series1.getData().add(new XYChart.Data(kalorie, 747.12));
        series1.getData().add(new XYChart.Data(kofeina, 50.0));


        vbox.getChildren().add(dane);
        vbox.getChildren().add(bc);

        Scene scene  = new Scene(vbox,800,600);
        bc.getData().addAll(series1);
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}