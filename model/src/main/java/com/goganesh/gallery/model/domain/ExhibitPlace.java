package com.goganesh.gallery.model.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "exhibit_place")
@Entity
public class ExhibitPlace extends BaseEntity {

    @ManyToOne
    @JoinColumn(name = "exhibit_id")
    private Exhibit exhibit;

    @ManyToOne
    @JoinColumn(name = "place_id")
    private Dictionary place;

    private String comment;

    @Column(name = "start_date")
    private LocalDateTime start;

    @Column(name = "end_date")
    private LocalDateTime end = LocalDateTime.of(LocalDate.of(9999,1,1), LocalTime.of(1, 1));
}
