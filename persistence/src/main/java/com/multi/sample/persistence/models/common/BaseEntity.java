package com.multi.sample.persistence.models.common;

import com.multi.sample.persistence.constants.SchemaConstants;

import javax.persistence.*;
import java.io.Serializable;

@MappedSuperclass
public class BaseEntity implements Serializable {

    private static final long serialVersionUID = -8820339311223268265L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = SchemaConstants.DELETED_COLUMN)
    private Boolean deleted = false;

    public boolean isNew() {
        return getId() == null || getId() < 1;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Boolean getDeleted() {
        return deleted;
    }

    public void setDeleted(Boolean deleted) {
        this.deleted = deleted;
    }
}
