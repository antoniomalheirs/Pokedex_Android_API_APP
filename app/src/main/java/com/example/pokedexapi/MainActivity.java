package com.example.pokedexapi;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.viewpager.widget.ViewPager;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import com.google.android.material.navigation.NavigationView;
import com.google.android.material.floatingactionbutton.FloatingActionButton; // Importe a classe FloatingActionButton

public class MainActivity extends AppCompatActivity {

    public ViewPager viewPager;
    private CarrosselPAdapter pagerAdapter;

    private DrawerLayout drawerLayout;
    private FloatingActionButton fabOpenNavigation; // Declare o FloatingActionButton

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        viewPager = findViewById(R.id.view_pagerP);
        pagerAdapter = new CarrosselPAdapter(this);

        CarrosselScroller autoScroll = new CarrosselScroller(this, viewPager);
        autoScroll.startAutoScroll();

        viewPager.setAdapter(pagerAdapter);

        drawerLayout = findViewById(R.id.drawer_layout);
        fabOpenNavigation = findViewById(R.id.fab_open_navigation); // Inicialize o FloatingActionButton

        fabOpenNavigation.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Ao clicar no botão, abra o NavigationView
                if (!drawerLayout.isDrawerOpen(GravityCompat.START)) {
                    drawerLayout.openDrawer(GravityCompat.START);
                }
            }
        });

        viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            private boolean userInteracted = false;
            private int lastUserInteractionPosition = 0;

            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
                // Este método é chamado enquanto o usuário está deslizando
                userInteracted = true;
            }

            @Override
            public void onPageSelected(int position) {
                // Este método é chamado quando o usuário seleciona uma página
                lastUserInteractionPosition = position;
                userInteracted = true;
                autoScroll.stopAutoScroll();
            }

            @Override
            public void onPageScrollStateChanged(int state) {
                // Este método é chamado quando o estado de rolagem do ViewPager muda
                if (state == ViewPager.SCROLL_STATE_IDLE) {
                    if (userInteracted) {
                        int currentPosition = viewPager.getCurrentItem();
                        autoScroll.setCurrentPage(currentPosition);
                        autoScroll.startAutoScroll();
                    } else {
                        autoScroll.startAutoScroll();
                    }
                    userInteracted = false;
                }
            }
        });

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

            DrawerLayout drawer = findViewById(R.id.drawer_layout);// ... (seu código de manipulação dos itens do NavigationView)

            drawerLayout.closeDrawer(GravityCompat.START);
            return true;
        });
    }
}
