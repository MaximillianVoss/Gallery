package com.goganesh.gallery.model.service;

import com.goganesh.gallery.model.domain.Dictionary;
import com.goganesh.gallery.model.repository.DictionaryRepository;
import lombok.AllArgsConstructor;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@AllArgsConstructor
public class DictionaryService {

    private final DictionaryRepository dictionaryRepository;

    public Optional<Dictionary> findByCode(String code) {
        return dictionaryRepository.findByCode(code);
    }

    public List<Dictionary> findAllByDictionary(Dictionary dictionary) {
        return dictionaryRepository.findAllByDictionary(dictionary);
    }

    public Optional<Dictionary> findById(UUID id) {
        return dictionaryRepository.findById(id);
    }
}
