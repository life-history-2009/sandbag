package jp.azumis.sandbag;

import java.util.Date;

/**
 * Singletonクラスへアクセスするスレッドクラス
 * アクセス間のインターバルを異なるよう設定可能
 * @author hanamura.shinsuke
 *
 */
public class RobotThread extends Thread{
    private Singleton singleton;

    private String name;

    /**
     * インターバル(ミリ秒)。既定値:1000ミリ秒
     */
    private int interval = 1000;

    private boolean returnFlag;

    private boolean running = false;


    public void init(String name, int interval) {
        this.name = name;
        this.interval = interval;
    }

    public void run() {
        this.running = true;
        while(this.running){
            addDate();
            try {
                sleep(this.interval);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
    
    private void addDate() {
        String dataToAdd = "added by [" + name + "]" + Singleton.DATE_FORMAT.format(new Date());
        singleton = Singleton.getInstance();
        singleton.addData(dataToAdd);
        
    }

    public void stopThread() {
        System.out.println("[" + name + "] is going to stop");
        this.running = false;
    }
}
