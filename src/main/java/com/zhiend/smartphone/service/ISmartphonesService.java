package com.zhiend.smartphone.service;

import com.zhiend.smartphone.entity.BackPage;
import com.zhiend.smartphone.entity.Smartphones;
import com.baomidou.mybatisplus.extension.service.IService;

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
}
