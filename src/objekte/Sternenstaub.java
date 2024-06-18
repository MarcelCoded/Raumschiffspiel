package objekte;

import javax.imageio.ImageIO;
import java.io.IOException;

public class Sternenstaub extends SuperObjekt {
    public Sternenstaub() {
        name = "Sternenstaub";
        try {
            bild = ImageIO.read(getClass().getResourceAsStream("/images/objekte/Funkeln.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
