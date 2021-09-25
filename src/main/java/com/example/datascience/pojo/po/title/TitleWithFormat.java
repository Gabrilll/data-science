package com.example.datascience.pojo.po.title;

import com.example.datascience.pojo.po.paragraph.ParagraphFormat;
import lombok.Data;
import org.hibernate.annotations.JoinColumnOrFormula;
import org.hibernate.annotations.JoinColumnsOrFormulas;
import org.hibernate.annotations.NotFound;
import org.hibernate.annotations.NotFoundAction;

import javax.persistence.*;

@Entity
@Data
@IdClass(TitleKey.class)
public class TitleWithFormat {
    @Id
    @Column(name = "id")
    private Integer id;
    @Id
    @Column(name = "word_token")
    private String wordToken;
    @Column(name = "text")
    private String text;

    @OneToOne(fetch = FetchType.EAGER, optional = false)
    @NotFound(action = NotFoundAction.IGNORE)
    @JoinColumnsOrFormulas({
            @JoinColumnOrFormula(column = @JoinColumn(name = "id", referencedColumnName = "id", insertable = false, updatable = false)),
            @JoinColumnOrFormula(column = @JoinColumn(name = "word_token", referencedColumnName = "token", insertable = false, updatable = false)),
    })
    private ParagraphFormat paragraphFormat;
}
