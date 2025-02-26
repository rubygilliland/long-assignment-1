package test;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

import org.junit.jupiter.api.Test;

import model.Album;
import model.MusicStore;
import model.Song;

public class MusicStoreTest {

	@Test
	public void testGetSongByTitle() {
		MusicStore myStore = new MusicStore();
		String result = myStore.getSongByTitle("Here We Go");
		assertEquals(result, "Here We Go - by: Ozomatli (Don't Mess With the Dragon)\n");
	}
	
	@Test
	public void testGetSongByArtist() {
		MusicStore myStore = new MusicStore();
		String result = myStore.getSongByArtist("Coldplay");
		String otherResult = "Politik - by: Coldplay (A Rush of Blood to the Head)\n" +
							"In My Place - by: Coldplay (A Rush of Blood to the Head)\n" +
							"God Put a Smile Upon Your Face - by: Coldplay (A Rush of Blood to the Head)\n" +
							"The Scientist - by: Coldplay (A Rush of Blood to the Head)\n" + 
							"Clocks - by: Coldplay (A Rush of Blood to the Head)\n" +
							"Daylight - by: Coldplay (A Rush of Blood to the Head)\n" +
							"Green Eyes - by: Coldplay (A Rush of Blood to the Head)\n" +
							"Warning Sign - by: Coldplay (A Rush of Blood to the Head)\n" +
							"A Whisper - by: Coldplay (A Rush of Blood to the Head)\n" +
							"A Rush of Blood to the Head - by: Coldplay (A Rush of Blood to the Head)\n" +
							"Amsterdam - by: Coldplay (A Rush of Blood to the Head)\n";
							
							
							
		assertEquals(result, otherResult);
	}
	
	
	@Test
	public void testGetAlbumByTitle() {
		MusicStore myStore = new MusicStore();
		String result = myStore.getAlbumByTitle("21");
		String otherResult = "21 - by: Adele (POP) 2011\n" +
							"\tRolling in the Deep - by: Adele (21)\n" +
							"\tRumour Has It - by: Adele (21)\n" +
							"\tTurning Tables - by: Adele (21)\n" +
							"\tDon't You Remember - by: Adele (21)\n" +
							"\tSet Fire to the Rain - by: Adele (21)\n" +
							"\tHe Won't Go - by: Adele (21)\n" +
							"\tTake It All - by: Adele (21)\n" +
							"\tI'll Be Waiting - by: Adele (21)\n" +
							"\tOne and Only - by: Adele (21)\n" +
							"\tLovesong - by: Adele (21)\n" +
							"\tSomeone Like You - by: Adele (21)\n" +
							"\tI Found a Boy - by: Adele (21)\n";		
							
		assertEquals(result, otherResult);
	}
	
	@Test
	public void testGetAlbumByArtist() {
		MusicStore myStore = new MusicStore();
		String result = myStore.getAlbumByArtist("Leonard Cohen");
		String otherResult = "Old Ideas - by: Leonard Cohen (SINGER_SONGWRITER) 2012\n" +
							"\tGoing Home - by: Leonard Cohen (Old Ideas)\n" +
							"\tAmen - by: Leonard Cohen (Old Ideas)\n" +
							"\tShow Me the Place - by: Leonard Cohen (Old Ideas)\n" +
							"\tDarkness - by: Leonard Cohen (Old Ideas)\n" +
							"\tAnyhow - by: Leonard Cohen (Old Ideas)\n" +
							"\tCrazy to Love You - by: Leonard Cohen (Old Ideas)\n" +
							"\tCome Healing - by: Leonard Cohen (Old Ideas)\n" +
							"\tBanjo - by: Leonard Cohen (Old Ideas)\n" +
							"\tLullaby - by: Leonard Cohen (Old Ideas)\n" +
							"\tDifferent Sides - by: Leonard Cohen (Old Ideas)\n";
							
		assertEquals(result, otherResult);
	}
	
	@Test
	public void testGetAlbums() {
		MusicStore myStore = new MusicStore();
		ArrayList<Album> result = myStore.getAlbums();
		ArrayList<Album> otherResult = new ArrayList<>();
		otherResult.add(new Album("19", "Adele", "POP", "2008"));
		otherResult.add(new Album("21", "Adele", "POP", "2011"));
		otherResult.add(new Album("Begin Again", "Norah Jones", "POP", "2018"));
		otherResult.add(new Album("Boys & Girls", "Alabama Shakes", "ALTERNATIVE", "2012"));
		otherResult.add(new Album("Cuando Los Angeles Lloran", "Mana", "LATIN", "1995"));
		otherResult.add(new Album("Don't Mess With the Dragon", "Ozomatli", "ROCK", "2007"));
		otherResult.add(new Album("Fight for Your Mind", "Ben Harper", "ALTERNATIVE", "1995"));
		otherResult.add(new Album("Mission Bell", "Amos Lee", "SINGER/SONGWRITER", "2010"));
		otherResult.add(new Album("Old Ideas", "Leonard Cohen", "SINGER/SONGWRITER", "2012"));
		otherResult.add(new Album("Sigh No More", "Mumford & Sons", "ALTERNATIVE", "2009"));
		otherResult.add(new Album("Waking Up", "OneRepublic", "ROCK", "2009"));
		otherResult.add(new Album("A Rush of Blood to the Head", "Coldplay", "ALTERNATIVE", "2002"));
		otherResult.add(new Album("Coat of Many Colors", "Dolly Parton", "TRADITIONAl COUNTRY", "1971"));
		otherResult.add(new Album("Tapestry", "Carol King", "ROCK", "1971"));
		otherResult.add(new Album("Sons", "The Heavy", "ROCK", "2019"));
		
		for (int i = 0; i < result.size(); i++) {
			assertEquals(result.get(i), otherResult.get(i));
		}
	}
	
	@Test
	public void testGetSongs() {
		MusicStore myStore = new MusicStore();
		ArrayList<Song> result = myStore.getSongs();
		ArrayList<Song> otherResult = new ArrayList<>();
		otherResult.add(new Song("Daydreamer", "Adele"));
		otherResult.add(new Song("Best for Last", "Adele"));
		otherResult.add(new Song("Chasing Pavements", "Adele"));
		otherResult.add(new Song("Cold Shoulder", "Adele"));
		otherResult.add(new Song("Crazy for You", "Adele"));
		otherResult.add(new Song("Melt My Heart to Stone", "Adele"));
		otherResult.add(new Song("First Love", "Adele"));
		otherResult.add(new Song("Right as Rain", "Adele"));
		otherResult.add(new Song("Make You Feel My Love", "Adele"));
		otherResult.add(new Song("My Same", "Adele"));
		otherResult.add(new Song("Tired", "Adele"));
		otherResult.add(new Song("Hometown Glory", "Adele"));
		otherResult.add(new Song("Rolling in the Deep", "Adele"));
		otherResult.add(new Song("Rumour Has It", "Adele"));
		otherResult.add(new Song("Turning Tables", "Adele"));
		otherResult.add(new Song("Don't You Remember", "Adele"));
		otherResult.add(new Song("Set Fire to the Rain", "Adele"));
		otherResult.add(new Song("He Won't Go", "Adele"));
		otherResult.add(new Song("Take It All", "Adele"));
		otherResult.add(new Song("I'll Be Waiting", "Adele"));
		otherResult.add(new Song("One and Only", "Adele"));
		otherResult.add(new Song("Lovesong", "Adele"));
		otherResult.add(new Song("Someone Like You", "Adele"));
		otherResult.add(new Song("I Found a Boy", "Adele"));
		otherResult.add(new Song("My Heart Is Full", "Norah Jones"));
		otherResult.add(new Song("Begin Again", "Norah Jones"));
		otherResult.add(new Song("It Was You", "Norah Jones"));
		otherResult.add(new Song("A Song with No Name", "Norah Jones"));
		otherResult.add(new Song("Uh Oh", "Norah Jones"));
		otherResult.add(new Song("Wintertime", "Norah Jones"));
		otherResult.add(new Song("Just a Little Bit", "Norah Jones"));
		otherResult.add(new Song("Hold On", "Alabama Shakes"));
		otherResult.add(new Song("I Found You", "Alabama Shakes"));
		otherResult.add(new Song("Hang Loose", "Alabama Shakes"));
		otherResult.add(new Song("Rise to the Sun", "Alabama Shakes"));
		otherResult.add(new Song("You Ain't Alone", "Alabama Shakes"));
		otherResult.add(new Song("Goin' to the Party", "Alabama Shakes"));
		otherResult.add(new Song("Heartbreaker", "Alabama Shakes"));
		otherResult.add(new Song("Boys & Girls", "Alabama Shakes"));
		otherResult.add(new Song("Be Mine", "Alabama Shakes"));
		otherResult.add(new Song("I Ain't the Same", "Alabama Shakes"));
		otherResult.add(new Song("On Your Way", "Alabama Shakes"));
		otherResult.add(new Song("Heavy Chevy (Bonus Track)", "Alabama Shakes"));
		otherResult.add(new Song("Como Un Perro Enloquecido", "Mana"));
		otherResult.add(new Song("Selva Negra", "Mana"));
		otherResult.add(new Song("Hundido En Un Rincon", "Mana"));
		otherResult.add(new Song("El Reloj Cucu", "Mana"));
		otherResult.add(new Song("Mis Ojos", "Mana"));
		otherResult.add(new Song("Ana", "Mana"));
		otherResult.add(new Song("Siempre El Amor", "Mana"));
		otherResult.add(new Song("Cuando Los Angeles Lloran", "Mana"));
		otherResult.add(new Song("Dejame Entrar", "Mana"));
		otherResult.add(new Song("No Ha Parado de Llover", "Mana"));
		otherResult.add(new Song("Antifaz", "Mana"));
		otherResult.add(new Song("El Borracho", "Mana"));
		otherResult.add(new Song("City Of Angels", "Ozomatli"));
		otherResult.add(new Song("After Party", "Ozomatli"));
		otherResult.add(new Song("Don't Mess With The Dragon", "Ozomatli"));
		otherResult.add(new Song("La Gallina", "Ozomatli"));
		otherResult.add(new Song("Magnolia Soul", "Ozomatli"));
		otherResult.add(new Song("Here We Go", "Ozomatli"));
		otherResult.add(new Song("La Temperatura", "Ozomatli"));
		otherResult.add(new Song("Violeta", "Ozomatli"));
		otherResult.add(new Song("Creo", "Ozomatli"));
		otherResult.add(new Song("When I Close My Eyes", "Ozomatli"));
		otherResult.add(new Song("Oppression", "Ben Harper"));
		otherResult.add(new Song("Ground on Down", "Ben Harper"));
		otherResult.add(new Song("Another Lonely Day", "Ben Harper"));
		otherResult.add(new Song("Gold to Me", "Ben Harper"));
		otherResult.add(new Song("Burn One Down", "Ben Harper"));
		otherResult.add(new Song("Excuse Me Mr.", "Ben Harper"));
		otherResult.add(new Song("People Lead", "Ben Harper"));
		otherResult.add(new Song("Fight for Your Mind", "Ben Harper"));
		otherResult.add(new Song("Give a Man a Home", "Ben Harper"));
		otherResult.add(new Song("By My Side", "Ben Harper"));
		otherResult.add(new Song("Power of the Gospel", "Ben Harper"));
		otherResult.add(new Song("God Fearing Man", "Ben Harper"));
		otherResult.add(new Song("One Road to Freedom", "Ben Harper"));
		otherResult.add(new Song("El Camino", "Amos Lee"));
		otherResult.add(new Song("Windows Are Rolled Down", "Amos Lee"));
		otherResult.add(new Song("Flower", "Amos Lee"));
		otherResult.add(new Song("Stay With Me", "Amos Lee"));
		otherResult.add(new Song("Out of the Cold", "Amos Lee"));
		otherResult.add(new Song("Jesus", "Amos Lee"));
		otherResult.add(new Song("Hello Again", "Amos Lee"));
		otherResult.add(new Song("Cup of Sorrow", "Amos Lee"));
		otherResult.add(new Song("Clear Blue Eyes (feat. Lucinda Williams)", "Amos Lee"));
		otherResult.add(new Song("Behind Me Now", "Amos Lee"));
		otherResult.add(new Song("Going Home", "Leonard Cohen"));
		otherResult.add(new Song("Amen", "Leonard Cohen"));
		otherResult.add(new Song("Show Me the Place", "Leonard Cohen"));
		otherResult.add(new Song("Darkness", "Leonard Cohen"));
		otherResult.add(new Song("Anyhow", "Leonard Cohen"));
		otherResult.add(new Song("Crazy to Love You", "Leonard Cohen"));
		otherResult.add(new Song("Come Healing", "Leonard Cohen"));
		otherResult.add(new Song("Banjo", "Leonard Cohen"));
		otherResult.add(new Song("Lullaby", "Leonard Cohen"));
		otherResult.add(new Song("Different Sides", "Leonard Cohen"));
		otherResult.add(new Song("Sigh No More", "Mumford & Sons"));
		otherResult.add(new Song("The Cave", "Mumford & Sons"));
		otherResult.add(new Song("Winter Winds", "Mumford & Sons"));
		otherResult.add(new Song("Roll Away Your Stone", "Mumford & Sons"));
		otherResult.add(new Song("White Blank Page", "Mumford & Sons"));
		otherResult.add(new Song("I Gave You All", "Mumford & Sons"));
		otherResult.add(new Song("Little Lion Man", "Mumford & Sons"));
		otherResult.add(new Song("Timshel", "Mumford & Sons"));
		otherResult.add(new Song("Thistle & Weeds", "Mumford & Sons"));
		otherResult.add(new Song("Awake My Soul", "Mumford & Sons"));
		otherResult.add(new Song("Dust Bowl Dance", "Mumford & Sons"));
		otherResult.add(new Song("After the Storm", "Mumford & Sons"));
		otherResult.add(new Song("Made for You", "OneRepublic"));
		otherResult.add(new Song("All the Right Moves", "OneRepublic"));
		otherResult.add(new Song("Secrets", "OneRepublic"));
		otherResult.add(new Song("Everybody Loves Me", "OneRepublic"));
		otherResult.add(new Song("Missing Persons 1 & 2", "OneRepublic"));
		otherResult.add(new Song("Good Life", "OneRepublic"));
		otherResult.add(new Song("All This Time", "OneRepublic"));
		otherResult.add(new Song("Fear", "OneRepublic"));
		otherResult.add(new Song("Waking Up", "OneRepublic"));
		otherResult.add(new Song("Marchin On", "OneRepublic"));
		otherResult.add(new Song("Lullaby", "OneRepublic"));
		otherResult.add(new Song("Politik", "Coldplay"));
		otherResult.add(new Song("In My Place", "Coldplay"));
		otherResult.add(new Song("God Put a Smile Upon Your Face", "Coldplay"));
		otherResult.add(new Song("The Scientist", "Coldplay"));
		otherResult.add(new Song("Clocks", "Coldplay"));
		otherResult.add(new Song("Daylight", "Coldplay"));
		otherResult.add(new Song("Green Eyes", "Coldplay"));
		otherResult.add(new Song("Warning Sign", "Coldplay"));
		otherResult.add(new Song("A Whisper", "Coldplay"));
		otherResult.add(new Song("A Rush of Blood to the Head", "Coldplay"));
		otherResult.add(new Song("Amsterdam", "Coldplay"));
		otherResult.add(new Song("Coat of Many Colors", "Dolly Parton"));
		otherResult.add(new Song("Traveling Man", "Dolly Parton"));
		otherResult.add(new Song("My Blue Tears", "Dolly Parton"));
		otherResult.add(new Song("If I Lose My Mind", "Dolly Parton"));
		otherResult.add(new Song("The Mystery of the Mystery", "Dolly Parton"));
		otherResult.add(new Song("She Never Met a Man (She Didn't Like)", "Dolly Parton"));
		otherResult.add(new Song("Early Morning Breeze", "Dolly Parton"));
		otherResult.add(new Song("The Way I See You", "Dolly Parton"));
		otherResult.add(new Song("Here I Am", "Dolly Parton"));
		otherResult.add(new Song("A Better Place to Live", "Dolly Parton"));
		otherResult.add(new Song("I Feel The Earth Move", "Carol King"));
		otherResult.add(new Song("So Far Away", "Carol King"));
		otherResult.add(new Song("Home Again", "Carol King"));
		otherResult.add(new Song("Beautiful", "Carol King"));
		otherResult.add(new Song("Way Over Yonder", "Carol King"));
		otherResult.add(new Song("You've Got A Friend", "Carol King"));
		otherResult.add(new Song("Where You Lead", "Carol King"));
		otherResult.add(new Song("Will You Love Me Tomorrow?", "Carol King"));
		otherResult.add(new Song("Tapestry", "Carol King"));
		otherResult.add(new Song("(You Make Me Feel Like) A Natural Woman", "Carol King"));
		otherResult.add(new Song("Heavy for You", "The Heavy"));
		otherResult.add(new Song("The Thief", "The Heavy"));
		otherResult.add(new Song("Better as One", "The Heavy"));
		otherResult.add(new Song("Fire", "The Heavy"));
		otherResult.add(new Song("Fighting for the Same Thing", "The Heavy"));
		otherResult.add(new Song("Hurt Interlude", "The Heavy"));
		otherResult.add(new Song("Put the Hurt on Me", "The Heavy"));
		otherResult.add(new Song("Simple Things", "The Heavy"));
		otherResult.add(new Song("A Whole Lot of Love", "The Heavy"));
		otherResult.add(new Song("What Don't Kill You", "The Heavy"));
		otherResult.add(new Song("Burn Bright", "The Heavy"));
		
		for (int i = 0; i < result.size(); i++) {
			assertEquals(result.get(i), otherResult.get(i));
		}
		
	}
	
	@Test
	public void testToString(){
		MusicStore myStore = new MusicStore();
		String result = myStore.toString();
		// This string was written by AI
		String musicStore = "Music Store:\n" +
                "\tAlbums:\n" +
                "\t\t1. 19 - by: Adele (POP) 2008\n" +
                "\t\t2. 21 - by: Adele (POP) 2011\n" +
                "\t\t3. Begin Again - by: Norah Jones (POP) 2018\n" +
                "\t\t4. Boys & Girls - by: Alabama Shakes (ALTERNATIVE) 2012\n" +
                "\t\t5. Cuando Los Angeles Lloran - by: Mana (LATIN) 1995\n" +
                "\t\t6. Don't Mess With the Dragon - by: Ozomatli (ROCK) 2007\n" +
                "\t\t7. Fight for Your Mind - by: Ben Harper (ALTERNATIVE) 1995\n" +
                "\t\t8. Mission Bell - by: Amos Lee (SINGER_SONGWRITER) 2010\n" +
                "\t\t9. Old Ideas - by: Leonard Cohen (SINGER_SONGWRITER) 2012\n" +
                "\t\t10. Sigh No More - by: Mumford & Sons (ALTERNATIVE) 2009\n" +
                "\t\t11. Waking Up - by: OneRepublic (ROCK) 2009\n" +
                "\t\t12. A Rush of Blood to the Head - by: Coldplay (ALTERNATIVE) 2002\n" +
                "\t\t13. Coat of Many Colors - by: Dolly Parton (TRADITIONAL_COUNTRY) 1971\n" +
                "\t\t14. Tapestry - by: Carol King (ROCK) 1971\n" +
                "\t\t15. Sons - by: The Heavy (ROCK) 2019\n" +
                "\tSongs:\n" +
                "\t\t1. Daydreamer - by: Adele (19)\n" +
                "\t\t2. Best for Last - by: Adele (19)\n" +
                "\t\t3. Chasing Pavements - by: Adele (19)\n" +
                "\t\t4. Cold Shoulder - by: Adele (19)\n" +
                "\t\t5. Crazy for You - by: Adele (19)\n" +
                "\t\t6. Melt My Heart to Stone - by: Adele (19)\n" +
                "\t\t7. First Love - by: Adele (19)\n" +
                "\t\t8. Right as Rain - by: Adele (19)\n" +
                "\t\t9. Make You Feel My Love - by: Adele (19)\n" +
                "\t\t10. My Same - by: Adele (19)\n" +
                "\t\t11. Tired - by: Adele (19)\n" +
                "\t\t12. Hometown Glory - by: Adele (19)\n" +
                "\t\t13. Rolling in the Deep - by: Adele (21)\n" +
                "\t\t14. Rumour Has It - by: Adele (21)\n" +
                "\t\t15. Turning Tables - by: Adele (21)\n" +
                "\t\t16. Don't You Remember - by: Adele (21)\n" +
                "\t\t17. Set Fire to the Rain - by: Adele (21)\n" +
                "\t\t18. He Won't Go - by: Adele (21)\n" +
                "\t\t19. Take It All - by: Adele (21)\n" +
                "\t\t20. I'll Be Waiting - by: Adele (21)\n" +
                "\t\t21. One and Only - by: Adele (21)\n" +
                "\t\t22. Lovesong - by: Adele (21)\n" +
                "\t\t23. Someone Like You - by: Adele (21)\n" +
                "\t\t24. I Found a Boy - by: Adele (21)\n" +
                "\t\t25. My Heart Is Full - by: Norah Jones (Begin Again)\n" +
                "\t\t26. Begin Again - by: Norah Jones (Begin Again)\n" +
                "\t\t27. It Was You - by: Norah Jones (Begin Again)\n" +
                "\t\t28. A Song with No Name - by: Norah Jones (Begin Again)\n" +
                "\t\t29. Uh Oh - by: Norah Jones (Begin Again)\n" +
                "\t\t30. Wintertime - by: Norah Jones (Begin Again)\n" +
                "\t\t31. Just a Little Bit - by: Norah Jones (Begin Again)\n" +
                "\t\t32. Hold On - by: Alabama Shakes (Boys & Girls)\n" +
                "\t\t33. I Found You - by: Alabama Shakes (Boys & Girls)\n" +
                "\t\t34. Hang Loose - by: Alabama Shakes (Boys & Girls)\n" +
                "\t\t35. Rise to the Sun - by: Alabama Shakes (Boys & Girls)\n" +
                "\t\t36. You Ain't Alone - by: Alabama Shakes (Boys & Girls)\n" +
                "\t\t37. Goin' to the Party - by: Alabama Shakes (Boys & Girls)\n" +
                "\t\t38. Heartbreaker - by: Alabama Shakes (Boys & Girls)\n" +
                "\t\t39. Boys & Girls - by: Alabama Shakes (Boys & Girls)\n" +
                "\t\t40. Be Mine - by: Alabama Shakes (Boys & Girls)\n" +
                "\t\t41. I Ain't the Same - by: Alabama Shakes (Boys & Girls)\n" +
                "\t\t42. On Your Way - by: Alabama Shakes (Boys & Girls)\n" +
                "\t\t43. Heavy Chevy (Bonus Track) - by: Alabama Shakes (Boys & Girls)\n" +
                "\t\t44. Como Un Perro Enloquecido - by: Mana (Cuando Los Angeles Lloran)\n" +
                "\t\t45. Selva Negra - by: Mana (Cuando Los Angeles Lloran)\n" +
                "\t\t46. Hundido En Un Rincon - by: Mana (Cuando Los Angeles Lloran)\n" +
                "\t\t47. El Reloj Cucu - by: Mana (Cuando Los Angeles Lloran)\n" +
                "\t\t48. Mis Ojos - by: Mana (Cuando Los Angeles Lloran)\n" +
                "\t\t49. Ana - by: Mana (Cuando Los Angeles Lloran)\n" +
                "\t\t50. Siempre El Amor - by: Mana (Cuando Los Angeles Lloran)\n" +
                "\t\t51. Cuando Los Angeles Lloran - by: Mana (Cuando Los Angeles Lloran)\n" +
                "\t\t52. Dejame Entrar - by: Mana (Cuando Los Angeles Lloran)\n" +
                "\t\t53. No Ha Parado de Llover - by: Mana (Cuando Los Angeles Lloran)\n" +
                "\t\t54. Antifaz - by: Mana (Cuando Los Angeles Lloran)\n" +
                "\t\t55. El Borracho - by: Mana (Cuando Los Angeles Lloran)\n" +
                "\t\t56. City Of Angels - by: Ozomatli (Don't Mess With the Dragon)\n" +
                "\t\t57. After Party - by: Ozomatli (Don't Mess With the Dragon)\n" +
                "\t\t58. Don't Mess With The Dragon - by: Ozomatli (Don't Mess With the Dragon)\n" +
                "\t\t59. La Gallina - by: Ozomatli (Don't Mess With the Dragon)\n" +
                "\t\t60. Magnolia Soul - by: Ozomatli (Don't Mess With the Dragon)\n" +
                "\t\t61. Here We Go - by: Ozomatli (Don't Mess With the Dragon)\n" +
                "\t\t62. La Temperatura - by: Ozomatli (Don't Mess With the Dragon)\n" +
                "\t\t63. Violeta - by: Ozomatli (Don't Mess With the Dragon)\n" +
                "\t\t64. Creo - by: Ozomatli (Don't Mess With the Dragon)\n" +
                "\t\t65. When I Close My Eyes - by: Ozomatli (Don't Mess With the Dragon)\n" +
                "\t\t66. Oppression - by: Ben Harper (Fight for Your Mind)\n" +
                "\t\t67. Ground on Down - by: Ben Harper (Fight for Your Mind)\n" +
                "\t\t68. Another Lonely Day - by: Ben Harper (Fight for Your Mind)\n" +
                "\t\t69. Gold to Me - by: Ben Harper (Fight for Your Mind)\n" +
                "\t\t70. Burn One Down - by: Ben Harper (Fight for Your Mind)\n" +
                "\t\t71. Excuse Me Mr. - by: Ben Harper (Fight for Your Mind)\n" +
                "\t\t72. People Lead - by: Ben Harper (Fight for Your Mind)\n" +
                "\t\t73. Fight for Your Mind - by: Ben Harper (Fight for Your Mind)\n" +
                "\t\t74. Give a Man a Home - by: Ben Harper (Fight for Your Mind)\n" +
                "\t\t75. By My Side - by: Ben Harper (Fight for Your Mind)\n" +
                "\t\t76. Power of the Gospel - by: Ben Harper (Fight for Your Mind)\n" +
                "\t\t77. God Fearing Man - by: Ben Harper (Fight for Your Mind)\n" +
                "\t\t78. One Road to Freedom - by: Ben Harper (Fight for Your Mind)\n" +
                "\t\t79. El Camino - by: Amos Lee (Mission Bell)\n" +
                "\t\t80. Windows Are Rolled Down - by: Amos Lee (Mission Bell)\n" +
                "\t\t81. Flower - by: Amos Lee (Mission Bell)\n" +
                "\t\t82. Stay With Me - by: Amos Lee (Mission Bell)\n" +
                "\t\t83. Out of the Cold - by: Amos Lee (Mission Bell)\n" +
                "\t\t84. Jesus - by: Amos Lee (Mission Bell)\n" +
                "\t\t85. Hello Again - by: Amos Lee (Mission Bell)\n" +
                "\t\t86. Cup of Sorrow - by: Amos Lee (Mission Bell)\n" +
                "\t\t87. Clear Blue Eyes (feat. Lucinda Williams) - by: Amos Lee (Mission Bell)\n" +
                "\t\t88. Behind Me Now - by: Amos Lee (Mission Bell)\n" +
                "\t\t89. Going Home - by: Leonard Cohen (Old Ideas)\n" +
                "\t\t90. Amen - by: Leonard Cohen (Old Ideas)\n" +
                "\t\t91. Show Me the Place - by: Leonard Cohen (Old Ideas)\n" +
                "\t\t92. Darkness - by: Leonard Cohen (Old Ideas)\n" +
                "\t\t93. Anyhow - by: Leonard Cohen (Old Ideas)\n" +
                "\t\t94. Crazy to Love You - by: Leonard Cohen (Old Ideas)\n" +
                "\t\t95. Come Healing - by: Leonard Cohen (Old Ideas)\n" +
                "\t\t96. Banjo - by: Leonard Cohen (Old Ideas)\n" +
                "\t\t97. Lullaby - by: Leonard Cohen (Old Ideas)\n" +
                "\t\t98. Different Sides - by: Leonard Cohen (Old Ideas)\n" +
                "\t\t99. Sigh No More - by: Mumford & Sons (Sigh No More)\n" +
                "\t\t100. The Cave - by: Mumford & Sons (Sigh No More)\n" +
                "\t\t101. Winter Winds - by: Mumford & Sons (Sigh No More)\n" +
                "\t\t102. Roll Away Your Stone - by: Mumford & Sons (Sigh No More)\n" +
                "\t\t103. White Blank Page - by: Mumford & Sons (Sigh No More)\n" +
                "\t\t104. I Gave You All - by: Mumford & Sons (Sigh No More)\n" +
                "\t\t105. Little Lion Man - by: Mumford & Sons (Sigh No More)\n" +
                "\t\t106. Timshel - by: Mumford & Sons (Sigh No More)\n" +
                "\t\t107. Thistle & Weeds - by: Mumford & Sons (Sigh No More)\n" +
                "\t\t108. Awake My Soul - by: Mumford & Sons (Sigh No More)\n" +
                "\t\t109. Dust Bowl Dance - by: Mumford & Sons (Sigh No More)\n" +
                "\t\t110. After the Storm - by: Mumford & Sons (Sigh No More)\n" +
                "\t\t111. Made for You - by: OneRepublic (Waking Up)\n" +
                "\t\t112. All the Right Moves - by: OneRepublic (Waking Up)\n" +
                "\t\t113. Secrets - by: OneRepublic (Waking Up)\n" +
                "\t\t114. Everybody Loves Me - by: OneRepublic (Waking Up)\n" +
                "\t\t115. Missing Persons 1 & 2 - by: OneRepublic (Waking Up)\n" +
                "\t\t116. Good Life - by: OneRepublic (Waking Up)\n" +
                "\t\t117. All This Time - by: OneRepublic (Waking Up)\n" +
                "\t\t118. Fear - by: OneRepublic (Waking Up)\n" +
                "\t\t119. Waking Up - by: OneRepublic (Waking Up)\n" +
                "\t\t120. Marchin On - by: OneRepublic (Waking Up)\n" +
                "\t\t121. Lullaby - by: OneRepublic (Waking Up)\n" +
                "\t\t122. Politik - by: Coldplay (A Rush of Blood to the Head)\n" +
                "\t\t123. In My Place - by: Coldplay (A Rush of Blood to the Head)\n" +
                "\t\t124. God Put a Smile Upon Your Face - by: Coldplay (A Rush of Blood to the Head)\n" +
                "\t\t125. The Scientist - by: Coldplay (A Rush of Blood to the Head)\n" +
                "\t\t126. Clocks - by: Coldplay (A Rush of Blood to the Head)\n" +
                "\t\t127. Daylight - by: Coldplay (A Rush of Blood to the Head)\n" +
                "\t\t128. Green Eyes - by: Coldplay (A Rush of Blood to the Head)\n" +
                "\t\t129. Warning Sign - by: Coldplay (A Rush of Blood to the Head)\n" +
                "\t\t130. A Whisper - by: Coldplay (A Rush of Blood to the Head)\n" +
                "\t\t131. A Rush of Blood to the Head - by: Coldplay (A Rush of Blood to the Head)\n" +
                "\t\t132. Amsterdam - by: Coldplay (A Rush of Blood to the Head)\n" +
                "\t\t133. Coat of Many Colors - by: Dolly Parton (Coat of Many Colors)\n" +
                "\t\t134. Traveling Man - by: Dolly Parton (Coat of Many Colors)\n" +
                "\t\t135. My Blue Tears - by: Dolly Parton (Coat of Many Colors)\n" +
                "\t\t136. If I Lose My Mind - by: Dolly Parton (Coat of Many Colors)\n" +
                "\t\t137. The Mystery of the Mystery - by: Dolly Parton (Coat of Many Colors)\n" +
                "\t\t138. She Never Met a Man (She Didn't Like) - by: Dolly Parton (Coat of Many Colors)\n" +
                "\t\t139. Early Morning Breeze - by: Dolly Parton (Coat of Many Colors)\n" +
                "\t\t140. The Way I See You - by: Dolly Parton (Coat of Many Colors)\n" +
                "\t\t141. Here I Am - by: Dolly Parton (Coat of Many Colors)\n" +
                "\t\t142. A Better Place to Live - by: Dolly Parton (Coat of Many Colors)\n" +
                "\t\t143. I Feel The Earth Move - by: Carol King (Tapestry)\n" +
                "\t\t144. So Far Away - by: Carol King (Tapestry)\n" +
                "\t\t145. Home Again - by: Carol King (Tapestry)\n" +
                "\t\t146. Beautiful - by: Carol King (Tapestry)\n" +
                "\t\t147. Way Over Yonder - by: Carol King (Tapestry)\n" +
                "\t\t148. You've Got A Friend - by: Carol King (Tapestry)\n" +
                "\t\t149. Where You Lead - by: Carol King (Tapestry)\n" +
                "\t\t150. Will You Love Me Tomorrow? - by: Carol King (Tapestry)\n" +
                "\t\t151. Tapestry - by: Carol King (Tapestry)\n" +
                "\t\t152. (You Make Me Feel Like) A Natural Woman - by: Carol King (Tapestry)\n" +
                "\t\t153. Heavy for You - by: The Heavy (Sons)\n" +
                "\t\t154. The Thief - by: The Heavy (Sons)\n" +
                "\t\t155. Better as One - by: The Heavy (Sons)\n" +
                "\t\t156. Fire - by: The Heavy (Sons)\n" +
                "\t\t157. Fighting for the Same Thing - by: The Heavy (Sons)\n" +
                "\t\t158. Hurt Interlude - by: The Heavy (Sons)\n" +
                "\t\t159. Put the Hurt on Me - by: The Heavy (Sons)\n" +
                "\t\t160. Simple Things - by: The Heavy (Sons)\n" +
                "\t\t161. A Whole Lot of Love - by: The Heavy (Sons)\n" +
                "\t\t162. What Don't Kill You - by: The Heavy (Sons)\n" +
                "\t\t163. Burn Bright - by: The Heavy (Sons)\n";
		
		assertEquals(result, musicStore);
		
		
	}
	
	
}
