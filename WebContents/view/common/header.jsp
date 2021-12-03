<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<meta charset="UTF-8">
<link rel="stylesheet" href="css/common.css" />
<body style="margin:0;"> <!-- body 기본 마진 때문에 넣었습니다. 여백이 생김 , 여백없이 만들려고 body 넣음  -->
<header class="headerBody">
<div class="headerTop">

<div style="display :flex;  width: 100vw; height :50px;  text-align: center; position: relative; z-index: 2">

	
	<!-- 제목 -->
	<div class="mainTitle"><a href="index.jsp">제목 </a><small style=" display :block;    font-size:0.6rem;
  line-height:1em;">화이팅</small></div>
	
	<!-- 메뉴 -->
	<div class="headerUl">
		<ul>
			<li><a href="">여행지 추천</a></li>
			<li><a href="">자유게시판</a></li>
			<li><a href="">공지사항</a></li>
		</ul>
	</div>
	
	<!-- 로그인,검색 -->
	<% if(session.getAttribute("LoginId") == null ) { %>
<div class="headerButtons">
		<input type="image" id="btn_search" alt="" src="img/whitem2.png">
		<button onClick="location.href='Login.jsp'" class="login_btn">로그인</button>
		<button onClick="location.href='Create.jsp'">회원가입</button>
	</div>

<% }else{ %>
    <div id="b_div" class="login">
		<input type="image" id="btn_search" alt="" src="img/whitem2.png" >
	<a href="" id="info"><img alt="내정보"  src="img/UserIcon.png"> &nbsp <b><%= session.getAttribute("LoginNick") %>님</b></a> &nbsp
		&nbsp<button onClick="location.href='tboard?cmd=LoginOut'">로그아웃</button>
	</div> 
<% } %>

	
	
	
  </div>
	</div>
</header>
</body>
