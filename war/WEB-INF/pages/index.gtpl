<% include '/WEB-INF/includes/header.gtpl' %>

<h1>Welcome</h1>

<p>
    Hi, welcome to ThumbUpper!
</p>

<p>
     More exciting content soon!
</p>

<div> 
    <% if (user) { %> 
        hi, <%=user.nickname%>! 
    <% } %> 
    <% if (users.isUserLoggedIn()) { %> 
        <a href="${users.createLogoutURL('/')}">Logout</a> 
    <%    } else { %> 
        <a href="${users.createLoginURL('/')}">Login</a> 
    <% } %> 
</div> 

<% include '/WEB-INF/includes/footer.gtpl' %>

