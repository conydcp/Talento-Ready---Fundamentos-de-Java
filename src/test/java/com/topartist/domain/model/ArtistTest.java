package com.topartist.domain.model;

import com.topartist.domain.exception.InvalidArtistException;
import com.topartist.domain.exception.NegativeSalesException;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ArtistTest {

    @Test
    void shouldCreateArtist() {

        Artist artist = new Artist(
                "ART-01",
                "Taylor Swift",
                100,
                50);

        assertEquals("ART-01", artist.getId());
        assertEquals("Taylor Swift", artist.getName());
        assertEquals(100, artist.getTicketSales());
        assertEquals(50, artist.getAlbumSales());
        assertEquals(150, artist.getTotalSales());
    }

    @Test
    void shouldThrowWhenIdIsNull() {
        assertThrows(
                InvalidArtistException.class,
                () -> new Artist(null, "Taylor", 1, 1));
    }

    @Test
    void shouldThrowWhenIdIsBlank() {
        assertThrows(
                InvalidArtistException.class,
                () -> new Artist("", "Taylor", 1, 1));
    }

    @Test
    void shouldThrowWhenNameIsNull() {
        assertThrows(
                InvalidArtistException.class,
                () -> new Artist("1", null, 1, 1));
    }

    @Test
    void shouldThrowWhenNameIsBlank() {
        assertThrows(
                InvalidArtistException.class,
                () -> new Artist("1", "", 1, 1));
    }

    @Test
    void shouldThrowWhenTicketSalesAreNegative() {
        assertThrows(
                NegativeSalesException.class,
                () -> new Artist("1", "Taylor", -1, 1));
    }

    @Test
    void shouldThrowWhenAlbumSalesAreNegative() {
        assertThrows(
                NegativeSalesException.class,
                () -> new Artist("1", "Taylor", 1, -1));
    }
}