package com.topartist.domain.model;

import com.topartist.domain.exception.InvalidArtistException;
import com.topartist.domain.exception.NegativeSalesException;

public class Artist {

    private final String id;
    private final String name;
    private final int ticketSales;
    private final int albumSales;

    public Artist(String id, String name, int ticketSales, int albumSales) {

        if (id == null || id.isBlank()) {
            throw new InvalidArtistException("Artist id cannot be empty.");
        }

        if (name == null || name.isBlank()) {
            throw new InvalidArtistException("Artist name cannot be empty.");
        }

        if (ticketSales < 0) {
            throw new NegativeSalesException("Ticket sales cannot be negative.");
        }

        if (albumSales < 0) {
            throw new NegativeSalesException("Album sales cannot be negative.");
        }

        this.id = id;
        this.name = name;
        this.ticketSales = ticketSales;
        this.albumSales = albumSales;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getTicketSales() {
        return ticketSales;
    }

    public int getAlbumSales() {
        return albumSales;
    }

    public int getTotalSales() {
        return ticketSales + albumSales;
    }
}