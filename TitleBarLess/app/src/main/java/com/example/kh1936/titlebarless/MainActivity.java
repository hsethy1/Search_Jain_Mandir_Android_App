package com.example.kh1936.titlebarless;

import android.os.Bundle;
import android.app.Activity;
import android.content.Context;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.widget.TextView;

import android.util.Log;

import java.util.List;

public class MainActivity extends Activity implements LocationListener{
    protected LocationManager locationManager;
    protected LocationListener locationListener;
    protected Context context;
    TextView txtLat;
    String lat;
    String provider;
    protected String latitude,longitude;
    protected boolean gps_enabled,network_enabled;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        txtLat = (TextView) findViewById(R.id.textview1);
        Location location;
        locationManager = (LocationManager) getSystemService(Context.LOCATION_SERVICE);
        locationManager.requestLocationUpdates(LocationManager.GPS_PROVIDER, 60, 500, this);
        Log.d("GPS Enabled", "GPS Enabled");
       // location.setLatitude(17.37201);
       // location.setAltitude(78.444893);
        location = locationManager.getLastKnownLocation(LocationManager.GPS_PROVIDER);
            if (location != null) {
                txtLat = (TextView) findViewById(R.id.textview1);
                txtLat.setText("Latitude:" + location.getLatitude() + ", Longitude:" + location.getLongitude());
            }
    }
    @Override
    public void onLocationChanged(Location location) {
        //List<Location> locList = null;
        Location tempLoc = new Location(LocationManager.GPS_PROVIDER);
        tempLoc.setLatitude(17.37201);
        tempLoc.setLongitude(78.444893);
        //locList.add(tempLoc);
        tempLoc.setLatitude(17.493860);
        tempLoc.setLongitude(78.351384);
        //locList.add(tempLoc);
        tempLoc.setLatitude(17.48771781);
        tempLoc.setLongitude(78.35893584);
        tempLoc.setLatitude(17.432523);
        tempLoc.setLongitude(78.407015);
        //locList.add(tempLoc);
        float distanceInMeters = tempLoc.distanceTo(location);
        txtLat = (TextView) findViewById(R.id.textview1);
    //    txtLat.setText("Latitude:" + location.getLatitude() + ", Longitude:" + location.getLongitude());
  //      double loc[][] ={{17.484217,78.389467},{17.486709,78.358714},{17.485379,78.360178},{17.484018,78.360983},{17.483527,78.363810},{17.482734,78.367340},{17.481852,78.372838},{17.480030,78.376282},{17.475687,78.380864}};
       // txtLat.setText("Karwaan Mandir distanec="+distanceInMeters+" location Latitude:" + location.getLatitude() + ", Longitude:" + location.getLongitude()+"distance"+distance(location.getLatitude(),17.37201,location.getLongitude(),78.444893,'K'));
     //   if(distance(location.getLatitude(),17.37201,location.getLongitude(),78.444893,'K')<=0.01){
     //       txtLat.setText("Karwaan Mandir "+distance(location.getLatitude(),17.37201,location.getLongitude(),78.444893,'K')+" location Latitude:" + location.getLatitude() + ", Longitude:" + location.getLongitude());
     //   }
        txtLat.setText("distance "+distanceInMeters+"from Current Location Latitude:" + location.getLatitude() + ", Longitude:" + location.getLongitude()+"to destination DADUS");
        if((int)distanceInMeters<=100){
            txtLat.setText("Allwyn location Latitude:" + location.getLatitude() + ", Longitude:" + location.getLongitude());
        }
     /*   for(int i=0;i<locList.size();i++){
            distanceInMeters =  tempLoc.distanceTo(locList.get(i));
            txtLat.setText("Current Location Latitude:" + location.getLatitude() + ", Longitude:" + location.getLongitude());
            if((int)distanceInMeters<=100){
                txtLat.setText("Allwyn location"+i+" Latitude:" + location.getLatitude() + ", Longitude:" + location.getLongitude());
            }
        }*/

    }

    @Override
    public void onProviderDisabled(String provider) {
        Log.d("Latitude","disable");
    }

    @Override
    public void onProviderEnabled(String provider) {
        Log.d("Latitude","enable");
    }

    @Override
    public void onStatusChanged(String provider, int status, Bundle extras) {
        Log.d("Latitude","status");
    }

 /*   private double distance(double lat1, double lon1, double lat2, double lon2, char unit) {
        double theta = lon1 - lon2;
        double dist = Math.sin(deg2rad(lat1)) * Math.sin(deg2rad(lat2)) + Math.cos(deg2rad(lat1)) * Math.cos(deg2rad(lat2)) * Math.cos(deg2rad(theta));
        dist = Math.acos(dist);
        dist = rad2deg(dist);
        dist = dist * 60 * 1.1515;
        if (unit == 'K') {
            dist = dist * 1.609344;
        } else if (unit == 'N') {
            dist = dist * 0.8684;
        }
        return (dist);
    }

    /*:::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::*/
/*::  This function converts decimal degrees to radians             :*/
/*:::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::*/
    private double deg2rad(double deg) {
        return (deg * Math.PI / 180.0);
    }

    /*:::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::*/
/*::  This function converts radians to decimal degrees             :*/
/*:::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::*/
    private double rad2deg(double rad) {
        return (rad * 180 / Math.PI);
    }
   /* public double distance(double lat1, double initialLong,
                                        double lat2, double finalLong, char unit){
        int R = 6371; // km
        double dLat = toRadians(lat1-lat1);
        double dLon = toRadians(finalLong-initialLong);
        lat1 = toRadians(lat1);
        lat2 = toRadians(lat2);

        double a = Math.sin(dLat/2) * Math.sin(dLat/2) +
                Math.sin(dLon/2) * Math.sin(dLon/2) * Math.cos(lat1) * Math.cos(lat2);
        double c = 2 * Math.atan2(Math.sqrt(a), Math.sqrt(1-a));
        return R * c;
    }

    public double toRadians(double deg) {
        return deg * (Math.PI/180);
    }*/
}