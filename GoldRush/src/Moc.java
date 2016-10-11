import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

/**
 * Created by Thu Trang on 11/06/16.
 */
public class Moc {
    ArrayList<Tnt> myListTnt;
    int tongDiem = 0;
    int positionX, positionY;
    BufferedImage image;
    BufferedImage imageDay;
    int speedY = 0, speedX = 0;
    boolean keoVe = false;
    static int anpha = 0, anphaPlus = 1;
    int y;
    String strImage;

    public Moc(int positionX, int positionY, String strImage) {
        myListTnt  = new ArrayList<>();
        this.positionX = positionX;
        this.positionY = positionY;
        this.strImage = strImage;
        try {
            image = ImageIO.read(new File(strImage));
            this.imageDay = ImageIO.read(new File("Resources/day.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void draw(BufferedImage bufferedImage){
        Graphics2D g = (Graphics2D) bufferedImage.getGraphics();
        g.rotate(Math.toRadians(anpha), 385, 134);
        g.drawImage(this.imageDay, 385, 134, 2, this.positionY - 134, null);
        g.drawImage(image, 320, this.positionY, null);
    }

    public void anDa(ArrayList<Da> listDa){
        Rectangle myMoc = new Rectangle(this.positionX, y, this.image.getWidth(), this.image.getHeight());
        Rectangle myDa;
        for(Da currentDa: listDa){
            myDa = new Rectangle(currentDa.positionX, currentDa.positionY, currentDa.image.getWidth(),
                    currentDa.image.getHeight());
            if(myMoc.intersects(myDa)){
                    this.speedY = -1;
                    try {
                        this.image = ImageIO.read(new File("Resources/gapda_1.png"));
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                keoVe = true;
                currentDa.biKeo = true;
                tongDiem += currentDa.score;
            }
        }
    }

    public void anPig(ArrayList<Pig> listPig){
        Rectangle myMoc = new Rectangle(this.positionX, y, this.image.getWidth(), this.image.getHeight());
        Rectangle myDo;
        for(Pig currentThing :listPig){
            myDo = new Rectangle(currentThing.positionX, currentThing.positionY, this.image.getWidth(),
                    this.image.getHeight());
            if(myMoc.intersects(myDo)){
                if(listPig == listPig){
                    this.speedY = -3;
                    try {
                        this.image = ImageIO.read(new File("Resources/gappig.png"));
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
                keoVe = true;
                currentThing.biKeo = true;
                tongDiem += currentThing.score;
            }
        }
    }

    public void anVang(ArrayList<Gold> listGold){
        Rectangle myMoc = new Rectangle(this.positionX, y, this.image.getWidth(), this.image.getHeight());
        Rectangle myGold;
        for(Gold currentThing : listGold){
            myGold = new Rectangle(currentThing.positionX, currentThing.positionY, currentThing.image.getWidth(),
                    currentThing.image.getHeight());
            if(myMoc.intersects(myGold)){
                    try {
                        switch (currentThing.type) {
                            case 1:
                                this.speedY = -1;
                                this.image = ImageIO.read(new File("Resources/gapvang_1.png"));
                                break;
                            case 3:
                                this.speedY = -2;
                                this.image = ImageIO.read(new File("Resources/gapvang_3.png"));
                                break;
                            case 4:
                                this.speedY = -3;
                                this.image = ImageIO.read(new File("Resources/gapvang_4.png"));
                                break;
                        }
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                keoVe = true;
                currentThing.biKeo = true;
                tongDiem += currentThing.score;
            }
        }
    }

    public void anTnt(ArrayList<Tnt> listTnt, ArrayList<Tnt> myListTnt){
        Rectangle myMoc = new Rectangle(this.positionX, y, this.image.getWidth(), this.image.getHeight());

        Rectangle myTnt;
        for(Tnt currentTnt : listTnt){
            myTnt = new Rectangle(currentTnt.positionX, currentTnt.positionY, this.image.getWidth(), this.image.getHeight());
            if(myMoc.intersects(myTnt)){
                currentTnt.biKeo = true;
                this.speedY = -3;
                keoVe = true;
                try {
                    this.image = ImageIO.read(new File("Resources/gaptnt.png"));
                    currentTnt.positionX = 500;
                    currentTnt.positionY = 100;
                    myListTnt.add(currentTnt);
                    myListTnt.add(currentTnt);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public void update(){
        this.positionY += speedY;
        double d1 = Math.cos(Math.toRadians(anpha));
        double d = Math.sin(Math.toRadians(anpha));
        y = ((int) ((positionY - 134)*d1)) + 134;
        this.positionX  = -((int) ((positionY - 134)*d)) + 350;
        if(this.positionY <= 134){
            speedY = 0;
            speedX = 0;
            this.positionX = 350;
            this.positionY = 134;
            try {
                this.image = ImageIO.read(new File("Resources/moc.png"));
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        if(this.positionY >= 600){
            keoVe = true;
            speedY = -3;
            this.speedX = (int) (this.speedY*d);
        }
        if(this.positionX == 350 && this.positionY == 134){
            if(anpha == 60){
                anphaPlus = -1;
            } else if(anpha == -60){
                anphaPlus = 1;
            }
            anpha += anphaPlus;
        }
    }
}