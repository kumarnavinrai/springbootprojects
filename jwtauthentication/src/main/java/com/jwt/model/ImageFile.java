package com.jwt.model;

import javax.persistence.*;

import lombok.*;

@Entity
@Table(name = "ImageFile")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ImageFile {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    private String imageUrl;
    private String imageId;

    public ImageFile(String name, String imageUrl, String imageId) {
        this.name = name;
        this.imageUrl = imageUrl;
        this.imageId = imageId;
    }

}