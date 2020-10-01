package com.dashboardjusttalk.model;

import com.fasterxml.jackson.databind.util.JSONPObject;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.query.criteria.internal.expression.function.AggregationFunction;
import springfox.documentation.spring.web.json.Json;

import javax.persistence.*;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "Results")
public class Result {
    @Id
    @Column(unique = true)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String userType;
    private String gender;
    private Date birthdate;
    @Column(length = 500)
    private String topicsTalk;
    @Column(length = 500)
    private String topicsHear;
    @Column(length = 500)
    private String segments;

    private String userTypeQualifiedUser;
    private String genderQualifiedUser;
    private Date birthdateQualifiedUser;
    @Column(length = 500)
    private String topicsTalkQualifiedUser;
    @Column(length = 500)
    private String topicsHearQualifiedUser;
    @Column(length = 500)
    private String segmentsQualifiedUser;
    private Date startTime;
    private Date endTime;
    @Column(length = 500)
    private String badgesAwarded;
}
