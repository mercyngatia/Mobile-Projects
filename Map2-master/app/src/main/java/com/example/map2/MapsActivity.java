package com.example.map2;

import androidx.fragment.app.FragmentActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.widget.Toast;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.android.gms.maps.model.Polygon;
import com.google.android.gms.maps.model.PolygonOptions;
import com.google.android.gms.maps.model.Polyline;
import com.google.android.gms.maps.model.PolylineOptions;

import java.util.ArrayList;

public class MapsActivity extends FragmentActivity implements OnMapReadyCallback{
      //  GoogleMap.OnInfoWindowClickListener{
        // GoogleMap.OnMapClickListener {

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
        LatLng m1 = new LatLng(-20 , -20);
        LatLng m2 = new LatLng(20 , -20);
        LatLng m3 = new LatLng(20 , 20);
        LatLng m4 = new LatLng(-20 , 20);

        LatLng m6 = new LatLng(0, 0);
        LatLng m7 = new LatLng(5, 0);
        LatLng m8 = new LatLng(5, 5);
        LatLng m9 = new LatLng(0, 5);

        marker = mMap.addMarker(new MarkerOptions()
                .position(m1)
                .draggable(true)
                .title("My location")
              //  .snippet("Lat: 20 Lng: 40")
                .snippet("Lat")
        );
        //Polyline
     //   PolylineOptions recOption = new PolylineOptions()

        //Arraylist
        ArrayList<LatLng> latyn = new ArrayList<>();
        latyn.add(m6);
        latyn.add(m7);
        latyn.add(m8);
        latyn.add(m9);

        PolygonOptions recOption = new PolygonOptions()
                .add(m1, m2, m3, m4)
//                .add(m2)
//                .add(m3)
//                .add(m4)
//                .add(m5)
                .addHole(latyn)
                .fillColor(Color.BLACK)
                .strokeColor(Color.RED);
//                .color(R.color.design_default_color_primary_dark)
//                .width(10)

//               Polyline polyline = mMap.addPolyline(recOption);


        //Get back the mutable polygon
        Polygon polygon = mMap.addPolygon(recOption);

        mMap.moveCamera(CameraUpdateFactory.newLatLng(m1));
    }
        //mMap.setOnInfoWindowClickListener(this);

        //  mMap.addMarker(new MarkerOptions().position(m1).title("Welcome here"));
       // mMap.moveCamera(CameraUpdateFactory.newLatLng(m1));
    }
//    @Override
//    public void onInfoWindowClick(Marker marker) {
//        Toast.makeText(this, "Info window is clicked",
//                Toast.LENGTH_LONG).show();
//
//    }

//    @Override
//    public void onMapClick(LatLng latLng) {
//        //When map is clicked
//        Toast.makeText(this, "Map is clicked", Toast.LENGTH_LONG).show();
//
//    }



//    @Override
//    public void onMarkerDragStart(Marker marker) {
//
//    }
//
//    @Override
//    public void onMarkerDrag(Marker marker) {
//
//    }
//
//    @Override
//    public void onMarkerDragEnd(Marker marker) {
//        //Getting the new position lat and lng
//        Toast.makeText(this, "lat:" + marker.getPosition().latitude
//                + "\nlng: " +marker.getPosition().longitude,
//        Toast.LENGTH_SHORT).show();
//
//    }

//    @Override
  //  public boolean onMarkerClick(Marker marker) {

   //     Toast.makeText(this, "My Latitude position: "+ marker.getPosition().latitude,
    //           Toast.LENGTH_LONG).show();

    //      return false;
   // }
