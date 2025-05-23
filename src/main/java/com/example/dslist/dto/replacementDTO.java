package com.example.dslist.dto;

public class replacementDTO {

    private Integer sourceIndex;
    private Integer destinationIndex;

    public replacementDTO() {
    }

    public replacementDTO(Integer sourceIndex, Integer destinationIndex) {
        this.sourceIndex = sourceIndex;
        this.destinationIndex = destinationIndex;
    }

    public Integer getSourceIndex() {
        return sourceIndex;
    }

    public Integer getDestinationIndex() {
        return destinationIndex;
    }
}
