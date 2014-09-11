package view;

import appmodel.FilesWindowAppModel;
import appmodel.GameSystemAppModel;
import appmodel.WorldMapAppModel;
import org.eclipse.xtext.xbase.lib.ObjectExtensions;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;
import org.uqbar.arena.layout.HorizontalLayout;
import org.uqbar.arena.layout.VerticalLayout;
import org.uqbar.arena.widgets.Button;
import org.uqbar.arena.widgets.Label;
import org.uqbar.arena.widgets.Panel;
import org.uqbar.arena.windows.SimpleWindow;
import org.uqbar.arena.windows.WindowOwner;
import org.uqbar.lacar.ui.model.Action;
import view.FilesWindow;
import view.WorldMapWindow;

@SuppressWarnings("all")
public class GameSystemWindow extends SimpleWindow<GameSystemAppModel> {
  public GameSystemWindow(final WindowOwner parent, final GameSystemAppModel model) {
    super(parent, model);
  }
  
  protected void addActions(final Panel actionsPanel) {
    HorizontalLayout _horizontalLayout = new HorizontalLayout();
    actionsPanel.setLayout(_horizontalLayout);
    Button _button = new Button(actionsPanel);
    final Procedure1<Button> _function = new Procedure1<Button>() {
      public void apply(final Button it) {
        it.setCaption("Mapamundi");
        final Action _function = new Action() {
          public void execute() {
            WorldMapAppModel _worldMapAppModel = new WorldMapAppModel();
            WorldMapWindow _worldMapWindow = new WorldMapWindow(GameSystemWindow.this, _worldMapAppModel);
            _worldMapWindow.open();
          }
        };
        it.onClick(_function);
      }
    };
    ObjectExtensions.<Button>operator_doubleArrow(_button, _function);
    Button _button_1 = new Button(actionsPanel);
    final Procedure1<Button> _function_1 = new Procedure1<Button>() {
      public void apply(final Button it) {
        it.setCaption("Expedientes");
        final Action _function = new Action() {
          public void execute() {
            FilesWindowAppModel _filesWindowAppModel = new FilesWindowAppModel();
            FilesWindow _filesWindow = new FilesWindow(GameSystemWindow.this, _filesWindowAppModel);
            _filesWindow.open();
          }
        };
        it.onClick(_function);
      }
    };
    ObjectExtensions.<Button>operator_doubleArrow(_button_1, _function_1);
  }
  
  protected void createFormPanel(final Panel mainPanel) {
    this.setTitle("¿Dónde está Carmen Sandiego?");
    VerticalLayout _verticalLayout = new VerticalLayout();
    mainPanel.setLayout(_verticalLayout);
    Label _label = new Label(mainPanel);
    _label.setText("Bienvenido al  mundo de Carmen Sandiego");
    Label _label_1 = new Label(mainPanel);
    _label_1.setText("¿Que desea hacer acontinuación?");
  }
}
