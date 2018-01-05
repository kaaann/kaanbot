package data;

import com.github.theholywaffle.teamspeak3.TS3Api;
import com.github.theholywaffle.teamspeak3.TS3Config;
import com.github.theholywaffle.teamspeak3.TS3Query;

/**
 * Created by Kaan on 02.01.2018.
 */
public class Data {

    public static TS3Config config = new TS3Config();
    public static TS3Query query = new TS3Query(config);
    public static TS3Api api = query.getApi();


}
