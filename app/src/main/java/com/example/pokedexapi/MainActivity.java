package com.example.pokedexapi;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.viewpager.widget.ViewPager;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.text.InputType;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.google.android.material.navigation.NavigationView;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class MainActivity extends AppCompatActivity {

    public ViewPager viewPager;
    private CarrosselPAdapter pagerAdapter;
    private DrawerLayout drawerLayout;
    private FloatingActionButton fabOpenNavigation;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btnSearch = findViewById(R.id.btnSearch);

        btnSearch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showSearchDialog();
            }
        });

        viewPager = findViewById(R.id.view_pagerP);
        pagerAdapter = new CarrosselPAdapter(this);

        CarrosselScroller autoScroll = new CarrosselScroller(this, viewPager);
        autoScroll.startAutoScroll();

        viewPager.setAdapter(pagerAdapter);

        drawerLayout = findViewById(R.id.drawer_layout);
        fabOpenNavigation = findViewById(R.id.fab_open_navigation);

        fabOpenNavigation.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
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
                userInteracted = true;
            }

            @Override
            public void onPageSelected(int position) {
                lastUserInteractionPosition = position;
                userInteracted = true;
                autoScroll.stopAutoScroll();
            }

            @Override
            public void onPageScrollStateChanged(int state) {
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

            if (R.id.n1th == itemId) {
                Intent intent = new Intent(this, generation1.class);
                startActivity(intent);
            } else if (R.id.n2th == itemId) {
                Intent intent = new Intent(this, generation2.class);
                startActivity(intent);
            } else if (R.id.n3th == itemId) {
                Intent intent = new Intent(this, generation3.class);
                startActivity(intent);
            } else if (R.id.n4th == itemId) {
                Intent intent = new Intent(this, generation4.class);
                startActivity(intent);
            } else if (R.id.n5th == itemId) {
                Intent intent = new Intent(this, generation5.class);
                startActivity(intent);
            } else if (R.id.n6th == itemId) {
                Intent intent = new Intent(this, generation6.class);
                startActivity(intent);
            } else if (R.id.n7th == itemId) {
                Intent intent = new Intent(this, generation7.class);
                startActivity(intent);
            } else if (R.id.n8th == itemId) {
                Intent intent = new Intent(this, generation8.class);
                startActivity(intent);
            }

            drawerLayout.closeDrawer(GravityCompat.START);
            return true;
        });
    }

    private void showSearchDialog() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Buscar Pokémon");
        final EditText input = new EditText(this);
        input.setInputType(InputType.TYPE_CLASS_TEXT);
        builder.setView(input);

        builder.setPositiveButton("Buscar", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                String searchQuery = input.getText().toString();
                // Aqui você deve implementar a lógica de pesquisa com base em 'searchQuery'
                // e abrir a atividade de detalhes com os dados do Pokémon pesquisado
                openPokemonDetailActivity(searchQuery);
            }
        });

        builder.setNegativeButton("Cancelar", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.cancel();
            }
        });

        builder.show();
    }

    private void openPokemonDetailActivity(String searchQuery) {
        // Aqui você deve implementar a lógica para obter os detalhes do Pokémon
        // com base na pesquisa 'searchQuery' e abrir a atividade de detalhes.
        // Por enquanto, vou abrir uma atividade de detalhes de exemplo.
        Intent intent = new Intent(this, PokemonDetalhes.class);
        intent.putExtra("name", searchQuery);
        startActivity(intent);
    }
}
