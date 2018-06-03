<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<body>
	<div class="modal fade" id="car_info_modal" tabindex="-1"
		role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
		<div class=" modal-dialog modal_lg">
			<form id="info_form">
				<div class="modal-content">
					<div class="modal-header">
						<button type="button" class="close" data-dismiss="modal"
							aria-hidden="true">&times;</button>
						<h4 class="modal-title" id="myModalLabel">添加车辆信息</h4>
					</div>
					<div class="modal-body">
						<div id="main_body">
							<table class="tab">
								<tbody>
									<tr>
										<td>车牌号：</td>
										<td><input name="carInfo.carName"
											class="form-control table_infomation" type="text"></td>
										<td>类型：</td>
										<td><input name="carInfo.carId"
											class="form-control table_infomation" type="text"></td>
									</tr>
								</tbody>
								
							</table>
						</div>
					</div>
					<div class="modal-footer">
						<button type="button" class="btn btn-danger sure_add_info"
							data-dismiss="modal">确认添加</button>
						<button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
						<input name="carInfo.carInfoId" id="tableid" type="hidden" />
					</div>
				</div>
			</form>
			<!-- /.modal-content -->
		</div>
		<!-- /.modal -->
	</div>


</body>
</html>