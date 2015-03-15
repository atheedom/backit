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

    <jsp:include page="head.jsp"/>

<body>
<jsp:include page="header.jsp"/>

     <div style="margin-top:30px;" class="section"><img src="${pageContext.request.contextPath}/img/logo.svg"></div>

        <!-- Home Section -->
        <article class="section gray-bg">
            <section id="how-it-works">
                <!-- Title Page -->
                <div class="section-title">
                
                <h1 class="title">We are the crowdfunding platform for Jersey!</h1>

 

<p class="title-description">BackIt connects great projects in our community with people who are passionate about good causes.
 Crowdfunding pulls multiple individual donations together to achieve big things. You may have heard people say, 'they only need a few pounds for a group of people and it's done', well that's what crowdfunding is.</p>

 

<p class="title-description">By keeping it local, your donation can achieve big things here in Jersey. You can back a variety of projects from art, music, heritage and sport.</p>

 

<p class="title-description">Make a difference - BackIt today!</p>
                
                
   
                </div>
                <!-- End Title Page -->
            </section>
        </article>
        <!-- Home Section -->
        
        <!-- Project Section -->

        <article id="current-projects" class="section white-bg">
            <section class="listings">
              	<c:forEach items="${campaigns}" var="campaign">  
                <div class="campaign-listing">
                    <a href="${pageContext.request.contextPath}/v1/campaigns/details/?campaignId=${campaign.id}"><img src="${pageContext.request.contextPath}/img/${campaign.imageURI}" alt=""></a>
                    <h3><a href="${pageContext.request.contextPath}/v1/campaigns/details/?campaignId=${campaign.id}">${campaign.title}</a></h3>
                    <p><a href="${pageContext.request.contextPath}/v1/campaigns/details/?campaignId=${campaign.id}">${campaign.summary}</a></p>
                        

<%--             <c:if test="${empty campaign.timeLeft.timeLeftAsString}">                            --%>
<%-- 		            <c:choose> --%>
<%-- 		        			<c:when test="${campaign.percentageFunded < 100}">		        			 --%>
<!-- 		        				<div class="campaign-funding failed">	       			 -->
<%-- 		        			</c:when> --%>
<%-- 		       		 		<c:when test="${campaign.percentageFunded >= 100}"> --%>
<!-- 		       		 			<div class="campaign-funding successful"> -->
<%-- 		       		 		</c:when> --%>
<%-- 					</c:choose> --%>
<%--             </c:if> --%>
            
<%--                    <c:if test="${campaign.timeLeft.timeLeftAsString != 0}">                            --%>
       
               <div class="campaign-funding">
<%--                         </c:if> --%>
            
      
                            
                            <progress value="${campaign.percentageFunded}" max="100"></progress>

                        <ul>
                            <li><strong>&pound;${campaign.targetFunding}</strong> <span>Target</span></li>
                            
                                             
                            <li 
                            	<c:if test ="${campaign.timeLeft.unitAsString == \"hours left\" }" var="var_name" scope= "page" >
                            		class="ends-today"
                            	</c:if>                           
                            ><strong>${campaign.timeLeft.timeLeftAsString}</strong> <span>${campaign.timeLeft.unitAsString}</span></li>
                            
                            
                            
                            <li><strong>${campaign.percentageFunded}%</strong> <span>Backed</span></li>
                            <li><strong>${campaign.noBackers}</strong> <span>Backers</span></li>
                        </ul>
                    </div>
                </div> 
                </c:forEach>
                 
            </section>
        </article>
                <!-- Project Section -->
        
       

        <!-- contact Section -->
        <article class="section gray-bg">
            <section id="contact">
                <!-- Title Page -->
                <div class="section-title">
                    <h1 class="title">Contact <img style="height: auto; position: relative; top: 10px; width: 200px;" src="${pageContext.request.contextPath}/img/logo.svg"></h1>
                </div>

                <div class="contact-form-full">


                    <form id="contact-form" class="contact-form" action="php/contact.php">
                        <p class="contact-name">
                            <label>Full name:</label>
                            <input id="contact_name" type="text" placeholder="Type your name here..." value="" name="name"/>
                        </p>
                        <p class="contact-email">
                            <label>Email address:</label>
                            <input id="contact_email" type="text" placeholder="Type your email here..." value="" name="email"/>
                        </p>
                        <p class="contact-message">
                            <label>Message:</label>
                            <textarea id="contact_message" placeholder="Type your message here..." name="message" rows="5" cols="40"></textarea>
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
                    <h1>Feel free to get in touch with us</h1>
                <ul>

                    <li><a href="mailto:hello@backit.je">hello@backit.je</a></li>
             
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
