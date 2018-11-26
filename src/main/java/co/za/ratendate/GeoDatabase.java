package co.za.ratendate;

import com.maxmind.geoip.LookupService;

import java.io.IOException;

public class GeoDatabase {
    private static GeoDatabase dbInstance = new GeoDatabase();
    LookupService lookupService;
    public static synchronized GeoDatabase getInstance() {
        if(dbInstance ==null) {

             dbInstance = new GeoDatabase();
        }
        return dbInstance;
    }

    private GeoDatabase() {
        if (lookupService == null) {
            try {

                lookupService = new LookupService("GeoIP.dat");
            } catch (IOException ioe) {
                System.out.println(ioe);
            }
        }
    }

}
