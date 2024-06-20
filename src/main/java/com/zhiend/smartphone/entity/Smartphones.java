package com.zhiend.smartphone.entity;

import java.math.BigDecimal;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 
 * </p>
 *
 * @author Zhiend
 * @since 2024-06-21
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("smartphones")
public class Smartphones implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "Smartphone")
    private String Smartphone;

    private String Brand;

    private String Model;

    private Integer ram;

    private Integer Storage;

    private String Color;

    private String Free;

    private BigDecimal finalPrice;


}
