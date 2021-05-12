package edu.isel.csee.backend.form;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class Inherit {
    private boolean state;
    private List<String> origins;
    private List<String> inherit;
    private Double deductPoint;
    private Double maxDeduct;
}
