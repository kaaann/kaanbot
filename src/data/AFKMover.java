package data;

import com.github.theholywaffle.teamspeak3.api.wrapper.Client;

import java.util.HashMap;
import java.util.Timer;
import java.util.TimerTask;

/**
 * Created by Kaan on 02.01.2018.
 */
public class AFKMover {


    public static HashMap<String, Long> AFK = new HashMap<>();
    public static HashMap<String, Boolean> Moved = new HashMap<>();
    public static HashMap<String, Integer> Channel= new HashMap<>();
    public static int Away = 1000;



    public static void start() {

        for(Client c : Data.api.getClients()) {

            if(c.isAway() || c.isInputMuted() || c.isOutputMuted()) {
                Data.api.sendPrivateMessage(c.getId(), "Du wirst in einigen Minuten in den [B][color=orange]AFK Bereich[/color][/B] verschoben!");

            }
        }


        Timer timer = new Timer();
        timer.schedule(new TimerTask() {

            @Override
            public void run() {
                for(Client c : Data.api.getClients()) {
                    if(!(c.isServerQueryClient())) {
                        if(c.isAway() || c.isInputMuted() || c.isOutputMuted()) {
                            if (!(AFK.containsKey(c.getUniqueIdentifier()))) {
                                if (!(AFK.containsKey(c.getUniqueIdentifier()))) {
                                    AFK.put(c.getUniqueIdentifier(), System.currentTimeMillis());
                                }else{
                                    long current = AFK.get(c.getUniqueIdentifier());
                                    if((System.currentTimeMillis() - current) >= Away) {
                                        Moved.put(c.getUniqueIdentifier(), true);
                                        Channel.put(c.getUniqueIdentifier(), c.getChannelId());
                                        AFK.remove(c.getUniqueIdentifier());
                                        Data.api.sendPrivateMessage(c.getId(), "Du wurdest in den [B][color=orange]AFK-Bereich[/B][/color] verschoben!");
                                        Data.api.moveClient(c.getId(), 3);                                    
                                    }
                                }
                            }else{
                                if (!(AFK.containsKey(c.getUniqueIdentifier()))) {
                                    AFK.remove(c.getUniqueIdentifier());
                                }
                                if(Moved.containsKey(c.getUniqueIdentifier())) {
                                    if(Moved.get(c.getUniqueIdentifier())){
                                        Data.api.moveClient(c.getId(), Channel.get(c.getUniqueIdentifier()));
                                        Moved.remove(c.getUniqueIdentifier());
                                        Channel.remove(c.getUniqueIdentifier());
                                    }

                                }
                            }

                        }
                    }



                }
            }
        }, 1000 , 5000);
    }

}


