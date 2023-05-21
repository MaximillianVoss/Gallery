package com.goganesh.gallery.model.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;

import javax.persistence.Entity;
import javax.persistence.Table;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "author")
@Entity
@SQLDelete(sql = "UPDATE author SET deleted = true WHERE id=?")
@Where(clause = "deleted=false")
public class Author extends BaseAudit {

    private String name;

}
