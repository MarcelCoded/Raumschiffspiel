package objekte;

import javax.imageio.ImageIO;
import java.io.IOException;

public class Astronaut extends SuperObjekt {
    public Astronaut() {
        name = "Astronaut";
        try {
            bild = ImageIO.read(getClass().getResourceAsStream("/images/objekte/astronaut.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
