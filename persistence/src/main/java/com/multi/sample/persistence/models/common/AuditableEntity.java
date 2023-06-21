package com.multi.sample.persistence.models.common;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;
import java.time.LocalDateTime;

@MappedSuperclass
public class AuditableEntity extends BaseEntity {
    private static final long serialVersionUID = -2182971455809204015L;

    @CreatedDate
    @Column(updatable = false)
    private LocalDateTime createDt = LocalDateTime.now();

    @LastModifiedDate
    @Column(insertable = false)
    private LocalDateTime modifyDt = LocalDateTime.now();
}
