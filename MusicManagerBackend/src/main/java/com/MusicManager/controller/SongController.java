package com.MusicManager.controller;

import com.MusicManager.model.Song;
import com.MusicManager.service.ServiceResult;
import com.MusicManager.service.SongService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController()
@RequestMapping("/song")
public class SongController {

    @Autowired
    private SongService songService;

    //GET /song
    @RequestMapping( value = "", method = RequestMethod.GET)
    public ResponseEntity<ServiceResult> getAllSong(){
        return new ResponseEntity<ServiceResult>(songService.getAllSong(), HttpStatus.OK);
    }

    //GET /song/{id}
    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ResponseEntity<ServiceResult> getSongById(@PathVariable("id") Integer id){
        return new ResponseEntity<ServiceResult>(songService.getSongById(id), HttpStatus.OK);
    }

    //POST /song
    @RequestMapping(value = "", method = RequestMethod.POST)
    public ResponseEntity<ServiceResult> createSong(@RequestBody Song song){
        return new ResponseEntity<>(songService.createSong(song),HttpStatus.OK);
    }

    //PUT /song/{id}
    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    public ResponseEntity<ServiceResult> updateSong(@PathVariable("id") Integer id, @RequestBody Song song){
        return new ResponseEntity<>(songService.updateSong(id, song), HttpStatus.OK);
    }

    //DELETE /song/{id}
    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<ServiceResult> deleteSong(@PathVariable("id") Integer id){
        return new ResponseEntity<>(songService.deleteSong(id), HttpStatus.OK);
    }

}
