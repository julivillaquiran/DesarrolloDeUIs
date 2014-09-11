package view

import org.uqbar.arena.windows.SimpleWindow
import org.uqbar.arena.widgets.Panel
import org.uqbar.arena.windows.WindowOwner
import appmodel.FilesWindowAppModel
import org.uqbar.arena.widgets.Label
import org.uqbar.arena.layout.VerticalLayout

class FilesWindow extends SimpleWindow<FilesWindowAppModel>{
	
	new(WindowOwner parent, FilesWindowAppModel model) {
		super(parent, model)
	}
	
	override protected addActions(Panel actionsPanel) {
		//throw new UnsupportedOperationException("TODO: auto-generated method stub")
	}
	
	override protected createFormPanel(Panel mainPanel) {
		title = "Expedientes"
		mainPanel.layout = new VerticalLayout
		
		new Label(mainPanel).text="ACA VA TODA LA INFORMACION DE LOS EXPEDIENTES"

	}
	
}