package edu.isel.csee.TesterForDB.domain.document;

import edu.isel.csee.TesterForDB.domain.Inherit;
import edu.isel.csee.TesterForDB.domain.Required;
import edu.isel.csee.TesterForDB.domain.State;
import edu.isel.csee.TesterForDB.domain.Testcase;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.persistence.Id;

@Document
@AllArgsConstructor
@Getter
@Setter
public class Policy {

    @Id
    private String id;
    private String name;
    private String group;
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
}
