package com.zhiend.smartphone.mapper;

import com.zhiend.smartphone.entity.Smartphones;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.zhiend.smartphone.vo.SmartphonesBrandVO;
import com.zhiend.smartphone.vo.SmartphonesModelVO;
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

    @Select("select Brand, count(*) as count from smartphonedb group by Brand order by count desc limit 10")
    List<SmartphonesBrandVO> countTop10Brands();

    @Select("select Model, count(*) as count from smartphonedb group by Model order by count desc")
    List<SmartphonesModelVO> countModel();
}
