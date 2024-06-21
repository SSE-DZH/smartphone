package com.zhiend.smartphone.service;

import com.zhiend.smartphone.entity.BackPage;
import com.zhiend.smartphone.entity.Smartphones;
import com.baomidou.mybatisplus.extension.service.IService;
import com.zhiend.smartphone.vo.*;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author Zhiend
 * @since 2024-06-21
 */
public interface ISmartphonesService extends IService<Smartphones> {

    BackPage<Smartphones> queryPage(Long pageNo, Long pageSize);

    List<String> getAllBrands();

    int countByType(String brand);

    List<SmartphonesBrandVO> countTop10Brands();

    List<SmartphonesModelVO> countModel();

    List<SmartphoneRamVO> countRom();

    ArrayList<smartphonesStorageVO> countStorage();

    ArrayList<smartphonesColorVO> countColor();

    ArrayList<smartphonesFreeVO> countFree();

    ArrayList<Smartphones> getByPriceRange(BigDecimal minPrice, BigDecimal maxPrice);
}
