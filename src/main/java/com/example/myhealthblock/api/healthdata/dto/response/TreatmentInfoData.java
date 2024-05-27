package com.example.myhealthblock.api.healthdata.dto.response;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@JsonIgnoreProperties(ignoreUnknown = true)
public class TreatmentInfoData {
    private String resType;

    @JsonProperty("resMediDetailList")
    private List<MedicationDetailDTO> resMediDetailList;

    private String resMedicationCnt;
    private String resPrescribeCnt;
    private String resVisitDays;
    private String resTreatType;
    private String resTreatStartDate;
    private String resHospitalName;
}