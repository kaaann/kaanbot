package cmds;

import com.github.theholywaffle.teamspeak3.api.event.TS3EventAdapter;
import com.github.theholywaffle.teamspeak3.api.event.TextMessageEvent;
import com.github.theholywaffle.teamspeak3.api.wrapper.Client;
import data.Data;

/**
 * Created by Kaan on 02.01.2018.
 */
public class NoPoke {

    public static void loadCMD(){

        Data.api.addTS3Listeners(new TS3EventAdapter() {
            @Override
            public void onTextMessage(TextMessageEvent e) {

                Client c = Data.api.getClientByUId(e.getInvokerUniqueId());

                if(e.getMessage().startsWith("!nopoke")) {

                    if (!c.isInServerGroup(10)) {                                                                 //NoPoke ID
                        Data.api.addClientToServerGroup(10, c.getDatabaseId());                                      //NoPoke ID
                        Data.api.sendPrivateMessage(c.getId(), "Du wurdest zur Servergruppe [color=red]NoPoke[/color]hinzugefügt!");
                        //NoPoke ID
                    } else if (c.isInServerGroup(10)) {                                                           //NoPoke ID
                        Data.api.removeClientFromServerGroup(10, c.getDatabaseId());                            //NoPoke ID
                        Data.api.sendPrivateMessage(c.getId(), "Du wurdest von der Servergruppe [color=red]NoPoke[/color]entfernt!");
                    }
                }

            }
        });


    }

}
