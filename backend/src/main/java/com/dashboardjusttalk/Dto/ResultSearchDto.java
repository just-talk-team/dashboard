package com.dashboardjusttalk.Dto;


import com.vladmihalcea.hibernate.type.json.JsonStringType;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.Type;
import org.hibernate.annotations.TypeDef;
import org.springframework.beans.factory.annotation.Required;

import javax.persistence.Column;
import java.util.Date;
@Getter
@Setter

public class ResultSearchDto {

    public Date startTime;
    public Date endTime;
    public int startYears;
    public int endYears;
    public String badges;
    public int duration;

}
