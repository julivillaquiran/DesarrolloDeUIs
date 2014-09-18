package view

import org.uqbar.arena.windows.SimpleWindow
import org.uqbar.arena.widgets.Panel
import org.uqbar.arena.windows.WindowOwner
import appmodel.FilesWindowAppModel
import org.uqbar.arena.widgets.Label
import villain.Villain
import org.uqbar.arena.widgets.List
import org.uqbar.arena.widgets.Button
import appmodel.CreateVillainAppModel
import org.uqbar.arena.layout.ColumnLayout
import org.uqbar.arena.layout.VerticalLayout
import villain.Hobbie
import org.uqbar.arena.bindings.PropertyAdapter
import villainView.CreateVillainWindow

class FilesWindow extends SimpleWindow<FilesWindowAppModel>{
	
	new(WindowOwner parent, FilesWindowAppModel model) {
		super(parent, model)
	}
	
	override protected addActions(Panel actionsPanel) {
		//This template is not gonna be used)
	}
	
	override protected createFormPanel(Panel mainPanel) {
		//This template is not gonna be used
	}
	
	override protected createMainTemplate(Panel mainPanel) {
		this.title = "Expedientes"		
		
		var Panel contentPanel = new Panel(mainPanel)
		contentPanel.layout = new ColumnLayout(2)
		this.createVillainList(contentPanel)
		this.createSelectedVillainInformation(contentPanel)
		
	}
	
	
	def createVillainList(Panel owner) {
		var Panel filesPanel = new Panel(owner)
			filesPanel.layout = new VerticalLayout
		
		
		new Label(filesPanel).text = "Malechores"
		new List<Villain>(filesPanel)=>[
			bindValueToProperty("selectedVillain")
			bindItemsToProperty("gameSystem.files").adapter = new PropertyAdapter(Villain, "name")
			if(modelObject.toEdit)
				height = 175
			else
				height = 300
			]
		
		new Button(filesPanel) =>[
			caption = "Nuevo Malechor"
			bindVisibleToProperty("toEdit")
			onClick = [ | new CreateVillainWindow(this, 
				new CreateVillainAppModel(modelObject.gameSystem, modelObject.selectedVillain, false)).open ]
		] 
		
		new Button(filesPanel) =>[
			caption = "Editar Malechor"
			bindVisibleToProperty("toEdit")
			onClick = [ | new CreateVillainWindow(this, 
				new CreateVillainAppModel(modelObject.gameSystem, modelObject.selectedVillain, true)).open
			]
		] 
	}
	
	def createSelectedVillainInformation(Panel owner) {
		var Panel villainInfoPanel = new Panel(owner)
			villainInfoPanel.layout = new VerticalLayout
			
			
			
		new Label(villainInfoPanel).text = "Nombre:"
		new Label(villainInfoPanel).bindValueToProperty("selectedVillain.name")
		
		new Label(villainInfoPanel).text = "Genero:"
		new Label(villainInfoPanel).bindValueToProperty("selectedVillain.sex")
		
		new Label(villainInfoPanel).text = "Señas Particulares:"
		new List<String>(villainInfoPanel)=>[
			bindItemsToProperty("selectedVillain.signs")
			height = 75
			]
		
		new Label(villainInfoPanel).text = "Hobbies:"
		new List<Hobbie>(villainInfoPanel)=>[
			bindItemsToProperty("selectedVillain.hobbies")
			height = 75
			]

	}
	
}