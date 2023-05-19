package com.goganesh.gallery.model.model;

import com.goganesh.gallery.model.domain.Dictionary;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class RecommendRequest {

    private Dictionary sex;
    private Dictionary education;
    private Integer age;
    private Dictionary style;
    private Dictionary genre;
}
