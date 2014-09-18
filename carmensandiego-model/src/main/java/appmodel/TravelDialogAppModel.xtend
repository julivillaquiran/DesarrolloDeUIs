package appmodel

import country.Country
import org.uqbar.commons.utils.Observable

@Observable
class TravelDialogAppModel {
	@Property
	SolveCaseWindowAppModel solveCaseWindowAppModel
	
	@Property
	Country	countryToTravel
	
	
	new(SolveCaseWindowAppModel solveCaseWindowAppModel){
		this.solveCaseWindowAppModel = solveCaseWindowAppModel
	}
}