<% include '/WEB-INF/includes/header.gtpl' %>

<script type="text/javascript">
    function loadGoalCreateForm() {
        jQuery.get("/goal/create", function(data) {
            jQuery("#container").html(data);
        });
    }
    
    jQuery(document).ready(function() {
        
    });
</script>

<div id="container"> 
    <h1>Welcome</h1>

    <p>
        Hi, welcome to ThumbUpper!
    </p>

    <p>
         More exciting content soon!
    </p>

    <% if (user) { %> 
        hi, <%=user.nickname%>! 
    <% } %> 
    <% if (users.isUserLoggedIn()) { %> 
        <a href="${users.createLogoutURL('/')}">Logout</a>
        <a href="#" onclick="loadGoalCreateForm();">Create Goal</a>
    <%    } else { %> 
        <a href="${users.createLoginURL('/')}">Login</a> 
    <% } %> 
</div> 

<% include '/WEB-INF/includes/footer.gtpl' %>

