package com.goganesh.gallery.model.service;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class FileStorageService {

    public void deleteFile(Path directory) throws IOException {
        Files.delete(directory);
    }

    public String saveFile(InputStream initialStream, Path directory, String originalFileName) throws IOException {
        if (!new File(directory.toString()).exists()) {
            Files.createDirectories(directory);
        }

        byte[] buffer = new byte[initialStream.available()];
        initialStream.read(buffer);

        Path path = Paths.get(directory.toString(), originalFileName);
        Files.createFile(path);

        File targetFile = new File(path.toString());
        try (OutputStream outStream = new FileOutputStream(targetFile)) {
            outStream.write(buffer);
        }

        return path.toString();
    }

    public File getFileByPath(String path) {
        return new File(path);
    }
}
