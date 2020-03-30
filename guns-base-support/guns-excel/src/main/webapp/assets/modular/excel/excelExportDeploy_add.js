/**
 * 添加或者修改页面
 */
var ExcelExportDeployInfoDlg = {
	data : {
		name : "",
		title : "",
		nid : "",
		template : "",
		dataSource : "",
		status : ""
	}
};

layui.use([ 'form', 'admin', 'ax', 'upload' ], function() {
	var $ = layui.jquery;
	var $ax = layui.ax;
	var form = layui.form;
	var admin = layui.admin;
	var upload = layui.upload;
	// 执行上传实例
	var uploadInst = upload.render({
		elem : '#templateUplod', // 绑定元素
		url : 'uploadTemplate', // 上传接口
		accept : 'file', // 只允许上传图片
		acceptMime : 'file/xls', // 只筛选图片
		done : function(res) {
			// 上传完毕回调
			if (res.code == 200) {
				$("#template").val(res.data);
				Feng.success("上传成功！");
				$("#src").text(res.data);
				$("#templateUplod").text("重新上传");
			} else {
				Feng.error("上传失败！" + res.message)
			}
		},
		error : function() {
			// 请求异常回调
			Feng.error("上传失败！")
		}
	});
	// 表单提交事件
	form.on('submit(btnSubmit)', function(data) {
		var ajax = new $ax(Feng.ctxPath + "/excelExportDeploy/addItem",
				function(data) {
					Feng.success("添加成功！");
					// 传给上个页面，刷新table用
					admin.putTempData('formOk', true);
					// 关掉对话框
					admin.closeThisDialog();
				}, function(data) {
					Feng.error("添加失败！" + data.responseJSON.message)
				});
		ajax.set(data.field);
		ajax.start();

		return false;
	});

});