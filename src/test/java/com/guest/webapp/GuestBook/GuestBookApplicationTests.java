package com.guest.webapp.GuestBook;

import com.guest.webapp.GuestBook.entities.Entry;
import com.guest.webapp.GuestBook.repositories.EntryRepository;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.util.Assert;
import java.util.ArrayList;
import java.util.List;

@SpringBootTest
class GuestBookApplicationTests {
	@Autowired
	private EntryRepository entryRepository;

	@Test
	void contextLoads() {
	}

	@BeforeAll
	static void setup() {
		System.out.println("Hello all");
	}

	@Test
	void testDeleteOneEntry() {
		//clear dataset
		entryRepository.deleteAll(); //now on 0
		List<Entry> currentEntries = entryRepository.findAll();
		Assert.isTrue(currentEntries.size()==0,"Nach dem Löschen sollte die DB Tabelle keine Einträge mehr halten");
		System.out.println("All entries deleted\n");

		//given
		//prepare dataset
		Entry entry = new Entry();
		List<Entry> entries = new ArrayList<>();
		entries.add(new Entry("Hans Meier","Hallo dies ist ein Gästebucheintrag.)"));
		entries.add(new Entry("Daniel","Dieses Gästebuch ist sehr schön, weiter so!"));
		entries.add(new Entry("Wolf","Diese Einträge sind nur für den Testzweck."));
		entryRepository.saveAll(entries);

		//when
		currentEntries = entryRepository.findAll(); //ist es ok wenn ich das gleiche Objekt nutze?
		Assert.isTrue(currentEntries.size()==3,"Entries must be 3");
		System.out.println("New entries saved\n");

		//delete Entry
		entry = currentEntries.get(0);
		entryRepository.deleteById(entry.getId());
		//entryRepository.deleteByName("Daniel"); //not a unique identifier, delete by last inserted id

		//then
		currentEntries = entryRepository.findAll();
		entry = currentEntries.get(0);
		//what is the dataset now?
		Assert.isTrue(currentEntries.size()==2,"Entries must be 2, after we deleted one");
		System.out.println("One entry deleted\n");
		Assert.isTrue(entry.getCreatedOn()!=null,"Make sure the date is automatically created");
		System.out.println("Date created\n");
	}
}
