package com.agilogy.csv;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 */
public class InMemoryCsvFile implements CsvFile {
    CsvStructure structure;
    List<CsvRecord> records;
	private String encoding;
	private String fileName;
  
    public InMemoryCsvFile(String fileName, String encoding) {
        structure = new StaticCsvStructure();
        records = new LinkedList<CsvRecord>();
        this.fileName = fileName;
        this.encoding = encoding;
    }

    @Override
	public CsvStructure getStructure() {
        return structure;
    }
    
	@Override
	public void setStructure(CsvStructure structure) {
		this.structure = structure;
	}

    @Override
	public void close() {
        try {
            OutputStreamWriter writer = new OutputStreamWriter( new FileOutputStream(fileName) , encoding);
            writer.write(structure.getHeaders());
            for(CsvRecord record:records) {
                writer.write(record.toString());
            }
            writer.close();
        } catch (IOException ex) {
            Logger.getLogger(InMemoryCsvFile.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
	public CsvRecord getEmptyRecord() {
        CsvRecord record = new CsvRecord(structure);
        records.add(record);
        return record;
    }
}
