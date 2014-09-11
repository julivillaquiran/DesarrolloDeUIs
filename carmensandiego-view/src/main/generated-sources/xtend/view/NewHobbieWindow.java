package view;

import appmodel.VillainAppModel;
import org.eclipse.xtext.xbase.lib.ObjectExtensions;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;
import org.uqbar.arena.layout.VerticalLayout;
import org.uqbar.arena.widgets.Button;
import org.uqbar.arena.widgets.Label;
import org.uqbar.arena.widgets.Panel;
import org.uqbar.arena.widgets.TextBox;
import org.uqbar.arena.windows.Dialog;
import org.uqbar.arena.windows.WindowOwner;
import org.uqbar.commons.utils.Observable;
import org.uqbar.lacar.ui.model.Action;
import org.uqbar.lacar.ui.model.ControlBuilder;

@Observable
@SuppressWarnings("all")
public class NewHobbieWindow extends Dialog<VillainAppModel> {
  public NewHobbieWindow(final WindowOwner owner, final VillainAppModel model) {
    super(owner, new VillainAppModel());
  }
  
  protected void createFormPanel(final Panel mainPanel) {
    this.setTitle("Nuevo Hobbie");
    VerticalLayout _verticalLayout = new VerticalLayout();
    mainPanel.setLayout(_verticalLayout);
    Label _label = new Label(mainPanel);
    _label.setText("Nombre:");
    TextBox _textBox = new TextBox(mainPanel);
    final Procedure1<TextBox> _function = new Procedure1<TextBox>() {
      public void apply(final TextBox it) {
        it.<Object, ControlBuilder>bindValueToProperty("newHobbie");
        it.setWidth(200);
      }
    };
    ObjectExtensions.<TextBox>operator_doubleArrow(_textBox, _function);
    Button _button = new Button(mainPanel);
    final Procedure1<Button> _function_1 = new Procedure1<Button>() {
      public void apply(final Button it) {
        it.setCaption("Aceptar");
        final Action _function = new Action() {
          public void execute() {
            NewHobbieWindow.this.close();
          }
        };
        it.onClick(_function);
      }
    };
    ObjectExtensions.<Button>operator_doubleArrow(_button, _function_1);
  }
}
