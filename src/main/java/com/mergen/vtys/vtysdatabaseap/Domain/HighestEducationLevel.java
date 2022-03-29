package com.mergen.vtys.vtysdatabaseap.Domain;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum HighestEducationLevel {
    primarySchool ,
    middleSchool,
    highSchool,
    associateDegree,
    bachelorsDegree,
    mastersDegree,
    doctoratePhd,
    none,
}
