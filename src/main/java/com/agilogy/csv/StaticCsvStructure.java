package com.agilogy.csv;
/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */


/**
 *
 * @author Jose
 */
public class StaticCsvStructure extends CsvStructure {

 
    public CsvStructure addField(String fieldName, Class<?> fieldType) {
        fields.put(fieldName, fieldType);
        return this;
    }

    public void checkNewFieldValuePair(String fieldName, Object value) {
        if (value == null) {
            return;
        }
        if (!fields.get(fieldName).isAssignableFrom(value.getClass())) {
            throw new IllegalArgumentException("Type mismatch in field " + fieldName + " and value " + value + ". Expected " + fields.get(fieldName) + " but was " + value.getClass());
        }

    }
}
