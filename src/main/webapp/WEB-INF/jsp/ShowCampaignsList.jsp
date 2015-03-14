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

        <link href="/css/main.css" rel="stylesheet">
        <link rel="shortcut icon" href="${pageContext.request.contextPath}/ico/favicon.ico">
        <link rel="apple-touch-icon" href="${pageContext.request.contextPath}/ico/apple-touch-icon-57-precomposed.png">
        <link rel="apple-touch-icon" sizes="114x114" href="${pageContext.request.contextPath}/ico/apple-touch-icon-114-precomposed.png">
        <link rel="apple-touch-icon" sizes="72x72" href="${pageContext.request.contextPath}/ico/apple-touch-icon-72-precomposed.png">
        <link rel="apple-touch-icon" sizes="144x144" href="${pageContext.request.contextPath}/ico/apple-touch-icon-144-precomposed.png">

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

<br><br><br>




        <article class="section">
            <section class="listings">
              	<c:forEach items="${campaigns}" var="campaign">  
                <div class="campaign-listing">
                    <a href=""><img src="${pageContext.request.contextPath}/img/${campaign.imageURI}" alt=""></a>
                    <h3><a href="">${campaign.title}</a></h3>
                    <p><a href="">${campaign.summary}</a></p>
                    <div class="campaign-funding">
                        <progress value="120" max="1000"></progress>
                        <ul>
                            <li><strong>&pound;${campaign.targetFunding}</strong> <span>Target</span></li>
                            <li><strong>${campaign.timeRemaining}</strong> <span>Days Left</span></li>
                            <li><strong>${campaign.backed}%</strong> <span>Backed</span></li>
                            <li><strong>${campaign.noBackers}</strong> <span>Backers</span></li>
                        </ul>
                    </div>
                </div> 
                </c:forEach>
                 
            </section>
        </article>




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

        <!-- Project Section -->
        <article class="section gray-bg">
            <section id="projects">
                <!-- Title Page -->
                <div class="section-title">
                    <h1 class="title">View Projects<span>.</span></h1>

                    <p class="title-description">We work across a network of carefully screened professionals 
                        with the proven experience to design and implement the changes your business needs.</p>

                    <p class="title-description">Our candidates will add real value due to their extensive 
                        backgrounds in leading and implementing transformation across a variety of sectors.</p>

                        <div class="button">About us</div>
                </div>
                <!-- End Title Page -->
            </section>
        </article>
        <!-- Project Section -->
        
<br><br><br>

<jsp:include page="footer.jsp"/>

       <script src="js/main-vendors.js"></script>
        <script src="js/main.js"></script>

</body>
</html>