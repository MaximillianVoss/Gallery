package com.goganesh.gallery.model.repository;

import com.goganesh.gallery.model.domain.Dictionary;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface DictionaryRepository extends JpaRepository<Dictionary, UUID> {

    Optional<Dictionary> findByCodeOrderByName(String code);

    List<Dictionary> findAllByDictionaryOrderByName(Dictionary dictionary);

    List<Dictionary> findAllByDictionary_CodeOrderByName(String code);
}
