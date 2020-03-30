package cn.stylefeng.guns.modular.appointment.cardInfo.mapper;

import cn.stylefeng.guns.modular.appointment.cardInfo.entity.CardInfo;
import cn.stylefeng.guns.modular.appointment.cardInfo.model.params.CardInfoParam;
import cn.stylefeng.guns.modular.appointment.cardInfo.model.result.CardInfoResult;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * <p>
 * 经费卡 Mapper 接口
 * </p>
 *
 * @author 康杨
 * @since 2020-03-27
 */
public interface CardInfoMapper extends BaseMapper<CardInfo> {

    /**
     * 获取列表
     *
     * @author 康杨
     * @Date 2020-03-27
     */
    List<CardInfoResult> customList(@Param("paramCondition") CardInfoParam paramCondition);

    /**
     * 获取map列表
     *
     * @author 康杨
     * @Date 2020-03-27
     */
    List<Map<String, Object>> customMapList(@Param("paramCondition") CardInfoParam paramCondition);

    /**
     * 获取分页实体列表
     *
     * @author 康杨
     * @Date 2020-03-27
     */
    Page<CardInfoResult> customPageList(@Param("page") Page page, @Param("paramCondition") CardInfoParam paramCondition);

    /**
     * 获取分页map列表
     *
     * @author 康杨
     * @Date 2020-03-27
     */
    Page<Map<String, Object>> customPageMapList(@Param("page") Page page, @Param("paramCondition") CardInfoParam paramCondition);

}
