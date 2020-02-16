package com.mydataway.demo1.dao.impl;

import com.mydataway.demo1.dao.Demo1Repo;
import org.springframework.stereotype.Repository;

import java.util.Arrays;
import java.util.List;

@Repository
public class Demo1RepoImpl implements Demo1Repo {

    @Override
    public List<String> getDemo1List() {
        return Arrays.asList("demo1-1", "demo1-2", "demo1-3");
    }
}
