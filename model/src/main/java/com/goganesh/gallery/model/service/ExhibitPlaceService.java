package com.goganesh.gallery.model.service;

import com.goganesh.gallery.model.domain.Exhibit;
import com.goganesh.gallery.model.domain.ExhibitPlace;
import com.goganesh.gallery.model.repository.ExhibitPlaceRepository;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;

@AllArgsConstructor
public class ExhibitPlaceService {

    private final ExhibitPlaceRepository exhibitPlaceRepository;

    public Page<ExhibitPlace> findAllByExhibit(Exhibit exhibit, Pageable pageable) {
        return exhibitPlaceRepository.findAllByExhibit(exhibit, pageable);
    }

    @Transactional
    public ExhibitPlace save(ExhibitPlace exhibitPlace) {
        exhibitPlace.setStart(LocalDateTime.now());

        ExhibitPlace last = exhibitPlaceRepository.findByExhibitAndEndBetween(exhibitPlace.getExhibit(), LocalDateTime.now(), exhibitPlace.getEnd())
                .orElseThrow(() -> new IllegalArgumentException("fd"));

        last.setEnd(LocalDateTime.now());
        exhibitPlaceRepository.save(last);

        return exhibitPlaceRepository.save(exhibitPlace);
    }

}
