package view;

import appmodel.CreateVillainAppModel;
import appmodel.FilesWindowAppModel;
import model.GameSystem;
import org.eclipse.xtext.xbase.lib.ObjectExtensions;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;
import org.uqbar.arena.bindings.PropertyAdapter;
import org.uqbar.arena.layout.ColumnLayout;
import org.uqbar.arena.layout.VerticalLayout;
import org.uqbar.arena.widgets.Button;
import org.uqbar.arena.widgets.Label;
import org.uqbar.arena.widgets.List;
import org.uqbar.arena.widgets.Panel;
import org.uqbar.arena.widgets.Selector;
import org.uqbar.arena.windows.SimpleWindow;
import org.uqbar.arena.windows.WindowOwner;
import org.uqbar.lacar.ui.model.Action;
import org.uqbar.lacar.ui.model.ControlBuilder;
import org.uqbar.lacar.ui.model.ListBuilder;
import org.uqbar.lacar.ui.model.bindings.Binding;
import villain.Hobbie;
import villain.Villain;
import villainView.CreateVillainWindow;

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
          Binding<?, Selector<Villain>, ListBuilder<Villain>> _bindItemsToProperty = it.bindItemsToProperty("gameSystem.files");
          PropertyAdapter _propertyAdapter = new PropertyAdapter(Villain.class, "name");
          _bindItemsToProperty.setAdapter(_propertyAdapter);
          FilesWindowAppModel _modelObject = FilesWindow.this.getModelObject();
          boolean _isToEdit = _modelObject.isToEdit();
          if (_isToEdit) {
            it.setHeight(175);
          } else {
            it.setHeight(300);
          }
        }
      };
      ObjectExtensions.<List<Villain>>operator_doubleArrow(_list, _function);
      Button _button = new Button(filesPanel);
      final Procedure1<Button> _function_1 = new Procedure1<Button>() {
        public void apply(final Button it) {
          it.setCaption("Nuevo Malechor");
          it.<ControlBuilder>bindVisibleToProperty("toEdit");
          final Action _function = new Action() {
            public void execute() {
              FilesWindowAppModel _modelObject = FilesWindow.this.getModelObject();
              GameSystem _gameSystem = _modelObject.getGameSystem();
              FilesWindowAppModel _modelObject_1 = FilesWindow.this.getModelObject();
              Villain _selectedVillain = _modelObject_1.getSelectedVillain();
              CreateVillainAppModel _createVillainAppModel = new CreateVillainAppModel(_gameSystem, _selectedVillain, false);
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
          it.<ControlBuilder>bindVisibleToProperty("toEdit");
          final Action _function = new Action() {
            public void execute() {
              FilesWindowAppModel _modelObject = FilesWindow.this.getModelObject();
              GameSystem _gameSystem = _modelObject.getGameSystem();
              FilesWindowAppModel _modelObject_1 = FilesWindow.this.getModelObject();
              Villain _selectedVillain = _modelObject_1.getSelectedVillain();
              CreateVillainAppModel _createVillainAppModel = new CreateVillainAppModel(_gameSystem, _selectedVillain, true);
              CreateVillainWindow _createVillainWindow = new CreateVillainWindow(FilesWindow.this, _createVillainAppModel);
              _createVillainWindow.open();
            }
          };
          it.onClick(_function);
        }
      };
      _xblockexpression = ObjectExtensions.<Button>operator_doubleArrow(_button_1, _function_2);
    }
    return _xblockexpression;
  }
  
  public List<Hobbie> createSelectedVillainInformation(final Panel owner) {
    List<Hobbie> _xblockexpression = null;
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
      List<String> _list = new List<String>(villainInfoPanel);
      final Procedure1<List<String>> _function = new Procedure1<List<String>>() {
        public void apply(final List<String> it) {
          it.bindItemsToProperty("selectedVillain.signs");
          it.setHeight(75);
        }
      };
      ObjectExtensions.<List<String>>operator_doubleArrow(_list, _function);
      Label _label_5 = new Label(villainInfoPanel);
      _label_5.setText("Hobbies:");
      List<Hobbie> _list_1 = new List<Hobbie>(villainInfoPanel);
      final Procedure1<List<Hobbie>> _function_1 = new Procedure1<List<Hobbie>>() {
        public void apply(final List<Hobbie> it) {
          it.bindItemsToProperty("selectedVillain.hobbies");
          it.setHeight(75);
        }
      };
      _xblockexpression = ObjectExtensions.<List<Hobbie>>operator_doubleArrow(_list_1, _function_1);
    }
    return _xblockexpression;
  }
}
