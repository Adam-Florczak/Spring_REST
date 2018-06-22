package com.github.adamflorczak.exceptions;




public class ValidationError {

private String field;
private String description;

    public ValidationError() {
    }



    public ValidationError(String field, String description) {
        this.field = field;
        this.description = description;
    }

    public String getField() {
        return field;
    }

    public String getDescription() {
        return description;
    }

    public void setField(String field) {
        this.field = field;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "field= " + field + '\'' +
                ", description= " + description + '\'' +
                '}';
    }
}
