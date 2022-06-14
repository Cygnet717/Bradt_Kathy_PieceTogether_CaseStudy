package com.kathybradt.piecetogether.Service;

import com.kathybradt.piecetogether.model.Other;

import java.util.List;

public interface OtherDAO {

    public List<Other> getUserOther(Long userId);
}
