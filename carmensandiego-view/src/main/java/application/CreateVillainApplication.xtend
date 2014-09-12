package application

import org.uqbar.arena.Application
import model.GameSystem
import appmodel.CreateVillainAppModel
import villainView.CreateVillainWindow

class CreateVillainApplication extends Application{
	GameSystem gameSystem = new GameSystem()
	
	override protected createMainWindow() {
		var model = new CreateVillainAppModel(gameSystem)
		new CreateVillainWindow(this, model) 
	}
	
	def static void main(String[] args) {
		new CreateVillainApplication().start()
	}
	
}