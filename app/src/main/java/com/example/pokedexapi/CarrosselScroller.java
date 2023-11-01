package com.example.pokedexapi;

import android.content.Context;
import android.os.Handler;
import android.os.Message;
import androidx.viewpager.widget.ViewPager;
import java.util.Timer;
import java.util.TimerTask;

public class CarrosselScroller {

    private ViewPager viewPager;
    private Timer timer;
    private int currentPage = 0;
    private final long DELAY_MS = 3000; // Delay inicial em milissegundos (3 segundos neste exemplo)
    private final long PERIOD_MS = 3000; // Intervalo de troca em milissegundos

    public CarrosselScroller(Context context, ViewPager viewPager) {
        this.viewPager = viewPager;
    }

    public void startAutoScroll() {
        if (timer != null) {
            timer.cancel();
        }
        timer = new Timer();
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                handler.sendEmptyMessage(0);
            }
        }, DELAY_MS, PERIOD_MS);
    }

    public void stopAutoScroll() {
        if (timer != null) {
            timer.cancel();
        }
    }

    public void setCurrentPage(int page) {
        currentPage = page;
    }

    private final Handler handler = new Handler(new Handler.Callback() {
        @Override
        public boolean handleMessage(Message msg) {
            if (currentPage == viewPager.getAdapter().getCount() - 1) {
                currentPage = 0;
            } else {
                currentPage++;
            }
            viewPager.setCurrentItem(currentPage, true);
            return true;
        }
    });
}






