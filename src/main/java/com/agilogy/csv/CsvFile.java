package com.agilogy.csv;

public interface CsvFile {

	public abstract CsvRecord getEmptyRecord();

	public abstract void close();

	public abstract CsvStructure getStructure();

	public abstract void setStructure(CsvStructure structure);

}