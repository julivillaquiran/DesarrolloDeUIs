package view

import org.uqbar.arena.windows.SimpleWindow
import org.uqbar.arena.widgets.Panel
import org.uqbar.arena.windows.WindowOwner
import appmodel.FilesWindowAppModel
import org.uqbar.arena.widgets.Label
import model.Villain
import org.uqbar.arena.widgets.List
import org.uqbar.arena.widgets.Button
import appmodel.CreateVillainAppModel
import org.uqbar.arena.layout.ColumnLayout
import org.uqbar.arena.layout.VerticalLayout
import model.Hobbie
import org.uqbar.arena.widgets.tables.Table

class FilesWindow extends SimpleWindow<FilesWindowAppModel>{
	
	new(WindowOwner parent, FilesWindowAppModel model) {
		super(parent, model)
	}
	
	override protected addActions(Panel actionsPanel) {
		//throw new UnsupportedOperationException("TODO: auto-generated method stub")
	}
	
	override protected createFormPanel(Panel mainPanel) {
//		title = "Expedientes"
//		mainPanel.layout = new VerticalLayout
//		
//		new Label(mainPanel).text="ACA VA TODA LA INFORMACION DE LOS EXPEDIENTES"
	}
	
	override protected createMainTemplate(Panel mainPanel) {
		this.title = "Expedientes"
		mainPanel.layout = new VerticalLayout
		
		
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
			bindItemsToProperty("gameSystem.files")//.adapter = new PropertyAdapter(Villain, "name")
			]
		
		new Button(filesPanel) =>[
			caption = "Nuevo Malechor"
			onClick = [ | new CreateVillainWindow(this, new CreateVillainAppModel(modelObject.gameSystem)).open ]
		] 
		
		new Button(filesPanel) =>[
			caption = "Editar Malechor"
			onClick = [ |showError("Not yet implemented")
			// new NuevaMateriaWindow(this, this.modelObject.carrera).open 
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
		
		
		new Label(villainInfoPanel).text = "Hobbies:"
		var hobbiesTable = new Table<Hobbie>(villainInfoPanel, Hobbie)
		hobbiesTable.bindItemsToProperty("selectedVillain.hobbies")
		hobbiesTable.bindValueToProperty("selectedHobbie")		
		
	}
	
}