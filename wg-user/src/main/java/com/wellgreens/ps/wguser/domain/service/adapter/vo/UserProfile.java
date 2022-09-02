package com.wellgreens.ps.wguser.domain.service.adapter.vo;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.wellgreens.ps.wguser.domain.input.Gender;
import com.wellgreens.ps.wguser.domain.input.UserHealthInfo;
import com.wellgreens.ps.wguser.domain.input.Rewards;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class UserProfile {
    String userId;
    String firstName;
    String lastName;
    Gender gender;
    LocalDate dateOfBirth;
    String email;
    String phoneNumber;
    Rewards rewards;
    String password;
    LocalDate onboardedDate;
    HealthInfo healthInfo;
}
