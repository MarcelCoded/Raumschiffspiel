package objekte;

import javax.imageio.ImageIO;
import java.io.IOException;

public class Sternschnuppe extends SuperObjekt {
    public Sternschnuppe() {
        name = "Sternschnuppe";
        try {
            bild = ImageIO.read(getClass().getResourceAsStream("/images/objekte/sternschnuppe.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
