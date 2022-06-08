package com.piecetogether.piecetogether.Service;
import com.piecetogether.piecetogether.model.Vacation;

import java.util.List;
public interface VacationDAO {

    public List<Vacation> getUserVacations(Long userId);
}
