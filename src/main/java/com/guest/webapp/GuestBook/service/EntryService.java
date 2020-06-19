package com.guest.webapp.GuestBook.service;

import com.guest.webapp.GuestBook.entities.Entry;
import com.guest.webapp.GuestBook.repositories.EntryRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EntryService {
private long timestamp;
    private EntryRepository entryRepository;

    public EntryService(EntryRepository entryRepository) {
        this.entryRepository = entryRepository;
    }

    public Entry addEntry(Entry e){
     return entryRepository.save(e);
    }

    public List<Entry> findAll(){
        return entryRepository.findAll();
    }

    public List<Entry> addEntries(List<Entry> list){
        return entryRepository.saveAll(list);
    }

    public void deleteAll(){
        entryRepository.deleteAll();
    }

    public long count(){
        return entryRepository.count();
    }

    public void deleteByID(Integer id){
        entryRepository.deleteById(id);
    }
}
