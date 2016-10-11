import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

/**
 * Created by Hung Nguyen on 11/06/16.
 */
public abstract class Thing {
    int positionX, positionY;
    BufferedImage image;
    int speedX;
    int speedY;
    /*
    boolean biNem;
    int score;
    boolean biKeo;*/

    public Thing(int positionX, int positionY, String strImage){
        this.positionX = positionX;
        this.positionY = positionY;
        try {
            image = ImageIO.read(new File(strImage));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public abstract void draw(BufferedImage bufferedImage);

    public abstract void update();
}
