package com.axitera.graph.entity;

import lombok.*;
import lombok.experimental.FieldDefaults;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.time.LocalDateTime;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Users {

    @Id
    int personal_nr;

    String email;
    @Column(name = "first_name")
    String firstName;
    String lastName;
    String roles;
    String team;
    String chief;
    LocalDateTime creationTime;
    LocalDateTime modification_time;
    LocalDateTime closeTime;
    int target_working_hours;
    String career_stage;
    int vacation_days;
    int min_bonus_limit_percent;
    int overtime_percent;
    int overtime_leftover;
}
