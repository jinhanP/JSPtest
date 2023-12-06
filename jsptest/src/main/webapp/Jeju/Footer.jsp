<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>footer</title>
<link rel="stylesheet" href="../css/jeju.css">
 <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css"rel="stylesheet"/>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.bundle.min.js"></script>
</head>
<body>
	<div id="container"> 
	  <footer>  
          <div id="bottomMenu"> 
        <ul> 
        <li><a href="#">회사 소개</a></li> 
        <li><a href="#">개인정보처리방침</a></li> 
        <li><a href="#">여행약관</a></li>
         <li><a href="#">사이트맵</a></li> 
  </ul> 
  <div id="sns"> 
  <ul> 
          <li><a href="#"><img src="img/sns-1.png"></a></li> 
          <li><a href="#"><img src="img/sns-2.png"></a></li> 
          <li><a href="#"><img src="img/sns-3.png"></a></li> 
  </ul> 
  </div> 
  </div> 
  <div id="company"> 
        <p>제주특별자치도 ***동 ***로 *** (대표전화) 123-456-7890</p> 
  </div>  
  </footer>  
  </div>
</body>
<script>
//객체가 없어서 null 이기떄문에 자바스크립트를 아래쪽 바디에 
var slides = document.querySelectorAll("#slides > img"); 
// querySelectorAll 자식 이미지를 배열로 가져온다.
var prev = document.getElementById("prev"); 
var next = document.getElementById("next"); 
var current = 0; 

showSlides(current); 


function showSlides(n) { 
 for (let i = 0; i < slides.length; i++) { 
 slides[i].style.display = "none"; 
 } 
 slides[n].style.display = "block"; 
} 

function prevSlide() { 
 if (current > 0) {
   current -= 1;
  }else{
    current = slides.length - 1; 
  }
  showSlides(current); 
} 

function nextSlide() { 
 if (current < slides.length - 1){
   current += 1; 
 } else{
   current = 0; 
 } 
 showSlides(current);  
}
</script>
</html>