package com.telustimesheet.telus.dto;

import lombok.Data;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;

import java.io.Serializable;

@Data
public class ErrorDto implements Serializable {

    private static final long serialVersionUID = 1L;

    private String name;

    private String value;

	public ErrorDto(final String name, final String value) {
        this.name = name;
        this.value = value;
    }

    @Override
    public boolean equals(final Object other) {
        if (!(other instanceof ErrorDto)) {
            return false;
        }
        ErrorDto castOther = (ErrorDto) other;
        return new EqualsBuilder().append(name, castOther.name).append(value, castOther.value).isEquals();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder().append(name).append(value).toHashCode();
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this).append("name", name).append("value", value).toString();
    }
}
