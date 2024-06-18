package objekte;

import javax.imageio.ImageIO;
import java.io.IOException;

public class ZerstoerterMeteorit extends SuperObjekt {

    public ZerstoerterMeteorit() {
        name = "ZerstoerterMeteorit";
        try {
            bild = ImageIO.read(getClass().getResourceAsStream("/images/objekte/meteoritkaputt.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
