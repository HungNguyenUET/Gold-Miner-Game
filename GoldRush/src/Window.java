import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;

/**
 * Created by Thu Trang on 17/06/16.
 */
public class Window extends Frame implements Runnable {
    BufferedImage bufferedImage;
    public Window(){
        this.setTitle("Gold Miner");
        this.setSize(800, 600);
        this.setVisible(true);
        GameManager.getInstance().getStackScreen().push(new MenuScreen());
        this.addWindowListener(new WindowListener() {
            @Override
            public void windowOpened(WindowEvent e) {

            }

            @Override
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }

            @Override
            public void windowClosed(WindowEvent e) {

            }

            @Override
            public void windowIconified(WindowEvent e) {

            }

            @Override
            public void windowDeiconified(WindowEvent e) {

            }

            @Override
            public void windowActivated(WindowEvent e) {

            }

            @Override
            public void windowDeactivated(WindowEvent e) {

            }
        });
        this.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if((e.getX() >= 50 && e.getX() <= 367) && (e.getY() >= 50 && e.getY() <= 337)){
                    ((MenuScreen)GameManager.getInstance().getStackScreen().peek()).startGame();
                }
                if(e.getX() >= 300 && e.getX() <= 600 && e.getY() >= 400 && e.getY() <= 500){
                    ((GameOver)GameManager.getInstance().getStackScreen().peek()).resetGame();
                }
            }

            @Override
            public void mousePressed(MouseEvent e) {

            }

            @Override
            public void mouseReleased(MouseEvent e) {

            }

            @Override
            public void mouseEntered(MouseEvent e) {

            }

            @Override
            public void mouseExited(MouseEvent e) {

            }
        });
        this.addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {

            }

            @Override
            public void keyPressed(KeyEvent e) {
                switch (e.getKeyCode()) {
                    case KeyEvent.VK_SPACE:
                        ((GameWindow) (GameManager.getInstance().getStackScreen().peek())).gapDo();
                        break;
                    case KeyEvent.VK_UP:
                        break;
                }
            }

            @Override
            public void keyReleased(KeyEvent e) {

            }
        });
    }

    public void gameUpdate(){
        GameManager.getInstance().getStackScreen().peek().update();
    }

    @Override
    public void update(Graphics g) {
        if(bufferedImage == null) {
            bufferedImage = new BufferedImage(800, 600, 1);
        }
        Graphics bufferGraphic = bufferedImage.getGraphics();
        GameManager.getInstance().getStackScreen().peek().draw(bufferGraphic);
        g.drawImage(bufferedImage, 0, 0, null);
    }

    @Override
    public void run() {
        while (true){
            try {
                Thread.sleep(17);
                gameUpdate();
                repaint();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }
    }
}
