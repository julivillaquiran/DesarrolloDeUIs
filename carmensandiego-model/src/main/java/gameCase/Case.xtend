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
	Villain caseVillain
	
	new(){
		escapeRoute = newArrayList
		generateEscapeRoute()
	}
	
	def generateEscapeRoute() {
		
	}
	
	
	def description(){
		return ("Esta es la descripcion del caso")
	}
	
	
}