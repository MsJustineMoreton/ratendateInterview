package co.za.ratendate;

import com.maxmind.geoip.Country;

import javax.jws.WebMethod;
import javax.jws.WebService;

public class Main {

    public static void main(String[] args) {
        GeoService geoService = new GeoService();
        System.out.println(geoService.getCountryName("151.38.39.114"));
        System.out.println(geoService.getCountryCode("12.25.205.51"));
        System.out.println(geoService.getCountryName("64.81.104.131"));
        System.out.println(geoService.getCountryCode("12.25.205.51"));

    }
    @WebService
    public static class GeoService {
        @WebMethod
        public String getCountryName(String ipNumber){
            GeoDatabase geoDatabase=GeoDatabase.getInstance();
            Country country = geoDatabase.lookupService.getCountry(ipNumber);
            return "The country is: " + country.getName();
        }
        @WebMethod
        public String getCountryCode(String ipNumber){
            GeoDatabase geoDatabase=GeoDatabase.getInstance();
            Country country = geoDatabase.lookupService.getCountry(ipNumber);
            return "The country is: " + country.getCode();
        }

    }
}
