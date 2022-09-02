package com.wellgreens.ps.wguser.domain.input;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Rewards {
    private String name;
    private String iconUrl;
    private String iconUrlAltText;
    private double totalRewardsTillDate;

}
