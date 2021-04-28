package com.example.task5mobile_draco.dramadata;

import android.os.Parcel;
import android.os.Parcelable;

public class DramaModel implements Parcelable {
    public DramaModel() {

    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public String getEps() {
        return eps;
    }

    public void setEps(String eps) {
        this.eps = eps;
    }

    public String getSinopsis() {
        return sinopsis;
    }

    public void setSinopsis(String sinopsis) {
        this.sinopsis = sinopsis;
    }

    public int getPoster() {
        return poster;
    }

    public void setPoster(int poster) {
        this.poster = poster;
    }

    private String title;
    private String genre;
    private String eps;
    private String sinopsis;
    private int poster;

    protected DramaModel(Parcel in) {
        title = in.readString();
        genre = in.readString();
        eps = in.readString();
        sinopsis = in.readString();
        poster = in.readInt();
    }

    public static final Creator<DramaModel> CREATOR = new Creator<DramaModel>() {
        @Override
        public DramaModel createFromParcel(Parcel in) {
            return new DramaModel(in);
        }

        @Override
        public DramaModel[] newArray(int size) {
            return new DramaModel[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(title);
        dest.writeString(genre);
        dest.writeString(eps);
        dest.writeString(sinopsis);
        dest.writeInt(poster);
    }
}
