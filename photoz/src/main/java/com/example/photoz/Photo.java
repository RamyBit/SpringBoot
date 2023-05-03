package com.example.photoz;

public class Photo {
    private String id;
    private String fileName;

    // Raw data

    public String getId() {
        return id;
    }

    public Photo() {
    }

    public Photo(String id, String fileName) {
        this.id = id;
        this.fileName = fileName;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }
}