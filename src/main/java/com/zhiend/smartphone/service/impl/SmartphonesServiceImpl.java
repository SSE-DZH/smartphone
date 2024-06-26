package com.zhiend.smartphone.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.zhiend.smartphone.entity.BackPage;
import com.zhiend.smartphone.entity.Smartphones;
import com.zhiend.smartphone.mapper.SmartphonesMapper;
import com.zhiend.smartphone.service.ISmartphonesService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.zhiend.smartphone.vo.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author Zhiend
 * @since 2024-06-21
 */
@Service
public class SmartphonesServiceImpl extends ServiceImpl<SmartphonesMapper, Smartphones> implements ISmartphonesService {

    @Autowired
    private SmartphonesMapper smartphonesMapper;

    @Override
    //根据页码和每页分页数给出分页查询，使用wrapper
    public BackPage<Smartphones> queryPage(Long pageNo, Long pageSize) {
        BackPage<Smartphones> SmartphonesBackPage = new BackPage<>();
        // 设置条件构造器
        QueryWrapper<Smartphones> wrapper = new QueryWrapper<>();
        // 构造分页信息，其中的Page<>(page, PAGE_RECORDS_NUM)的第一个参数是第几页，而第二个参数是每页的记录数
        Page<Smartphones> SmartphonesPage = new Page<>(pageNo, pageSize);
        // page(SmartphonesPage, wrapper)这里的第一个参数就是上面定义了的Page对象，第二个参数就是上面定义的条件构造器对象，通过调用这个方法就可以根据你的分页信息以及查询信息获取分页数据
        IPage<Smartphones> SmartphonesIPage = page(SmartphonesPage, wrapper);
        // 封装数据，其中getRecords()是获取记录数，getCurrent()获取当前页数，getPages()获取总页数，getTotal()获取记录总数，还要其他更多的方法，大家可以自行查看，在这里就不过多赘述了
        SmartphonesBackPage.setContentList(SmartphonesIPage.getRecords());
        SmartphonesBackPage.setCurrentPage(SmartphonesIPage.getCurrent());
        SmartphonesBackPage.setTotalPage(SmartphonesIPage.getPages());
        SmartphonesBackPage.setTotalNum(SmartphonesIPage.getTotal());
        return SmartphonesBackPage;
    }

    @Override
    public List<String> getAllBrands() {
        return smartphonesMapper.getAllBrands();
    }

    @Override
    public int countByType(String brand) {
        return smartphonesMapper.countByType(brand);
    }

    @Override
    public List<SmartphonesBrandVO> countTop10Brands() {
        return smartphonesMapper.countTop10Brands();
    }

    @Override
    public List<SmartphonesModelVO> countModel() {
        return smartphonesMapper.countModel();
    }

    @Override
    public List<SmartphoneRamVO> countRom() {
        return smartphonesMapper.countRom();
    }

    @Override
    public ArrayList<smartphonesStorageVO> countStorage() {
        return smartphonesMapper.countStorage();
    }

    @Override
    public ArrayList<smartphonesColorVO> countColor() {
        return smartphonesMapper.countColor();
    }

    @Override
    public ArrayList<smartphonesFreeVO> countFree() {
        return smartphonesMapper.countFree();
    }

    @Override
    public ArrayList<Smartphones> getByPriceRange(BigDecimal minPrice, BigDecimal maxPrice) {
        QueryWrapper<Smartphones> queryWrapper = new QueryWrapper<>();
        queryWrapper.between("Final_Price", minPrice, maxPrice);
        return (ArrayList<Smartphones>) smartphonesMapper.selectList(queryWrapper);
    }


}
