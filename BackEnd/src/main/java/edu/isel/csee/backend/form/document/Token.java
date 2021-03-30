package edu.isel.csee.backend.form.document;

import edu.isel.csee.backend.form.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.persistence.Id;

@Document
@AllArgsConstructor
@Getter
@Setter
public class Token {

    @Id
    private String id;
    private String token; // students
    private String itoken;
    private String group;
    private String className;
    private String instructor;
    private boolean feedback;
    private String createDate;
    private String dueDate;
    private Double point;
    private State compiled;
    private Testcase runtimeCompare;
    private Required packages;
    private Required classes;
    private Required customException;
    private Required customStructure;
    private Required overriding;
    private Required overloading;
    private State thread;
    private State javadoc;
    private State encapsulation;
    private Inherit inheritSuper;
    private Inherit inheritInterface;
    private Count count;
}
