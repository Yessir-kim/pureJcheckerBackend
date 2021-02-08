package edu.isel.csee.TesterForDB.domain;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class Testcase {
    private List<String> input;
    private List<String> output;
    private Double deductPoint;
    private Double maxDeduct;
}
