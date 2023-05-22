package com.goganesh.gallery.model.domain;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class BaseAudit extends BaseEntity {

    private boolean deleted = Boolean.FALSE;
}
