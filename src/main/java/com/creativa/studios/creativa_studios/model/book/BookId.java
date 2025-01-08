package com.creativa.studios.creativa_studios.model.book;

import java.util.Objects;

public record BookId(long value) {
    public BookId {
        if (value <= 0) {
            throw new IllegalArgumentException("'value' must be greater than 0");
        }
    }
}
