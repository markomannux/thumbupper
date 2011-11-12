package goal

import groovyx.gaelyk.spock.*
import com.google.appengine.api.datastore.*
import static com.google.appengine.api.datastore.FetchOptions.Builder.*

class GoalSaveTests extends GaelykUnitSpec {

    def setup() {
        groovlet 'goal/save.groovy'
    }       

    def "the save groovlet is used to persist a goal"() {
        given: "required params are provided"
        groovletInstance.params = [summary: "hi! I'm a summary"]

        when: "the initialised groovlet is invoked"
        groovletInstance.get()

        then: "the new goal is persisted in the datastore"
        def query = new Query("goal")
        def preparedQuery = datastore.prepare(query)
        def entities = preparedQuery.asList(FetchOptions.Builder.withDefaults())

        assert entities.size() == 1
        assert entities[0].summary == "hi! I'm a summary"

    }
}
