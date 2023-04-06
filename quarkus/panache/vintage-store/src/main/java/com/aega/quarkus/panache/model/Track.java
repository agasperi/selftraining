package com.aega.quarkus.panache.model;

import java.time.Duration;
import java.time.Instant;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import io.quarkus.hibernate.orm.panache.PanacheEntity;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity(name = "t_tracks")
public class Track extends PanacheEntity{

    @Column(nullable = false)
    private String title;
    @Column(nullable = false)
    private Duration duration;
    @Column(name = "created_date", nullable = false)
    private Instant createdDate;
    @ManyToOne
    @JoinColumn(name = "cd_fk")
    private CD cd;

}
