package com.dashboardjusttalk.Dto;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import java.util.Date;
@Getter
@Setter
public class ResultInsertionDto {
    public String userType;
    public String gender;
    public Date birthdate;
    public String topicsTalk;
    public String topicsHear;
    public String segments;
    public String userTypeQualifiedUser;
    public String genderQualifiedUser;
    public Date birthdateQualifiedUser;
    public String topicsTalkQualifiedUser;
    public String topicsHearQualifiedUser;
    public String segmentsQualifiedUser;
    public Date startTime;
    public Date endTime;
    public String badgesAwarded;
}
