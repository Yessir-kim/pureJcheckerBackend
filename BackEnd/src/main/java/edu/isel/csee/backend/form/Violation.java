package edu.isel.csee.backend.form;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class Violation {
    private boolean violation;
    private boolean bViolation;
    private List<String> violationNumber;
    private Integer violationCount;
    private Double deductedPoint;
}
