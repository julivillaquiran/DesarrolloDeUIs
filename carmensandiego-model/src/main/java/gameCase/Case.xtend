package gameCase

import org.uqbar.commons.utils.Observable
import country.Country
import villain.Villain
import java.util.List


@Observable
class Case {
	@Property
	List<Country> escapeRoute
	
	@Property
	Villain responsable
	
	@Property
	String caseName
	
	@Property
	String description
	
	@Property
	Country currentCountry
	
	
	new(Villain robber){
		responsable = robber
		escapeRoute = newArrayList
	}
		
}