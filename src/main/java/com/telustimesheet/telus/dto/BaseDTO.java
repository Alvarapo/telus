package com.telustimesheet.telus.dto;

import java.io.Serializable;
/**
 * DTO (Data Transfer Object) base para todos los DTO:
 * 	- Id.
 *
 * @author Álvaro Rofa Aranda
 * @version 1
 *
 */
public interface BaseDTO extends Serializable {
    /**
     * Método getter que se encarga de devolver el valor del atributo id.
     * @return El valor del atributo id.
     */
    Long getId();

    /**
     * Método set para el atributo id.
     * @param identificador Nuevo valor para el atributo id.
     */
    void setId(Long identificador);
}
