package com.ooad.good.mapper;

import com.ooad.good.model.po.FlashSaleItemPo;

public interface FlashSaleItemPoMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table flash_sale_item
     *
     * @mbg.generated
     */
    int deleteByPrimaryKey(Long id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table flash_sale_item
     *
     * @mbg.generated
     */
    int insert(FlashSaleItemPo record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table flash_sale_item
     *
     * @mbg.generated
     */
    int insertSelective(FlashSaleItemPo record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table flash_sale_item
     *
     * @mbg.generated
     */
    FlashSaleItemPo selectByPrimaryKey(Long id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table flash_sale_item
     *
     * @mbg.generated
     */
    int updateByPrimaryKeySelective(FlashSaleItemPo record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table flash_sale_item
     *
     * @mbg.generated
     */
    int updateByPrimaryKey(FlashSaleItemPo record);
}