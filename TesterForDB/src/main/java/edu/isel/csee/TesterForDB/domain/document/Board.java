package edu.isel.csee.TesterForDB.domain.document;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.persistence.Id;

@Document
@AllArgsConstructor
@Setter
@Getter
public class Board {

    @Id
    private String id;
    private String writer;
    private String title;
    private String content;
    private String createdDate;
    private String modifiedDate;

}
