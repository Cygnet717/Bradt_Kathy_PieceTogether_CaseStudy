package com.kathybradt.piecetogether.Service;

import com.kathybradt.piecetogether.model.Jobs;

import java.util.List;

public interface JobsDAO {
    public List<Jobs> getUserJobs(Long userId);
}
