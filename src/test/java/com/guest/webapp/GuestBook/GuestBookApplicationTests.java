package com.guest.webapp.GuestBook;
import com.guest.webapp.GuestBook.entities.Entry;
import com.guest.webapp.GuestBook.repositories.EntryRepository;
import com.guest.webapp.GuestBook.service.EntryService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;
import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = GuestBookApp.class)
public class GuestBookApplicationTests {

	@Autowired
	private EntryService entryService;

	private List<Entry> entries = new ArrayList<>();
	private Entry entry;




	@Before
	public void setup(){ //prepare dataset
		entries.add(new Entry("Hans Meier","Hallo dies ist ein Gästebucheintrag.)"));
		entries.add(new Entry("Daniel","Dieses Gästebuch ist sehr schön, weiter so!"));
		entries.add(new Entry("Wolf","Diese Einträge sind nur für den Testzweck."));
		entry = new Entry("DanielTestInsert","Dies ist ein Testeintrag");
	}

	@Test //JPA's save method returns the persisted entity which can never be null.
	public void testInsertOneEntry(){
		entryService.addEntry(entry);
		entry = entryService.addEntry(entry);
		assertThat(entry).isNotNull();
	}

	@Test
	public void testUpdateOneEntry(){
		entry.setName("DanielTestUpdate");
		entry = entryService.addEntry(entry);
		assertThat(entry).isNotNull();
	}

	@Test
	public void testInsertMultipleEntries(){
		entries = entryService.addEntries(entries);
		assertThat(entries).isNotNull();
	}

	@Test
	public void testFindAllEntries(){
		entries = entryService.findAll();
		assertThat(entries).isNotNull();
	}

	@Test
	public void testDeleteAllEntries(){
		entryService.deleteAll();
		assertThat(entryService.count()).isZero();
	}
}
