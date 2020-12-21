package com.ooad.good.dao;

import cn.edu.xmu.ooad.util.ResponseCode;
import cn.edu.xmu.ooad.util.ReturnObject;
import com.ooad.good.mapper.SkuPoMapper;
import com.ooad.good.model.bo.Groupon;
import com.ooad.good.model.bo.Sku;
import com.ooad.good.model.po.GrouponActivityPo;
import com.ooad.good.model.po.SkuPo;
import com.ooad.good.service.PresaleService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Repository;

import java.util.Objects;

@Repository
public class SkuDao {
    private  static  final Logger logger = LoggerFactory.getLogger(SkuDao.class);

    @Autowired
    SkuPoMapper skuPoMapper;

    /**
     * 管理员添加新的sku到spu里
     * @param sku
     * @return
     */
    public ReturnObject<Sku>insertSku(Sku sku){
        SkuPo skuPo=sku.gotSkuPo();
        ReturnObject<Sku> retObj=null;
        try{
            int ret = skuPoMapper.insertSelective(skuPo);
            if (ret == 0) {
                //插入失败
                logger.debug("insertRole: insert sku fail " + skuPo.toString());
                retObj = new ReturnObject<>(ResponseCode.RESOURCE_ID_NOTEXIST, String.format("新增失败：" + skuPo.getName()));
            } else {
                //插入成功
                logger.debug("insertRole: insert sku = " + skuPo.toString());
                sku.setId(skuPo.getId());
                retObj = new ReturnObject<>(sku);
            }
        }
        catch (DataAccessException e) {
            if (Objects.requireNonNull(e.getMessage()).contains("auth_role.auth_role_name_uindex")) {
                //若有重复的角色名则新增失败
                logger.debug("updateRole: have same sku name = " + skuPo.getName());
                retObj = new ReturnObject<>(ResponseCode.ROLE_REGISTERED, String.format("sku名重复：" + skuPo.getName()));
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
     * 店家商品上架
     * @param id
     * @return
     */
    public ReturnObject<Sku>onlineSku(Long id){
        SkuPo skuPo=skuPoMapper.selectByPrimaryKey(id);
        ReturnObject<Sku>retObj=null;
        if(skuPo==null||skuPo.getState()==0){
            //商品sku不存在或已被删除
            logger.info("sku not exist");
            retObj=new ReturnObject<>(ResponseCode.RESOURCE_ID_NOTEXIST);
            return retObj;
        }

        Byte state=1;
        skuPo.setState(state);
        logger.info("OnlineSku: successful: sku name = " + skuPo.getName());

        retObj = new ReturnObject<>();
        return retObj;

    }

    /**
     * 店家商品下架
     * @param id
     * @return
     */
    public ReturnObject<Sku> offlineSku(Long id){
        SkuPo skuPo=skuPoMapper.selectByPrimaryKey(id);
        ReturnObject<Sku>retObj=null;
        if(skuPo==null||skuPo.getState()==0){
            //团购活动不存在或已被删除
            logger.info("sku not exist");
            retObj=new ReturnObject<>(ResponseCode.RESOURCE_ID_NOTEXIST);
            return retObj;
        }

        Byte state=2;
        skuPo.setState(state);
        logger.info("offlineSku: successful: sku name = " + skuPo.getName());

        retObj = new ReturnObject<>();
        return retObj;

    }
}
