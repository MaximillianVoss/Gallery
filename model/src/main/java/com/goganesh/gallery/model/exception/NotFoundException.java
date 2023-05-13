package com.goganesh.gallery.model.exception;

public class NotFoundException extends RuntimeException {

    public NotFoundException(String objectType, String idType, String id) {
        super(String.format("No found object %s with %s %s", objectType, idType, id));
    }
}
