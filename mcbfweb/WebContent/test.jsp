<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="sjm" uri="/struts-jquery-mobile-tags"%>



<jsp:include page="/inc.header.jsp" />
<div data-role="page">  
    <div class="header" data-role="header">  
        <span class="open left"><a href="#panel-01">&#61641;</a></span>  
        <span class="title">Hello World</span>  
        <span class="open right"><a href="#panel-02">&#9776;</a></span>  
    </div>  
    <div class="content" data-role="content">  
        <h3>This is the content</h3>  
        <p>Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod  
        tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam [...].</p>  
    </div>  
    <div class="panel left" data-role="panel" data-position="left" data-display="push" id="panel-01">  
        <ul>  
            <li class="newsfeed"><a href="#" title="Home">News Feed</a></li>  
            <li class="profile"><a href="#" title="Profile">Profile</a></li>  
            <li class="setting"><a href="#" title="Setting">Setting</a></li>  
            <li class="logout"><a href="#" title="Logout">Logout</a></li>  
            <li class="report"><a href="#" title="Report">Report Bug</a></li>  
        </ul>  
    </div>  
    <div class="panel right" data-role="panel" data-position="right" data-display="overlay" id="panel-02">  
            <ul>  
                <li><a href="#" title="John Doe"><span class="avatar"><img src="img/mambows_120.jpg" width="30" height="30"></span>John Doe</a></li>  
                <li><a href="#" title="Jessy Doe"><span class="avatar"><img src="img/mkalalang_120.jpg" width="30" height="30"></span>Jessy Doe</a></li>  
            </ul>  
    </div>  
</div>  
</body>
</html>