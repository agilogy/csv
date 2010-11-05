package com.agilogy.csv;


import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 *
 * @author Jose
 */
public class CsvRecord {
    Map<String, Set<Object>> values;
    CsvStructure structure;
    
    public CsvRecord(CsvStructure structure) {
        this.values = new HashMap<String, Set<Object>>();
        this.structure = structure;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        for (String field : structure.getFieldNames()) {
            builder.append(getValuesAsString(field));
            builder.append(structure.getFieldSeparator());
        }
        for (int i=0; i < (structure.getFieldSeparator().length()); i++ ) {
             builder.deleteCharAt(builder.length()-1);
        }
        builder.append(structure.getRecordSeparator());
        return builder.toString();
    }

    public String getValuesAsString(String fieldName) {
        StringBuilder builder = new StringBuilder();
        Set<Object> s =  values.get(fieldName);
        if (s == null) {
            return "";
        }
        for (Object o: s) {
            String valueString = o == null ? "" : o.toString();
            if (o instanceof Date) {
                valueString = structure.formatDate((Date)o);
            }
            valueString = valueString.replaceAll("\r", "");
            valueString = valueString.replaceAll("\n", " ");
            builder.append(valueString);
            builder.append(structure.getValueSeparator());
        }
        builder.deleteCharAt(builder.length()-1);
        return builder.toString();
    }

    public void addValue(String fieldName, Object value) {
        structure.checkNewFieldValuePair(fieldName, value);

        if (values.get(fieldName) == null) {
            Set<Object> s = new HashSet<Object>();
            values.put(fieldName, s);
        }
        values.get(fieldName).add(value);
    }
}
