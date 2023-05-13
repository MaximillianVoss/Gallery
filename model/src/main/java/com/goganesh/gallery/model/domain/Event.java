package com.goganesh.gallery.model.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "event")
@Entity
public class Event extends BaseEntity {

    public String name;
    public String description;
    @Column(name = "start_date")
    public LocalDate start;
    @Column(name = "end_date")
    public LocalDate end;
    @ManyToOne
    @JoinColumn(name = "type_id")
    public Dictionary type;

}
