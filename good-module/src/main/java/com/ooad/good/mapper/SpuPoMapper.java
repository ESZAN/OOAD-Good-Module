package com.ooad.good.mapper;

import com.ooad.good.model.po.SpuPo;
import com.ooad.good.model.po.SpuPoExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface SpuPoMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table goods_spu
     *
     * @mbg.generated
     */
    int deleteByExample(SpuPoExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table goods_spu
     *
     * @mbg.generated
     */
    int deleteByPrimaryKey(Long id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table goods_spu
     *
     * @mbg.generated
     */
    int insert(SpuPo record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table goods_spu
     *
     * @mbg.generated
     */
    int insertSelective(SpuPo record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table goods_spu
     *
     * @mbg.generated
     */
    List<SpuPo> selectByExample(SpuPoExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table goods_spu
     *
     * @mbg.generated
     */
    SpuPo selectByPrimaryKey(Long id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table goods_spu
     *
     * @mbg.generated
     */
    int updateByExampleSelective(@Param("record") SpuPo record, @Param("example") SpuPoExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table goods_spu
     *
     * @mbg.generated
     */
    int updateByExample(@Param("record") SpuPo record, @Param("example") SpuPoExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table goods_spu
     *
     * @mbg.generated
     */
    int updateByPrimaryKeySelective(SpuPo record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table goods_spu
     *
     * @mbg.generated
     */
    int updateByPrimaryKey(SpuPo record);
}