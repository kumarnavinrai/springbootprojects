package com.jwt.services;

import com.jwt.model.ImageFile;
import com.jwt.repo.ImagefileRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class ImageFileService {

    @Autowired
    ImagefileRepository imagefileRepository;

    public List<ImageFile> list(){
        return imagefileRepository.findAll();
    }

    public Optional<ImageFile> getOne(int id){
        return imagefileRepository.findById(id);
    }

    public void save(ImageFile image){
        imagefileRepository.save(image);
    }

    public void delete(int id){
        imagefileRepository.deleteById(id);
    }

    public boolean exists(int id){
        return imagefileRepository.existsById(id);
    }
}
