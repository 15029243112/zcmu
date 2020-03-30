layui.use(['table', 'admin', 'ax', 'func'], function () {
    var $ = layui.$;
    var table = layui.table;
    var $ax = layui.ax;
    var admin = layui.admin;
    var func = layui.func;

    /**
     * 经费卡管理
     */
    var CardInfo = {
        tableId: "cardInfoTable"
    };

    /**
     * 初始化表格的列
     */
    CardInfo.initColumn = function () {
        return [[
            {type: 'checkbox'},
            {field: 'cardName', sort: true, title: '经费卡名称'},
            {field: 'cardCode', sort: true, title: '经费卡号'},
            {field: 'type', sort: true, title: '性质'},
            {field: 'payWay', sort: true, title: '经费卡类型'},
            {field: 'currentAmount', sort: true, title: '当前金额'},
            {field: 'payAmount', sort: true, title: '累计支出'},
            {field: 'owner', sort: true, title: '所属人员/单位'},
            {field: 'endDate', sort: true, title: '截止日期'},
            {field: 'status', sort: true, title: '状态'},
            {align: 'center', toolbar: '#tableBar', title: '操作'}
        ]];
    };

    /**
     * 点击查询按钮
     */
    CardInfo.search = function () {
        var queryData = {};


        table.reload(CardInfo.tableId, {
            where: queryData, page: {curr: 1}
        });
    };

    /**
     * 弹出添加对话框
     */
    CardInfo.openAddDlg = function () {
        func.open({
            title: '添加经费卡',
            content: Feng.ctxPath + '/appointment/cardInfo/add',
            tableId: CardInfo.tableId
        });
    };

     /**
      * 点击编辑
      *
      * @param data 点击按钮时候的行数据
      */
      CardInfo.openEditDlg = function (data) {
          func.open({
              title: '修改经费卡',
              content: Feng.ctxPath + '/appointment/cardInfo/edit?cardId=' + data.cardId,
              tableId: CardInfo.tableId
          });
      };


    /**
     * 导出excel按钮
     */
    CardInfo.exportExcel = function () {
        var checkRows = table.checkStatus(CardInfo.tableId);
        if (checkRows.data.length === 0) {
            Feng.error("请选择要导出的数据");
        } else {
            table.exportFile(tableResult.config.id, checkRows.data, 'xls');
        }
    };

    /**
     * 点击删除
     *
     * @param data 点击按钮时候的行数据
     */
    CardInfo.onDeleteItem = function (data) {
        var operation = function () {
            var ajax = new $ax(Feng.ctxPath + "/appointment/cardInfo/delete", function (data) {
                Feng.success("删除成功!");
                table.reload(CardInfo.tableId);
            }, function (data) {
                Feng.error("删除失败!" + data.responseJSON.message + "!");
            });
            ajax.set("cardId", data.cardId);
            ajax.start();
        };
        Feng.confirm("是否删除?", operation);
    };

    // 渲染表格
    var tableResult = table.render({
        elem: '#' + CardInfo.tableId,
        url: Feng.ctxPath + '/appointment/cardInfo/list',
        page: true,
        height: "full-158",
        cellMinWidth: 100,
        cols: CardInfo.initColumn()
    });

    // 搜索按钮点击事件
    $('#btnSearch').click(function () {
        CardInfo.search();
    });

    // 添加按钮点击事件
    $('#btnAdd').click(function () {

    CardInfo.openAddDlg();

    });

    // 导出excel
    $('#btnExp').click(function () {
        CardInfo.exportExcel();
    });

    // 工具条点击事件
    table.on('tool(' + CardInfo.tableId + ')', function (obj) {
        var data = obj.data;
        var layEvent = obj.event;

        if (layEvent === 'edit') {
            CardInfo.openEditDlg(data);
        } else if (layEvent === 'delete') {
            CardInfo.onDeleteItem(data);
        }
    });
});
