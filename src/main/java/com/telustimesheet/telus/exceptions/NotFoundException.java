package com.telustimesheet.telus.exceptions;

import com.telustimesheet.telus.dto.ErrorDto;
import org.springframework.http.HttpStatus;

import java.util.Arrays;

public class NotFoundException extends TelusException {
    private static final long serialVersionUID = -6870732210014274010L;

	public NotFoundException(final String message) {
        super(HttpStatus.NOT_FOUND.value(), message);
    }

	public NotFoundException(final String message, final ErrorDto data) {
        super(HttpStatus.NOT_FOUND.value(), message, Arrays.asList(data));
    }
}