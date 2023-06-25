package com.goganesh.gallery.model.repository;

import com.goganesh.gallery.model.domain.Event;
import com.goganesh.gallery.model.domain.Exhibit;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.UUID;

public interface ExhibitRepository extends JpaRepository<Exhibit, UUID> {

    Page<Exhibit> findAllByNameContainingIgnoreCase(String name, Pageable pageable);

    long countAllByNameContainingIgnoreCase(String name);

    @Query("select ee.exhibit from EventExhibit ee where ee.event = :ev")
    List<Exhibit> findAllByEvent(@Param("ev") Event event);


    @Query(value ="SELECT e.* FROM exhibit e WHERE CONCAT(e.name, e.code, e.year, e.length, e.width) LIKE %?1% AND e.type_id = CAST(?2 AS uuid)",
        nativeQuery = true)
    Page<Exhibit> findAllBySearchAndType(@Param("keyword") String keyword, @Param("filterone") String filterone, Pageable pageable);

    @Query(value = "SELECT * FROM exhibit e WHERE CONCAT(e.name, e.code, e.year, e.length, e.width) LIKE %?1% AND e.year = CAST(?2 AS INT)",
        nativeQuery = true)
    Page<Exhibit> findAllBySearchFilterDate(@Param("keyword") String keyword, @Param("filterone") String filterone, Pageable pageable);

    @Query("SELECT e FROM Exhibit e WHERE CONCAT(e.name, e.code, e.year, e.length, e.width) LIKE %?1%")
    Page<Exhibit> findAllBySearchOnly(@Param("keyword") String keyword, Pageable pageable);
}
