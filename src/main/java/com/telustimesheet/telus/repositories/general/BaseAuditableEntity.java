package com.telustimesheet.telus.repositories.general;

import lombok.EqualsAndHashCode;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.Column;
import javax.persistence.EntityListeners;
import javax.persistence.MappedSuperclass;
import java.io.Serializable;
import java.time.LocalDateTime;

@EntityListeners(AuditingEntityListener.class)
@MappedSuperclass
@EqualsAndHashCode
public class BaseAuditableEntity<ID extends Serializable> {
    /** Versión de serialización. */
    @SuppressWarnings("unused")
    private static final long serialVersionUID = 1L;

    /** Usuario de creacion. */
    @Column(name = "S_CREADO", nullable = true, insertable = true, updatable = false)
    @CreatedBy
    protected String usuarioCreacion;

    /** Fecha de creación. */
    @Column(name = "F_CREACION", nullable = false, updatable = false)
    @CreatedDate
    protected LocalDateTime fechaCreacion;
    /** Usuario de modificación. */
    @Column(name = "S_MODIFICADO", nullable = true)
    @LastModifiedBy
    protected String usuarioModificacion;

    /** Fecha de modificación. */
    @Column(name = "F_MODIFICA", nullable = true)
    @LastModifiedDate
    protected LocalDateTime fechaModificacion;
}