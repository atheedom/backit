<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>


<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>


<!DOCTYPE html>
<!--[if lt IE 7]><html class="no-js lt-ie9 lt-ie8 lt-ie7" lang="en"> <![endif]-->
<!--[if (IE 7)&!(IEMobile)]><html class="no-js lt-ie9 lt-ie8" lang="en"><![endif]-->
<!--[if (IE 8)&!(IEMobile)]><html class="no-js lt-ie9" lang="en"><![endif]-->
<!--[if (IE 9)]><html class="no-js ie9" lang="en"><![endif]-->
<!--[if gt IE 8]><!-->
<html lang="en-GB"> <!--<![endif]-->
    <head>
        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <title>BackIt.je | The Jersey Crowdfunding Platform</title>

        <meta name="description" content="BackIt.je - A crowdfunding platform for Jersey specific civic, community, creative and commerce projects, featuring a choice of campaign types including thresholds, subscriptions and donations.">
        <meta name="keywords" content="jersey, crowdfunding, fund-raising">
        <meta name="robots" content="index, follow">

        <meta name="viewport" content="width=device-width, initial-scale=1.0 user-scalable=no">
        <meta name="HandheldFriendly" content="true">
        <meta name="MobileOptimized" content="320">
        <meta name="theme-color" content="#fff">
        <!--[if IEMobile]><meta http-equiv="cleartype" content="on"><![endif]-->

        <link href="${pageContext.request.contextPath}/css/main.css" rel="stylesheet">
        <link rel="shortcut icon" href="${pageContext.request.contextPath}/ico/favicon.ico">
        <link rel="apple-touch-icon" href="${pageContext.request.contextPath}/ico/apple-touch-icon-57-precomposed.png">
        <link rel="apple-touch-icon" sizes="114x114" href="${pageContext.request.contextPath}/ico/apple-touch-icon-114-precomposed.png">
        <link rel="apple-touch-icon" sizes="72x72" href="${pageContext.request.contextPath}/ico/apple-touch-icon-72-precomposed.png">
        <link rel="apple-touch-icon" sizes="144x144" href="${pageContext.request.contextPath}/ico/apple-touch-icon-144-precomposed.png">

<style>
@font-face {
  font-family: 'FontAwesome';
  src: url('{pageContext.request.contextPath}/fonts/font-awesome/fontawesome-webfont.eot');
  src: url('{pageContext.request.contextPath}/fonts/font-awesome/fontawesome-webfont.eot') format('embedded-opentype'), 
  url('{pageContext.request.contextPath}/fonts/font-awesome/fontawesome-webfont.woff2') format('woff2'),
   url('{pageContext.request.contextPath}/fonts/font-awesome/fontawesome-webfont.woff') format('woff'),
   url('{pageContext.request.contextPath}/fonts/font-awesome/fontawesome-webfont.ttf') format('truetype'), 
   url('{pageContext.request.contextPath}/fonts/font-awesome/fontawesome-webfont.svg') format('svg');
  font-weight: normal;
  font-style: normal;
}
</style>
 <link href="${pageContext.request.contextPath}/css/font-awesome.css" rel="stylesheet">
        <script>
          (function(i,s,o,g,r,a,m){i['GoogleAnalyticsObject']=r;i[r]=i[r]||function(){
          (i[r].q=i[r].q||[]).push(arguments)},i[r].l=1*new Date();a=s.createElement(o),
          m=s.getElementsByTagName(o)[0];a.async=1;a.src=g;m.parentNode.insertBefore(a,m)
          })(window,document,'script','//www.google-analytics.com/analytics.js','ga');
          ga('create', 'UA-60756207-1', 'auto');
          ga('send', 'pageview');
        </script>
    
    </head>
    

<body>
<jsp:include page="header.jsp"/>


        <!-- Project Section -->
        <article class="row section white-bg">
            <section id="projects">
                <!-- Title Page -->
                <div class="section-title">
                    <h1 class="title">Project Name<span>.</span></h1>
                </div>

                <div class="project-img">
                    <img src="${pageContext.request.contextPath}/img/300x300.jpg">
                </div>

                <div class="project-funding">
                    <div class="container">
                        
                            
		            <c:choose>
		        			<c:when test= "${campaign.percentageFunded <= 100 && timeRemaining == 0}"><div class="campaign-funding failed"> </c:when >
		       		 		<c:when test= "${campaign.percentageFunded == 100 && timeRemaining == 0}"><div class="campaign-funding successful"> </c:when >
		        			<c:otherwise><div class="campaign-funding"></c:otherwise>
					</c:choose>
                            
                            
                            <progress value="${campaign.percentageFunded}" max="100"></progress>
                           
                            
                        
                            <!-- 
                               <c:if test ="${campaign.percentageFunded <= 100}" var="var_name" scope= "page" >
                            
                            </c:if>
                            
                            >100% + timeout = success
                            <100% + timeout = fail
                            <100% + time remaining = nothing
                            
                            if hours left RED otherwise nothing
                            
                             -->
                            <ul>
                                <li><strong>${campaign.noBackers}</strong> <span>Backers</span></li>
                                <li><strong>&pound;${campaign.pledged}</strong> <span>Pledged</span></li>
                                <li><strong>&pound;${campaign.targetFunding}</strong> <span>Target</span></li>
                                <li><strong>${campaign.percentageFunded}%</strong> <span>Backed</span></li>
                                <li><strong>${campaign.timeRemaining}</strong> <span>Days Left</span></li>
                            </ul>
                        </div>                        
                        <p>This campaign concludes at: ${campaign.formatedEndDate}.</p>

                    </div>
                    
                </div>

                <form class="backit-but">
                    <button class="button">Back This Project</button>
                </form>


                <div class="project-description">
                    <div id="social-area">
                        <nav id="social">
                            <ul>
                                <li><a href="https://twitter.com/BirdStudiosBtn" title="Follow us on Twitter" target="_blank"><span class="fa fa-twitter"></span></a></li>
                                <li><a href="https://www.facebook.com/BirdStudiosBtn" title="Follow us on Facebook" target="_blank"><span class="fa fa-facebook"></span></a></li>
                            </ul>
                        </nav>

                        <p>${campaign.description}</p>
                    </div>
                </div>


                <div class="project-backit">
                                  	<c:forEach items="${campaign.rewards}" var="reward"> 
                                  	
          	<br>title: ${reward.title}
          	<br>description: ${reward.description}
          	<br>value: ${reward.value}
          	<br>totalNumber: ${reward.totalNumber}
          	
      	
                                  	
                                  	
                                  	 </c:forEach>
                                  	
                    
                </div>

                
                <!-- End Title Page -->
            </section>
        </article>
        <!-- Project Section -->





<jsp:include page="footer.jsp"/>

       <script src="js/main-vendors.js"></script>
        <script src="js/main.js"></script>

</body>
</html>