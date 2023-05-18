package com.goganesh.gallery.model.model;

import com.goganesh.gallery.model.domain.Event;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class EventRecommendRate {
    private final Event event;
    private final Long rate;
}
