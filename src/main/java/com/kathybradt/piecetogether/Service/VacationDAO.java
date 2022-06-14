package com.kathybradt.piecetogether.Service;
import com.kathybradt.piecetogether.model.Vacation;

import java.util.List;
public interface VacationDAO {

    public List<Vacation> getUserVacations(Long userId);
}
