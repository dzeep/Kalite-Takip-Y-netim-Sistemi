package com.mergen.vtys.vtysdatabaseap.Domain;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum Gender {

    male (0),
    female (1),
    unspecified(2);

    private final int id;

}
