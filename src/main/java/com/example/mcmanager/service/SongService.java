package com.example.mcmanager.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.example.mcmanager.entity.Song;

import java.util.List;

public interface SongService extends IService<Song> {

    List<Song> getAllSong();

    boolean updateSong(Song song);

    Song getSongById(Integer songid);

    boolean updateSongById(Integer songid);
}