package com.ooad.good.dao;

import cn.edu.xmu.ooad.util.ResponseCode;
import cn.edu.xmu.ooad.util.ReturnObject;
import com.ooad.good.mapper.SpuPoMapper;
import com.ooad.good.model.bo.Spu;
import com.ooad.good.model.po.SpuPo;
import com.ooad.good.model.po.SpuPoExample;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Repository;

import java.util.Objects;

@Repository
public class SpuDao {
    private Logger logger = LoggerFactory.getLogger(SpuDao.class);
    @Autowired
    private SpuPoMapper spuPoMapper;

    /**
     * 店家新建商品spu
     * @param spu
     * @return
     */
    public ReturnObject<Spu>insertSpu(Spu spu){
        SpuPo spuPo=spu.gotSpuPo();
        ReturnObject<Spu>retObj=null;
        try{
            int ret = spuPoMapper.insertSelective(spuPo);
            if (ret == 0) {
                //插入失败
                logger.debug("insertRole: insert spu fail " + spuPo.toString());
                retObj = new ReturnObject<>(ResponseCode.RESOURCE_ID_NOTEXIST, String.format("新增失败：" + spuPo.getName()));
            } else {
                //插入成功
                logger.debug("insertRole: insert spu = " + spuPo.toString());
                spu.setId(spuPo.getId());
                retObj = new ReturnObject<>(spu);
            }
        }
        catch (DataAccessException e) {
            if (Objects.requireNonNull(e.getMessage()).contains("auth_role.auth_role_name_uindex")) {
                //若有重复的角色名则新增失败
                logger.debug("updateRole: have same spu name = " + spuPo.getName());
                retObj = new ReturnObject<>(ResponseCode.ROLE_REGISTERED, String.format("spu名重复：" + spuPo.getName()));
            } else {
                // 其他数据库错误
                logger.debug("other sql exception : " + e.getMessage());
                retObj = new ReturnObject<>(ResponseCode.INTERNAL_SERVER_ERR, String.format("数据库错误：%s", e.getMessage()));
            }
        }
        catch (Exception e) {
            // 其他Exception错误
            logger.error("other exception : " + e.getMessage());
            retObj = new ReturnObject<>(ResponseCode.INTERNAL_SERVER_ERR, String.format("发生了严重的数据库错误：%s", e.getMessage()));
        }
        return retObj;
    }

    /**
     * 店家修改spu
     * @param spu
     * @return
     */
    public ReturnObject<Spu> updateSpu(Spu spu) {
        SpuPo spuPo = spu.gotSpuPo();
        ReturnObject<Spu> retObj = null;
        SpuPoExample example = new SpuPoExample();
        SpuPoExample.Criteria criteria = example.createCriteria();
        criteria.andIdEqualTo(spu.getId());

        try{
            int ret = spuPoMapper.updateByExampleSelective(spuPo, example);
//            int ret = roleMapper.updateByPrimaryKeySelective(rolePo);
            if (ret == 0) {
                //修改失败
                logger.debug("updateRole: update spu fail : " + spuPo.toString());
                retObj = new ReturnObject<>(ResponseCode.RESOURCE_ID_NOTEXIST, String.format("spu id不存在：" + spuPo.getId()));
            } else {
                //修改成功
                logger.debug("updateRole: update spu = " + spuPo.toString());
                retObj = new ReturnObject<>();
            }
        }
        catch (DataAccessException e) {
            if (Objects.requireNonNull(e.getMessage()).contains("auth_role.auth_role_name_uindex")) {
                //若有重复的角色名则修改失败
                logger.debug("updateRole: have same spu name = " + spuPo.getName());
                retObj = new ReturnObject<>(ResponseCode.ROLE_REGISTERED, String.format("spu名重复：" + spuPo.getName()));
            } else {
                // 其他数据库错误
                logger.debug("other sql exception : " + e.getMessage());
                retObj = new ReturnObject<>(ResponseCode.INTERNAL_SERVER_ERR, String.format("数据库错误：%s", e.getMessage()));
            }
        }
        catch (Exception e) {
            // 其他Exception错误
            logger.error("other exception : " + e.getMessage());
            retObj = new ReturnObject<>(ResponseCode.INTERNAL_SERVER_ERR, String.format("发生了严重的数据库错误：%s", e.getMessage()));
        }
        return retObj;
    }

}
