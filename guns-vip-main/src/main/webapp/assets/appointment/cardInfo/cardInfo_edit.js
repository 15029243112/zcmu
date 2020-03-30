/**
 * 详情对话框
 */
var CardInfoInfoDlg = {
    data: {
        cardId: "",
        cardName: "",
        cardCode: "",
        type: "",
        payWay: "",
        currentAmount: "",
        payAmount: "",
        originalAmount: "",
        owner: "",
        endDate: "",
        status: "",
        remarks: "",
    }
};

/**
 * 用户详情对话框
 */
var UserInfoDlg = {
    data: {
        deptId: "",
        deptName: ""
    }
};

var Handle = {
    nextObject: '',
    assignee: "",
    userId:""
};


layui.use(['form', 'admin', 'ax','laydate','upload','formSelects','layer'], function () {
    var $ = layui.jquery;
    var $ax = layui.ax;
    var form = layui.form;
    var admin = layui.admin;
    var laydate = layui.laydate;
    var layer = layui.layer;

    // 点击部门时
    $('#ownerName').click(function () {
        var type = $("#type").val();
        if (type==''){
            layer.msg("请选择卡性质");
            return;
        }else if (type=='1'){
            layer.open({
                type: 2,
                title: '选择人员',
                area: ['600px', '400px'],
                content: Feng.ctxPath + '/taskWaiting/selectDealer',
                end: function () {
                    $("#ownerName").val(Handle.nextObject);
                    $("#owner").val(Handle.userId);
                }
            });

        }else if (type=='2'){
            var formName = encodeURIComponent("parent.UserInfoDlg.data.deptName");
            var formId = encodeURIComponent("parent.UserInfoDlg.data.deptId");
            var treeUrl = treeUrl = encodeURIComponent("/dept/tree");
            layer.open({
                type: 2,
                title: '请选择',
                area: ['300px', '400px'],
                content: Feng.ctxPath + '/system/commonTree?formName=' + formName + "&formId=" + formId + "&treeUrl=" + treeUrl,
                end: function () {
                    $("#owner").val(UserInfoDlg.data.deptId);
                    $("#ownerName").val(UserInfoDlg.data.deptName);
                }
            });
        }
    });

    // 渲染时间选择框
    laydate.render({
        elem: '#endDate'
    });







    //获取详情信息，填充表单
    var ajax = new $ax(Feng.ctxPath + "/appointment/cardInfo/detail?cardId=" + Feng.getUrlParam("cardId"));
    var result = ajax.start();
    console.log(result);
    form.val('cardInfoForm', result.data);

        //表单提交事件
        form.on('submit(btnSubmit)', function (data) {
            var ajax = new $ax(Feng.ctxPath + "/appointment/cardInfo/editItem", function (data) {
                Feng.success("更新成功！");
                //传给上个页面，刷新table用
                admin.putTempData('formOk', true);
                //关掉对话框
                admin.closeThisDialog();
            }, function (data) {
                Feng.error("更新失败！" + data.responseJSON.message)
            });
            ajax.set(data.field);
            ajax.start();

            return false;
        });

});