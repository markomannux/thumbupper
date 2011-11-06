import com.google.appengine.api.datastore.*

def query = new Query("goal")
def preparedQuery = datastore.prepare(query)
def entities = preparedQuery.asList(FetchOptions.Builder.withDefaults())

def goals = entities.collect {
		[summary:'goal1']
	}
def jb = new groovy.json.JsonBuilder(goals)
out.write (jb.toString())
