package edu.isel.csee.backend.form.document;

import edu.isel.csee.backend.form.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.persistence.Id;

@Document
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class Grade {
    @Id
    private String id;
    private String studentNum;
    private String token;
    private String className;
    private String instructor;
    private String gradingDate;
    private Double point;
    private Violation compile;
    private Violation runtimeResult;
    private Violation packages;
    private Violation classes;
    private Violation customException;
    private Violation customStructure;
    private Violation overriding;
    private Violation overloading;
    private Violation thread;
    private Violation javadoc;
    private Violation encapsulation;
    private Violation inheritSuper;
    private Violation inheritInterface;
    private Double result;
}
