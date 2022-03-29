package com.mergen.vtys.vtysdatabaseap.Service;

import com.mergen.vtys.vtysdatabaseap.Model.VacationAccrual;

import java.awt.desktop.OpenFilesEvent;
import java.util.List;
import java.util.Optional;

public interface VacationAccrualService extends HelperService<VacationAccrual> {
    List<VacationAccrual> getVacationAccrualList();
    Optional<VacationAccrual> getVacationAccrualById(Long id);
}
