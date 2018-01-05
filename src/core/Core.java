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

        Data.config.setHost("xxx");
        Data.config.setFloodRate(TS3Query.FloodRate.DEFAULT);
        Data.query.connect();
        Data.api.login("xxx", "xxx");
        Data.api.selectVirtualServerById(1);
        Data.api.setNickname("kaanbot");

        Data.api.registerAllEvents();

        //events
        ClientJoin.loadEvent();
        ClientMoved.loadEvent();

        //cmds
        NoPoke.loadCMD();
        NoMessage.loadCMD();

    }
}
