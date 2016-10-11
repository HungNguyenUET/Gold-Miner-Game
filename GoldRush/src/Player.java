import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

/**
 * Created by Thu Trang on 11/06/16.
 */
public class Player {
    int positionX, positionY;
    BufferedImage image;
    static Moc moc;
    public Player(int positionX, int positionY, String strImage) {
        this.positionX = positionX;
        this.positionY = positionY;
        moc = new Moc(this.positionX + 20, this.positionY + 110, "Resources/moc.png");
        try {
            this.image = ImageIO.read(new File(strImage));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void draw(BufferedImage bufferedImage){
        Graphics g = bufferedImage.getGraphics();
        g.drawImage(image, positionX, positionY, null);
    }
}
