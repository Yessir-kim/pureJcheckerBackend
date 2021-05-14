package edu.isel.csee.backend.form;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class RequiredType {
    private boolean state;
    private List<String> required;
    private Double deductPoint;
    private Double maxDeduct;
}
