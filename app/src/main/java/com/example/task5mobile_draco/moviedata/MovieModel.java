package com.example.task5mobile_draco.moviedata;

import android.os.Parcel;
import android.os.Parcelable;

public class MovieModel implements Parcelable {
    private int poster;
    private String title;
    private String genres;
    private String limitold;
    private String duration;
    private String rating;



    private String sinopsis;
    MovieModel(){

    }
    public String getSinopsis() {
        return sinopsis;
    }

    public void setSinopsis(String sinopsis) {
        this.sinopsis = sinopsis;
    }
    public String getGenres() {
        return genres;
    }

    public void setGenres(String genres) {
        this.genres = genres;
    }

    public String getLimitold() {
        return limitold;
    }

    public void setLimitold(String limitold) {
        this.limitold = limitold;
    }

    public String getDuration() {
        return duration;
    }

    public void setDuration(String duration) {
        this.duration = duration;
    }

    public String getRating() {
        return rating;
    }

    public void setRating(String rating) {
        this.rating = rating;
    }
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
    public int getPoster() {
        return poster;
    }

    public void setPoster(int poster) {
        this.poster = poster;
    }


    protected MovieModel(Parcel in) {
        poster = in.readInt();
        title = in.readString();
        genres = in.readString();
        limitold = in.readString();
        duration = in.readString();
        rating = in.readString();
        sinopsis = in.readString();
    }

    public static final Creator<MovieModel> CREATOR = new Creator<MovieModel>() {
        @Override
        public MovieModel createFromParcel(Parcel in) {
            return new MovieModel(in);
        }

        @Override
        public MovieModel[] newArray(int size) {
            return new MovieModel[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(poster);
        dest.writeString(title);
        dest.writeString(genres);
        dest.writeString(limitold);
        dest.writeString(duration);
        dest.writeString(rating);
        dest.writeString(sinopsis);
    }

}
