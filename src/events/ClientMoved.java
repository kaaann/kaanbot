package events;

import com.github.theholywaffle.teamspeak3.api.event.ClientMovedEvent;
import com.github.theholywaffle.teamspeak3.api.event.TS3EventAdapter;
import com.github.theholywaffle.teamspeak3.api.wrapper.Client;
import data.Data;

import java.util.ArrayList;

/**
 * Created by Kaan on 02.01.2018.
 */
public class ClientMoved {

    public static void loadEvent(){

        Data.api.addTS3Listeners(new TS3EventAdapter() {
            @Override
            public void onClientMoved(ClientMovedEvent e) {

                if(e.getTargetChannelId() == 25){


                    ArrayList<String>teammember = new ArrayList<String>();



                    for (Client c : Data.api.getClients()) {
                        if (c.isInServerGroup(12)) {                                                        

                            teammember.add(c.toString());

                            Data.api.sendPrivateMessage(c.getId(), "Es ist jemand im [color=orange]Support-Bereich[/color]!");


                        }else if(c.getChannelId() == 25){

                            int x  = teammember.size() + 1;

                            Data.api.sendPrivateMessage(c.getId(), "Es sind " + x + " Supporter online, um dir zu helfen");

                        }

                    }


                }


                if(Data.api.getClientById(e.getClientId()))


            }
        });
    }
}
