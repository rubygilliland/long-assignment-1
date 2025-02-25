package test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import model.MusicStore;

class MusicStoreTest {

	@Test
	void testGetSongByTitle() {
		MusicStore myStore = new MusicStore();
		String result = myStore.getSongByTitle("Here We Go");
		assertEquals(result, "Here We Go by Ozomalti (Don't Mess With the Dragon\n");
	}

}
