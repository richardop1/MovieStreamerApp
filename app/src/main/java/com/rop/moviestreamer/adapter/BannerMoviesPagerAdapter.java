package com.rop.moviestreamer.adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.rop.moviestreamer.MovieDetails;
import com.rop.moviestreamer.R;
import com.rop.moviestreamer.model.BannerMovies;

import java.util.List;

import androidx.annotation.NonNull;
import androidx.viewpager.widget.PagerAdapter;

public class BannerMoviesPagerAdapter extends PagerAdapter {
    Context context;
    List<BannerMovies> bannerMoviesList;

    public BannerMoviesPagerAdapter(Context context, List<BannerMovies> bannerMoviesList){
        this.context = context;
        this.bannerMoviesList = bannerMoviesList;
    }

    @Override
    public int getCount() {
        return bannerMoviesList.size();
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
        return view == object;
    }

    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
        container.removeView((View) object);
    }

    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, final int position) {
        View view = LayoutInflater.from(container.getContext()).inflate(R.layout.banner_movie_layout, container, false);
        ImageView bannerImage = view.findViewById(R.id.banner_image);

        Glide.with(context).load(bannerMoviesList.get(position).getImageUrl()).into(bannerImage);
        container.addView(view);

        bannerImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Toast.makeText(context,bannerMoviesList.get(position).getMovieName()+" ",Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(context, MovieDetails.class);
                intent.putExtra("movieId",bannerMoviesList.get(position).getId());
                intent.putExtra("movieName",bannerMoviesList.get(position).getMovieName());
                intent.putExtra("movieImageUrl",bannerMoviesList.get(position).getImageUrl());
                intent.putExtra("movieFile",bannerMoviesList.get(position).getFileUrl());

                context.startActivity(intent);
            }
        });
        return view;
    }
}
