import javax.imageio.ImageIO;
import java.awt.*;
import java.io.File;
import java.io.IOException;

/**
 * Created by Thu Trang on 18/06/16.
 */
public class GameOver implements Screen {
    Image gameOver, reset;

    public GameOver(){
        try {
            reset = ImageIO.read(new File("Resources/button_reset.png"));
            gameOver = ImageIO.read(new File("Resources/gameover.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void resetGame(){
        GameManager.getInstance().getStackScreen().pop();
    }


    @Override
    public void click() {

    }

    @Override
    public void update() {

    }

    @Override
    public void draw(Graphics g) {
        g.drawImage(gameOver, 0, 0, null);
        g.drawImage(reset, 300, 400, null);
    }
}
