package com.agilogy.csv;

import static org.junit.Assert.*;

import java.io.File;
import java.io.IOException;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.agilogy.csv.util.CompareFiles;

public class InMemoryCsvFileTest {

	private static final String REFERENCE_FILE = "src/test/resources/inmemorycsvfile-reference.csv";
	private static final String FILE = "src/test/resources/inmemorycsvfile.csv";

	@After
	@Before
	public void cleanUp() {
		File f = new File(FILE);
		if (f.exists()) {
			f.delete();
		}
	}

	@Test
	public void testDynamicStructureInMemory() throws IOException {
		String FIELD1="Field 1";
		String VALUE1="Value 1";
		String FIELD2="Field 2";
		String VALUE2="Value 2";
		CsvFile file = new InMemoryCsvFile(FILE, "utf-8");
		file.setStructure(new DynamicCsvStructure());
		CsvRecord record = file.getEmptyRecord();
		record.addValue(FIELD1, VALUE1);
		record.addValue(FIELD2, VALUE2);
		file.close();
		assertTrue(CompareFiles.sameContents(REFERENCE_FILE, FILE));
	}
}
