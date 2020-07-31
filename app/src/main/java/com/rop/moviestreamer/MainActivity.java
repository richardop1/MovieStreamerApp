package com.rop.moviestreamer;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.widget.NestedScrollView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;
import android.view.View;

import com.google.android.material.appbar.AppBarLayout;
import com.google.android.material.tabs.TabLayout;
import com.rop.moviestreamer.adapter.BannerMoviesPagerAdapter;
import com.rop.moviestreamer.adapter.MainRecyclerAdapter;
import com.rop.moviestreamer.model.AllCategory;
import com.rop.moviestreamer.model.BannerMovies;
import com.rop.moviestreamer.model.CategoryItem;

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

    //main recyclerView
    MainRecyclerAdapter mainRecyclerAdapter;
    RecyclerView mainRecycler;
    List<AllCategory> allCategoryList;

    NestedScrollView nestedScrollView;
    AppBarLayout appBarLayout;





    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        appBarLayout = findViewById(R.id.appbar);
        nestedScrollView = findViewById(R.id.nested_scroll);
        tabCategory = findViewById(R.id.tablayout);
        tabIndicator = findViewById(R.id.tab_indicator);

        // home banner list
        homeMoviesList = new ArrayList<>();
        homeMoviesList.add(new BannerMovies(1,"test","https://sm.ign.com/ign_es/screenshot/default/ironmanvr-blogroll-1554158268175_1ybb.jpg","https://androidappsforyoutube.s3.ap-south-1.amazonaws.com/primevideo/patallok.mp4"));
        homeMoviesList.add(new BannerMovies(2,"test","https://sm.ign.com/ign_es/screenshot/default/ironmanvr-blogroll-1554158268175_1ybb.jpg","https://androidappsforyoutube.s3.ap-south-1.amazonaws.com/primevideo/patallok.mp4"));
        homeMoviesList.add(new BannerMovies(3,"test","https://sm.ign.com/ign_es/screenshot/default/ironmanvr-blogroll-1554158268175_1ybb.jpg","https://androidappsforyoutube.s3.ap-south-1.amazonaws.com/primevideo/patallok.mp4"));
        homeMoviesList.add(new BannerMovies(4,"test","https://sm.ign.com/ign_es/screenshot/default/ironmanvr-blogroll-1554158268175_1ybb.jpg","https://androidappsforyoutube.s3.ap-south-1.amazonaws.com/primevideo/patallok.mp4"));
        homeMoviesList.add(new BannerMovies(5,"test","https://sm.ign.com/ign_es/screenshot/default/ironmanvr-blogroll-1554158268175_1ybb.jpg","https://androidappsforyoutube.s3.ap-south-1.amazonaws.com/primevideo/patallok.mp4"));

        // tv show banner list
        tvShowBannerList = new ArrayList<>();
        tvShowBannerList.add(new BannerMovies(1,"tv","https://www.ecestaticos.com/image/clipping/9a2f321f12e61373c26776bed0b50985/el-emotivo-homenaje-con-el-que-039-the-walking-dead-039-despide-a-uno-de-sus-protagonistas.jpg","https://androidappsforyoutube.s3.ap-south-1.amazonaws.com/primevideo/patallok.mp4"));
        tvShowBannerList.add(new BannerMovies(2,"tv","https://www.ecestaticos.com/image/clipping/9a2f321f12e61373c26776bed0b50985/el-emotivo-homenaje-con-el-que-039-the-walking-dead-039-despide-a-uno-de-sus-protagonistas.jpg","https://androidappsforyoutube.s3.ap-south-1.amazonaws.com/primevideo/patallok.mp4"));
        tvShowBannerList.add(new BannerMovies(3,"tv","https://www.ecestaticos.com/image/clipping/9a2f321f12e61373c26776bed0b50985/el-emotivo-homenaje-con-el-que-039-the-walking-dead-039-despide-a-uno-de-sus-protagonistas.jpg","https://androidappsforyoutube.s3.ap-south-1.amazonaws.com/primevideo/patallok.mp4"));
        tvShowBannerList.add(new BannerMovies(4,"tv","https://www.ecestaticos.com/image/clipping/9a2f321f12e61373c26776bed0b50985/el-emotivo-homenaje-con-el-que-039-the-walking-dead-039-despide-a-uno-de-sus-protagonistas.jpg","https://androidappsforyoutube.s3.ap-south-1.amazonaws.com/primevideo/patallok.mp4"));
        tvShowBannerList.add(new BannerMovies(5,"tv","https://www.ecestaticos.com/image/clipping/9a2f321f12e61373c26776bed0b50985/el-emotivo-homenaje-con-el-que-039-the-walking-dead-039-despide-a-uno-de-sus-protagonistas.jpg","https://androidappsforyoutube.s3.ap-south-1.amazonaws.com/primevideo/patallok.mp4"));
        // movie banner list
        movieBannerList = new ArrayList<>();
        movieBannerList.add(new BannerMovies(1,"movie","https://as.com/meristation/imagenes/2019/12/12/avances/1576175321_723620_1576327909_noticia_normal.jpg","https://androidappsforyoutube.s3.ap-south-1.amazonaws.com/primevideo/patallok.mp4"));
        movieBannerList.add(new BannerMovies(2,"movie","https://as.com/meristation/imagenes/2019/12/12/avances/1576175321_723620_1576327909_noticia_normal.jpg","https://androidappsforyoutube.s3.ap-south-1.amazonaws.com/primevideo/patallok.mp4"));
        movieBannerList.add(new BannerMovies(3,"movie","https://as.com/meristation/imagenes/2019/12/12/avances/1576175321_723620_1576327909_noticia_normal.jpg","https://androidappsforyoutube.s3.ap-south-1.amazonaws.com/primevideo/patallok.mp4"));
        movieBannerList.add(new BannerMovies(4,"movie","https://as.com/meristation/imagenes/2019/12/12/avances/1576175321_723620_1576327909_noticia_normal.jpg","https://androidappsforyoutube.s3.ap-south-1.amazonaws.com/primevideo/patallok.mp4"));
        movieBannerList.add(new BannerMovies(5,"movie","https://as.com/meristation/imagenes/2019/12/12/avances/1576175321_723620_1576327909_noticia_normal.jpg","https://androidappsforyoutube.s3.ap-south-1.amazonaws.com/primevideo/patallok.mp4"));
        //kids banner list
        kidsBannerList = new ArrayList<>();
        kidsBannerList.add(new BannerMovies(1,"movie","https://as.com/meristation/imagenes/2019/10/25/noticias/1572002941_916672_1572003064_noticia_normal.jpg","https://androidappsforyoutube.s3.ap-south-1.amazonaws.com/primevideo/patallok.mp4"));
        kidsBannerList.add(new BannerMovies(2,"movie","https://as.com/meristation/imagenes/2019/10/25/noticias/1572002941_916672_1572003064_noticia_normal.jpg","https://androidappsforyoutube.s3.ap-south-1.amazonaws.com/primevideo/patallok.mp4"));
        kidsBannerList.add(new BannerMovies(3,"movie","https://as.com/meristation/imagenes/2019/10/25/noticias/1572002941_916672_1572003064_noticia_normal.jpg","https://androidappsforyoutube.s3.ap-south-1.amazonaws.com/primevideo/patallok.mp4"));
        kidsBannerList.add(new BannerMovies(4,"movie","https://as.com/meristation/imagenes/2019/10/25/noticias/1572002941_916672_1572003064_noticia_normal.jpg","https://androidappsforyoutube.s3.ap-south-1.amazonaws.com/primevideo/patallok.mp4"));
        kidsBannerList.add(new BannerMovies(5,"movie","https://as.com/meristation/imagenes/2019/10/25/noticias/1572002941_916672_1572003064_noticia_normal.jpg","https://androidappsforyoutube.s3.ap-south-1.amazonaws.com/primevideo/patallok.mp4"));

        setBannerMoviesPagerAdapter(homeMoviesList);

        tabCategory.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                switch (tab.getPosition()){
                    case 0:
                        setBannerMoviesPagerAdapter(homeMoviesList);
                        setScrollDefaultState();
                        return;
                    case 1:
                        setBannerMoviesPagerAdapter(tvShowBannerList);
                        setScrollDefaultState();
                        return;
                    case 2:
                        setBannerMoviesPagerAdapter(movieBannerList);
                        setScrollDefaultState();
                        return;
                    case 3:
                        setBannerMoviesPagerAdapter(kidsBannerList);
                        setScrollDefaultState();
                        return;
                    default:
                        setBannerMoviesPagerAdapter(homeMoviesList);
                        setScrollDefaultState();
                }
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });

        // first we will add item data
        List<CategoryItem> homeCatListItem = new ArrayList<>();
        homeCatListItem.add(new CategoryItem(1,"Iron Man","https://elintransigente.com/wp-content/uploads/2020/07/The-Walking-Dead-1.jpg?w=1024?w=1000&h=600&crop=1","https://androidappsforyoutube.s3.ap-south-1.amazonaws.com/primevideo/patallok.mp4"));
        homeCatListItem.add(new CategoryItem(2,"The Avengers","https://i.ytimg.com/vi/fI_CqtIr2hg/maxresdefault.jpg","https://androidappsforyoutube.s3.ap-south-1.amazonaws.com/primevideo/patallok.mp4"));
        homeCatListItem.add(new CategoryItem(3,"Sonic","https://i.ytimg.com/vi/tKRdXKapt1s/maxresdefault.jpg","https://androidappsforyoutube.s3.ap-south-1.amazonaws.com/primevideo/patallok.mp4"));
        homeCatListItem.add(new CategoryItem(4,"Avatar","https://i.ytimg.com/vi/2SrVzHNIp3g/maxresdefault.jpg","https://androidappsforyoutube.s3.ap-south-1.amazonaws.com/primevideo/patallok.mp4\n"));

        List<CategoryItem> homeCatListItem1 = new ArrayList<>();
        homeCatListItem1.add(new CategoryItem(1,"Dragon Ball","https://static-cdn.jtvnw.net/cf_vods/d2nvs31859zcd8/jeffbiwuls/209888436/294c49be-6d4d-40f5-b44f-e7713ea4f9b4/thumb/customdeef0f820ff726e7-640x360.jpeg","https://androidappsforyoutube.s3.ap-south-1.amazonaws.com/primevideo/patallok.mp4"));
        homeCatListItem1.add(new CategoryItem(2,"Cars","https://cdn.hobbyconsolas.com/sites/navi.axelspringer.es/public/styles/480/public/media/image/2017/07/cars-3.jpg?itok=Q2YBLxRz","https://androidappsforyoutube.s3.ap-south-1.amazonaws.com/primevideo/patallok.mp4"));
        homeCatListItem1.add(new CategoryItem(3,"The mask","https://cdn.shortpixel.ai/client/q_glossy,ret_img,w_1000,h_600/https://wipy.tv/wp-content/uploads/2020/01/Jim-Carrey-podr%C3%ADa-participar-en-%E2%80%98The-Mask-2%E2%80%99.jpg","https://androidappsforyoutube.s3.ap-south-1.amazonaws.com/primevideo/patallok.mp4"));
        homeCatListItem1.add(new CategoryItem(4,"Dead pool","https://i.blogs.es/d50a8e/deadpool-1200x675/1366_2000.jpeg","https://androidappsforyoutube.s3.ap-south-1.amazonaws.com/primevideo/patallok.mp4"));

        allCategoryList = new ArrayList<>();

        allCategoryList.add(new AllCategory(1,"Wath next TV and movies", homeCatListItem));
        allCategoryList.add(new AllCategory(2,"Movies in Hindi",homeCatListItem1));
        allCategoryList.add(new AllCategory(3,"Kids and family",homeCatListItem));
        allCategoryList.add(new AllCategory(4,"Amazon Original Series",homeCatListItem1));
        allCategoryList.add(new AllCategory(3,"Kids and family",homeCatListItem));
        allCategoryList.add(new AllCategory(4,"Amazon Original Series",homeCatListItem1));


        setMainRecycler(allCategoryList);

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

    private void setMainRecycler(List<AllCategory> allCategoryList){
        mainRecycler = findViewById(R.id.main_recycler);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this, RecyclerView.VERTICAL,false);
        mainRecycler.setLayoutManager(layoutManager);
        mainRecyclerAdapter = new MainRecyclerAdapter(this,allCategoryList);
        mainRecycler.setAdapter(mainRecyclerAdapter);
    }

    private void setScrollDefaultState(){
        nestedScrollView.fullScroll(View.FOCUS_UP);
        nestedScrollView.scrollTo(0,0);
        appBarLayout.setExpanded(true);
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