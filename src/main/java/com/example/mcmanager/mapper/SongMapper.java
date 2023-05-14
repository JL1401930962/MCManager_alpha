package com.example.mcmanager.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.mcmanager.entity.Song;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SongMapper extends BaseMapper<Song> {

    List<Song> getAllSong();

    boolean updateSong(Song song);

    Song getSongById(Integer songid);

    boolean updateSongById(Integer songid);
}
