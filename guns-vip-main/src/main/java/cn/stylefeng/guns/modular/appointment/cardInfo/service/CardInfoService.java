package cn.stylefeng.guns.modular.appointment.cardInfo.service;

import cn.stylefeng.guns.base.pojo.page.LayuiPageInfo;
import cn.stylefeng.guns.modular.appointment.cardInfo.entity.CardInfo;
import cn.stylefeng.guns.modular.appointment.cardInfo.model.params.CardInfoParam;
import cn.stylefeng.guns.modular.appointment.cardInfo.model.result.CardInfoResult;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * <p>
 * 经费卡 服务类
 * </p>
 *
 * @author 康杨
 * @since 2020-03-27
 */
public interface CardInfoService extends IService<CardInfo> {

    /**
     * 新增
     *
     * @author 康杨
     * @Date 2020-03-27
     */
    void add(CardInfoParam param);

    /**
     * 删除
     *
     * @author 康杨
     * @Date 2020-03-27
     */
    void delete(CardInfoParam param);

    /**
     * 更新
     *
     * @author 康杨
     * @Date 2020-03-27
     */
    void update(CardInfoParam param);

    /**
     * 查询单条数据，Specification模式
     *
     * @author 康杨
     * @Date 2020-03-27
     */
    CardInfoResult findBySpec(CardInfoParam param);

    /**
     * 查询列表，Specification模式
     *
     * @author 康杨
     * @Date 2020-03-27
     */
    List<CardInfoResult> findListBySpec(CardInfoParam param);

    /**
     * 查询分页数据，Specification模式
     *
     * @author 康杨
     * @Date 2020-03-27
     */
     LayuiPageInfo findPageBySpec(CardInfoParam param);

}
