package com.example.mcmanager.controller;

import com.example.mcmanager.entity.Song;
import com.example.mcmanager.entity.User;
import com.example.mcmanager.service.SongService;
import com.example.mcmanager.service.UserService;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/song")
@CrossOrigin
public class SongController {

    @Autowired
    private UserService userService;

    // songService
    @Autowired
    private SongService songService;

    /**
     * 接口：获取信息
     * @return
     */
    @PostMapping("/list1")
    public List<Song> list(){
        return songService.list();
    }

    // 获取所有歌曲信息
    @GetMapping("/getAllSong")
    public List<Song> getAllSong(){
        return songService.getAllSong();
    }

    // 修改歌曲信息
    @PostMapping("/updateSong")
    public boolean updateSong(@RequestBody Song song){
        return songService.updateSong(song);
    }
    // 根据歌曲id修改歌曲信息
    @PostMapping("/updateSongById")
    public boolean updateSongById(@RequestBody Integer songid){
        return songService.updateSongById(songid);
    }

    // 添加歌曲信息
    @PostMapping("/addSong")
    public boolean addSong(@RequestBody Song song){
        return songService.addSong(song);
    }

    // 删除歌曲信息
    @PostMapping("/deleteSongById")
    public boolean deleteSongById(@RequestParam("songid") Integer songid){
        return songService.removeById(songid);
    }

    // 根据id查询歌曲信息
    @GetMapping("/getSongById")
    public Song getSongById(@Param("songid") Integer songid){
        return songService.getSongById(songid);
    }

    // 确认歌曲id存在
    @PostMapping("/checkSongId")
    public boolean checkSongId(@RequestParam("songid") Integer songid){
        return songService.checkSongId(songid);
    }

}
