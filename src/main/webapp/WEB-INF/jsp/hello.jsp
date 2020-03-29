<!DOCTYPE html>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html lang="en">
<head>

	<!-- Access the bootstrap Css like this, 
		Spring boot will handle the resource mapping automcatically -->
	<link rel="stylesheet" type="text/css" href="webjars/bootstrap/3.3.7/css/bootstrap.min.css" />

	<!-- 
	<spring:url value="/css/main.css" var="springCss" />
	<link href="${springCss}" rel="stylesheet" />
	 -->
	<c:url value="/css/main.css" var="jstlCss" />
	<link href="${jstlCss}" rel="stylesheet" />
	
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
	<script type="text/javascript" src="webjars/bootstrap/3.3.7/js/bootstrap.min.js"></script>
	
	<script>
		$(document).ready(function(){
			console.log("jqury calisti !!!");
		});
	</script>
	
</head>
<body>

	<nav class="navbar navbar-inverse">
		<div class="container">
			<div class="navbar-header">
				<a class="navbar-brand" href="/">Spring Boot</a>
			</div>
			<div id="navbar" class="collapse navbar-collapse">
				<ul class="nav navbar-nav">
					<li class="active"><a href="/">Home</a></li>
					<li><a href="/about">About</a></li>
				</ul>
			</div>
		</div>
	</nav>

	<div class="container">

		<div class="starter-template hello-title">
			<h1>Spring Boot Hello Page</h1>
			<h2>Hello : ${message}</h2> 
		</div>
		<div class="row justify-content-start"> 
		    <button class="btn btn-success btn-lg active" onclick="tableToExcel('tblData','')">Excel Al</button>
		</div>
		
		<div class="row">
			<table id="tblData" class="table table-bordered">
		        <tbody>
		            <tr>
		              <th>Adi Soyadi</th>
		                <td>${ad_soyad}</td>
		            </tr>
		            <tr>
		              <th>Il - Adi</th>
		                <td>${ilAdi}</td>
		            </tr>
		        </tbody>
	      </table>
		</div>
	</div>
	
	
	<script type="text/javascript">

		function tableToExcel(table, name) {
		   var uri = 'data:application/vnd.ms-excel;base64,',
		        template = '<html xmlns:o="urn:schemas-microsoft-com:office:office" xmlns:x="urn:schemas-microsoft-com:office:excel" xmlns="http://www.w3.org/TR/REC-html40"><head><!--[if gte mso 9]><xml><x:ExcelWorkbook><x:ExcelWorksheets><x:ExcelWorksheet><x:Name>{worksheet}</x:Name><x:WorksheetOptions><x:DisplayGridlines/></x:WorksheetOptions></x:ExcelWorksheet></x:ExcelWorksheets></x:ExcelWorkbook></xml><![endif]--></head><body><table>{table}</table></body></html>'
		        , base64 = function (s) {
		            return window.btoa(unescape(encodeURIComponent(s)))
		        }
		        , format = function (s, c) {
		            return s.replace(/{(\w+)}/g, function (m, p) {
		                return c[p];
		            })
		        };
		        if (!table.nodeType) table = document.getElementById(table);
		        var ctx = {worksheet: name || 'Worksheet', table: table.innerHTML};
		        window.location.href = uri + base64(format("\uFEFF" +template, ctx));
		        
		}
	</script>
</body>

</html>