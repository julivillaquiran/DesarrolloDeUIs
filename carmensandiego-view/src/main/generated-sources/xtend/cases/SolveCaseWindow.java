package cases;

import appmodel.ArrestWarrentDialogAppModel;
import appmodel.FilesWindowAppModel;
import appmodel.SolveCaseWindowAppModel;
import appmodel.TravelWindowAppModel;
import cases.ArrestWarrentDialog;
import cases.MessageDialog;
import cases.TravelWindow;
import country.Country;
import gameCase.Case;
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
import view.FilesWindow;

@SuppressWarnings("all")
public class SolveCaseWindow extends SimpleWindow<SolveCaseWindowAppModel> {
  public SolveCaseWindow(final WindowOwner parent, final SolveCaseWindowAppModel model) {
    super(parent, model);
  }
  
  protected void addActions(final Panel actionsPanel) {
  }
  
  protected void createFormPanel(final Panel mainPanel) {
  }
  
  protected void createMainTemplate(final Panel mainPanel) {
    SolveCaseWindowAppModel _modelObject = this.getModelObject();
    Case _thisCase = _modelObject.getThisCase();
    String _caseName = _thisCase.getCaseName();
    String _plus = ("Resolviendo " + _caseName);
    String title = new String(_plus);
    this.setTitle(title);
    Panel contentPanel = new Panel(mainPanel);
    VerticalLayout _verticalLayout = new VerticalLayout();
    contentPanel.setLayout(_verticalLayout);
    this.caseControl(contentPanel);
    this.travelingDataInformation(contentPanel);
  }
  
  public Button caseControl(final Panel owner) {
    Button _xblockexpression = null;
    {
      Panel contentPanel = new Panel(owner);
      ColumnLayout _columnLayout = new ColumnLayout(2);
      contentPanel.setLayout(_columnLayout);
      this.controlButtons(contentPanel);
      _xblockexpression = this.placesButtons(contentPanel);
    }
    return _xblockexpression;
  }
  
  public List<Object> travelingDataInformation(final Panel owner) {
    List<Object> _xblockexpression = null;
    {
      Panel caseControlPanel = new Panel(owner);
      VerticalLayout _verticalLayout = new VerticalLayout();
      caseControlPanel.setLayout(_verticalLayout);
      Label _label = new Label(caseControlPanel);
      _label.setText("Recorrido Criminal:");
      List<Object> _list = new List<Object>(caseControlPanel);
      final Procedure1<List<Object>> _function = new Procedure1<List<Object>>() {
        public void apply(final List<Object> it) {
          Binding<?, Selector<Object>, ListBuilder<Object>> _bindItemsToProperty = it.bindItemsToProperty("currentCorrectPath");
          PropertyAdapter _propertyAdapter = new PropertyAdapter(Country.class, "name");
          _bindItemsToProperty.setAdapter(_propertyAdapter);
          it.setHeight(50);
        }
      };
      ObjectExtensions.<List<Object>>operator_doubleArrow(_list, _function);
      Label _label_1 = new Label(caseControlPanel);
      _label_1.setText("Destinos Fallidos:");
      List<Object> _list_1 = new List<Object>(caseControlPanel);
      final Procedure1<List<Object>> _function_1 = new Procedure1<List<Object>>() {
        public void apply(final List<Object> it) {
          Binding<?, Selector<Object>, ListBuilder<Object>> _bindItemsToProperty = it.bindItemsToProperty("currentPathErrors");
          PropertyAdapter _propertyAdapter = new PropertyAdapter(Country.class, "name");
          _bindItemsToProperty.setAdapter(_propertyAdapter);
          it.setHeight(50);
        }
      };
      _xblockexpression = ObjectExtensions.<List<Object>>operator_doubleArrow(_list_1, _function_1);
    }
    return _xblockexpression;
  }
  
  public Button controlButtons(final Panel panel) {
    Button _xblockexpression = null;
    {
      Panel controlButtonsPanel = new Panel(panel);
      VerticalLayout _verticalLayout = new VerticalLayout();
      controlButtonsPanel.setLayout(_verticalLayout);
      Label _label = new Label(controlButtonsPanel);
      _label.setText("Estas en:");
      Label _label_1 = new Label(controlButtonsPanel);
      _label_1.<Object, ControlBuilder>bindValueToProperty("currentCountry.name");
      Button _button = new Button(controlButtonsPanel);
      final Procedure1<Button> _function = new Procedure1<Button>() {
        public void apply(final Button it) {
          it.setCaption("Orden de Arrestro");
          final Action _function = new Action() {
            public void execute() {
              SolveCaseWindowAppModel _modelObject = SolveCaseWindow.this.getModelObject();
              ArrestWarrentDialogAppModel _arrestWarrentDialogAppModel = new ArrestWarrentDialogAppModel(_modelObject);
              ArrestWarrentDialog _arrestWarrentDialog = new ArrestWarrentDialog(SolveCaseWindow.this, _arrestWarrentDialogAppModel);
              _arrestWarrentDialog.open();
            }
          };
          it.onClick(_function);
        }
      };
      ObjectExtensions.<Button>operator_doubleArrow(_button, _function);
      Label _label_2 = new Label(controlButtonsPanel);
      _label_2.setText("Orden ya emitida:");
      Label _label_3 = new Label(controlButtonsPanel);
      _label_3.<Object, ControlBuilder>bindValueToProperty("captureOrder.name");
      Button _button_1 = new Button(controlButtonsPanel);
      final Procedure1<Button> _function_1 = new Procedure1<Button>() {
        public void apply(final Button it) {
          it.setCaption("Viajar");
          final Action _function = new Action() {
            public void execute() {
              SolveCaseWindowAppModel _modelObject = SolveCaseWindow.this.getModelObject();
              TravelWindowAppModel _travelWindowAppModel = new TravelWindowAppModel(_modelObject);
              TravelWindow _travelWindow = new TravelWindow(SolveCaseWindow.this, _travelWindowAppModel);
              _travelWindow.open();
            }
          };
          it.onClick(_function);
        }
      };
      ObjectExtensions.<Button>operator_doubleArrow(_button_1, _function_1);
      Button _button_2 = new Button(controlButtonsPanel);
      final Procedure1<Button> _function_2 = new Procedure1<Button>() {
        public void apply(final Button it) {
          it.setCaption("Expedientes");
          final Action _function = new Action() {
            public void execute() {
              SolveCaseWindowAppModel _modelObject = SolveCaseWindow.this.getModelObject();
              GameSystem _gameSystem = _modelObject.getGameSystem();
              FilesWindowAppModel _filesWindowAppModel = new FilesWindowAppModel(_gameSystem, false);
              FilesWindow _filesWindow = new FilesWindow(SolveCaseWindow.this, _filesWindowAppModel);
              _filesWindow.open();
            }
          };
          it.onClick(_function);
        }
      };
      _xblockexpression = ObjectExtensions.<Button>operator_doubleArrow(_button_2, _function_2);
    }
    return _xblockexpression;
  }
  
  public Button placesButtons(final Panel panel) {
    Button _xblockexpression = null;
    {
      Panel placesButtonsPanel = new Panel(panel);
      VerticalLayout _verticalLayout = new VerticalLayout();
      placesButtonsPanel.setLayout(_verticalLayout);
      Label _label = new Label(placesButtonsPanel);
      _label.setText("Lugares:");
      Button _button = new Button(placesButtonsPanel);
      final Procedure1<Button> _function = new Procedure1<Button>() {
        public void apply(final Button it) {
          it.bindCaptionToProperty("thosePlaces0.name");
          final Action _function = new Action() {
            public void execute() {
              SolveCaseWindowAppModel _modelObject = SolveCaseWindow.this.getModelObject();
              _modelObject.throwMessageThosePlaces0();
              SolveCaseWindowAppModel _modelObject_1 = SolveCaseWindow.this.getModelObject();
              MessageDialog _messageDialog = new MessageDialog(SolveCaseWindow.this, _modelObject_1);
              _messageDialog.open();
            }
          };
          it.onClick(_function);
        }
      };
      ObjectExtensions.<Button>operator_doubleArrow(_button, _function);
      Button _button_1 = new Button(placesButtonsPanel);
      final Procedure1<Button> _function_1 = new Procedure1<Button>() {
        public void apply(final Button it) {
          it.bindCaptionToProperty("thosePlaces1.name");
          final Action _function = new Action() {
            public void execute() {
              SolveCaseWindowAppModel _modelObject = SolveCaseWindow.this.getModelObject();
              _modelObject.throwMessageThosePlaces1();
              SolveCaseWindowAppModel _modelObject_1 = SolveCaseWindow.this.getModelObject();
              MessageDialog _messageDialog = new MessageDialog(SolveCaseWindow.this, _modelObject_1);
              _messageDialog.open();
            }
          };
          it.onClick(_function);
        }
      };
      ObjectExtensions.<Button>operator_doubleArrow(_button_1, _function_1);
      Button _button_2 = new Button(placesButtonsPanel);
      final Procedure1<Button> _function_2 = new Procedure1<Button>() {
        public void apply(final Button it) {
          it.bindCaptionToProperty("thosePlaces2.name");
          final Action _function = new Action() {
            public void execute() {
              SolveCaseWindowAppModel _modelObject = SolveCaseWindow.this.getModelObject();
              _modelObject.throwMessageThosePlaces2();
              SolveCaseWindowAppModel _modelObject_1 = SolveCaseWindow.this.getModelObject();
              MessageDialog _messageDialog = new MessageDialog(SolveCaseWindow.this, _modelObject_1);
              _messageDialog.open();
            }
          };
          it.onClick(_function);
        }
      };
      _xblockexpression = ObjectExtensions.<Button>operator_doubleArrow(_button_2, _function_2);
    }
    return _xblockexpression;
  }
}
