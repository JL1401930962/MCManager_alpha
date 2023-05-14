package com.example.mcmanager.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

@TableName(value = "song")
@Data
public class Song {

    @TableId(type = IdType.AUTO)
    private Integer songid;
    private String songname;
    private String songurl;
    private Integer albumid;
    private String albumname;
    private Integer artistid;
    private String artistname;
    private String icon;

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;

    public Integer getSongid() {
        return songid;
    }


    public void setSongid(Integer songid) {
        this.songid = songid;
    }


    public String getSongname() {
        return songname;
    }

    public void setSongname(String songname) {
        this.songname = songname;
    }

    public Integer getAlbumid() {
        return albumid;
    }

    public void setAlbumid(Integer albumid) {
        this.albumid = albumid;
    }

    public String getAlbumname() {
        return albumname;
    }

    public void setAlbumname(String albumname) {
        this.albumname = albumname;
    }

    public Integer getArtistid() {
        return artistid;
    }

    public void setArtistid(Integer artistid) {
        this.artistid = artistid;
    }

    public String getArtistname() {
        return artistname;
    }

    public void setArtistname(String artistname) {
        this.artistname = artistname;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }
}
