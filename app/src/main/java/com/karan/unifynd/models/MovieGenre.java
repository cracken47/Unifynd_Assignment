package com.karan.unifynd.models;

public class MovieGenre {

    private String albumName;
    private String artistName;
    private Integer id;

    public MovieGenre(String albumName, String artistName, Integer id) {
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
