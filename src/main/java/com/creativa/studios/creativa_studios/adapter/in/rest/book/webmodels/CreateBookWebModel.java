package com.creativa.studios.creativa_studios.adapter.in.rest.book.webmodels;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Data;

import java.util.Date;

@Data
@Builder
public class CreateBookWebModel {
    @JsonProperty(value = "title", required = true)
    private String title;

    @JsonProperty(value = "author", required = true)
    private String author;

    @JsonProperty(value = "dateOfPublication", required = true)
    private Date dateOfPublication;

    @JsonProperty(value = "price", defaultValue = "0")
    private double price;
}
