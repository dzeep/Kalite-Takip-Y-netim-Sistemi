package com.mergen.vtys.vtysdatabaseap.Service;

import com.mergen.vtys.vtysdatabaseap.Dto.PaymentsDto;

import java.util.List;

public interface PaymentsService extends HelperService<PaymentsDto>{
    List<PaymentsDto> getPaymentsList();
    PaymentsDto getPaymentsById(Long id);
}
