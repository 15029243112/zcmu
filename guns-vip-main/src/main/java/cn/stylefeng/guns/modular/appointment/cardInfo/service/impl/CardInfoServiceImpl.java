package cn.stylefeng.guns.modular.appointment.cardInfo.service.impl;

import cn.stylefeng.guns.base.pojo.page.LayuiPageFactory;
import cn.stylefeng.guns.base.pojo.page.LayuiPageInfo;
import cn.stylefeng.guns.modular.appointment.cardInfo.entity.CardInfo;
import cn.stylefeng.guns.modular.appointment.cardInfo.mapper.CardInfoMapper;
import cn.stylefeng.guns.modular.appointment.cardInfo.model.params.CardInfoParam;
import cn.stylefeng.guns.modular.appointment.cardInfo.model.result.CardInfoResult;
import  cn.stylefeng.guns.modular.appointment.cardInfo.service.CardInfoService;
import cn.stylefeng.guns.sys.modular.system.warpper.UserWrapper;
import cn.stylefeng.roses.core.util.ToolUtil;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import java.io.Serializable;
import java.util.List;

/**
 * <p>
 * 经费卡 服务实现类
 * </p>
 *
 * @author 康杨
 * @since 2020-03-27
 */
@Service
public class CardInfoServiceImpl extends ServiceImpl<CardInfoMapper, CardInfo> implements CardInfoService {

    @Override
    public void add(CardInfoParam param){
        CardInfo entity = getEntity(param);
        this.save(entity);
    }

    @Override
    public void delete(CardInfoParam param){
        this.removeById(getKey(param));
    }

    @Override
    public void update(CardInfoParam param){
        CardInfo oldEntity = getOldEntity(param);
        CardInfo newEntity = getEntity(param);
        ToolUtil.copyProperties(newEntity, oldEntity);
        this.updateById(newEntity);
    }

    @Override
    public CardInfoResult findBySpec(CardInfoParam param){
        return null;
    }

    @Override
    public List<CardInfoResult> findListBySpec(CardInfoParam param){
        return null;
    }

    @Override
    public LayuiPageInfo findPageBySpec(CardInfoParam param){
        Page pageContext = getPageContext();
        IPage page = this.baseMapper.customPageList(pageContext, param);
        return LayuiPageFactory.createPageInfo(page);
    }

    private Serializable getKey(CardInfoParam param){
        return param.getCardId();
    }

    private Page getPageContext() {
        return LayuiPageFactory.defaultPage();
    }

    private CardInfo getOldEntity(CardInfoParam param) {
        return this.getById(getKey(param));
    }

    private CardInfo getEntity(CardInfoParam param) {
        CardInfo entity = new CardInfo();
        ToolUtil.copyProperties(param, entity);
        return entity;
    }

}
