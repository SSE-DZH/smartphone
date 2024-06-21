package com.zhiend.smartphone.controller;


import com.zhiend.smartphone.entity.BackPage;
import com.zhiend.smartphone.entity.Smartphones;
import com.zhiend.smartphone.result.Result;
import com.zhiend.smartphone.service.ISmartphonesService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.math.BigDecimal;
import java.util.ArrayList;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author Zhiend
 * @since 2024-06-21
 */
@RestController
@RequestMapping("/smartphones")
@CrossOrigin("*")
@Api(tags = "智能手机数据统计")
@Slf4j
public class SmartphonesController {
    @Autowired
    private ISmartphonesService smartphonesService;

    @ApiOperation("添加智能手机")
    @PostMapping("/add")
    public Result addNetflixTitle(@RequestBody @Valid Smartphones smartphones, BindingResult bindingResult) {
        // 校验参数
        if (bindingResult.hasErrors()) {
            return Result.error(bindingResult.getAllErrors().get(0).getDefaultMessage());
        }

        // 保存到数据库
        boolean result = smartphonesService.save(smartphones);
        if (result) {
            return Result.success();
        } else {
            return Result.error("添加失败");
        }
    }

    @ApiOperation("删除智能手机信息")
    @DeleteMapping("/delete/{Smartphone}")
    public Result deleteNetflixTitle(@PathVariable String Smartphone) {
        boolean result = smartphonesService.removeById(Smartphone);
        if (result) {
            return Result.success();
        } else {
            return Result.error("删除失败");
        }
    }

    @ApiOperation("更新智能手机")
    @PutMapping("/update")
    public Result updateNetflixTitle(@RequestBody @Valid Smartphones smartphones, BindingResult bindingResult) {
        // 校验参数
        if (bindingResult.hasErrors()) {
            return Result.error(bindingResult.getAllErrors().get(0).getDefaultMessage());
        }

        // 执行更新操作
        boolean result = smartphonesService.updateById(smartphones);
        if (result) {
            return Result.success();
        } else {
            return Result.error("更新失败");
        }
    }

    @ApiOperation("根据Smartphone（主键）查询智能手机")
    @GetMapping("/get/{Smartphone}")
    public Result getNetflixTitle(@PathVariable String Smartphone) {
        Smartphones smartphones = smartphonesService.getById(Smartphone);
        if (smartphones != null) {
            return Result.success(smartphones);
        } else {
            return Result.error("未找到对应记录");
        }
    }


    @ApiOperation("查询所有分页智能手机信息")
    @GetMapping("/getAllPages")
    public Result queryPage(@RequestParam("pageNo") Long pageNo, @RequestParam("pageSize") Long pageSize) {
        return Result.success(smartphonesService.queryPage(pageNo, pageSize));
    }

    //获取所有手机品牌，为list集合
    @ApiOperation("获取所有手机品牌")
    @GetMapping("/get-all-brands")
    public Result getAllBrands() {
        return Result.success(smartphonesService.getAllBrands());
    }

    @ApiOperation("根据品牌统计手机数量")
    @GetMapping("/count-by-type")
    public Result countByType(@RequestParam String brand) {
        int count = smartphonesService.countByType(brand);
        return Result.success(count);
    }

    //统计前10的品牌手机数量
    @ApiOperation("统计前10的品牌手机数量")
    @GetMapping("/count-top-10-brands")
    public Result countTop10Brands() {
        return Result.success(smartphonesService.countTop10Brands());
    }

    //统计手机型号数量，返回封装smartphonesModelVO
    @ApiOperation("统计手机型号数量")
    @GetMapping("/count-model")
    public Result countModel() {
        return Result.success(smartphonesService.countModel());
    }

    //统计ROM数量，返回封装类型smartphonesRomVO
    @ApiOperation("统计ROM数量")
    @GetMapping("/count-rom")
    public Result countRom() {
        return Result.success(smartphonesService.countRom());
    }

    //统计Storage数量，返回封装类型smartphonesStorageVO
    @ApiOperation("统计Storage数量")
    @GetMapping("/count-storage")
    public Result countStorage() {
        return Result.success(smartphonesService.countStorage());
    }

    //统计Color数量，返回封装类型smartphonesColorVO
    @ApiOperation("统计Color数量")
    @GetMapping("/count-color")
    public Result countColor() {
        return Result.success(smartphonesService.countColor());
    }

    //统计Free数量，返回封装类型smartphonesFreeVO
    @ApiOperation("统计Free数量")
    @GetMapping("/count-free")
    public Result countFree() {
        return Result.success(smartphonesService.countFree());
    }

    //根据finalPrice价格区间返回Smartphones
    @ApiOperation("根据finalPrice价格区间返回Smartphones")
    @GetMapping("/get-by-price-range")
    public Result getByPriceRange(@RequestParam("minPrice") BigDecimal minPrice, @RequestParam("maxPrice") BigDecimal maxPrice) {
        ArrayList<Smartphones> smartphonesList = smartphonesService.getByPriceRange(minPrice, maxPrice);
        return Result.success(smartphonesList);
    }


}
