/**
 * Created by Hung Nguyen on 11/06/16.
 */
public class Main {
    public static void main(String[] args){
        Window window = new Window();
        Thread thread = new Thread(window);
        thread.start();

    }
}
