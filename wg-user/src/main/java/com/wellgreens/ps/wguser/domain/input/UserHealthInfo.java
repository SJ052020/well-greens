package com.wellgreens.ps.wguser.domain.input;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class UserHealthInfo {
    private int height;
    private int weight;
    private int bmi;

//    private void setBmi() {
//        this.bmi = weight/(height * height);
//    }

}
