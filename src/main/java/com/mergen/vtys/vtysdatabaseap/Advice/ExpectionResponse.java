package com.mergen.vtys.vtysdatabaseap.Advice;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.web.bind.annotation.RequestParam;

import java.time.LocalDate;
import java.time.LocalDateTime;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ExpectionResponse {
    private LocalDateTime timestamp;
    private String message;
    private String code;
}

    