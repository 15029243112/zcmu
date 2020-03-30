package cn.stylefeng.guns.modular.appointment.cardInfo.controller;


import cn.hutool.core.bean.BeanUtil;
import cn.stylefeng.guns.base.pojo.page.LayuiPageInfo;
import cn.stylefeng.guns.modular.appointment.cardInfo.entity.CardInfo;
import cn.stylefeng.guns.modular.appointment.cardInfo.model.params.CardInfoParam;
import cn.stylefeng.guns.modular.appointment.cardInfo.service.CardInfoService;
import cn.stylefeng.guns.sys.modular.system.entity.Dept;
import cn.stylefeng.guns.sys.modular.system.entity.Dict;
import cn.stylefeng.guns.sys.modular.system.model.DeptDto;
import cn.stylefeng.guns.sys.modular.system.service.DeptService;
import cn.stylefeng.guns.sys.modular.system.service.DictService;
import cn.stylefeng.guns.sys.modular.system.service.UserService;
import cn.stylefeng.roses.core.base.controller.BaseController;
import cn.stylefeng.roses.kernel.model.response.ResponseData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;


import java.util.List;
import java.util.Map;

import static cn.stylefeng.guns.base.consts.ConfigConstant.CARD_DICT_PAYWAY;
import static cn.stylefeng.guns.base.consts.ConfigConstant.CARD_DICT_TYPE;
import static cn.stylefeng.guns.base.consts.ConfigConstant.STATUS;
import static cn.stylefeng.guns.base.consts.ConfigConstant.CARD_TYPE_PER;
import static cn.stylefeng.guns.base.consts.ConfigConstant.CARD_TYPE_UNIT;





/**
 * 经费卡控制器
 *
 * @author 康杨
 * @Date 2020-03-27 14:44:56
 */
@Controller
@RequestMapping("/appointment/cardInfo")
public class CardInfoController extends BaseController {

    private String PREFIX = "/appointment/cardInfo";

    @Autowired
    private CardInfoService cardInfoService;
    @Autowired
    private DictService dictService;
    @Autowired
    private UserService userService;
    @Autowired
    private DeptService deptService;


    /**
     * 跳转到主页面
     *
     * @author 康杨
     * @Date 2020-03-27
     */
    @RequestMapping("")
    public String index() {
        return PREFIX + "/cardInfo.html";
    }

    /**
     * 新增页面
     *
     * @author 康杨
     * @Date 2020-03-27
     */
    @RequestMapping("/add")
    public String add(Model model) {
        List<Dict> dictAayWay = dictService.listDictsByCode(CARD_DICT_PAYWAY);
        model.addAttribute("dictAayWay",dictAayWay);
        List<Dict> dictType = dictService.listDictsByCode(CARD_DICT_TYPE);
        model.addAttribute("dictType",dictType);
        List<Dict> dictStatus = dictService.listDictsByCode(STATUS);
        model.addAttribute("dictStatus",dictStatus);
        return PREFIX + "/cardInfo_add.html";
    }

    /**
     * 编辑页面
     *
     * @author 康杨
     * @Date 2020-03-27
     */
    @RequestMapping("/edit")
    public String edit(Model model) {
        List<Dict> dictAayWay = dictService.listDictsByCode(CARD_DICT_PAYWAY);
        model.addAttribute("dictAayWay",dictAayWay);
        List<Dict> dictType = dictService.listDictsByCode(CARD_DICT_TYPE);
        model.addAttribute("dictType",dictType);
        List<Dict> dictStatus = dictService.listDictsByCode(STATUS);
        model.addAttribute("dictStatus",dictStatus);
        return PREFIX + "/cardInfo_edit.html";
    }

    /**
     * 新增接口
     *
     * @author 康杨
     * @Date 2020-03-27
     */
    @RequestMapping("/addItem")
    @ResponseBody
    public ResponseData addItem(CardInfoParam cardInfoParam) {
        cardInfoParam.setCurrentAmount(cardInfoParam.getOriginalAmount());
        cardInfoParam.setPayAmount(0.00);
        this.cardInfoService.add(cardInfoParam);
        return ResponseData.success();
    }

    /**
     * 编辑接口
     *
     * @author 康杨
     * @Date 2020-03-27
     */
    @RequestMapping("/editItem")
    @ResponseBody
    public ResponseData editItem(CardInfoParam cardInfoParam) {
        this.cardInfoService.update(cardInfoParam);
        return ResponseData.success();
    }

    /**
     * 删除接口
     *
     * @author 康杨
     * @Date 2020-03-27
     */
    @RequestMapping("/delete")
    @ResponseBody
    public ResponseData delete(CardInfoParam cardInfoParam) {
        this.cardInfoService.delete(cardInfoParam);
        return ResponseData.success();
    }

    /**
     * 查看详情接口
     *
     * @author 康杨
     * @Date 2020-03-27
     */
    @RequestMapping("/detail")
    @ResponseBody
    public ResponseData detail(CardInfoParam cardInfoParam) {
        CardInfo detail = this.cardInfoService.getById(cardInfoParam.getCardId());
        String   ownerName="";
        BeanUtil.copyProperties(detail, cardInfoParam);
        if (detail.getType().equals(CARD_TYPE_PER)){
            Map<String, Object> userInfoMap=userService.getUserInfo(detail.getOwner());
            cardInfoParam.setOwnerName(userInfoMap.get("name").toString());
        }else if (detail.getType().equals(CARD_TYPE_UNIT)){
            Dept dept = deptService.getById(detail.getOwner());
            cardInfoParam.setOwnerName(dept.getFullName());
        }
        return ResponseData.success(cardInfoParam);
    }

    /**
     * 查询列表
     *
     * @author 康杨
     * @Date 2020-03-27
     */
    @ResponseBody
    @RequestMapping("/list")
    public LayuiPageInfo list(CardInfoParam cardInfoParam) {



        return this.cardInfoService.findPageBySpec(cardInfoParam);
    }

}


