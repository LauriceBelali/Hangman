package test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.io.IOException;
import java.util.Arrays;

import org.junit.Test;

import hangman.FileInteraction;

public class UnitTest {
	private FileInteraction fileInteraction = new FileInteraction("/strings.csv");

	@Test
	public void testGetRandomString() throws IOException {
		assertTrue(Arrays.asList("sweden", "france").contains(fileInteraction.getRandomString()));
	}

	@Test
	public void testGetAllString() throws IOException {
		assertEquals(2, fileInteraction.getAllStrings().length);
	}


}
