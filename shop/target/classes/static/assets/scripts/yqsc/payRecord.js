/** 支付记录对象 */
var payRecordObject = {
	init : function() {
		// 初始化应用表格
		this._init_app_table();
		this._reg_init_send_btn_event();
		// 分类下拉框事件
		this._reg_select_cate_event();
		// 搜索按钮事件
		this._reg_search_btn_event();
	},
	_reg_init_send_btn_event:function(){
		//进入发货
		$(document).on("click", ".pf-table-btn-edit", function() {
			var $tr = $(this).closest("tr");
			// 行数据
			var rowData = $tr.data("data");
			$("#pf-modal-share").modal('show');
			$("#pf-table-buyRecord").bootstrapTable(
				{
					method : 'get',
					url : "/yqsc/userYg/"+rowData.id+"/pay.json",
					cache : false,
					// height : 400,
					sidePagination : 'server', // client or server
					queryParamsType : 'pageSize',
					search : false,
					striped : true,
					clickToSelect : true,
					pagination : true,
					pageSize : 100,
					pageList : [ 10, 20, 50, 100, 200 ],
					paginationDetail : true,
					paginationHAlign : 'right', // right, left
					showColumns : false,
					showRefresh : false,
					minimumCountColumns : 2,
					checkboxHeader : true,
					ct : true,
					onLoadSuccess : function() {
						// 初始化表格中
	
					},
					columns : [
							{
								field : 'id',
								title : '序号',
								align : 'left',
								valign : 'middle',
								visible : true,
								sortable : false
							},
							{
								field : 'productName',
								title : '商品名称',
								align : 'left',
								valign : 'middle',
								visible : true,
								sortable : false
							},
							{
								field : 'period',
								title : '期数',
								align : 'left',
								valign : 'middle',
								visible : true,
								sortable : false
							},
							{
								field : 'buyNum',
								title : '人次',
								align : 'left',
								valign : 'middle',
								visible : true,
								sortable : false
							},
							{
								field : 'createTime',
								title : '购买时间',
								align : 'left',
								valign : 'middle',
								visible : true,
								sortable : false
							}
							]
				});

		});
	},
	// 搜索按钮事件
	_reg_search_btn_event : function() {
		$("#pf-btn-search").click(function() {
			$("#pf-table-payRecord").bootstrapTable("refresh", {
				url : "/yqsc/payRecord/all.json?payType=" + $("#payType").val() + "&payStatus=" + $("#payStatus").val() + "&searchText=" + encodeURIComponent($("#searchbox").val()),
				pageNumber : 1
			});
		});
	},
	// 分类下拉框事件
	_reg_select_cate_event : function() {
		$("#payType").change(function() {
			$("#pf-btn-search").click();
		});
		$("#payStatus").change(function() {
			$("#pf-btn-search").click();
		});
	},
	// 初始化应用表格
	_init_app_table : function() {
		$("#pf-table-payRecord").bootstrapTable(
				{
					method : 'get',
					url : "/yqsc/payRecord/all.json",
					cache : false,
					// height : 400,
					sidePagination : 'server', // client or server
					queryParamsType : 'pageSize',
					search : false,
					striped : true,
					clickToSelect : true,
					pagination : true,
					pageSize : 20,
					pageList : [ 10, 20, 50, 100, 200 ],
					paginationDetail : true,
					paginationHAlign : 'right', // right, left
					showColumns : false,
					showRefresh : false,
					minimumCountColumns : 2,
					checkboxHeader : true,
					ct : true,
					onLoadSuccess : function() {
						// 初始化表格中
					},
					columns : [
							{
								field : 'id',
								title : '#id',
								align : 'center',
								valign : 'middle',
								visible : false,
								sortable : false

							},
							{
								field : 'userId',
								title : '会员ID',
								align : 'left',
								valign : 'middle',
								visible : true,
								sortable : false
							},
							{
								field : 'userName',
								title : '会员名',
								align : 'left',
								valign : 'middle',
								visible : true,
								sortable : false
							},
							{
								field : 'amount',
								title : '付款金额',
								align : 'left',
								valign : 'middle',
								visible : true,
								sortable : false
							},
							{
								field : 'payStatusName',
								title : '支付状态',
								align : 'left',
								valign : 'middle',
								visible : true,
								sortable : false
							},
							{
								field : 'payTypeName',
								title : '支付方式',
								align : 'left',
								valign : 'middle',
								visible : true,
								sortable : false
							},
							{
								field : 'payNo',
								title : '支付流水号',
								align : 'left',
								valign : 'middle',
								visible : true,
								sortable : false
							},
							{
								field : 'createTime',
								title : '本系统支付时间',
								align : 'left',
								valign : 'middle',
								visible : true,
								sortable : false
							},
							{
								field : 'thirdPayTime',
								title : '第三方系统支付时间',
								align : 'left',
								valign : 'middle',
								visible : true,
								sortable : false
							},
							{
								field : 'thirdTradeNo',
								title : '第三方支付交易号',
								align : 'left',
								valign : 'middle',
								visible : true,
								sortable : false
							},
							{
								field : 'thirdTradeStatus',
								title : '第三方支付状态',
								align : 'left',
								valign : 'middle',
								visible : true,
								sortable : false
							},
							{
								field : 'ygProduct',
								title : ' 商品信息',
								align : 'left',
								valign : 'middle',
								visible : false,
								sortable : false,
								formatter : function(value, row, index) {
									var html = '<a href="/product/' + value.id + '.html" target="_blank"><img src="' + value.logoPath
											+ '" style="width:40px;height:40px;">' + '(第' + value.period + '期)' + value.name;
									html += '&nbsp;&nbsp;￥' + (value.totalNum * value.singlePrice) + "</a>";
									return html;
								}
							},
							{
								field : 'oprate',
								title : '状态与操作',
								align : 'left',
								valign : 'middle',
								visible : true,
								sortable : false,
								formatter : function(value, row, index) {
									var html = row.statusName;
									html = '<br/><a class="am-btn hl-btn-green  am-btn-xs pf-table-btn-edit" style="margin-right:5px;">购买明细</a>';
									
									return html;
								}

							} ]
				});
	}
}
payRecordObject.init();

var site_preview = function(id) {
	window.open("/payRecord/" + id);
}
