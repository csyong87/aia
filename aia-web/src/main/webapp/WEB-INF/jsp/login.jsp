<%@ include file="tags.jsp"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<script type="text/javascript">
	$(document).ready(function(){
		$('.buttonLinkText').bind('click', function(e){
			$('#loginForm').submit();
			e.preventDefault();
		});
	});
</script>

<div class="t-t">
	<span class="tt-l-corner"></span>
	<span class="tt-r-corner"></span>
</div>
<div class="t-m">
	<div class="login-mainarea">
		<div class="graybox-wrapper">
			<span class="graybox-signintxt ssoParahead1"><spring:message code="aia.login.signin.message"/></span>
			<div class="graybox-container">
				<div class="gb-t">
					<span class="gb-t-l"></span>
					<span class="gb-t-r"></span>
				</div>
				<div class="gb-m">
					<div class="signinform">
						<c:if test="${SPRING_SECURITY_LAST_EXCEPTION ne null}">
							<div class="login-error"><spring:message code="aia.login.error.message"/> </div>
						</c:if>
						<form action="authenticate" method="POST" id="loginForm">
							<label class="sf-lbl" for="username"><spring:message code="aia.login.username.message"/> </label>
							<input type="text" id="username" name="username" title=" Please enter a Username" maxlength="80" value="" class="sf-txtbox" tabindex="2/">
							<label class="sf-lbl password" for="password"><spring:message code="aia.login.password.message"/> </label>
							<input type="password" id="password" name="password" title=" Please enter a Password" value="" maxlength="255" class="sf-pwdbox" tabindex="3/">
							<div class="sf-btnarea">
								<a href="#" class="buttonLinkText" title=" Please click here to sign in" tabindex="4">
									<span class="blt-l"></span>
									<span class="blt-txt"><spring:message code="aia.login.signin.btn"/></span>
									<span class="blt-r"></span>
								</a>
							</div>
						</form>
					</div>
				</div>
				<div class="gb-b">
					<span class="gb-b-l"></span>
					<span class="gb-b-r"></span>
				</div>
			</div>
		</div>
		<div class="footer-info">
			<div>
				 This site is intended solely for use by TechM's authorized users. Use of this site is subject to the Legal Notices, Terms for Use and Privacy Statement located on this site. 
				 Use of the site by customers and partners, if authorized, is also subject to the terms of your contract(s) with TechM. 
				 Use of this site by TechM employees is also subject to company policies, including the Code of Conduct. 
				 Unauthorized access or breach of these terms may result in termination of your authorization to use this site and/or civil and criminal penalties.
			</div>
		</div>
	</div>
</div>
<div class="t-b">
	<span class="tb-l-corner"></span>
	<span class="tb-r-corner"></span>
</div>