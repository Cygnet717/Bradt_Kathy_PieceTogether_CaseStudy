package com.piecetogether.piecetogether.Service;

import com.piecetogether.piecetogether.model.Jobs;

import java.util.List;

public interface JobsDAO {
    public List<Jobs> getUserJobs(Long userId);
}
