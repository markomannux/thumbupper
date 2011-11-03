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
        
        when: "the initialised groovlet is invoked"
        groovletInstance.get()
         
        then: "the persisted data is found in the response"
	1 * out.write('hello')

    }
}
