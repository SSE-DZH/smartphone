package com.zhiend.smartphone.service;

import com.zhiend.smartphone.entity.BackPage;
import com.zhiend.smartphone.entity.Smartphones;
import com.baomidou.mybatisplus.extension.service.IService;
import com.zhiend.smartphone.vo.SmartphonesBrandVO;
import com.zhiend.smartphone.vo.SmartphonesModelVO;

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

    List getAllBrands();

    int countByType(String brand);

     List<SmartphonesBrandVO> countTop10Brands();

    List<SmartphonesModelVO> countModel();
}
