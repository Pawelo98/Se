
import java.io.FileInputStream;
import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.effect.Bloom;
import javafx.scene.effect.ColorAdjust;
import javafx.scene.effect.GaussianBlur;
import javafx.scene.effect.Glow;
import javafx.scene.effect.Reflection;
import javafx.scene.effect.SepiaTone;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.scene.transform.Rotate;
import javafx.scene.transform.Shear;
import javafx.stage.Stage;
public class Obraz extends Application {
public static void main(String[] args) {
// TODO Auto-generated method stub
launch(args);
}
@Override
public void start(Stage stage) throws Exception {
// wczytywanie obrazow
Image image = new Image(new FileInputStream("woda.jpg"));
//Image image2 = new Image(new FileInputStream("kubekjpg.jpg"));
// ustawianie ImageView
ImageView imageView = new ImageView(image);
//ImageView imageView2 = new ImageView(image2);
// ustawianie polozenia obiektu klasy ImageView
imageView.setX(50);
imageView.setY(25);
//imageView2.setX(30);
//imageView2.setY(320);
// ustawianie wymiarow obiektu klasy ImageView
imageView.setFitHeight(500);
imageView.setFitWidth(500);
imageView.setPreserveRatio(true);
/*imageView2.setFitHeight(150);
imageView2.setFitWidth(250);
imageView2.setPreserveRatio(true);*/
// efekty -------------------------------------------
// gausssian blur
// imageView.setEffect(new GaussianBlur());
//bloom
//imageView.setEffect(new Bloom());
// glow
imageView.setEffect(new Glow(0.3));
// reflection
// imageView.setEffect(new Reflection(0.0, 0.7, 0.5, 0.0));
// sepia
// imageView.setEffect(new SepiaTone(0.8));
// color adjust
// imageView.setEffect(new ColorAdjust(-0.05,0.8,0.9,0.4));
// transformacje -------------------------------------------
// rotation
// imageView.setRotate(imageView.getRotate() + 180);
// scaling X & Y
// getScaleX() - zwraca skale obrazu
// imageView.setScaleX(imageView.getScaleX()*0.5);
// imageView.setScaleY(imageView.getScaleY()*0.3);
// tekst
Text t = new Text();
// ustawianie polozenia obiektu klasy Text
t.setX(70.0f);
t.setY(350.0f);
// ustawienia tekstu, koloru i czcionki
t.setText("Twoje zapotrzebowanie na wodê w dniu dzisiejszym " );
t.setFill(Color.BLACK);
t.setFont(Font.font("null", FontWeight.BOLD, 20));
// utworzenie obiektu klasy Group (grupy zawierajacej obiekty klas ImageView i Text)
Group root = new Group(imageView, t);
// utworzenie sceny z ustawieniem koloru tla
Scene scene = new Scene(root, 600, 500, Color.LIGHTSKYBLUE);
// ustawienie nazwy sceny
stage.setTitle("GET LAZY");
// dodanie obiektu klasy Scene do obiektu klasy Stage (okna)
stage.setScene(scene);
// wyœwietlenie zawartoœci okna
stage.show();
}
}
