package objekte;

import javax.imageio.ImageIO;
import java.io.IOException;

public class SchwarzesLoch extends SuperObjekt {
    public SchwarzesLoch() {
        name = "Schwarzes Loch";
        try {
            bild = ImageIO.read(getClass().getResourceAsStream("/images/objekte/SchwarzesLoch.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
