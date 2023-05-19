package com.goganesh.gallery.model.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "exhibit")
@Entity
public class Exhibit extends BaseEntity {

    private String name;
    private String code;

    @ManyToOne
    @JoinColumn(name = "author_id")
    private Author author;

    @ManyToOne
    @JoinColumn(name = "type_id")
    private Dictionary type;

    @ManyToOne
    @JoinColumn(name = "genre_id")
    private Dictionary genre;

    @ManyToOne
    @JoinColumn(name = "style_id")
    private Dictionary style;

    @ManyToOne
    @JoinColumn(name = "storage_condition_id")
    private Dictionary storageCondition;

    private Integer year;
    private Integer length;
    private Integer width;

    private String image;

}
