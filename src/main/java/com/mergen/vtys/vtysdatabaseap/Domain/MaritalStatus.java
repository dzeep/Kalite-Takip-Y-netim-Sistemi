package com.mergen.vtys.vtysdatabaseap.Domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;

@Getter
@AllArgsConstructor
@Slf4j
public enum MaritalStatus {

    married (0),
    single (1),
    unspecified(2);

    private final int id;

    public int getSize()
    {
        return MaritalStatus.values().length;
    }

}


