package com.zhiend.smartphone.mapper;

import com.zhiend.smartphone.entity.Smartphones;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author Zhiend
 * @since 2024-06-21
 */
public interface SmartphonesMapper extends BaseMapper<Smartphones> {

    @Select("select distinct Brand from smartphonedb")
    List getAllBrands();

    @Select("select count(*) from smartphonedb where Brand = #{brand}")
    int countByType(String brand);
}
