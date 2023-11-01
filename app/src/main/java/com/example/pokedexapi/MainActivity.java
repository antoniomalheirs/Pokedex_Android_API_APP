package com.example.pokedexapi;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.viewpager.widget.ViewPager;


import android.content.Intent;
import android.os.Bundle;

import com.google.android.material.navigation.NavigationView;

public class MainActivity extends AppCompatActivity {

    public ViewPager viewPager;
    private CarrosselPAdapter pagerAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        viewPager = findViewById(R.id.view_pagerP);
        pagerAdapter = new CarrosselPAdapter(this);

        CarrosselScroller autoScroll = new CarrosselScroller(this, viewPager); // Substitua 'this' pelo contexto apropriado
        autoScroll.startAutoScroll();


        viewPager.setAdapter(pagerAdapter);

        NavigationView navigationView = findViewById(R.id.navigation_view);
        navigationView.setNavigationItemSelectedListener(item -> {
            int itemId = item.getItemId();

            if (R.id.n1th == itemId)
            {
                Intent intent = new Intent(this, generation1.class);
                startActivity(intent);
            }
            else if (R.id.n2th == itemId)
            {
                Intent intent = new Intent(this, generation2.class);
                startActivity(intent);
            }
            else if (R.id.n3th == itemId)
            {
                Intent intent = new Intent(this, generation3.class);
                startActivity(intent);
            }
            else if (R.id.n4th == itemId)
            {
                Intent intent = new Intent(this, generation4.class);
                startActivity(intent);
            }
            else if (R.id.n5th == itemId)
            {
                Intent intent = new Intent(this, generation5.class);
                startActivity(intent);
            }
            else if (R.id.n6th == itemId)
            {
                Intent intent = new Intent(this, generation6.class);
                startActivity(intent);
            }
            else if (R.id.n7th == itemId)
            {
                Intent intent = new Intent(this, generation7.class);
                startActivity(intent);
            }
            else if (R.id.n8th == itemId)
            {
                Intent intent = new Intent(this, generation8.class);
                startActivity(intent);
            }

            DrawerLayout drawer = findViewById(R.id.drawer_layout);
            drawer.closeDrawer(GravityCompat.START);
            return true;
        });
    }

}