package com.mergen.vtys.vtysdatabaseap.Domain;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum DisabledDegree  {

    none (0),
    firstDegreeDisabled (1),
    secondDegreeDisabled(2),
    thirdDegreeDisabled(3);

    private final int id;

}

