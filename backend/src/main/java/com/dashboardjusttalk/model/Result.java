package com.dashboardjusttalk.model;

import com.dashboardjusttalk.util.StringSetConverter;
import com.fasterxml.jackson.databind.util.JSONPObject;
import com.vladmihalcea.hibernate.type.json.JsonStringType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Type;
import org.hibernate.annotations.TypeDef;
import org.hibernate.query.criteria.internal.expression.function.AggregationFunction;
import springfox.documentation.spring.web.json.Json;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Set;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "Results")
@TypeDef(
        name = "json",
        typeClass = JsonStringType.class
)
public class Result  {
    @Id
    @Column(unique = true)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String userType;
    private String gender;
    private Date birthdate;
    @Convert(converter = StringSetConverter.class)
    @Column
    private Set<String> topicsTalk;

    @Convert(converter = StringSetConverter.class)
    @Column
    private Set<String> topicsHear;

    @Convert(converter = StringSetConverter.class)
    @Column
    private Set<String> segments;

    private String userTypeQualifiedUser;
    private String genderQualifiedUser;
    private Date birthdateQualifiedUser;
    @Convert(converter = StringSetConverter.class)
    @Column
    private Set<String> topicsTalkQualifiedUser;
    @Convert(converter = StringSetConverter.class)
    @Column
    private Set<String> topicsHearQualifiedUser;
    @Convert(converter = StringSetConverter.class)
    @Column
    private Set<String> segmentsQualifiedUser;
    private Date startTime;
    private Date endTime;
    @Convert(converter = StringSetConverter.class)
    @Column
    private Set<String> badgesAwarded;
}
