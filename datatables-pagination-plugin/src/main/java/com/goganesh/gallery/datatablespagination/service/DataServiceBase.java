package com.goganesh.gallery.datatablespagination.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.goganesh.gallery.datatablespagination.model.PaginationCriteria;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.logging.Logger;
import java.util.logging.Level;
import java.util.stream.Collectors;

public abstract class DataServiceBase<T> implements TableDataService {

    private final Logger log = Logger.getLogger(this.getClass().getName());

    private static final ObjectMapper OBJECT_MAPPER = new ObjectMapper()
            .registerModule(new JavaTimeModule())
            .configure(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS, false);

    @Override
    public List<Map<String, String>> getPageEntries(PaginationCriteria paginationCriteria) throws TableDataException {
        List<T> data = getData(paginationCriteria);
        //todo log.debug("Table data retrieved...");

        List<Map<String, String>> records = new ArrayList<>(data.size());
        try {
            data.forEach(i -> {
                Map<String, Object> m = OBJECT_MAPPER.convertValue(i, Map.class);
                records.add(m.entrySet().stream()
                        .collect(Collectors.toMap(k -> k.getKey(), v -> v.getValue().toString())));
            });
            //todo log.debug("Data map generated...");
        } catch (Exception e) {
            log.log(Level.SEVERE, "Error fetching page entries.", e);
            throw new TableDataException("", e);
        }
        return records;
    }

    protected abstract List<T> getData(PaginationCriteria paginationCriteria) throws TableDataException;

}
