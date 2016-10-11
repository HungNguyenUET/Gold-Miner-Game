import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

/**
 * Created by Thu Trang on 18/06/16.
 */
public class Tnt extends Thing{
    boolean biKeo;
    boolean veDich;

    public Tnt(int positionX, int positionY, String strImage) {
        super(positionX, positionY, strImage);
        biKeo = false;
        try {
            this.image = ImageIO.read(new File("Resources/tnt1.png"));
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
    }
}
