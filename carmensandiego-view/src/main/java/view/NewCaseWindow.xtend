package view

import org.uqbar.arena.windows.SimpleWindow
import org.uqbar.arena.widgets.Panel
import org.uqbar.arena.windows.WindowOwner
import appmodel.NewCaseWindowAppModel
import org.uqbar.arena.widgets.Label
import org.uqbar.arena.widgets.Button
import org.uqbar.arena.layout.HorizontalLayout
import cases.SolveCaseWindow
import appmodel.SolveCaseWindowAppModel

class NewCaseWindow extends SimpleWindow<NewCaseWindowAppModel> {
	
	new(WindowOwner parent, NewCaseWindowAppModel model) {
		super(parent, model)
	}
	
	override protected addActions(Panel actionsPanel) {
		actionsPanel.layout = new HorizontalLayout
		
		new Button(actionsPanel)=>[
			caption = "Aceptar Caso"
			onClick = [ | new SolveCaseWindow(this,
				 new SolveCaseWindowAppModel(modelObject.gameSystem, modelObject.thisCase)).open
			]
		]
		
		new Button(actionsPanel)=>[
			caption = "Rechazar Caso"
			onClick = [ | this.close
			]
		]
	}
	
	override protected createFormPanel(Panel mainPanel) {
		this.title = modelObject.thisCase.caseName
		new Label(mainPanel).text="Bienvenido Detective, tenemos un nuevo caso para usted:"
		
		new Label(mainPanel).bindValueToProperty("thisCase.description")
	}
	
}