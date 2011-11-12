import com.google.appengine.api.datastore.*
 
def goal = new Entity("goal")
goal.summary = params.summary
goal.save()
