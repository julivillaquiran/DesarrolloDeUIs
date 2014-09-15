package application

import org.uqbar.arena.Application
import model.GameSystem
import appmodel.CreateVillainAppModel
import villainView.CreateVillainWindow
import villain.Villain

class CreateVillainApplication extends Application{
	GameSystem gameSystem = new GameSystem()
	Villain villain = new Villain()
	
	override protected createMainWindow() {
		
		var model = new CreateVillainAppModel(gameSystem, villain, true)
		new CreateVillainWindow(this, model) 
	
	}
	
	def static void main(String[] args) {
		new CreateVillainApplication().start()
	}
	
}