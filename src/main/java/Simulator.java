import logic.Game;

public class Simulator {

    public static void main(String[] args) {
        System.out.println("You can use `mvn package; java -jar target/ants-1.0.jar` to run this app from the console");
        Game game = new Game();
        game.start();


    }



}
