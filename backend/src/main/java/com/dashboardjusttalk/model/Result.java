package com.dashboardjusttalk.model;

import com.fasterxml.jackson.databind.util.JSONPObject;
import springfox.documentation.spring.web.json.Json;

import javax.persistence.Column;
import javax.persistence.Id;
import java.util.Date;

public class Result {
    @Id
    @Column(unique = true)
    private int id;
    private String userType;
    private String gender;
    private Date birthdate;
    private JSONPObject topicsTalk;
    private JSONPObject topicsHear;
    private Json segments;

    private String userTypeQualifiedUser;
    private String genderQualifiedUser;
    private Date birthdateQualifiedUser;
    private Json topicsTalkQualifiedUser;
    private Json topicsHearQualifiedUser;
    private Json segmentsQualifiedUser;
    private Date startTime;
    private Date endTime;
    private Json badgesAwarded;
}
