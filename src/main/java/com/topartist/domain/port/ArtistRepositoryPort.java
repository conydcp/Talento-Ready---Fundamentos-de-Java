package com.topartist.domain.port;

import com.topartist.domain.model.Artist;

import java.util.Optional;

public interface ArtistRepositoryPort {

    Optional<Artist> findById(String id);

    boolean existsById(String id);

    void save(Artist artist);

}