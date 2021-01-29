package com.karan.unifynd.models;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class HipHop {

    private String albumName;
    private String artistName;
    @PrimaryKey
    private Integer id;

    public HipHop(String albumName, String artistName, Integer id) {
        this.albumName = albumName;
        this.artistName = artistName;
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getAlbumName() {
        return albumName;
    }

    public void setAlbumName(String albumName) {
        this.albumName = albumName;
    }

    public String getArtistName() {
        return artistName;
    }

    public void setArtistName(String artistName) {
        this.artistName = artistName;
    }
}
