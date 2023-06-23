package com.goganesh.gallery.model.domain;

import java.time.LocalDate;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;

import javax.persistence.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "exhibit")
@Entity
@SQLDelete(sql = "UPDATE exhibit SET deleted = true WHERE id=?")
@Where(clause = "deleted=false")
public class Exhibit extends BaseAudit {

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

    @Column(name = "date_gain")
    private LocalDate dateGain;

    @Column(name = "date_restore")
    private LocalDate dateRestore;

    private String txt;

    @ManyToOne
    @JoinColumn(name = "status_id")
    private Dictionary status;

}
