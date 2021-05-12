package edu.isel.csee.backend.form;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class Oracle {
    private boolean state;
    private List<String> input;
    private List<String> output;
    private Double deductPoint;
    private Double maxDeduct;
}
