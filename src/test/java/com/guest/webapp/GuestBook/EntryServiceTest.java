package com.guest.webapp.GuestBook;


import com.guest.webapp.GuestBook.entities.Entry;
import com.guest.webapp.GuestBook.repositories.EntryRepository;
import com.guest.webapp.GuestBook.service.EntryService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Captor;
import org.mockito.Mock;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;
import static org.mockito.Mockito.verify;

import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
@RunWith(MockitoJUnitRunner.class)
public class EntryServiceTest { //argumentCaptor Test

    private EntryService service;
    @Mock private Entry entry = new Entry();
    @Captor
    private ArgumentCaptor<Entry> entryArgumentCaptor;
    @Mock
    private EntryRepository mockEntryRepository;
    @Mock
    private Entry mockReturnEntry;

    @Before
    public void setup() {
        service = new EntryService(mockEntryRepository);
        when(mockEntryRepository.save(entryArgumentCaptor.capture())).thenReturn(mockReturnEntry);
    }

    @Test
    public void canAddEntry() {
        Entry returnVal = service.addEntry(entry);
        verify(mockEntryRepository).save(entry); //check if service delegates correctly //Deligiert
        assertThat(returnVal).isEqualTo(mockReturnEntry); //check if the repository returns
        //assertThat(returnVal.getName()).isEqualTo("Daniel");
        //assertThat(entryArgumentCaptor.getValue().getName()).isEqualTo("Daniel"); //wurde es richtig bearbeitet?
    }

    @Test //JPA's save method returns the persisted entity which can never be null.
    public void testInsertOneEntry(){
        when(service.addEntry(entry)).thenReturn(entry);
        entry = service.addEntry(entry);
        assertThat(entry).isNotNull();
    }
}
