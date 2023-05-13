package com.goganesh.gallery.model.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "dictionary")
@Entity
public class Dictionary extends BaseEntity {
    @ManyToOne
    @JoinColumn(name = "dictionary_id")
    private Dictionary dictionary;
    private String name;
    private String code;
}
