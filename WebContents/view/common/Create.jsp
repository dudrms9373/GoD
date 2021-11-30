<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<style>
	h2 {text-align: center;}
	table {margin-left: auto; margin-right: auto; border: 1px solid black;  
	padding : 50px; }
	.CreateForm { text-align: center;}
	table td { padding: 6px; }
 	div { text-align: center;}
 	#btn_create { width: 180px; height: 50px; margin-top: 20px; }
</style>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
<script>
window.onload = function() {
	$('#mon,#year').change(function() {
	var mon = document.getElementById('mon').value;
	var year = document.getElementById('year').value;
	
	console.log(year);
	console.log(mon);
	
	let lastDate = new Date(year, mon, 0);
    var c = lastDate.getDate();
	
	console.log("마지막 일자" + c);
    
	var html ="";
	for (var i = 0; i < c+1; i++) {
		html += "<option>"+ i +"</option>";
	}
	  $('#day').html(html);
}
      )
	}
</script>
</head>
<body>
<div>
	<a href=index.jsp><img src="img/home.png" style="width: 50px; height: 50px;"></a>
</div>

<h2>회원가입</h2>
	
<form action="" method="post" class="CreateForm">
	<table>
	<tr>
	<td>아이디  </td>
		<td colspan="2"> <input type="text" name="id" placeholder="ID"></td>
	</tr>
	<tr>
	<td>비밀번호  </td>
		<td colspan="2"><input type="password" name="pw" placeholder="PW"></td>
	</tr>
	<tr>
	<td>이름  </td>
		<td colspan="2"><input type="text" name="name" placeholder="이름"></td>
	</tr>
	<tr>
	<td>이메일  </td>
		<td colspan="2"><input type="text" name="email" placeholder="이메일"></td>
	</tr>
	<tr>
	<td>생년월일  </td>
		<td colspan="2"> <select name="birth" id="year">
	<%for(int i=1900; i<2021; i++){ %>
				<option><%=i %></option>
				<%} %>
	       </select> 년 
	       
	<select name="b_month" id="mon">
	<%for(int a=1; a < 13; a++){ %>
				<option><%=a %></option>
				<%} %>
	       </select> 월
	     
	       
	<select name="b_day" id="day">
	
	
	       </select> 일</td>
	</tr>
	<tr>
	<td>전화번호  </td>
		<td colspan="2"><select name="tel1">
		<option>010</option>
		<option>011</option>
		<option>016</option>
		<option>017</option>
		<option>019</option>
</select>
	- <input type="text" name="tel2" size="4">
	- <input type="text" name="tel3" size="4"> </td>
	</tr>
	<tr>
	<td>성별  </td>
		<td colspan="2"><input type="radio" name="gender" value="m" checked>남자
	<input type="radio" name="gender" value="f">여자 </td>
	</tr>
	<tr>
	
		<td colspan="3" ><input type="submit" value="회원가입" id="btn_create"> </td>
	</tr>
</table>
	</form>
</body>
</html>