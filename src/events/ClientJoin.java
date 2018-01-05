package events;

import com.github.theholywaffle.teamspeak3.api.event.ClientJoinEvent;
import com.github.theholywaffle.teamspeak3.api.event.TS3EventAdapter;
import data.Data;

/**
 * Created by Kaan on 02.01.2018.
 */
public class ClientJoin {

    public static void loadEvent(){

        Data.api.addTS3Listeners(new TS3EventAdapter() {

            @Override
            public void onClientJoin(ClientJoinEvent e) {

                String clientname = e.getClientNickname();

                Data.api.sendPrivateMessage(e.getClientId(), "Willkommen auf [color=orange]TeamExact[/color][B] " + clientname + "[/B]!");
                Data.api.sendPrivateMessage(e.getClientId(), "Befehle:");
                Data.api.sendPrivateMessage(e.getClientId(), "[color=red]!nopoke[/color]  //nicht mehr anstupsbar | anstupsbar");
                Data.api.sendPrivateMessage(e.getClientId(), "[color=red]!nomessage[/color]  //nicht mehr anschreibbar | anschreibbar");


            }
        });


    }

}
