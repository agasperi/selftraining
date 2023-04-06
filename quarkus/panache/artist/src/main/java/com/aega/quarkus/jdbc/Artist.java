package com.aega.quarkus.jdbc;

import java.time.Instant;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Getter
@Setter
@NoArgsConstructor
public class Artist {

    private Long id;
    private String name;
    private String bio;
    private Instant createdDate = Instant.now();

    public Artist(String name, String bio) {
        this.name = name;
        this.bio = bio;
    }

    public Artist(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
      return "Artist{" +
        "id=" + id +
        ", name='" + name + '\'' +
        ", bio='" + bio + '\'' +
        ", createdDate=" + createdDate +
        '}';
    }

}
