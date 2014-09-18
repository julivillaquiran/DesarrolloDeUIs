package appmodel

import gameCase.Case
import java.util.List
import java.util.Random
import model.GameSystem
import org.uqbar.commons.utils.Observable

@Observable
class NewCaseWindowAppModel {
	@Property
	GameSystem gameSystem
	
	@Property
	Case thisCase
	
	new(GameSystem gameSystem){
			this.gameSystem = gameSystem
			thisCase = chooseCase()
	}
	
	def Case chooseCase() {
		gameSystem.cases.random
	}
	
	def static <E> E random(List<E> col) {
		val index = new Random().nextInt(col.size)
		col.get(index)
	}
	
}