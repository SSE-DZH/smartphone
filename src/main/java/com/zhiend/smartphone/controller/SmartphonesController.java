package com.zhiend.smartphone.controller;


import com.zhiend.smartphone.service.ISmartphonesService;
import io.swagger.annotations.Api;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

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

}
