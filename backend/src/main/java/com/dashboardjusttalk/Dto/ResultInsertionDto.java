package com.dashboardjusttalk.Dto;

import com.vladmihalcea.hibernate.type.json.JsonStringType;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.Type;
import org.hibernate.annotations.TypeDef;

import javax.persistence.Column;
import java.util.Date;
import java.util.List;
import java.util.Set;

@Getter
@Setter
@TypeDef(
        name = "json",
        typeClass = JsonStringType.class
)
public class ResultInsertionDto {
    public String user_type;
    public String gender;
    public Date birthdate;


    public Set<String> topics_talk;

    public Set<String> topics_hear;

    public Set<String> segments;


    public String user_type_qualified_user;
    public String gender_qualified_user;
    public Date birthdate_qualified_user;


    public Set<String> topics_talk_qualified_user;

    public Set<String> topics_hear_qualified_user;

    public Set<String> segments_qualified_user;

    public Date start_time;
    public Date end_time;

    public Set<String> badges_awarded;
}
