import com.google.appengine.api.datastore.*
import com.google.appengine.api.datastore.Query.SortDirection

def query = new Query("goal")
query.addSort("summary", SortDirection.ASCENDING)
def preparedQuery = datastore.prepare(query)
def entities = preparedQuery.asList(FetchOptions.Builder.withDefaults())

def goals = entities.collect {
		[summary:it.summary]
	}
def jb = new groovy.json.JsonBuilder(goals)
out.write (jb.toString())
