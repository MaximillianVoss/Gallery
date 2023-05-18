package com.goganesh.gallery.model.service;

import com.goganesh.gallery.model.domain.Dictionary;
import com.goganesh.gallery.model.repository.DictionaryRepository;
import lombok.AllArgsConstructor;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@AllArgsConstructor
public class DictionaryService {

    public static final String EXHIBIT_TYPE_CODE = "EXH_TYPE";
    public static final String PLACE_TYPE_CODE = "PLACE_TYPE";
    public static final String ATTACH_TYPE_CODE = "EXH_ATTACH_TYPE";
    public static final String STORAGE_CONDITION_TYPE_CODE = "STORAGE_CONDITION_TYPE";
    public static final String STYLE_TYPE_CODE = "STYLE_TYPE";
    public static final String GENRE_TYPE_CODE = "GENRE_TYPE";
    public static final String EVENT_TYPE_CODE = "EVENT_TYPE";
    public static final String EDU_TYPE_CODE = "EDUCATION_TYPE";
    public static final String SEX_TYPE_CODE = "SEX_TYPE";

    private final DictionaryRepository dictionaryRepository;

    public Optional<Dictionary> findByCode(String code) {
        return dictionaryRepository.findByCode(code);
    }

    public List<Dictionary> findAllByParenCode(String code) {
        return dictionaryRepository.findAllByDictionary_Code(code);
    }

    public List<Dictionary> findAllByDictionary(Dictionary dictionary) {
        return dictionaryRepository.findAllByDictionary(dictionary);
    }

    public Optional<Dictionary> findById(UUID id) {
        return dictionaryRepository.findById(id);
    }
}
