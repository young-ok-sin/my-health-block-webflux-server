package com.example.myhealthblock.api.healthdata.dto.response;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@JsonIgnoreProperties(ignoreUnknown = true)
public class HealthCheckupResponseDTO<T> {
    @JsonProperty("result")
    private ResultDTO resultDTO;
    @JsonProperty("data")
    private T data;
}
