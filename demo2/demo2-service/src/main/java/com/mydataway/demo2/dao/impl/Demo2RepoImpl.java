package com.mydataway.demo2.dao.impl;

import com.mydataway.demo2.dao.Demo2Repo;
import org.springframework.stereotype.Repository;

import java.util.Arrays;
import java.util.List;

@Repository
public class Demo2RepoImpl implements Demo2Repo {

    @Override
    public List<String> getDemo2List() {
        return Arrays.asList("demo2-1", "demo2-2");
    }
}
