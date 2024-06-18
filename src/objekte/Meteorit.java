package objekte;

import javax.imageio.ImageIO;
import java.io.IOException;

public class Meteorit extends SuperObjekt {

    public Meteorit() {
        name = "Meteorit";
        try {
            bild = ImageIO.read(getClass().getResourceAsStream("/images/objekte/meteorit.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
