package com.dashboardjusttalk.Dto.converter;

import com.dashboardjusttalk.Dto.ResultInsertionDto;
import com.dashboardjusttalk.model.Result;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class ResultInsertionDtoConverter {

    public ResultInsertionDto convertToDto(Result result){
        ResultInsertionDto resultInsertionDto = new ResultInsertionDto();
        resultInsertionDto.setGender(result.getGender());
        resultInsertionDto.setBirthdate(result.getBirthdate());
        resultInsertionDto.setUser_type(result.getUserType());
        resultInsertionDto.setTopics_talk(result.getTopicsTalk());
        resultInsertionDto.setTopics_hear(result.getTopicsHear());
        resultInsertionDto.setSegments(result.getSegments());
        resultInsertionDto.setUser_type_qualified_user(result.getUserTypeQualifiedUser());
        resultInsertionDto.setBirthdate_qualified_user(result.getBirthdateQualifiedUser());
        resultInsertionDto.setTopics_hear_qualified_user(result.getTopicsHearQualifiedUser()
                );
        resultInsertionDto.setTopics__talk_qualified_user(result.getTopicsTalkQualifiedUser());
        resultInsertionDto.setStart_time(result.getStartTime());
        resultInsertionDto.setEnd_time(result.getEndTime());
        resultInsertionDto.setBadges_awarded(result.getBadgesAwarded());
        return resultInsertionDto;
    }
    public Result convertToEntity(ResultInsertionDto resultInsertionDto){
        Result result = new Result();
        result.setGender(resultInsertionDto.getGender());
        result.setBirthdate(resultInsertionDto.getBirthdate());
        result.setUserType(resultInsertionDto.getUser_type());
        result.setTopicsHear(resultInsertionDto.getTopics_hear());
        result.setTopicsTalk(resultInsertionDto.getTopics_talk());
        result.setSegments(resultInsertionDto.getSegments());
        result.setUserTypeQualifiedUser(resultInsertionDto.getUser_type_qualified_user());
        result.setBirthdateQualifiedUser(resultInsertionDto.getBirthdate_qualified_user());
        result.setTopicsHearQualifiedUser(resultInsertionDto.getTopics_hear_qualified_user());
        result.setTopicsTalkQualifiedUser(resultInsertionDto.getTopics__talk_qualified_user());
        result.setStartTime(resultInsertionDto.getStart_time());
        result.setEndTime(resultInsertionDto.getEnd_time());
        result.setBadgesAwarded(resultInsertionDto.getBadges_awarded());
        return result;
    }

}
