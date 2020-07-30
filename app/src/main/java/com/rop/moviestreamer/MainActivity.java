package com.rop.moviestreamer;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;

import com.google.android.material.tabs.TabLayout;
import com.rop.moviestreamer.adapter.BannerMoviesPagerAdapter;
import com.rop.moviestreamer.model.BannerMovies;

import java.util.ArrayList;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

public class MainActivity extends AppCompatActivity {

    BannerMoviesPagerAdapter bannerMoviesPagerAdapter;
    TabLayout tabCategory, tabIndicator;
    ViewPager bannerMoviesViewPager;
    List<BannerMovies> homeMoviesList;


    List<BannerMovies> tvShowBannerList;
    List<BannerMovies> movieBannerList;
    List<BannerMovies> kidsBannerList;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tabCategory = findViewById(R.id.tablayout);
        tabIndicator = findViewById(R.id.tab_indicator);

        // home banner list
        homeMoviesList = new ArrayList<>();
        homeMoviesList.add(new BannerMovies(1,"test","https://sm.ign.com/ign_es/screenshot/default/ironmanvr-blogroll-1554158268175_1ybb.jpg",""));
        homeMoviesList.add(new BannerMovies(2,"test","https://sm.ign.com/ign_es/screenshot/default/ironmanvr-blogroll-1554158268175_1ybb.jpg",""));
        homeMoviesList.add(new BannerMovies(3,"test","https://sm.ign.com/ign_es/screenshot/default/ironmanvr-blogroll-1554158268175_1ybb.jpg",""));
        homeMoviesList.add(new BannerMovies(4,"test","https://sm.ign.com/ign_es/screenshot/default/ironmanvr-blogroll-1554158268175_1ybb.jpg",""));
        homeMoviesList.add(new BannerMovies(5,"test","https://sm.ign.com/ign_es/screenshot/default/ironmanvr-blogroll-1554158268175_1ybb.jpg",""));

        // tv show banner list
        tvShowBannerList = new ArrayList<>();
        tvShowBannerList.add(new BannerMovies(1,"tv","https://www.ecestaticos.com/image/clipping/9a2f321f12e61373c26776bed0b50985/el-emotivo-homenaje-con-el-que-039-the-walking-dead-039-despide-a-uno-de-sus-protagonistas.jpg",""));
        tvShowBannerList.add(new BannerMovies(2,"tv","https://www.ecestaticos.com/image/clipping/9a2f321f12e61373c26776bed0b50985/el-emotivo-homenaje-con-el-que-039-the-walking-dead-039-despide-a-uno-de-sus-protagonistas.jpg",""));
        tvShowBannerList.add(new BannerMovies(3,"tv","https://www.ecestaticos.com/image/clipping/9a2f321f12e61373c26776bed0b50985/el-emotivo-homenaje-con-el-que-039-the-walking-dead-039-despide-a-uno-de-sus-protagonistas.jpg",""));
        tvShowBannerList.add(new BannerMovies(4,"tv","https://www.ecestaticos.com/image/clipping/9a2f321f12e61373c26776bed0b50985/el-emotivo-homenaje-con-el-que-039-the-walking-dead-039-despide-a-uno-de-sus-protagonistas.jpg",""));
        tvShowBannerList.add(new BannerMovies(5,"tv","https://www.ecestaticos.com/image/clipping/9a2f321f12e61373c26776bed0b50985/el-emotivo-homenaje-con-el-que-039-the-walking-dead-039-despide-a-uno-de-sus-protagonistas.jpg",""));
        // movie banner list
        movieBannerList = new ArrayList<>();
        movieBannerList.add(new BannerMovies(1,"movie","https://as.com/meristation/imagenes/2019/12/12/avances/1576175321_723620_1576327909_noticia_normal.jpg",""));
        movieBannerList.add(new BannerMovies(2,"movie","https://as.com/meristation/imagenes/2019/12/12/avances/1576175321_723620_1576327909_noticia_normal.jpg",""));
        movieBannerList.add(new BannerMovies(3,"movie","https://as.com/meristation/imagenes/2019/12/12/avances/1576175321_723620_1576327909_noticia_normal.jpg",""));
        movieBannerList.add(new BannerMovies(4,"movie","https://as.com/meristation/imagenes/2019/12/12/avances/1576175321_723620_1576327909_noticia_normal.jpg",""));
        movieBannerList.add(new BannerMovies(5,"movie","https://as.com/meristation/imagenes/2019/12/12/avances/1576175321_723620_1576327909_noticia_normal.jpg",""));
        //kids banner list
        kidsBannerList = new ArrayList<>();
        kidsBannerList.add(new BannerMovies(1,"movie","https://as.com/meristation/imagenes/2019/10/25/noticias/1572002941_916672_1572003064_noticia_normal.jpg",""));
        kidsBannerList.add(new BannerMovies(2,"movie","https://as.com/meristation/imagenes/2019/10/25/noticias/1572002941_916672_1572003064_noticia_normal.jpg",""));
        kidsBannerList.add(new BannerMovies(3,"movie","https://as.com/meristation/imagenes/2019/10/25/noticias/1572002941_916672_1572003064_noticia_normal.jpg",""));
        kidsBannerList.add(new BannerMovies(4,"movie","https://as.com/meristation/imagenes/2019/10/25/noticias/1572002941_916672_1572003064_noticia_normal.jpg",""));
        kidsBannerList.add(new BannerMovies(5,"movie","https://as.com/meristation/imagenes/2019/10/25/noticias/1572002941_916672_1572003064_noticia_normal.jpg",""));

        setBannerMoviesPagerAdapter(homeMoviesList);

        tabCategory.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                switch (tab.getPosition()){
                    case 0:
                        setBannerMoviesPagerAdapter(homeMoviesList);
                        return;
                    case 1:
                        setBannerMoviesPagerAdapter(tvShowBannerList);
                        return;
                    case 2:
                        setBannerMoviesPagerAdapter(movieBannerList);
                        return;
                    case 3:
                        setBannerMoviesPagerAdapter(kidsBannerList);
                        return;
                    default:
                        setBannerMoviesPagerAdapter(homeMoviesList);
                }
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });
    }

    private void setBannerMoviesPagerAdapter(List<BannerMovies> bannerMoviesList){
        bannerMoviesViewPager = findViewById(R.id.banner_viewPager);
        bannerMoviesPagerAdapter = new BannerMoviesPagerAdapter(this,bannerMoviesList);
        bannerMoviesViewPager.setAdapter(bannerMoviesPagerAdapter);
        tabIndicator.setupWithViewPager(bannerMoviesViewPager);

        Timer sliderTimer = new Timer();
        sliderTimer.scheduleAtFixedRate(new AutoSlider(),400,6000);
        tabIndicator.setupWithViewPager(bannerMoviesViewPager);
    }

    class AutoSlider extends TimerTask{

        @Override
        public void run() {
            MainActivity.this.runOnUiThread(new Runnable() {
                @Override
                public void run() {
                    if (bannerMoviesViewPager.getCurrentItem() < homeMoviesList.size() - 1) {
                        bannerMoviesViewPager.setCurrentItem(bannerMoviesViewPager.getCurrentItem() + 1);
                    }else{
                        bannerMoviesViewPager.setCurrentItem(0);
                    }
                }
            });
        }
    }
}