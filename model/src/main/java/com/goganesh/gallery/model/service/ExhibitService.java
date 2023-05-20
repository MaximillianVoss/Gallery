package com.goganesh.gallery.model.service;

import com.goganesh.gallery.model.domain.Event;
import com.goganesh.gallery.model.domain.Exhibit;
import com.goganesh.gallery.model.repository.ExhibitRepository;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.nio.ByteBuffer;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@AllArgsConstructor
public class ExhibitService {

    private final ExhibitRepository exhibitRepository;

    public Optional<Exhibit> findById(UUID id) {
        return exhibitRepository.findById(id);
    }

    public Page<Exhibit> findAll(Pageable pageable) {
        return exhibitRepository.findAll(pageable);
    }

    public Page<Exhibit> findAllByNameContain(String name, Pageable pageable) {
        return exhibitRepository.findAllByNameContainingIgnoreCase(name, pageable);
    }

    public long count() {
        return exhibitRepository.count();
    }

    public Exhibit update(Exhibit exhibit) {
        return exhibitRepository.save(exhibit);
    }

    public Exhibit create(Exhibit exhibit) {
        exhibit.setCode(shortUUID());
        return exhibitRepository.save(exhibit);
    }

    public static String shortUUID() {
        UUID uuid = UUID.randomUUID();
        long l = ByteBuffer.wrap(uuid.toString().getBytes()).getLong();
        return Long.toString(l, Character.MAX_RADIX);
    }

    public List<Exhibit> findAllByEvent(Event event) {
        return exhibitRepository.findAllByEvent(event);
    }
}
