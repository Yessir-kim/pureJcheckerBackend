package edu.isel.csee.TesterForDB.domain;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class Inherit {
    private boolean state;
    private List<String> inheritClass;
    private List<String> target;
    private Double deductPoint;
    private Double maxDeduct;
}
