package com.mergen.vtys.vtysdatabaseap.Service;

import com.mergen.vtys.vtysdatabaseap.Dto.VacationAccrualDto;
import com.mergen.vtys.vtysdatabaseap.Model.VacationAccrual;

import java.awt.desktop.OpenFilesEvent;
import java.util.List;
import java.util.Optional;

public interface VacationAccrualService extends HelperService<VacationAccrualDto> {
    List<VacationAccrualDto> getVacationAccrualList();
    VacationAccrualDto getVacationAccrualById(Long id);
}
