package com.goganesh.gallery.model.repository;

import com.goganesh.gallery.model.domain.Exhibit;
import com.goganesh.gallery.model.domain.ExhibitFile;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface ExhibitFileRepository extends JpaRepository<ExhibitFile, UUID> {

    Page<ExhibitFile> findAllByExhibit(Exhibit exhibit, Pageable pageable);
}
