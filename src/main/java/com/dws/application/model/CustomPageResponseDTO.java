package com.dws.application.model;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.data.domain.Page;

import java.util.List;

@Getter
@NoArgsConstructor
@Schema(description = "Simplified paged data response structure")
public class CustomPageResponseDTO<T> {

    @Schema(description = "List of the current page's content")
    private List<T> content;

    @Schema(description = "Current page number (zero-based)")
    private int number;

    @Schema(description = "Page size")
    private int size;

    @Schema(description = "Total number of elements across all pages")
    private long totalElements;

    @Schema(description = "Total number of pages")
    private int totalPages;

    public CustomPageResponseDTO(Page<T> page) {
        this.content = page.getContent();
        this.number = page.getNumber();
        this.size = page.getSize();
        this.totalElements = page.getTotalElements();
        this.totalPages = page.getTotalPages();
    }
}
