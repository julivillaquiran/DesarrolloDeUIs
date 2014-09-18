package view

import org.uqbar.arena.windows.SimpleWindow
import appmodel.GameSystemAppModel
import org.uqbar.arena.windows.WindowOwner
import org.uqbar.arena.widgets.Panel
import org.uqbar.arena.layout.HorizontalLayout
import org.uqbar.arena.widgets.Label
import org.uqbar.arena.widgets.Button
import org.uqbar.arena.layout.VerticalLayout
import appmodel.FilesWindowAppModel
import appmodel.WorldMapAppModel
import appmodel.NewCaseWindowAppModel

class GameSystemWindow extends SimpleWindow<GameSystemAppModel> {
	
	new(WindowOwner parent, GameSystemAppModel model) {
		super(parent, model)
	}
	
	override protected addActions(Panel actionsPanel) {
		actionsPanel.layout = new HorizontalLayout
		
		new Button(actionsPanel)=>[
			caption = "Nuevo Caso"
			onClick = [ | new NewCaseWindow(this, new NewCaseWindowAppModel(modelObject.gameSystem)).open
			]
		]
		
		new Button(actionsPanel)=>[
			caption = "Mapamundi"
			onClick = [ | new WorldMapWindow(this, new WorldMapAppModel(modelObject.gameSystem)).open	]
		]
		
		new Button(actionsPanel)=>[
			caption = "Expedientes"
			onClick = [ | new FilesWindow(this, new FilesWindowAppModel(modelObject.gameSystem, true)).open
			]
		]
	}
	
	override protected createFormPanel(Panel mainPanel) {
		title = "¿Dónde está Carmen Sandiego?"
		mainPanel.layout = new VerticalLayout
		
		new Label(mainPanel).text="Bienvenido al  mundo de Carmen Sandiego"
		new Label(mainPanel).text="¿Que desea hacer acontinuación?"

		
	}
	

}