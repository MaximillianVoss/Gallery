package com.goganesh.gallery.model.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import java.util.UUID;

@Getter
@Setter
public class BaseAudit extends BaseEntity {

    private boolean deleted = Boolean.FALSE;
}
