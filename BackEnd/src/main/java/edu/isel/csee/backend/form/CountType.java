package edu.isel.csee.backend.form;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CountType {
    private boolean state;
    private Double deductPoint;
    private int methodCount;
    private int fieldCount;
    private int enForCount;
}