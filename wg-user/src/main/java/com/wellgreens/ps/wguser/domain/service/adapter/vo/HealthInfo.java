package com.wellgreens.ps.wguser.domain.service.adapter.vo;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class HealthInfo {
    private int height;
    private int weight;
    private int bmi;

//    private void setBmi() {
//        this.bmi = weight/(height * height);
//    }
}
