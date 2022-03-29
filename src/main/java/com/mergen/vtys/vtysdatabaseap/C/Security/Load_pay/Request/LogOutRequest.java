package com.mergen.vtys.vtysdatabaseap.C.Security.Load_pay.Request;

import lombok.Data;

@Data
public class LogOutRequest {
    private Long userId;

    public Long getUserId() {
        return this.userId;
    }


}

    