package com.ooad.good.mapper;

import com.ooad.good.model.po.FloatPricePo;

public interface FloatPricePoMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table float_price
     *
     * @mbg.generated
     */
    int deleteByPrimaryKey(Long id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table float_price
     *
     * @mbg.generated
     */
    int insert(FloatPricePo record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table float_price
     *
     * @mbg.generated
     */
    int insertSelective(FloatPricePo record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table float_price
     *
     * @mbg.generated
     */
    FloatPricePo selectByPrimaryKey(Long id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table float_price
     *
     * @mbg.generated
     */
    int updateByPrimaryKeySelective(FloatPricePo record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table float_price
     *
     * @mbg.generated
     */
    int updateByPrimaryKey(FloatPricePo record);
}