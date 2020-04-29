package com.guest.webapp.GuestBook;
import com.guest.webapp.GuestBook.entities.Entry;
import com.guest.webapp.GuestBook.repositories.EntryRepository;
import org.junit.After;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.util.Assert;
import java.util.ArrayList;
import java.util.List;
import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
class GuestBookApplicationTests {

	static private List<Entry> entries = new ArrayList<>();
	static private Entry entry;

	@Autowired
	private EntryRepository entryRepository;


	@BeforeAll
	static void setup(){ //prepare dataset
		entries.add(new Entry("Hans Meier","Hallo dies ist ein Gästebucheintrag.)"));
		entries.add(new Entry("Daniel","Dieses Gästebuch ist sehr schön, weiter so!"));
		entries.add(new Entry("Wolf","Diese Einträge sind nur für den Testzweck."));
		entry = new Entry("DanielTestInsert","Dies ist ein Testeintrag");
	}

	@Test //JPA's save method returns the persisted entity which can never be null.
	@Order(1)
	void testInsertOneEntry(){
		entry = entryRepository.save(entry);
		assertThat(entry).isNotNull();
	}

	@Test
	@Order(2)
	void testUpdateOneEntry(){
		entry.setName("DanielTestUpdate");
		entry = entryRepository.save(entry);
		assertThat(entry).isNotNull();
	}

	@Test
	@Order(3)
	void testInsertMultipleEntries(){
		entries = entryRepository.saveAll(entries);
		assertThat(entries).isNotNull();
	}

	@Test
	@Order(4)
	void testFindAllEntries(){
		entries = entryRepository.findAll();
		assertThat(entries).isNotNull();
	}

	@Test
	@Order(5)
	void testDeleteAllEntries(){
		entryRepository.deleteAll();
		assertThat(entryRepository.count()).isZero();
	}
}
