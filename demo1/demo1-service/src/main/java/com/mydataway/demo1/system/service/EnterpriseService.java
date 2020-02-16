package com.mydataway.demo1.system.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.mydataway.demo1.system.domain.Enterprise;
import com.mydataway.demo1.system.service.dto.EnterpriseQueryDto;

public interface EnterpriseService {

    void saveEnterprise(Enterprise enterprise);

    void deleteEnterprise(Long id);

    void updateEnterprise(Enterprise enterprise);

    IPage<Enterprise> queryEnterPriseList(EnterpriseQueryDto enterpriseQueryDto);

    Enterprise queryById(Long id);

    Enterprise queryByName(String name);

    Enterprise queryByNumber(String number);

    Enterprise queryByFullName(String fullName);
}
