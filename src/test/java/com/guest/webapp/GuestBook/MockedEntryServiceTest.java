package com.guest.webapp.GuestBook;

import com.guest.webapp.GuestBook.entities.Entry;
import com.guest.webapp.GuestBook.repositories.EntryRepository;
import com.guest.webapp.GuestBook.service.EntryService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.boot.test.context.SpringBootTest;
import java.util.List;
import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@SpringBootTest
@RunWith(MockitoJUnitRunner.class)
public class MockedEntryServiceTest {

    @Mock
    private Entry mockEntry;
    @Mock
    private List<Entry> mockEntries;
    @Mock private EntryRepository mockEntryRepository;

    private EntryService entryService;


    @Before
    public void setup() {
        entryService = new EntryService(mockEntryRepository);
        when(mockEntryRepository.save(any(Entry.class))).thenReturn(mockEntry);
        when(mockEntryRepository.saveAll(mockEntries)).thenReturn(mockEntries);
        when(mockEntryRepository.findAll()).thenReturn(mockEntries);
        //when(mockEntryRepository.deleteAll()).thenReturn(entries); //deleteAll returns void
        when(mockEntryRepository.count()).thenReturn(0L);
    }

    @Test //JPA's save method returns the persisted entity which can never be null.
    public void testInsertOneEntry() {
        mockEntry = entryService.addEntry(mockEntry);
        assertThat(mockEntry).isNotNull();
    }

    @Test
    public void testUpdateOneEntry() {
        mockEntry.setName("DanielTestUpdate");
        mockEntry = entryService.addEntry(mockEntry);
        assertThat(mockEntry).isNotNull();
    }

    @Test
    public void testInsertMultipleEntries() {
        mockEntries = entryService.addEntries(mockEntries);
        assertThat(mockEntries).isNotNull();
    }

    @Test
    public void testFindAllEntries() {
        mockEntries = entryService.findAll();
        assertThat(mockEntries).isNotNull();
    }

    @Test
    public void testDeleteAllEntries() {
        entryService.deleteAll();
        assertThat(entryService.count()).isZero();
    }
}
