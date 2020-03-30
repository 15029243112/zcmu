package cn.stylefeng.guns.modular.appointment.cardInfo.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.IdType;
import java.util.Date;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.TableField;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;

/**
 * <p>
 * 经费卡
 * </p>
 *
 * @author 康杨
 * @since 2020-03-27
 */
@TableName("team_card_info")
public class CardInfo implements Serializable {

    private static final long serialVersionUID=1L;

    /**
     * 经费卡Id
     */
      @TableId(value = "card_id", type = IdType.AUTO)
    private Long cardId;

    /**
     * 经费卡名称
     */
    @TableField("card_name")
    private String cardName;

    /**
     * 经费卡号
     */
    @TableField("card_code")
    private String cardCode;

    /**
     * 性质  1：个人  2：单位
     */
    @TableField("type")
    private String type;

    /**
     * 经费卡类型 经费卡类型：0、经费卡;1、测试券;2、人才券;3、设备券 
     */
    @TableField("pay_way")
    private String payWay;

    /**
     * 当前金额
     */
    @TableField("current_amount")
    private Double currentAmount;

    /**
     * 累计支出
     */
    @TableField("pay_amount")
    private Double payAmount;

    /**
     * 原始金额
     */
    @TableField("original_amount")
    private Double originalAmount;

    /**
     * 所属人员/单位
     */
    @TableField("owner")
    private Long owner;

    /**
     * 截止日期
     */
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @TableField("end_date")
    private Date endDate;

    /**
     * 状态  1可用  0不可用
     */
    @TableField("status")
    private String status;

    /**
     * 备注
     */
    @TableField("remarks")
    private String remarks;

    /**
     * 创建人
     */
      @TableField(value = "create_user", fill = FieldFill.INSERT)
    private Long createUser;

    /**
     * 创建日期
     */
    @TableField("cretae_time")
    private Date cretaeTime;

    /**
     * 修改人
     */
      @TableField(value = "update_user", fill = FieldFill.UPDATE)
    private Long updateUser;

    /**
     * 修改日期
     */
      @TableField(value = "update_time", fill = FieldFill.UPDATE)
    private Date updateTime;


    public Long getCardId() {
        return cardId;
    }

    public void setCardId(Long cardId) {
        this.cardId = cardId;
    }

    public String getCardName() {
        return cardName;
    }

    public void setCardName(String cardName) {
        this.cardName = cardName;
    }

    public String getCardCode() {
        return cardCode;
    }

    public void setCardCode(String cardCode) {
        this.cardCode = cardCode;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getPayWay() {
        return payWay;
    }

    public void setPayWay(String payWay) {
        this.payWay = payWay;
    }

    public Double getCurrentAmount() {
        return currentAmount;
    }

    public void setCurrentAmount(Double currentAmount) {
        this.currentAmount = currentAmount;
    }

    public Double getPayAmount() {
        return payAmount;
    }

    public void setPayAmount(Double payAmount) {
        this.payAmount = payAmount;
    }

    public Double getOriginalAmount() {
        return originalAmount;
    }

    public void setOriginalAmount(Double originalAmount) {
        this.originalAmount = originalAmount;
    }

    public Long getOwner() {
        return owner;
    }

    public void setOwner(Long owner) {
        this.owner = owner;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }

    public Long getCreateUser() {
        return createUser;
    }

    public void setCreateUser(Long createUser) {
        this.createUser = createUser;
    }

    public Date getCretaeTime() {
        return cretaeTime;
    }

    public void setCretaeTime(Date cretaeTime) {
        this.cretaeTime = cretaeTime;
    }

    public Long getUpdateUser() {
        return updateUser;
    }

    public void setUpdateUser(Long updateUser) {
        this.updateUser = updateUser;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }



    @Override
    public String toString() {
        return "CardInfo{" +
        "cardId=" + cardId +
        ", cardName=" + cardName +
        ", cardCode=" + cardCode +
        ", type=" + type +
        ", payWay=" + payWay +
        ", currentAmount=" + currentAmount +
        ", payAmount=" + payAmount +
        ", originalAmount=" + originalAmount +
        ", owner=" + owner +
        ", endDate=" + endDate +
        ", status=" + status +
        ", remarks=" + remarks +
        ", createUser=" + createUser +
        ", cretaeTime=" + cretaeTime +
        ", updateUser=" + updateUser +
        ", updateTime=" + updateTime +
        "}";
    }
}
