package edu.isel.csee.backend.form;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class ViolationType {
    private boolean violation;
    private List<String> violationNumber;
    private Integer violationCount;
    private Double deductedPoint;
}
