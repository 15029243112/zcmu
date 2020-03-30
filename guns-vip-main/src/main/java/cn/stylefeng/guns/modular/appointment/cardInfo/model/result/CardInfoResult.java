package cn.stylefeng.guns.modular.appointment.cardInfo.model.result;

import lombok.Data;
import java.util.Date;
import java.io.Serializable;

/**
 * <p>
 * 经费卡
 * </p>
 *
 * @author 康杨
 * @since 2020-03-27
 */
@Data
public class CardInfoResult implements Serializable {

    private static final long serialVersionUID = 1L;


    /**
     * 经费卡Id
     */
    private Long cardId;

    /**
     * 经费卡名称
     */
    private String cardName;

    /**
     * 经费卡号
     */
    private String cardCode;

    /**
     * 性质  1：个人  2：单位
     */
    private String type;

    /**
     * 经费卡类型 经费卡类型：0、经费卡;1、测试券;2、人才券;3、设备券 
     */
    private String payWay;

    /**
     * 当前金额
     */
    private Double currentAmount;

    /**
     * 累计支出
     */
    private Double payAmount;

    /**
     * 原始金额
     */
    private Double originalAmount;

    /**
     * 所属人员/单位
     */
    private Long owner;

    /**
     * 截止日期
     */
    private Date endDate;

    /**
     * 状态  1可用  0不可用
     */
    private String status;

    /**
     * 备注
     */
    private String remarks;

    /**
     * 创建人
     */
    private Long createUser;

    /**
     * 创建日期
     */
    private Date cretaeTime;

    /**
     * 修改人
     */
    private Long updateUser;

    /**
     * 修改日期
     */
    private Date updateTime;

}
