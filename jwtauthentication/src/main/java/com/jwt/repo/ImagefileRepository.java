package com.jwt.repo;

import com.jwt.model.ImageFile;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ImagefileRepository extends JpaRepository<ImageFile,Integer> {

}
