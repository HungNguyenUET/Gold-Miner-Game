import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

/**
 * Created by Thu Trang on 18/06/16.
 */
public class Pig extends Thing {
    int score;
    boolean biKeo;

    public Pig(int positionX, int positionY, String strImage, int score) {
        super(positionX, positionY, strImage);
        this.score = score;
        speedX = -3;
        biKeo = false;
        try {
            this.image = ImageIO.read(new File(strImage));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void draw(BufferedImage bufferedImage) {
        Graphics g = bufferedImage.getGraphics();
        g.drawImage(this.image, positionX, positionY, null);
    }

    @Override
    public void update() {
        positionX += speedX;
        if (positionX < -10){
            positionX = 810;
        }
    }
}
