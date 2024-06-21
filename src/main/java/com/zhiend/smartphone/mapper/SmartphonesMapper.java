package com.zhiend.smartphone.mapper;

import com.zhiend.smartphone.entity.Smartphones;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.zhiend.smartphone.vo.*;
import org.apache.ibatis.annotations.Select;

import java.util.ArrayList;
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

    @Select("select distinct Brand from smartphones")
    List<String> getAllBrands();

    @Select("select count(*) from smartphones where Brand = #{brand}")
    int countByType(String brand);

    @Select("select Brand, count(*) as count from smartphones group by Brand order by count desc limit 10")
    List<SmartphonesBrandVO> countTop10Brands();

    @Select("select Model, count(*) as count from smartphones group by Model order by count desc")
    List<SmartphonesModelVO> countModel();

    @Select("SELECT RAM, COUNT(*) AS count FROM smartphones WHERE RAM IS NOT NULL GROUP BY RAM ORDER BY count DESC")
    List<SmartphoneRamVO> countRom();

    @Select("SELECT Storage, COUNT(*) AS count FROM smartphones GROUP BY Storage ORDER BY count DESC")
    ArrayList<smartphonesStorageVO> countStorage();

    @Select("SELECT Color, COUNT(*) AS count FROM smartphones GROUP BY Color ORDER BY count DESC")
    ArrayList<smartphonesColorVO> countColor();

    @Select("SELECT Free, COUNT(*) AS count FROM smartphones GROUP BY Free ORDER BY count DESC")
    ArrayList<smartphonesFreeVO> countFree();
}
