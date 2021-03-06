//js默认执行
$(function() {
	//全局变量
	var parent_div = null;
	var a_href = null;
	//方法声明------------------------------start
	//方法加载，让方法开始加载，以便调用
	//修改信息
	var modiInfo = function() {
		//获取id、
		var id = $(this).siblings('input').val();
		//查询单条用户的信息
		$.post("/pxzb/car/car_getcarAllInfo",
			{
				tableName : data.tableName
			}, function(xhr) {
				//modal_id_1，除去学生前部分，方便后部分操作
				var modal_id_1 = data.tableName.replace("car", "");
				//modal_id，最终获取到的模态框id
				var modal_id = modal_id_1.substring(0, 1).toLowerCase() + modal_id_1.substring(1) + "_modal";
				$('#' + modal_id + ' form').find("input,select").each(function() {
					var na = $(this).attr('name').split(".")[1];
					if (na == "carId") {
						$(this).val(xhr.ObjDatas[i].object.carId);
					} else if ($(this).attr('name') == "carName") {
						$(this).val(xhr.ObjDatas[i].object.carName);
					}
					else $(this).val(xhr.ObjDatas[i].object[na]);
				})
				//等全部信息加载完毕，再将模态框显示出来，避免模态框出现但是对应的值还未加载情况
				//如果为用户信息，则只显示基础部分（当前是学生管理页面）
				if (a_href == "info") {
					$("#" + modal_id).find('.other').show();
					$("#" + modal_id).find('.basic').hide();
				}
				//显示出模态框
				$("#" + modal_id).modal({
					keyboard : true
				});
				$("#" + modal_id).find('.sure_mod').unbind().click(function() {
					var review_data = $("#" + modal_id + " form").serialize() + "&tableName=" + data.tableName;
					$.post("/pxzb/car/car_updatecarAllInfo", review_data, function(sxh_data) {
						if (sxh_data.result == "success") {
							toastr.success("修改成功!");
							$("#" + modal_id).modal('hide');
							doQuery();
						}
					}, "json")
				}).show();
			}, "json");
	}

	//页面加载开始，给与元素加载事件-----------------------end

	//页面中只需要绑定一次事件的元素绑定事件区----start
	$('.nav-tabs li a').click(function() {
		//如果已经是点击状态，则点击不作为
		if ($(this).parent('li').attr('class') == 'active') return;
		//重置页码
		data.page = 1;
		//将所有的确认导出按钮隐藏
		$('.sure_export').hide();
		//清空模糊查询内容
		data.fuzzy_query = '';
		//除去链接属性中的#号
		a_href = $(this).attr("href").substr(1);
		//获取panel-body内和所点击的类别相对应的div父元素
		parent_div = $('#' + a_href);
		//通过点击的a标签的链接属性，来给全局对象data.tableName赋值
		data.tableName = "car" + a_href.substring(0, 1).toUpperCase() + a_href.substring(1);
		//条件筛选清空
		parent_div.find("#search_input").empty();
		//执行查询操作
		doQuery();
		//导出模态框初始化
		m_check.init({
			id : '#export_' + a_href + ' #check'
		});
	});

	//指定查询
	$('.search_info').click(function() {
		var this_object = $(this);
		if (this_object.text().trim() == "确认搜索") {
			var name = '';
			var value = '';
			this_object.siblings('#search_input').find('div').each(function() {
				name = data.tableName.replace("car", "car") + '.' + $(this).attr('id');
				var val_arr = [];
				$(this).find('input').each(function() {
					val_arr.push($(this).val());
				});
				//将搜索的内容放入js的数据中
				info_data[data.tableName][name] = val_arr.join(",");
			});
			doQuery();
		} else if (this_object.text().trim() == "清空搜索") {
			$.confirm({
				title : '确定清空?',
				smoothContent : false,
				content : false,
				autoClose : 'cancelAction|10000',
				buttons : {
					deleteUser : {
						btnClass : 'btn-danger',
						text : '确定',
						action : function() {
							this_object.siblings('#search_input').empty();
							$.each(data, function(k, v) {
								if (k.indexOf('car') > -1) {
									data[k] = "";
								}
							})
						}
					},
					cancelAction : {
						btnClass : 'btn-blue',
						text : '取消',
					}
				}
			});
		}
	});
	//学生添加
	$('.sure_add_info').click(function() {
		var review_data = $("#add_info_modal form").serialize() + "&tableName=" + data.tableName;
		$.post("/pxzb/car/car_setcarAllInfo", review_data, function(sxh_data) {
			if (sxh_data.result == "success") {
				toastr.success('添加成功!')
			} else {
				toastr.error('添加失败!');
			}
		}, "json")
	});
	//模糊查询
	$('.fuzzy_query').click(function() {
		data.fuzzy_query = $(this).parent().prev().val();
		doQuery();
	});
	//一次事件的元素绑定事件区----end
	$('.panel-footer a').click(function() {
		var style = $(this).text();
		switch (style) {
		case '首页':
			if (!pageDataInformation.pageIndex <= 1) {
				toastr.info("您已经在首页!");
				return;
			}
			data.page = 1;
			doQuery();
			break;
		case '上一页':
			if (!pageDataInformation.HavePrePage) {
				toastr.info("您已经在第一页!");
				return;
			}
			data.page = pageDataInformation.pageIndex - 1;
			doQuery();
			break;
		case '下一页':
			if (!pageDataInformation.HaveNextPage) {
				toastr.info("您已经在最后一页！")
				return;
			}
			data.page = pageDataInformation.pageIndex + 1;
			doQuery();
			break;
		case '尾页':
			if (pageDataInformation.pageIndex == pageDataInformation.totalPages) {
				toastr.info("您已经在尾页!");
				return;
			}
			data.page = pageDataInformation.totalPages;
			doQuery();
			break;
		}
	});
	//方法声明----start
	//查询方法
	function doQuery() {
		$.ajax({
			url : "/pxzb/car/car_getcarAllInfo",
			type : "post",
			async : false,
			timeout : 3000,
			data : data,
			dataType : "json",
			success : function(xhr_data) {
				$('#' + a_href).find('table tbody').html(getStr(xhr_data));
				//每次做查询之后，按钮需要重新绑定事件
				/*$('.solidButton').click(solidInfo);
				$('.modiButton').click(modiInfo);*/
				//记录分页信息
				setPageInfo(xhr_data);
			},
			error : function() {
				toastr.warning('服务器错误!');
			}
		});
	}
	//通过a标签的href属性，获取查询到的组合成的字符串结果
	function getStr(xhr) {
		var str = "";
		switch (a_href) {
		case 'info':
			for (i = 0; i < xhr.ObjDatas.length; i++) {
				str = `<tr>
				<td>${(i + 1)}</td>
				<td>${xhr.ObjDatas[i].object.carId}</td>
				<td>${xhr.ObjDatas[i].object.carName}</td>
				<td>${xhr.ObjDatas[i].object.sex}</td>
				<td>${xhr.ObjDatas[i].object.enrolmentYear}</td>
				<td>${xhr.ObjDatas[i].object.certificateNo}</td>
				<td>${xhr.ObjDatas[i].object.departmentId}</td>
				<td>${xhr.ObjDatas[i].object.createTime}</td>
				<td><input type="hidden" value="${xhr.ObjDatas[i].carInfo.carId}">
				<button class="btn btn-default btn-xs modiButton" title="修改"><i class="fa fa-pencil-square-o fa-lg"></i></button>
		        <button class="btn btn-default btn-xs solidButton" title="固化"><i class="fa fa-chain fa-lg" ></i></button></td></tr></tr>`;
			}
			break;
		case 'award':
			for (i = 0; i < xhr.ObjDatas.length; i++) {
				str = `<tr>
				<td>${(i + 1)}</td>
				<td>${xhr.ObjDatas[i].object.carId}</td>
				<td>${xhr.ObjDatas[i].object.awardId}</td>
				<td>${xhr.ObjDatas[i].object.awardName}</td>
				<td>${xhr.ObjDatas[i].object.awardClass}</td>
				<td>${xhr.ObjDatas[i].object.authorizationNo} </td>
				<td>${xhr.ObjDatas[i].object.time}</td>
				<td>${xhr.ObjDatas[i].object.firstAward}</td>
				<td>${xhr.ObjDatas[i].object.createTime}</td>
				<td><input type="hidden" value="${xhr.ObjDatas[i].object.awardId}">
				<button class="btn btn-default btn-xs modiButton" title="修改"><i class="fa fa-pencil-square-o fa-lg"></i></button>
		        <button class="btn btn-default btn-xs solidButton" title="固化"><i class="fa fa-chain fa-lg" ></i></button></td></tr></tr>`;
			}
			break;
		case 'patent':
			for (i = 0; i < xhr.ObjDatas.length; i++) {
				str = `<tr>
				<td>${(i + 1)}</td>
				<td>${xhr.ObjDatas[i].object.patentId}</td>
				<td>${xhr.ObjDatas[i].object.carId}</td>
				<td>${xhr.ObjDatas[i].object.awardName}</td>
				<td>${xhr.ObjDatas[i].object.awardClass}</td>
				<td>${xhr.ObjDatas[i].object.authorizationNo}</td>
				<td>${xhr.ObjDatas[i].object.time}</td>
				<td>${xhr.ObjDatas[i].object.firstPatent}</td>
				<td>${xhr.ObjDatas[i].object.createTime}</td>
				<td><input type="hidden" value="${xhr.ObjDatas[i].object.patentId}">
				<button class="btn btn-default btn-xs modiButton" title="修改"><i class="fa fa-pencil-square-o fa-lg"></i></button>
		        <button class="btn btn-default btn-xs solidButton" title="固化"><i class="fa fa-chain fa-lg" ></i></button></td></tr></tr>`;
			}
			break;
		case 'paper':
			for (i = 0; i < xhr.length; i++) {
				str = `<tr>
				<td>${(i + 1)}</td>
				<td>${xhr.ObjDatas[i].object.paperId}</td>
				<td>${xhr.ObjDatas[i].object.carId}</td>
				<td>${xhr.ObjDatas[i].object.periodical}</td>
				<td>${xhr.ObjDatas[i].object.publishTime}</td>
				<td>${xhr.ObjDatas[i].object.includedSituation}</td>
				<td>${xhr.ObjDatas[i].object.createTime}</td>
				<td><input type="hidden" value="${xhr.ObjDatas[i].object.paperId}">
				<button class="btn btn-default btn-xs modiButton" title="修改"><i class="fa fa-pencil-square-o fa-lg"></i></button>
		        <button class="btn btn-default btn-xs solidButton" title="固化"><i class="fa fa-chain fa-lg" ></i></button></td></tr></tr>`;
			}
			break;
		case 'project':
			for (i = 0; i < xhr.length; i++) {
				str = `<tr>
				<td>${(i + 1)}</td>
				<td>${xhr.ObjDatas[i].object.projectId}</td>
				<td>${xhr.ObjDatas[i].object.projectName}</td>
				<td>${xhr.ObjDatas[i].object.carId}</td>
				<td>${xhr.ObjDatas[i].object.projectLeading}</td>
				<td>${xhr.ObjDatas[i].object.userId}</td>
				<td>${xhr.ObjDatas[i].object.createTime}</td>
				<td><input type="hidden" value="${xhr.ObjDatas[i].object.projectId}">
				<button class="btn btn-default btn-xs modiButton" title="修改"><i class="fa fa-pencil-square-o fa-lg"></i></button>
		        <button class="btn btn-default btn-xs solidButton" title="固化"><i class="fa fa-chain fa-lg" ></i></button></td></tr></tr>`;
			}
			break;
		case 'class':
			for (i = 0; i < xhr.length; i++) {
				str = `<tr>
				<td>${(i + 1)}</td>
				<td>${xhr.ObjDatas[i].object.classId}</td>
				<td>${xhr.ObjDatas[i].object.className}</td>
				<td>${xhr.ObjDatas[i].object.userId}</td>
				<td><input type="hidden" value="${xhr.ObjDatas[i].object.classId}">
				<button class="btn btn-default btn-xs modiButton" title="修改"><i class="fa fa-pencil-square-o fa-lg"></i></button>
		        <button class="btn btn-default btn-xs solidButton" title="固化"><i class="fa fa-chain fa-lg" ></i></button></td></tr></tr>`;
			}
			break;
		default:
			toastr.warning('服务器错误!');
			break;
		}
		return str;
	}

	//方法声明----end
	//加载后默认点击学生信息管理
	$('a[href="#info"]').click();

})