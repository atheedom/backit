<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
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
		@import url(http://fonts.googleapis.com/css?family=Open+Sans:400,400italic,600,600italic,300italic,300,700,700italic);

@font-face {
    font-family: 'museo_slab500';
    src: url('${pageContext.request.contextPath}/fonts/Museo_Slab_500_2-webfont.eot');
    src: url('${pageContext.request.contextPath}/fonts/Museo_Slab_500_2-webfont.eot?#iefix') format('embedded-opentype'),
         url('${pageContext.request.contextPath}/fonts/Museo_Slab_500_2-webfont.woff2') format('woff2'),
         url('${pageContext.request.contextPath}/fonts/Museo_Slab_500_2-webfont.woff') format('woff'),
         url('${pageContext.request.contextPath}/fonts/Museo_Slab_500_2-webfont.ttf') format('truetype'),
         url('${pageContext.request.contextPath}/fonts/Museo_Slab_500_2-webfont.svg#museo_slab500') format('svg');
    font-weight: normal;
    font-style: normal;
}
		</style>
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

        <!-- Home Section -->
        <article class="section white-bg">
            <section id="how-it-works">
                <!-- Title Page -->
                <div class="section-title">
                    <h1 class="title">So how does crowdfunding work?</h1>
                    <p class="title-description">At Deltra we provide resources for organisations in need of 
                        support to strengthen their programme and project teams. Our understanding and knowledge 
                        of the challenges you face as a business is critical to delivering the very best in 
                        resources to your business.</p>

                    <p class="title-description">Our primary focus is to understand your business, your 
                        needs and tailor a specific delivery plan for you. Our clients include FTSE 250, 
                        Alternative Investment Market and Small to Medium Enterprises organisations in the UK and Europe.</p>   
                </div>
                <!-- End Title Page -->
            </section>
        </article>
        <!-- Home Section -->
        

        <article class="section">
            <section class="listings">
              	<c:forEach items="${campaigns}" var="campaign">  
                <div class="campaign-listing">
                    <a href=""><img src="${pageContext.request.contextPath}/img/${campaign.imageURI}" alt=""></a>
                    <h3><a href="${pageContext.request.contextPath}/v1/campaigns/details/?campaignId=${campaign.id}">${campaign.title}</a></h3>
                    <p><a href="${pageContext.request.contextPath}/v1/campaigns/details/?campaignId=${campaign.id}">${campaign.summary}</a></p>
                        
                               
		            <c:choose>
		        			<c:when test= "${campaign.percentageFunded <= 100 && (timeRemaining == 0 || timeRemaining == null || timeRemaining < 0)}"><div class="campaign-funding failed"> </c:when >
		       		 		<c:when test= "${campaign.percentageFunded == 100 && (timeRemaining == 0 || timeRemaining == null || timeRemaining < 0)}"><div class="campaign-funding successful"> </c:when >
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
                            <li><strong>&pound;${campaign.targetFunding}</strong> <span>Target</span></li>
                            <li><strong>${campaign.timeLeft.timeLeftAsString}</strong> <span>${campaign.timeLeft.unitAsString}</span></li>
                            <li><strong>${campaign.percentageFunded}%</strong> <span>Backed</span></li>
                            <li><strong>${campaign.noBackers}</strong> <span>Backers</span></li>
                        </ul>
                    </div>
                </div> 
                </c:forEach>
                 
            </section>
        </article>
        
        




        <!-- contact Section -->
        <article class="section white-bg">
            <section id="contact">
                <!-- Title Page -->
                <div class="section-title">
                    <h1 class="title">Contact backit<span>.</span></h1>
                </div>

                <div class="contact-form-full">


                    <form id="contact-form" class="contact-form" action="php/contact.php">
                        <p class="contact-name">
                            <input id="contact_name" type="text" placeholder="Full Name" value="" name="name"/>
                        </p>
                        <p class="contact-email">
                            <input id="contact_email" type="text" placeholder="Email Address" value="" name="email"/>
                        </p>
                        <p class="contact-message">
                            <textarea id="contact_message" placeholder="Your Message" name="message" rows="15" cols="40"></textarea>
                        </p>
                        <p class="contact-submit">
                            <a id="contact-submit" class="submit" type="submit" value="submit">Send Your Email</a>
                        </p>
                        
                        <div id="response">
                        
                        </div>
                    </form>                        
                </div>
                <!-- End Title Page -->

                <div class="contact-details">
                <ul>
                    <li>Contact Details</li>
                    <li><a href="mailto:hello@backit.je">hello@backit.je</a></li>
                    <li>
                        Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod
                        tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam,
                        quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo
                        consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse
                        cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non
                        proident, sunt in culpa qui officia deserunt mollit anim id est laborum.
                        
                    </li>
                </ul>
            </div>
            </section>
        </article>
        <!-- contact Section -->

        

<jsp:include page="footer.jsp"/>

       <script src="${pageContext.request.contextPath}/js/main-vendors.js"></script>
        <script src="${pageContext.request.contextPath}/js/main.js"></script>

</body>
</html>
