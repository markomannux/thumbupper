<script type="text/javascript">
    function submitGoalCreateForm() {
        jQuery.post("/goal/save", function(data) {
            var returnedGoal = jQuery("<li><span>goal</span><span>10/02/2011</span></li>")
            jQuery("#goalsList").append(returnedGoal)    
        });
    }
    
    jQuery(document).ready(function() {
        jQuery("#createGoalSubmit").click(function() {
            submitGoalCreateForm()
        });
    });
</script>

<h1>Create a new goal</h1>

<form action="/goal/save" method="post">
    <label for="summary">Summary</label><input type="text" name="summary" id="summary"/>
    <label for="dueDate">Due date</label><input type="text" name="dueDate" id="dueDate"/>
    <input type="button" id="createGoalSubmit" value="create"/>
</form>

<ul id="goalsList">
    
</ul>
