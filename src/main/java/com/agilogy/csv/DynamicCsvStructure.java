package com.agilogy.csv;

import java.util.Set;

public class DynamicCsvStructure extends CsvStructure{
	
	@Override
	public void checkNewFieldValuePair(String fieldName, Object value) {
		fields.put(fieldName, null);
	}

}
