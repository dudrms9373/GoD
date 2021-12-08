<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c"  uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="/css/common.css" />
<link rel="stylesheet" href="/css/tboard.css" />
<script src="https://code.jquery.com/jquery-3.6.0.js"></script>
<script>
  var totalData = ${totalData};    // 총 데이터 수 ${totalData}
  var dataPerPage = ${dpp};    // 한 페이지에 나타낼 데이터 수 ${dpp}
  if(totalData<100){
	  var pageCount = Math.ceil(totalData/dataPerPage);  
  } else{
  var pageCount = 10;        // 한 화면에 나타낼 페이지 수(불변 예정)
	  
  }
	
  function paging(totalData, dataPerPage, pageCount, currentPage){
    
    console.log("currentPage : " + currentPage);
    
    var totalPage = Math.ceil(totalData/dataPerPage);    // 총 페이지 수
    var pageGroup = Math.ceil(currentPage/pageCount);    // 페이지 그룹
    
    console.log("pageGroup : " + pageGroup);
    
    var last = pageGroup * pageCount;    // 화면에 보여질 마지막 페이지 번호
    if(last > totalPage)
        last = totalPage;
    var first = last - (pageCount-1);    // 화면에 보여질 첫번째 페이지 번호
    var next = last+1;
    var prev = first-1;
    
    console.log("last : " + last);
    console.log("first : " + first);
    console.log("next : " + next);
    console.log("prev : " + prev);

    var $pingingView = $("#paging");
    
    var html = "";
    
    if(prev > 0)
        html += "<a href='#' id='prev'><</a> ";
    
    for(var i=first; i <= last; i++){
        html += "<a href='#' id=" + i + ">" + i + "</a> ";
    }
    
    if(last < totalPage)
        html += "<a href=# id='next'>></a>";
    
    $("#paging").html(html);    // 페이지 목록 생성
    $("#paging a").css("color", "black");
    $("#paging a#" + currentPage).css({"text-decoration":"none", 
                                       "color":"red", 
                                       "font-weight":"bold"});    // 현재 페이지 표시
                                       
    $("#paging a").click(function(){
        
        var $item = $(this);
        var $id = $item.attr("id");
        var selectedPage = $item.text();
        console.log($id);
        if($id == "next")    selectedPage = next;
        if($id == "prev")    selectedPage = prev;
        
        paging(totalData, dataPerPage, pageCount, selectedPage);
        
        if($id=="next"||$id=="prev"){
        	console.log('none action');
        } else{
        	
        $.ajax({
        	url:'/tboard?cmd=BOARDPAGINGACTION',
        	data:{ currentpage:$id,
        		   dpp:dataPerPage,
        		   aa: new Date() //304 방지용 dummy data
        		   },
        	datatype:'json'
        
        	}).done(function( json ){
        		let tag='';
        		  var totalData = json.total;    // 총 데이터 수 ${totalData}
        		  var dataPerPage = json.dpp;    // 한 페이지에 나타낼 데이터 수 ${dpp}
        		  
        		  if(totalData<100){
        			  var pageCount = Math.ceil(totalData/dataPerPage);  
        		  } else{
        		  var pageCount = 10;        // 한 화면에 나타낼 페이지 수
        			  
        		  }
        		  
        		  
        		  var cnt=1;
        		  json.tboard.forEach(function(tboard,index){
        			 console.dir(tboard.title);
					if(cnt==2){
					tag+='<div id="boardbox2">';
					
						
					} else{
					tag+='<div id="boardbox">';
						
					cnt=cnt+1;
					}
					tag+='<div id="imagebox"><a href="/tboard?cmd=READBOARDCONT&boardNum='+tboard.tbNum+'">';
					tag+='<img src="/uploadFiles/'+tboard.img1+'"></img></a></div>';
					tag+= '<div id="listcont">번호:'+ tboard.number +'<br>';
					tag+= '제목:'+tboard.title+'<br>';
					tag+= '작성자:'+ tboard.nickname +'<br>';
					tag+= '조회수:'+ tboard.readCnt  +'<br>';
					tag+= '추천수:'+ tboard.likeCnt  +'<br>' ;
					tag+= '작성일:'+ tboard.wDate    +'</div>';
					tag+='</div>';
        			  
        		  });
        		
				
				$('#tlist').html(tag);
				
			}).fail( function(xhr ){
				alert(xhr.status+''+xhr.statusText);
			 }) //ajax
        	} //다음과 이전 버튼이 아닌 경우  
    })  //페이징 클릭시
        	
       
    
                                       
} //페이징 함수 끝

  $(function() {        
    paging(totalData, dataPerPage, pageCount, 1);
   
    
    
  });
</script>
</head>
<body id="listcontainer">
	<%@include file = "/view/common/header.jsp" %>
	<h2 id="tboardTitle">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
	&nbsp;&nbsp;&nbsp;&nbsp;여행지 추천</h2><a id="writeButton" href="/tboard?cmd=" >게시물 작성</a>
	<div id="tlist">
	<a href="/tboard?cmd=TBOARDWRITEFORM?id=${ LoginId }"></a>
	<c:set var="i" value="1"/>
	<c:forEach var="boardVo" items="${ boardList }">
	<c:if test="${i eq '1' }">
	<div id="boardbox">
	</c:if>
	<c:if test="${i eq '2' }">
	<div id="boardbox2">
	</c:if>
	<c:set var="i" value="2"/>
	<div id="imagebox"><a href="/tboard?cmd=READBOARDCONT&boardNum=${ boardVo.tbNum }">
	<img src="/uploadFiles/${ boardVo.img1 }"></img></a></div>
	<div id="listcont">
	번호:${ boardVo.number }<br>
	제목:${ boardVo.title }<br>
	작성자:${ boardVo.nickName }<br>
	조회수:${ boardVo.readCnt }<br>
	추천수:${ boardVo.likeCnt }<br>
	작성일:${ boardVo.wDate }</div>
	</div>
	</c:forEach>
	</div>
	<!--<div id="tlist">
	
	  <div id="boardbox">
	<div id="imagebox"><a href="#">
	<img src="/uploadFiles/Desert.jpg"></img></a></div>
	<div id="listcont">
	No:1<br>
	제목:아름다운 풍경을 찾아서<br>
	작성자:<br>
	조회수:<br>
	추천수:<br>
	작성일:
	</div>
	</div>
	
	</div>-->
	
	<div id="paging"> </div>
	<%@include file = "/view/common/footer.jsp" %>
</body>
</html>