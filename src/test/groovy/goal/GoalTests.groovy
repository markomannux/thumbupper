package goal

import groovyx.gaelyk.spock.*
import com.google.appengine.api.datastore.*
import static com.google.appengine.api.datastore.FetchOptions.Builder.*
 
class GoalTests extends GaelykUnitSpec {
 
    def setup() {
        groovlet 'goal/list.groovy'
    }
 
    def "the groovlet is used to obtain a list of goals"() {
        given: "some goals exists in the datastore"
	def goal1 = new Entity("goal")
	goal1.summary = 'goal1'
	goal1.save()
        
        when: "the initialised groovlet is invoked"
        groovletInstance.get()

        then: "the persisted data is found in the response"
	interaction {
		def jb = new groovy.json.JsonBuilder([[summary:'goal1']] )
		1 * out.write(jb.toString())
	}
    }
}
