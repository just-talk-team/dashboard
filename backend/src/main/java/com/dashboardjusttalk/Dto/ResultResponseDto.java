package com.dashboardjusttalk.Dto;

import com.dashboardjusttalk.util.StringSetConverter;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Convert;
import java.util.Set;
@Getter
@Setter
public class ResultResponseDto {
    public String userType;
    public long years;
    public String badgesAwarded;
    public String segments;
    public String topicsTalkQualifiedUser;

}
