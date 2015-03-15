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



        <!-- contact Section -->
        <article style="margin-top: 50px;" class="section gray-bg">
            <section id="contact">
                <!-- Title Page -->
                <div class="section-title">
                    <h1 class="title">Get Backing<span>.</span></h1>
                </div>

                <div class="contact-form-full">


                    <form id="contact-form" class="contact-form" action="php/contact.php">
                        <p class="contact-name">
                            <label>Project name:</label>
                            <input id="contact_name" type="text" placeholder="Type your name here..." value="" name="name"/>
                        </p>

                        <p class="contact-message">
                            <label>Project Summary:</label>
                            <textarea id="contact_message" placeholder="Type your message here..." name="message" rows="15" cols="40"></textarea>
                        </p>

                        <p class="contact-message">
                            <label>Project Description:</label>
                            <textarea id="contact_message" placeholder="Type your message here..." name="message" rows="15" cols="40"></textarea>
                        </p>

                        <p>
                            <label>Choose a category:</label>
                            <select name="Category">
                            <option value="Milk">Art</option>
                            <option value="Cheese">Music</option>
                            <option value="Bread">Sport</option>
                        </p>

                        <p class="contact-email">
                            <label>Your hashtag:</label>
                            <input id="contact_email" type="text" placeholder="Type your hashtag here..." value="" name="email"/>
                        </p>

                        <p>
                            <label>Upload your video:</label>
                            <input type="text" name="textline" size="30">
                        </p>
                            <label>Upload your video:</label>
                            <input type="file" name="datafile" size="40">
                        </p>

                        <p>
                            <label>Upload your Ppoto:</label>
                            <input type="text" name="textline" size="30">
                        </p>
                            <label>Upload your photo:</label>
                            <input type="file" name="datafile" size="40">
                        </p>

                        <p>
                            <label>Choose a campaign model:</label>
                            <select name="model">
                            <option value="Milk">Art</option>
                            <option value="Cheese">Music</option>
                            <option value="Bread">Sport</option>
                        </p>

                        <p class="contact-email">
                            <label>Your start date:</label>
                            <input id="contact_email" type="text" placeholder="Type your start date here..." value="" name="email"/>
                        </p>

                        <p class="contact-email">
                            <label>Your end date:</label>
                            <input id="contact_email" type="text" placeholder="Type your end date here..." value="" name="email"/>
                        </p>

                        <p class="contact-email">
                            <label>Amount of backing:</label>
                            <input id="contact_email" type="text" placeholder="Type your target amount here..." value="" name="email"/>
                        </p>

                        <p class="contact-submit">
                            <a id="contact-submit" class="submit" type="submit" value="submit">Submit your details</a>
                        </p>



        
                        
                        <div id="response">
                        
                        </div>
                    </form>                        
                </div>
                <!-- End Title Page -->

                <div class="contact-details">
                    <h1>Looking forward to getting backing?</h1>
                <ul>

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
