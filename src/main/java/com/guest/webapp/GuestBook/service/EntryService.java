package com.guest.webapp.GuestBook.service;

import com.guest.webapp.GuestBook.entities.Entry;
import com.guest.webapp.GuestBook.repositories.EntryRepository;

import java.util.Date;

public class EntryService {
private long timestamp;
    private final EntryRepository entryRepository;

    public EntryService(EntryRepository entryRepository, long timestamp) {
        this.entryRepository = entryRepository;
        this.timestamp = timestamp;
    }

    public Entry addEntry(Entry e){
        e.setName("Daniel");
        e.setCreatedOn(new Date(timestamp));
     return entryRepository.save(e);
    }

    public Iterable<Entry> findAll(){
        return entryRepository.findAll();
    }
}
