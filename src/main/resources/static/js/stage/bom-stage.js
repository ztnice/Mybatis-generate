
$(document).ready(
	$("#doSubmit1").click(
		function() {
			var x = $("#text1").val();
			if (x.length == 0) {
				$("#myModal").modal('show');
				return;
			}
			$.ajax({
				type : 'GET',
				url : '/loadBom/loadByID',
				data : {
					"bdf" : x
				},
				success : function(result) {
					var x = JSON.stringify(result);
					var y = JSON.parse(x);
					var m=y[0];
					var n=y[1];
					var rel = "<table class='table table-striped tableNormalStyle' style='width:"+200*m.length+"px'>" + "<tr>"
					rel=rel+ "<th class='numToCenter'>序号</th>" + "<th>顺序号</th>";
					for (var i = 0; i < m.length; i++) {
						rel=rel+"<th>"+m[i]+"</th>";
					}
					rel=rel+"</tr>";
					for (var i = 2; i < y.length; i++) {
						rel = rel + "<tr>";
						rel=rel+"<td>"+y[i].index+"</td>";
						rel=rel+"<td>"+y[i].on+"</td>";
							for (var j = 0; j < n.length; j++) {
								rel=rel+"<td>"+eval("y["+i+"]."+eval("n["+j+"]"))+"</td>";
							}
							rel = rel + "</tr>";
					}
					rel = rel + "</table>";
					$("#content").html(rel);
				},
				error : function(result) {
					alert("网络发生错误，请稍后重试");
				},
			});
		}),
);