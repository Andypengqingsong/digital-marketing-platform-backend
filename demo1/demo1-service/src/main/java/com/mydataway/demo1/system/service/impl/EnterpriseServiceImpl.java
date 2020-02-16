package com.mydataway.demo1.system.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.mydataway.demo1.system.domain.Enterprise;
import com.mydataway.demo1.system.repository.EnterpriseRepository;
import com.mydataway.demo1.system.service.EnterpriseService;
import com.mydataway.demo1.system.service.dto.EnterpriseQueryDto;
import com.mydataway.utils.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;


/**
 * @author calvinkun
 * @date 2020/2/16 0016 18:14
 */
@Service
public class EnterpriseServiceImpl implements EnterpriseService {

    @Autowired
    private EnterpriseRepository enterpriseRepository;

    @Override
    public void saveEnterprise(Enterprise enterprise) {
        enterprise.setCreateTime(new Date());
        enterpriseRepository.insert(enterprise);
    }

    @Override
    public void deleteEnterprise(Long id) {
        enterpriseRepository.deleteById(id);
    }

    @Override
    public void updateEnterprise(Enterprise enterprise) {
        enterprise.setUpdateTime(new Date());
        enterpriseRepository.updateById(enterprise);
    }

    @Override
    public IPage<Enterprise> queryEnterPriseList(EnterpriseQueryDto enterpriseQueryDto) {
        QueryWrapper<Enterprise> queryWrapper = new QueryWrapper<>();
        if (StringUtils.isNotBlank(enterpriseQueryDto.getName())){
            queryWrapper.lambda().like(Enterprise::getName,enterpriseQueryDto.getName());
        }
        if (StringUtils.isNotBlank(enterpriseQueryDto.getNumber())){
            queryWrapper.lambda().eq(Enterprise::getNumber,enterpriseQueryDto.getNumber());
        }
        queryWrapper.orderByDesc("id");
        return enterpriseRepository.selectPage(new Page<>(enterpriseQueryDto.getPageNum(),enterpriseQueryDto.getPageSize()), queryWrapper);
    }

    @Override
    public Enterprise queryById(Long id) {
        return enterpriseRepository.selectById(id);
    }

    @Override
    public Enterprise queryByName(String name) {
        QueryWrapper<Enterprise> queryWrapper = new QueryWrapper<>();
        queryWrapper.lambda().eq(Enterprise::getName,name);
        return EnterpriseReturn(queryWrapper);
    }

    @Override
    public Enterprise queryByNumber(String number) {
        QueryWrapper<Enterprise> queryWrapper = new QueryWrapper<>();
        queryWrapper.lambda().eq(Enterprise::getNumber,number);
        return EnterpriseReturn(queryWrapper);
    }

    @Override
    public Enterprise queryByFullName(String fullName) {
        QueryWrapper<Enterprise> queryWrapper = new QueryWrapper<>();
        queryWrapper.lambda().eq(Enterprise::getFullName,fullName);
        return EnterpriseReturn(queryWrapper);
    }

    private Enterprise EnterpriseReturn(QueryWrapper<Enterprise> queryWrapper){
        List<Enterprise> list = enterpriseRepository.selectList(queryWrapper);
        if (list != null && list.size() > 0) {
            return list.get(0);
        }
        return null;
    }
}
