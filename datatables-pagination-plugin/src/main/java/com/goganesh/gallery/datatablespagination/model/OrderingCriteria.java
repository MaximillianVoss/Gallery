package com.goganesh.gallery.datatablespagination.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class OrderingCriteria {
    public static final String ASC = "asc";
    public static final String DESC = "desc";

    /**
     * Column to which ordering should be applied. This is an index reference to the
     * columns array of information that is also submitted to the server.
     */
    private int column;

    /**
     * Ordering direction for this column. It will be asc or desc to indicate
     * ascending ordering or descending ordering, respectively.
     */
    private String dir;

}