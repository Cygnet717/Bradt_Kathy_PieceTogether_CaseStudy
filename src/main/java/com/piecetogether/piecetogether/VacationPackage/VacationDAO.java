package com.piecetogether.piecetogether.VacationPackage;
import java.util.List;
public interface VacationDAO {

    public List<Vacation> getUserVacations(Long userId);
}
