package com.agilogy.csv;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;

public abstract class CsvStructure {
	protected String fieldSeparator = ",";
	protected String valueSeparator = "|";
	protected String recordSeparator = "\r\n";
	protected String dateFormat = "dd/MM/yyyy";
    protected DateFormat format;
    protected Map<String, Class> fields;
    
	protected CsvStructure() {
		fields = new LinkedHashMap<String, Class>();
		format = new SimpleDateFormat(dateFormat);
	}

	public String getFieldSeparator() {
		return fieldSeparator;
	}

	public void setFieldSeparator(String fieldSeparator) {
		this.fieldSeparator = fieldSeparator;
	}

	public String getValueSeparator() {
		return valueSeparator;
	}

	public void setValueSeparator(String valueSeparator) {
		this.valueSeparator = valueSeparator;
	}

	public String getRecordSeparator() {
		return recordSeparator;
	}

	public void setRecordSeparator(String recordSeparator) {
		this.recordSeparator = recordSeparator;
	}

	public String getDateFormat() {
		return dateFormat;
	}

	public void setDateFormat(String dateFormat) {
		this.dateFormat = dateFormat;
	}

	public String formatDate(Date date) {
		return format.format(date);
	}

    public Set<String> getFieldNames() {
        return fields.keySet();
    }
    
    public String getHeaders() {
        StringBuilder builder = new StringBuilder();
        for (String field : getFieldNames()) {
            builder.append(field);
            builder.append(getFieldSeparator());
        }
        for (int i = 0; i < (getFieldSeparator().length()); i++) {
            builder.deleteCharAt(builder.length() - 1);
        }
        builder.append(getRecordSeparator());
        return builder.toString();
    }


	public abstract void checkNewFieldValuePair(String fieldName, Object value);

}
