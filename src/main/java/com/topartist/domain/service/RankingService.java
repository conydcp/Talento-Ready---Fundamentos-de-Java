package com.topartist.domain.service;

import com.topartist.domain.exception.DuplicateArtistException;
import com.topartist.domain.exception.InvalidArtistException;
import com.topartist.domain.exception.InvalidExperienceException;
import com.topartist.domain.model.Artist;
import com.topartist.domain.port.ArtistRepositoryPort;

public class RankingService {

    private final ArtistRepositoryPort artistRepositoryPort;

    public RankingService(ArtistRepositoryPort artistRepositoryPort) {
        this.artistRepositoryPort = artistRepositoryPort;
    }

    public void registerArtist(Artist artist) {

        if (artistRepositoryPort.existsById(artist.getId())) {
            throw new DuplicateArtistException(
                    "Artist id already exists.");
        }

        artistRepositoryPort.save(artist);

    }

    public String calculateRankingTier(
            String artistId,
            int experienceMultiplier) {

        if (experienceMultiplier <= 0) {
            throw new InvalidExperienceException(
                    "Experience multiplier must be greater than zero.");
        }

        Artist artist = artistRepositoryPort.findById(artistId)
                .orElseThrow(() -> new InvalidArtistException("Artist not found."));

        int score = artist.getTotalSales() * experienceMultiplier;

        if (score >= 1000) {
            return "DIAMOND";
        }

        if (score >= 500) {
            return "GOLD";
        }

        return "BRONZE";
    }

}