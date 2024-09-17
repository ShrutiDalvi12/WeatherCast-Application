package com.example.myapplication123;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
import com.example.myapplication123.databinding.ActivityMainBinding;

import org.json.JSONException;
import org.json.JSONObject;


public class MainActivity extends AppCompatActivity {

    private DrawerLayout mdrawlayout;
    private ActionBarDrawerToggle mtoggle;


    ActivityMainBinding binding;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        replaceFragment(new TemperatureFragment());

        binding.bottomnavigationView.setOnItemSelectedListener(item -> {

            switch (item.getItemId()) {
                case R.id.bottom_nav_temp:
                    replaceFragment(new TemperatureFragment());
                    break;

                case R.id.bottom_nav_aqi:
                    replaceFragment(new AqiFragment());
                    break;

                case R.id.bottom_nav_windspeed:
                    replaceFragment(new WindSpeedFragment());
                    break;

                case R.id.bottom_nav_uvi:
                    replaceFragment(new UviFragment());
                    break;

                case R.id.bottom_nav_humidity:
                    replaceFragment(new HumidityFragment());
                    break;
            }
            return true;
        });

        mdrawlayout = findViewById(R.id.drawer_layout);
        mtoggle = new ActionBarDrawerToggle(this, mdrawlayout, R.string.open, R.string.close);

        mdrawlayout.addDrawerListener(mtoggle);
        mtoggle.syncState();
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

    }

    public  void replaceFragment(Fragment fragment) {

        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.fragment_layout,fragment);
        fragmentTransaction.commit();

    }

    public boolean onOptionsItemSelected(@NonNull MenuItem item) {

        if(mtoggle.onOptionsItemSelected(item)){
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

}
