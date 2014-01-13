<%@include file="includes/header.jsp"%>  


<div class="centerText" style="position: relative; top: 20%;">

<div style="font-size: 30px; color: ${color};">
${status}
</div>

<br/><br/>

<form action="upload/go" method="post" enctype="multipart/form-data">
Clique para escolher: <input type="file" name="upfile"><br/><br/>
 <input type=submit value="Fazer upload!" />
</form>

</div>


<%@include file="includes/rodape.jsp"%>  
