package com.example.photoz.web;


import com.example.photoz.service.PhotozService;
import com.example.photoz.modul.Photo;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.server.ResponseStatusException;

import java.io.IOException;
import java.util.*;

@RestController
public class PhotozController {


//    private List<Photo> db = List.of(new Photo("1","hello.jpg"));
private final PhotozService photozService;

    public PhotozController(PhotozService photozService) {
        this.photozService = photozService;
    }

    @GetMapping("/")
    public String hello(){
        return "Hello World";
    }
    @GetMapping("/photoz")
    public Collection<Photo> get(){
        return photozService.get();
    }

    @GetMapping("/photoz/{id}")
    public Photo get(@PathVariable String id){
        Photo photo = photozService.get(id);
        if (photo == null) throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        return photo;
    }

    @DeleteMapping("/photoz/{id}")
    public void delete(@PathVariable String id ){
       Photo photo = photozService.remove(id);
       if(photo == null){
           throw new ResponseStatusException(HttpStatus.NOT_FOUND);
       }
    }
    // to test
    // (async function deletePhoto(id){
    //      await fetch('http://localhost/photoz/' + id, {
    //          method: "DELETE"
    // })})("5");

    @PostMapping("/photoz")
    public Photo create(@RequestPart("data") MultipartFile file) throws IOException {

        Photo photo =photozService.save(file.getOriginalFilename(),file.getContentType(), file.getBytes());
        return photo;
    }
    //-----------/To test create/--------------
    //    (async function createPhoto(){
    //        let photo = {"fileName": "hello.jpg"};
    //        await fetch('http://localhost:8080/photoz', {
    //                method: "POST",
    //                headers: {
    //            Accept: 'application/json',
    //                    'Content-Type': 'application/json',
    //        },
    //        body: JSON.stringify(photo)
    //    }).then(result => result.text()).
    //        then(text => alert(text));
    //    })();
}
