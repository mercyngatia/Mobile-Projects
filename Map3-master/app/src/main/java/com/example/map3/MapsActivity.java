package com.example.map3;

import androidx.fragment.app.FragmentActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.widget.Toast;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.Circle;
import com.google.android.gms.maps.model.CircleOptions;
import com.google.android.gms.maps.model.Dash;
import com.google.android.gms.maps.model.Dot;
import com.google.android.gms.maps.model.Gap;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.android.gms.maps.model.PatternItem;
import com.google.android.gms.maps.model.Polyline;
import com.google.android.gms.maps.model.PolylineOptions;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.List;

public class MapsActivity extends FragmentActivity implements OnMapReadyCallback{

    private GoogleMap mMap;
    private Marker marker;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps);
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
    }

    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;

        // Add a marker in Sydney and move the camera
        LatLng m1 = new LatLng(20 , 40);
        LatLng m2 = new LatLng(25 , 45);
        LatLng m3 = new LatLng(30 , 50);
        LatLng m4 = new LatLng(45 , 55);
        LatLng m5 = new LatLng(60 , 90);


        marker = mMap.addMarker(new MarkerOptions()
                .position(m1)
                .draggable(true)
                .title("My location")
                .snippet("Lat")
        );

        //List
        List<PatternItem> pattern = Arrays.asList(
                new Dot() ,
                new Gap(10),
                new Dash(50)

        );

        //Polyline
        PolylineOptions opt = new PolylineOptions()
                .add(m1)
                .add(m2)
                .add(m3)
                .add(m4)
                .add(m5);

        //Polyline
        Polyline p = mMap.addPolyline(opt); //by default

        p.setPattern(pattern);


        //Circle
//        CircleOptions circlen = new CircleOptions()
//                .center(m1)
//                .radius(10000); //in meters
//
//        //Get back the mutable circle
//        Circle circle = mMap.addCircle(circlen);
//        circle.setStrokeColor(Color.BLUE);

//        //Polyline
//        PolylineOptions recOption = new PolylineOptions()
//                .add(m1)
//                .add(m2)
//                .add(m3)
//                .add(m4)
//                .add(m5);
//
//        Polyline polyline = mMap.addPolyline(recOption);

      mMap.moveCamera(CameraUpdateFactory.newLatLng(m1));
    }

}