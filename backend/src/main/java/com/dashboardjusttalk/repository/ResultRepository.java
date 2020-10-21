package com.dashboardjusttalk.repository;

import com.dashboardjusttalk.Dto.ResultResponseDto;
import com.dashboardjusttalk.model.Result;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface ResultRepository extends JpaRepository<Result , Integer> {

    @Query(value = "select r.user_type as userType, r.badges_awarded as badgesAwarded,r.segments as segments,r.topics_talk_qualified_user as topicsTalkQualifiedUser, timestampdiff(YEAR, r.birthdate,now()) as years " +
            "FROM results r " +
            "WHERE r.start_time >= :startTime " +
            "AND r.start_time <= :endTime",
            nativeQuery = true)
    List<ResultResponseDto> SelectSearch(Date startTime,Date endTime);
}
