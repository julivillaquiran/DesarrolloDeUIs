package view;

import appmodel.CreateVillainAppModel;
import appmodel.FilesWindowAppModel;
import model.GameSystem;
import model.Hobbie;
import model.Villain;
import org.eclipse.xtext.xbase.lib.ObjectExtensions;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;
import org.uqbar.arena.layout.ColumnLayout;
import org.uqbar.arena.layout.VerticalLayout;
import org.uqbar.arena.widgets.Button;
import org.uqbar.arena.widgets.Control;
import org.uqbar.arena.widgets.Label;
import org.uqbar.arena.widgets.List;
import org.uqbar.arena.widgets.Panel;
import org.uqbar.arena.widgets.tables.Table;
import org.uqbar.arena.windows.SimpleWindow;
import org.uqbar.arena.windows.WindowOwner;
import org.uqbar.lacar.ui.model.Action;
import org.uqbar.lacar.ui.model.ControlBuilder;
import org.uqbar.lacar.ui.model.bindings.Binding;
import view.CreateVillainWindow;

@SuppressWarnings("all")
public class FilesWindow extends SimpleWindow<FilesWindowAppModel> {
  public FilesWindow(final WindowOwner parent, final FilesWindowAppModel model) {
    super(parent, model);
  }
  
  protected void addActions(final Panel actionsPanel) {
  }
  
  protected void createFormPanel(final Panel mainPanel) {
  }
  
  protected void createMainTemplate(final Panel mainPanel) {
    this.setTitle("Expedientes");
    VerticalLayout _verticalLayout = new VerticalLayout();
    mainPanel.setLayout(_verticalLayout);
    Panel contentPanel = new Panel(mainPanel);
    ColumnLayout _columnLayout = new ColumnLayout(2);
    contentPanel.setLayout(_columnLayout);
    this.createVillainList(contentPanel);
    this.createSelectedVillainInformation(contentPanel);
  }
  
  public Button createVillainList(final Panel owner) {
    Button _xblockexpression = null;
    {
      Panel filesPanel = new Panel(owner);
      VerticalLayout _verticalLayout = new VerticalLayout();
      filesPanel.setLayout(_verticalLayout);
      Label _label = new Label(filesPanel);
      _label.setText("Malechores");
      List<Villain> _list = new List<Villain>(filesPanel);
      final Procedure1<List<Villain>> _function = new Procedure1<List<Villain>>() {
        public void apply(final List<Villain> it) {
          it.<Object, ControlBuilder>bindValueToProperty("selectedVillain");
          it.bindItemsToProperty("gameSystem.files");
        }
      };
      ObjectExtensions.<List<Villain>>operator_doubleArrow(_list, _function);
      Button _button = new Button(filesPanel);
      final Procedure1<Button> _function_1 = new Procedure1<Button>() {
        public void apply(final Button it) {
          it.setCaption("Nuevo Malechor");
          final Action _function = new Action() {
            public void execute() {
              FilesWindowAppModel _modelObject = FilesWindow.this.getModelObject();
              GameSystem _gameSystem = _modelObject.getGameSystem();
              CreateVillainAppModel _createVillainAppModel = new CreateVillainAppModel(_gameSystem);
              CreateVillainWindow _createVillainWindow = new CreateVillainWindow(FilesWindow.this, _createVillainAppModel);
              _createVillainWindow.open();
            }
          };
          it.onClick(_function);
        }
      };
      ObjectExtensions.<Button>operator_doubleArrow(_button, _function_1);
      Button _button_1 = new Button(filesPanel);
      final Procedure1<Button> _function_2 = new Procedure1<Button>() {
        public void apply(final Button it) {
          it.setCaption("Editar Malechor");
          final Action _function = new Action() {
            public void execute() {
              FilesWindow.this.showError("Not yet implemented");
            }
          };
          it.onClick(_function);
        }
      };
      _xblockexpression = ObjectExtensions.<Button>operator_doubleArrow(_button_1, _function_2);
    }
    return _xblockexpression;
  }
  
  public Binding<Object, Control, ControlBuilder> createSelectedVillainInformation(final Panel owner) {
    Binding<Object, Control, ControlBuilder> _xblockexpression = null;
    {
      Panel villainInfoPanel = new Panel(owner);
      VerticalLayout _verticalLayout = new VerticalLayout();
      villainInfoPanel.setLayout(_verticalLayout);
      Label _label = new Label(villainInfoPanel);
      _label.setText("Nombre:");
      Label _label_1 = new Label(villainInfoPanel);
      _label_1.<Object, ControlBuilder>bindValueToProperty("selectedVillain.name");
      Label _label_2 = new Label(villainInfoPanel);
      _label_2.setText("Genero:");
      Label _label_3 = new Label(villainInfoPanel);
      _label_3.<Object, ControlBuilder>bindValueToProperty("selectedVillain.sex");
      Label _label_4 = new Label(villainInfoPanel);
      _label_4.setText("Señas Particulares:");
      Label _label_5 = new Label(villainInfoPanel);
      _label_5.setText("Hobbies:");
      Table<Hobbie> hobbiesTable = new Table<Hobbie>(villainInfoPanel, Hobbie.class);
      hobbiesTable.bindItemsToProperty("selectedVillain.hobbies");
      _xblockexpression = hobbiesTable.<Object, ControlBuilder>bindValueToProperty("selectedHobbie");
    }
    return _xblockexpression;
  }
}
