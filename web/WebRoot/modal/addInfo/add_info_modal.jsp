<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<body>
	<div class="modal fade" id="add_info_modal" tabindex="-1" role="dialog"
		aria-labelledby="myModalLabel" aria-hidden="true">
		<div class=" modal-dialog modal_lg">
			<form id="info_form">
				<div class="modal-content">
					<div class="modal-header">
						<button type="button" class="close" data-dismiss="modal"
							aria-hidden="true">&times;</button>
						<h4 class="modal-title" id="myModalLabel">添加新装备</h4>
					</div>
					<div class="modal-body">
						<div id="main_body">
							<table class="tab" style="width: 700px; margin: auto;">
								<tbody>
									<tr>
										<td>装备id：</td>
										<td><input name="zbInfo.userId"
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
						<input name="zbInfo.zbInfoId" id="tableid" type="hidden" />
					</div>
				</div>
			</form>
			<!-- /.modal-content -->
		</div>
		<!-- /.modal -->
	</div>
</body>
</html>
