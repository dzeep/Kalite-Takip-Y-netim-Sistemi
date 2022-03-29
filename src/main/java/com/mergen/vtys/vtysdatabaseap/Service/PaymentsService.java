package com.mergen.vtys.vtysdatabaseap.Service;

import com.mergen.vtys.vtysdatabaseap.Model.Payments;

import java.util.List;
import java.util.Optional;

public interface PaymentsService extends HelperService<Payments>{
    List<Payments> getPaymentsList();
    Optional<Payments> getPaymentsById(Long id);
}
