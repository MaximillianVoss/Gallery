package com.goganesh.gallery.model.service;

import com.goganesh.gallery.model.domain.BaseEntity;
import com.goganesh.gallery.model.domain.Event;
import com.goganesh.gallery.model.domain.Exhibit;
import lombok.AllArgsConstructor;

import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Path;
import java.nio.file.Paths;

@AllArgsConstructor
public class ImageService {

    private final FileStorageService fileStorageService;
    private final String baseDirectory;
    private final String eventImageSubDirectory;
    private final String exhibitImageSubDirectory;

    public String save(BaseEntity baseEntity, InputStream inputStream, String originalFilename) throws IOException {
        String imageSubDirectory = null;
        if (baseEntity instanceof Event) {
            imageSubDirectory = eventImageSubDirectory;
        } else if (baseEntity instanceof Exhibit) {
            imageSubDirectory = exhibitImageSubDirectory;
        }

        Path directory = Paths.get(baseDirectory, imageSubDirectory, baseEntity.getId().toString());
        String imagePath = fileStorageService.saveFile(inputStream, directory, originalFilename)
                .replace(baseDirectory, "");
        return imagePath;
    }

    public void delete(BaseEntity baseEntity) throws IOException {
        String imagePath = null;
        if (baseEntity instanceof Event) {
            imagePath = ((Event) baseEntity).getImage();
        } else if (baseEntity instanceof Exhibit) {
            imagePath = ((Exhibit) baseEntity).getImage();
        }
        fileStorageService.deleteFile(Path.of(baseDirectory + imagePath));
    }
}
