package goal

import groovyx.gaelyk.spock.*
import com.google.appengine.api.datastore.*
import static com.google.appengine.api.datastore.FetchOptions.Builder.*
import com.google.appengine.api.datastore.Query.SortDirection
 
class GoalTests extends GaelykUnitSpec {
 
    def setup() {
    }
 
    def "the list groovlet is used to obtain a list of goals"() {
        given: "some goals exists in the datastore"
        groovlet 'goal/list.groovy'
        def goal
        def goals = []
        2.times {
            goal = new Entity("goal")
            goal.summary = "goal$it"
            goal.save()
            goals << goal
        }

        when: "the initialised groovlet is invoked"
        groovletInstance.get()

        then: "the persisted data is found in the response"
        interaction {
            def jb = new groovy.json.JsonBuilder(goals.collect { [summary:it.summary] } )
            1 * response.setContentType('application/json')
            1 * response.setStatus(200)
            1 * out.write(jb.toString())
        }
    }

    def "the save groovlet is used to persist a goal"() {
        given: "the groovlet is initialized"
        groovlet 'goal/save.groovy'

        when: "the initialised groovlet is invoked with goal data"
        groovletInstance.params = [summary: "hi! I'm a summary"]
        groovletInstance.get()

        then: "the new goal is persisted in the datastore"
        def query = new Query("goal")
        def preparedQuery = datastore.prepare(query)
        def entities = preparedQuery.asList(FetchOptions.Builder.withDefaults())

        assert entities.size() == 1
        assert entities[0].summary == "hi! I'm a summary"

    }
}
