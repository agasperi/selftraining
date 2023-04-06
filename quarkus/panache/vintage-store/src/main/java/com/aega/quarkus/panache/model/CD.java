package com.aega.quarkus.panache.model;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
@Entity
public class CD extends Item {

    @Column(name = "music_company")
    private String musicCompany;

    @Column(length = 100)
    private String genre;

    @OneToMany(mappedBy = "cd")
    public List<Track> tracks = new ArrayList<>();

}
