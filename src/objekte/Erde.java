package objekte;

import javax.imageio.ImageIO;
import java.io.IOException;

public class Erde extends SuperObjekt {
    public Erde() {
        name = "Erde";
        try {
            bild = ImageIO.read(getClass().getResourceAsStream("/images/objekte/erde.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
