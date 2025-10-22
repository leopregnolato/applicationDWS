package com.dws.application.model;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Schema(description = "Details about a musical group or artist")
public class MusicalGroupsDTO {

    @Schema(description = "Unique identifier of the group (UUID)", example = "31e609d2-49aa-4b71-ad6e-57c0b0f54161")
    private String id;

    @Schema(description = "Official name of the group", example = "The Celestial Beings")
    private String name;

    @Schema(description = "URL to the group's main promotional image", example = "https://cdn.api.com/images/celestial.jpg")
    private String image;

    @Schema(description = "Main musical genre", example = "Synthwave")
    private String genre;

    @Schema(description = "Short biography or description", example = "An electronic music duo formed in 2018, known for their futuristic sound.")
    private String biography;

    @Schema(description = "Total number of plays across all platforms", example = "8500000")
    private Long numPlays;

    @Schema(description = "List of unique album IDs associated with the group",
            example = "[\"a4c5d6e7-8f90-1234-5678-9abcdef01234\", \"b1c2d3e4-f5g6-7890-1234-56789abcdef0\"]")
    private List<String> albums;

}
