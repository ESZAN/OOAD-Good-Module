package com.ooad.good.model.vo;

import com.ooad.good.model.bo.Shop;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @Author: Chaoyang Deng
 * @Date: 2020/12/9 上午9:20
 */
@Data
public class ShopSimpleRetVo {
    @ApiModelProperty(value="店铺名称")
    private String name;

    @ApiModelProperty(value="店铺id")
    private Long id;

    public ShopSimpleRetVo(Shop shop)
    {
        this.name=shop.getName();
        this.id=shop.getId();
    }
}
