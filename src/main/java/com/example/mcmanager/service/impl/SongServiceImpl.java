package com.example.mcmanager.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.mcmanager.entity.Song;
import com.example.mcmanager.mapper.SongMapper;
import com.example.mcmanager.service.SongService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SongServiceImpl extends ServiceImpl<SongMapper, Song>
        implements SongService {

    @Autowired
    SongMapper songMapper;

    @Override
    public List<Song> getAllSong() {
        return songMapper.getAllSong();
    }

    @Override
    public boolean updateSong(Song song) {
        return songMapper.updateSong(song);
    }

    @Override
    public Song getSongById(Integer songid) {
        return songMapper.getSongById(songid);
    }

    @Override
    public boolean updateSongById(Integer songid) {
        return songMapper.updateSongById(songid);
    }

}