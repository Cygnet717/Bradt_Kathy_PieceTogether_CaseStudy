package com.piecetogether.piecetogether.JobsPackage;

import java.util.List;

public interface JobsDAO {
    public List<Jobs> getUserJobs(Long userId);
}
