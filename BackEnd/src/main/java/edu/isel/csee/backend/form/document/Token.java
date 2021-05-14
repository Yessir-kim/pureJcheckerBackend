package edu.isel.csee.backend.form.document;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
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
    private String token;
    private String itoken;
    private String group;
    private String className;
    private String instructor;
    private boolean feedback;
    private String createDate;
    // 프론트엔드에서 추가적으로 구현해야될 부분
    private String dueDate;
    private Double point;
    private CompileType compiled;
    private OracleType oracle;
    private RequiredType packages;
    private RequiredType classes;
    private RequiredType customException;
    private RequiredType customStructure;
    private RequiredType overriding;
    private RequiredType overloading;
    private BasicType thread;
    private BasicType javadoc;
    private BasicType encapsulation;
    private InheritType inheritSuper;
    private InheritType inheritInterface;
    private CountType count;
    private String filePath;
}
