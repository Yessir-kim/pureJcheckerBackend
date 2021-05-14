package edu.isel.csee.backend.form.document;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
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
    private String isDirect;
    private String studentNum;
    private String token;
    private String itoken;
    private String className;
    private String instructor;
    private String gradingDate;
    private Double point;
    private CompileViolationType compile;
    private ViolationType delay;
    private ViolationType oracle;
    private ViolationType packages;
    private ViolationType classes;
    private ViolationType customException;
    private ViolationType customStructure;
    private ViolationType overriding;
    private ViolationType overloading;
    private ViolationType thread;
    private ViolationType javadoc;
    private ViolationType encapsulation;
    private ViolationType inheritSuper;
    private ViolationType inheritInterface;
    private ViolationType count;
    private Double result;

}
