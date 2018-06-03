<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<body>
	<div class="modal fade" id="car_award_modal" tabindex="-1"
		role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
		<div class=" modal-dialog modal_lg">
			<form id="info_form">
				<div class="modal-content">
					<div class="modal-header">
						<button type="button" class="close" data-dismiss="modal"
							aria-hidden="true">&times;</button>
						<h4 class="modal-title" id="myModalLabel">添加award信息</h4>
					</div>
					<div class="modal-body">
						<div id="main_body">
							<table class="tab">
								<tbody>
									<tr>
										<td>姓名：</td>
										<td><input name="carInfo.carName"
											class="form-control table_infomation" type="text"></td>
										<td>学号：</td>
										<td><input name="carInfo.carId"
											class="form-control table_infomation" type="text"></td>
									</tr>
								</tbody>
								<tbody class="other">
									<tr>
										<td></td>
									</tr>
									<tr>
										<td>年制：</td>
										<td><select name="carInfo.calendarYear"
											class="form-control table_infomation">
												<option></option>
												<option>1</option>
												<option>2</option>
												<option>3</option>
												<option>4</option>
												<option>5</option>
										</select></td>
										<td>&nbsp;&nbsp;入学年份：</td>
										<td><input name="carInfo.enrolmentYear"
											class="form-control table_infomation" type="text"
											placeholder="四位数，如2018"></td>
									</tr>

									<tr>
										<td>证件类型：</td>
										<td><select name="carInfo.certificateType"
											class="form-control table_infomation">
												<option>身份证</option>
												<option>护照</option>
												<option>其他证件</option>
										</select></td>
										<td>&nbsp;&nbsp;证件编号：</td>
										<td><input name="carInfo.certificateNo"
											class="form-control table_infomation" type="text"></td>
									</tr>

									<tr>
										<td>性别：</td>
										<td><select name="carInfo.sex"
											class="form-control table_infomation">
												<option></option>
												<option>男</option>
												<option>女</option>

										</select></td>
										<td>民族：</td>
										<td><input name="carInfo.nation"
											class="form-control table_infomation" type="text"></td>
									</tr>
									<tr>
										<td>政治面貌：</td>
										<td><input name="carInfo.politicalStatus"
											class="form-control table_infomation" type="text"></td>
										<td>生源地：</td>
										<td><input name="carInfo.carSource"
											class="form-control table_infomation" type="text"></td>
									</tr>
									<tr>
										<td>学生类型：</td>
										<td><input name="carInfo.carType"
											class="form-control table_infomation" type="text"></td>
										<td>招生类型：</td>
										<td><input name="carInfo.enrolmentType"
											class="form-control table_infomation" type="text"></td>
									</tr>
									</tr>
									<tr>
										<td>授课方式：</td>
										<td><input name="carInfo.classType"
											class="form-control table_infomation" type="text"></td>
										<td>专业代码：</td>
										<td><input name="carInfo.classNumber"
											class="form-control table_infomation" type="text"></td>
									</tr>
									</tr>
									<tr>
										<td>专业名称：</td>
										<td><input name="carInfo.className"
											class="form-control table_infomation" type="text"></td>
										<td>自主专业名称：</td>
										<td><input name="carInfo.inClassName"
											class="form-control table_infomation" type="text"></td>
									</tr>
									</tr>
									<tr>
										<td>所在学院：</td>
										<td><input name="carInfo.departmentId"
											class="form-control table_infomation" type="text"></td>
										<td>是否师范类专业：</td>
										<td><select name="carInfo.zbTraining"
											class="form-control table_infomation">
												<option></option>
												<option>是</option>
												<option>否</option>
										</select></td>
									</tr>
									</tr>
									<tr>
										<td>是否残疾：</td>
										<td><select name="carInfo.deformed"
											class="form-control table_infomation">
												<option></option>
												<option>是</option>
												<option>否</option>
										</select></td>
										<td>异动类型：</td>
										<td><input name="carInfo.changes"
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