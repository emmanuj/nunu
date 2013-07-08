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
				<div id="registerDiv">
					<h1 class="welcome" >A better way to connect</h1>
					
					<h2>Lets get started. Its fast and free! </h2>
                    <g:if test="${user?.hasErrors()}">
                      <div class="alert alert-error"><a href="#" class="close" data-dismiss="alert">×</a>
                           <g:renderErrors bean="${user}" as="list" />

                      </div>
                    </g:if>
					<g:form name="signupform" url="[controller:'user',action:'register']">
						<input type="text" class="input input-large" placeholder="Username" name="username"><br/>
						<input type="text" placeholder="email" name="email"/><br/>
						<input type="password" placeholder="Password" name="password"/><br/>
						<input type="password" placeholder="Confirm" name="confirm_password"/><br/>
						<input type="submit" class="btn" value="signup"/>
					</g:form>
				</div>
			</div>
		</div>
	</body>
</html>
