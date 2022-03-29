package com.mergen.vtys.vtysdatabaseap.Domain;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum BloodType {

    zeroPlus (0),
    zeroMinus (1),
    aPlus(2),
    aMinus(3),
    bPlus(4),
    bMinus(5),
    abPlus(6),
    abMinus(7);

    private final int id;

}