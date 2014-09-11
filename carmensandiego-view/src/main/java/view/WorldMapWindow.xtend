package view

import org.uqbar.arena.windows.SimpleWindow
import appmodel.WorldMapAppModel
import org.uqbar.arena.widgets.Panel
import org.uqbar.arena.windows.WindowOwner
import org.uqbar.arena.widgets.Label
import org.uqbar.arena.layout.VerticalLayout

class WorldMapWindow extends SimpleWindow<WorldMapAppModel> {
	
	new(WindowOwner parent, WorldMapAppModel model) {
		super(parent, model)
	}
	
	override protected addActions(Panel actionsPanel) {
		//throw new UnsupportedOperationException("TODO: auto-generated method stub")
	}
	
	override protected createFormPanel(Panel mainPanel) {
		title = "Mapamundi"
		mainPanel.layout = new VerticalLayout
		
		new Label(mainPanel).text="ACA VA TODA LA INFORMACION DEL MAPAMUNDI"

	}
	
}