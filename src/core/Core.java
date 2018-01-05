package core;
import cmds.NoMessage;
import cmds.NoPoke;
import com.github.theholywaffle.teamspeak3.TS3Query;
import data.AFKMover;
import data.Data;
import events.ClientJoin;
import events.ClientMoved;


public class Core {


    public static void main(String[] args) {

        Data.config.setHost("176.31.152.4");
        Data.config.setFloodRate(TS3Query.FloodRate.DEFAULT);
        Data.query.connect();
        Data.api.login("Bot", "IohxK7BM");
        Data.api.selectVirtualServerById(1);
        Data.api.setNickname("ExactBot");

        Data.api.registerAllEvents();

        //events
        ClientJoin.loadEvent();
        ClientMoved.loadEvent();

        //cmds
        NoPoke.loadCMD();
        NoMessage.loadCMD();

    }
}
