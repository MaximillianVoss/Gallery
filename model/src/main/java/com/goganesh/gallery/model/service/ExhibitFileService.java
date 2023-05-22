package com.goganesh.gallery.model.service;

import com.goganesh.gallery.model.domain.Dictionary;
import com.goganesh.gallery.model.domain.Exhibit;
import com.goganesh.gallery.model.domain.ExhibitFile;
import com.goganesh.gallery.model.repository.ExhibitFileRepository;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Optional;
import java.util.UUID;

@AllArgsConstructor
public class ExhibitFileService {

    private final ExhibitFileRepository exhibitFileRepository;
    private final FileStorageService fileStorageService;
    private final String baseDirectory;
    private final String exhibitFileSubDirectory;


    public void save(Exhibit exhibit, Dictionary docType, String originalFileName, InputStream inputStream) throws IOException {
        Path directory = Paths.get(baseDirectory, exhibitFileSubDirectory, exhibit.getId().toString(), docType.getCode());
        String path = fileStorageService.saveFile(inputStream, directory, originalFileName);

        ExhibitFile exhibitFile = new ExhibitFile();
        exhibitFile.setExhibit(exhibit);
        exhibitFile.setType(docType);
        exhibitFile.setPath(path.replace(baseDirectory, ""));

        exhibitFileRepository.save(exhibitFile);
    }

    public Page<ExhibitFile> findAllByExhibit(Exhibit exhibit, Pageable pageable) {
        return exhibitFileRepository.findAllByExhibit(exhibit, pageable);
    }

    public Optional<ExhibitFile> findById(UUID id) {
        return exhibitFileRepository.findById(id);
    }

    public void delete(ExhibitFile exhibitFile) throws IOException {
        Path path = Paths.get(baseDirectory, exhibitFile.getPath());
        fileStorageService.deleteFile(path);

        exhibitFileRepository.delete(exhibitFile);
    }

    public long countAllByExhibit(Exhibit exhibit) {
        return exhibitFileRepository.countAllByExhibit(exhibit);
    }
}
