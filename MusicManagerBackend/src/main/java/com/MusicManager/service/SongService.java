package com.MusicManager.service;

import com.MusicManager.model.Song;
import com.MusicManager.repository.SongRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.MusicManager.service.ServiceResult.Status;

@Service
public class SongService {
    @Autowired
    private SongRepository songRepository;

    //Get all list songs
    public ServiceResult getAllSong(){
        ServiceResult result = new ServiceResult();
        result.setData(songRepository.findAll());
        result.setMessage("Lấy dữ liệu thành công");
        return result;
    }

    //Get song by _id
    public ServiceResult getSongById(Integer id){
        ServiceResult result = new ServiceResult();
        Song song = songRepository.findById(id).orElse(null);
        result.setData(song);

        return result ;
    }

    //Save a song
    public ServiceResult createSong(Song song){
        ServiceResult result = new ServiceResult();

        result.setData(songRepository.save(song));

        return result;
    }

    //Update a song
    public ServiceResult updateSong(Integer id, Song song){
        ServiceResult result = new ServiceResult();

        if(!songRepository.findById(id).isPresent()){
            result.setStatus(Status.FAILED);
            result.setMessage("Song not found!");
        }else{
            song.setId(id);
            result.setData(songRepository.save(song));
        }

        return result;
    }

    //Delete a song
    public ServiceResult deleteSong(Integer id){

        ServiceResult result = new ServiceResult();
        Song song = songRepository.findById(id).orElse(null);

        if(song == null){
            result.setStatus(Status.FAILED);
            result.setMessage("Song not found");
        }else{
            songRepository.delete(song);
            result.setMessage("Delete Success!");
        }

        return result;
    }

}
