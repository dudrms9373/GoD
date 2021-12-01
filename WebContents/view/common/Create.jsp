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
      function check() {
		 
        var r = document.reg_input; 
        if ( r.id.value == "" ) {
            alert("아이디를 입력해주십시오");
            r.id.focus();
            return false;
        }
        if (r.pw.value == "") {
            alert("비밀번호를 입력해주십시오");
            r.pw.focus();           
            return false;
        }
        if (r.name.value == "") {
            alert("이름을 입력해주십시오");
            r.name.focus();
            return false;
        }
        if (r.email.value == "") {
            alert("이메일을 입력해주십시오");
            r.email.focus();
            return false;
        }

        if (r.tel2.value == "" || r.tel3.value == "") {
            alert("전화번호를 입력해주십시오");
            r.tel1.focus();
            return false;
        }
        if (r.day.value == "") {
            alert("생일을 선택해주십시오");
            return false;
        }
        if (r.gender.value == "") {
            alert("성별을 선택해주십시오");
            return false;
        }
    }   
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
	for (var i = 1; i < c+1; i++) {
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
	
<form name="reg_input" action="tboard?cmd=insert" method="post" class="CreateForm" onsubmit="return check()">
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
	       
	<select name="month" id="mon">
	<%for(int a=1; a < 13; a++){ %>
				<option><%=a %></option>
				<%} %>
	       </select> 월
	     
	       
	<select name="day" id="day">
	
	
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
		<td colspan="2"><input type="radio" name="gender" value="m">남자
	<input type="radio" name="gender" value="f">여자 </td>
	</tr>
	<tr>
		<td colspan="3" ><input type="submit" value="회원가입" id="btn_create" > </td>
	</tr>
</table>
	</form>
</body>
</html>
