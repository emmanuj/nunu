<!DOCTYPE html>
<html>
	<head>
		<meta name="layout" content="main"/>
		<title>Nunu</title>
		<g:javascript library="jquery"></g:javascript>
	</head>
	<body>
		<div class="wrapper container">
			<div id="header">
				<h1 class="logo">Nu<span class="orange">nu</span></h1>
				<div class="nav">
					<a href="#" class="btn">Login</a>
				</div>
			</div>
			<hr>
			<div class="innerWrapper">
				<div id="registerDiv" style="text-align:center;">
					<h1>Login </h1>
                    <g:if test="${user?.hasErrors()}">
                      <div class="alert alert-error"><a href="#" class="close" data-dismiss="alert">×</a>
                           <g:renderErrors bean="${user}" as="list" />
					  </div>
                    </g:if>
					<g:form name="loginform" url="[controller:'user',action:'login']">
						<input type="text" class="input input-large" placeholder="Username or email" name="username"><br/>
						<input type="password" placeholder="Password" name="password"/><br/>
						<input type="submit" class="btn" value="login"/>
					</g:form>
				</div>
			</div>
		</div>
	</body>
</html>
