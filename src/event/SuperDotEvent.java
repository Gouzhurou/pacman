package event;

import logic.GhostController;
import logic.PacmanController;

import java.awt.*;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.ScheduledExecutorService;

public class SuperDotEvent extends TimerTask implements Event {
    private PacmanController pacmanController;
    private GhostController[] ghostControllers;
    public static final int DELAY_IN_SECONDS = 10;
    private static int countActiveDots;
    private Timer timer;
    public static final int SUPER_SPEED = 500;
    public SuperDotEvent(PacmanController pacmanController, Timer timer, GhostController[] ghostControllers){
        this.pacmanController = pacmanController;
        this.ghostControllers = ghostControllers;
        this.timer = timer;
        countActiveDots = 0;
    }
    @Override
    public void event() {
        if (countActiveDots == 0){
            pacmanController.setKillingAbility(true);
            pacmanController.getPacman().setSpeed(SUPER_SPEED);
            for (int i = 0; i < ghostControllers.length; i++) {
                ghostControllers[i].getGhost().setCurColor(Color.BLUE);
            }
        }
        timer.schedule(this, DELAY_IN_SECONDS * 1000);
        countActiveDots++;
    }

    @Override
    public void run(){
        if (countActiveDots == 1){
            pacmanController.getPacman().setNormalSpeed();
            pacmanController.setKillingAbility(false);
            for (int i = 0; i < ghostControllers.length; i++) {
                ghostControllers[i].getGhost().setNormalColor();
            }
        }
        countActiveDots--;
    }

}
