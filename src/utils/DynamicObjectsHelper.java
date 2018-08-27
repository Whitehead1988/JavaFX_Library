package utils;

import javafx.application.Application;
import javafx.application.ConditionalFeature;
import javafx.application.Platform;
import javafx.beans.property.DoubleProperty;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.scene.AmbientLight;
import javafx.scene.Group;
import javafx.scene.PerspectiveCamera;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.paint.PhongMaterial;
import javafx.scene.shape.Sphere;
import javafx.scene.transform.Rotate;
import javafx.stage.Stage;

import java.io.File;
import java.io.FileInputStream;

public class DynamicObjectsHelper extends Application {
    private double anchorX;
    private double anchorAngleY;
    private final DoubleProperty angleX = new SimpleDoubleProperty(0);
    private final DoubleProperty angleY = new SimpleDoubleProperty(0);

    public static void main(String[] args) {
        Application.launch(args);
    }

    @Override
    public void start(Stage stage) {
        boolean supp = Platform.isSupported(ConditionalFeature.SCENE3D);
        try {
            if (supp) {
                Image diffuseMap;
                diffuseMap = new Image(new FileInputStream(
                        new File("C:\\Users\\Bartłomiej\\Desktop\\Books\\src\\Resources\\images\\earth1.jpg")));
                PhongMaterial pm = new PhongMaterial();
                pm.setDiffuseMap(diffuseMap);
                Sphere sphere = new Sphere(100);
                sphere.setMaterial(pm);
                Group group = new Group();
                group.setTranslateX(150);
                group.setTranslateY(150);
                group.setTranslateZ(100);
                Rotate xRotate = new Rotate(0, Rotate.X_AXIS);
                Rotate yRotate = new Rotate(0, Rotate.Y_AXIS);
                group.getTransforms().setAll(xRotate, yRotate);
                xRotate.angleProperty().bind(angleX);
                yRotate.angleProperty().bind(angleY);
                AmbientLight aLight = new AmbientLight();
                group.getChildren().addAll(sphere, aLight);
                Scene scene = new Scene(group, 300, 300, true);
                scene.setFill(Color.BLACK);
                scene.setOnMouseDragged((MouseEvent event) -> {
                    angleY.set(anchorAngleY + anchorX - event.getSceneX());
                });
                PerspectiveCamera cam = new PerspectiveCamera(false);
                scene.setCamera(cam);
                stage.setScene(scene);
            } else {
                StackPane root = new StackPane();
                Label label = new Label("Brak obsługi 3D");
                root.getChildren().add(label);
                Scene sc = new Scene(root, 300, 300);
                stage.setScene(sc);
            }
            stage.show();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

