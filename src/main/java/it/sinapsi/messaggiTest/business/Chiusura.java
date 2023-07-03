package it.sinapsi.messaggiTest.business;

import java.util.Timer;
import java.util.TimerTask;

public class Chiusura extends TimerTask {
    private Timer timer;
    public Chiusura(Timer timer){
        this.timer = timer;
    }

    @Override
    public void run() {
        timer.cancel();
    }
}
