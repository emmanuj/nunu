<!DOCTYPE html>
<html>
	<head>
		<meta name="layout" content="main"/>
		<title>Nunu | Home</title>
		
	</head>
	<body>
		
		<div class="wrapper container">	
			<div id="header">
				<h1 class="logo">Nu<span class="orange">nu</span></h1>
				<div class="nav">
				<g:if test="${session.user}">
					Welcome ${session.user.username} <g:link controller="user", action="logout"> logout</g:link>
				</g:if>
					
				</div>
			</div>
			<hr>
			
			
			<div class="innerWrapper">
				<g:formRemote name="updateForm" update="tetas" method="get" url="[action:'postTeta' ]">
					<textarea name="message"></textarea><br/>
					<input type="submit" value="Share Teta"/>
				</g:formRemote>
		</div>
		
		<div id="tetas">
			
			<g:render template="tetas" collection="${tetas}" var="teta"/>
			
		</div>
		</div>
		<div class="sidebar">
			<h3>Following</h3>
			<g:each in="${currentuser?.following}" var="user">
				${user.username}<br/>
			</g:each>
			
			<h3>Followers</h3>
			<g:each in="${followers}" var="user">
				${user.username}<br/>
			</g:each>
			
		</div>
		</div>
	</body>
</html>
