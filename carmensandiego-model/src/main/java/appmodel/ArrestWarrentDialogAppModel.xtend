package appmodel

import org.uqbar.commons.utils.Observable
import villain.Villain

@Observable
class ArrestWarrentDialogAppModel {
	
	@Property
	SolveCaseWindowAppModel solveCaseWindowAppModel
	
	@Property
	Villain warrent
	
	new(SolveCaseWindowAppModel solveCaseWindowAppModel){
		this.solveCaseWindowAppModel = solveCaseWindowAppModel
	}
	
	def sendWarrent(){
		if(warrent!=null)
			solveCaseWindowAppModel.captureOrder = warrent	
	}
	
}