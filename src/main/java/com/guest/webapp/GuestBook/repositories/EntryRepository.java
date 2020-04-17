package com.guest.webapp.GuestBook.repositories;

import com.guest.webapp.GuestBook.entities.Entry;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface EntryRepository extends JpaRepository<Entry, Integer> {
    List<Entry> findByOrderByIdDesc();

    Entry findByName(String name);
    Entry deleteByName(String name);

//    @Query("select * from Entry e where e.name = %?1")
//    Entry findeEintragdurchNamen(String name);
//
//    @Query(value = "select * from guestbook_table e where e.name = %?1", nativeQuery = true)
//    Entry findeEintragdurchNamen2(String name);

}
