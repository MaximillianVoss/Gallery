package com.goganesh.gallery.model.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;

import javax.persistence.*;
import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "event")
@Entity
@SQLDelete(sql = "UPDATE event SET deleted = true WHERE id=?")
@Where(clause = "deleted=false")
public class Event extends BaseAudit {

    private String name;
    private String description;
    @Column(name = "start_date")
    private LocalDate start;
    @Column(name = "end_date")
    private LocalDate end;
    @ManyToOne
    @JoinColumn(name = "type_id")
    private Dictionary type;

    private String image;
}
