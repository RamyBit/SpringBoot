package com.example.photoz.repository;

import com.example.photoz.modul.Photo;
import org.springframework.data.repository.CrudRepository;

public interface PhotozRepository extends CrudRepository<Photo, Integer> {
}
