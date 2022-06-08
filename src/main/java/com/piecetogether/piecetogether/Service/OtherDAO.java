package com.piecetogether.piecetogether.Service;

import com.piecetogether.piecetogether.model.Other;

import java.util.List;

public interface OtherDAO {

    public List<Other> getUserOther(Long userId);
}
