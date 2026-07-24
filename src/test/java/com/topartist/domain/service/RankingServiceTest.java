package com.topartist.domain.service;

import com.topartist.domain.exception.DuplicateArtistException;
import com.topartist.domain.exception.InvalidArtistException;
import com.topartist.domain.exception.InvalidExperienceException;
import com.topartist.domain.model.Artist;
import com.topartist.domain.port.ArtistRepositoryPort;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class RankingServiceTest {

    @Mock
    private ArtistRepositoryPort repository;

    @InjectMocks
    private RankingService service;

    @Test
    @DisplayName("Should return DIAMOND tier")
    void shouldReturnDiamondTier() {

        // Arrange
        Artist artist = new Artist("1", "Taylor", 200, 300);

        when(repository.findById("1"))
                .thenReturn(Optional.of(artist));

        // Act
        String result = service.calculateRankingTier("1", 2);

        // Assert
        assertEquals("DIAMOND", result);
    }

    @Test
    @DisplayName("Should return GOLD tier")
    void shouldReturnGoldTier() {

        // Arrange
        Artist artist = new Artist("2", "Bruno", 100, 100);

        when(repository.findById("2"))
                .thenReturn(Optional.of(artist));

        // Act
        String result = service.calculateRankingTier("2", 3);

        // Assert
        assertEquals("GOLD", result);
    }

    @Test
    @DisplayName("Should return BRONZE tier")
    void shouldReturnBronzeTier() {

        // Arrange
        Artist artist = new Artist("3", "Indie", 10, 20);

        when(repository.findById("3"))
                .thenReturn(Optional.of(artist));

        // Act
        String result = service.calculateRankingTier("3", 2);

        // Assert
        assertEquals("BRONZE", result);
    }

    @Test
    @DisplayName("Should throw InvalidArtistException when artist does not exist")
    void shouldThrowWhenArtistDoesNotExist() {

        // Arrange
        when(repository.findById("99"))
                .thenReturn(Optional.empty());

        // Act & Assert
        assertThrows(
                InvalidArtistException.class,
                () -> service.calculateRankingTier("99", 2));
    }

    @Test
    @DisplayName("Should throw InvalidExperienceException when multiplier is zero")
    void shouldThrowWhenMultiplierIsZero() {

        // Act & Assert
        assertThrows(
                InvalidExperienceException.class,
                () -> service.calculateRankingTier("1", 0));
    }

    @Test
    @DisplayName("Should register a new artist")
    void shouldRegisterArtistSuccessfully() {

        // Arrange
        Artist artist = new Artist(
                "ART-100",
                "Taylor Swift",
                100,
                50);

        when(repository.existsById("ART-100"))
                .thenReturn(false);

        // Act
        service.registerArtist(artist);

        // Assert
        verify(repository).save(artist);
    }

    @Test
    @DisplayName("Should throw DuplicateArtistException when artist id already exists")
    void shouldThrowDuplicateArtistException() {

        // Arrange
        Artist artist = new Artist(
                "ART-100",
                "Taylor Swift",
                100,
                50);

        when(repository.existsById("ART-100"))
                .thenReturn(true);

        // Act & Assert
        assertThrows(
                DuplicateArtistException.class,
                () -> service.registerArtist(artist));
    }
}