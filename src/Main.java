import event.DotEvent;
import event.SuperDotEvent;
import logic.*;
import model.*;
import model.Point;
import util.*;
import util.Window;

import java.awt.*;
import java.util.HashMap;
import java.util.Map;
import java.util.Timer;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        Game game = new Game();
        StartWindow startWindow = new StartWindow(game);
        String text;

        if (game.startGame()) text = "You win!";
        else text = "You lose!";
        EndWindow endWindow = new EndWindow(text);
    }
}