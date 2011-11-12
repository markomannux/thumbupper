package goal

import groovyx.gaelyk.spock.*
import com.google.appengine.api.datastore.*
 
class GoalListTests extends GaelykUnitSpec {
 
    def setup() {
        groovlet 'goal/list.groovy'
    }
 
    def "the list groovlet is used to obtain a list of goals"() {
        given: "some goals exists in the datastore"
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

}
