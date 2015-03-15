<!DOCTYPE html>
<!--[if lt IE 7]><html class="no-js lt-ie9 lt-ie8 lt-ie7" lang="en"> <![endif]-->
<!--[if (IE 7)&!(IEMobile)]><html class="no-js lt-ie9 lt-ie8" lang="en"><![endif]-->
<!--[if (IE 8)&!(IEMobile)]><html class="no-js lt-ie9" lang="en"><![endif]-->
<!--[if (IE 9)]><html class="no-js ie9" lang="en"><![endif]-->
<!--[if gt IE 8]><!-->
<html lang="en-GB"> <!--<![endif]-->

  <jsp:include page="head.jsp"/>
  
    <body>

<jsp:include page="header.jsp"/>

		<div class="login-content">
			<div id="login" class="login-content-inner">
				<form method="post" action="${pageContext.request.contextPath}/v1/campaigns/list/">
					<h2>Log In</h2>
			        <p><input type="text" name="login" value="" placeholder="Username or Email"></p>
			        
			        <p><input type="password" name="password" value="" placeholder="Password"></p>

			        <p class="remember_me">
			          <label>
			            <input id="log-in-different" type="checkbox" name="remember_me" id="remember_me">
			            Remember me on this computer
			          </label>
			        </p>
			        <p class="button submit"><input style="padding: 0;" type="submit" name="commit" value="Login"></p>
		      	</form>
		    </div>
	    </div><!-- End login-content -->

<jsp:include page="footer.jsp"/>

       <script src="${pageContext.request.contextPath}/js/main-vendors.js"></script>
        <script src="${pageContext.request.contextPath}/js/main.js"></script>

</body>
</html>

