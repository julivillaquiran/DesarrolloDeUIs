package view;

import appmodel.FilesWindowAppModel;
import org.uqbar.arena.layout.VerticalLayout;
import org.uqbar.arena.widgets.Label;
import org.uqbar.arena.widgets.Panel;
import org.uqbar.arena.windows.SimpleWindow;
import org.uqbar.arena.windows.WindowOwner;

@SuppressWarnings("all")
public class FilesWindow extends SimpleWindow<FilesWindowAppModel> {
  public FilesWindow(final WindowOwner parent, final FilesWindowAppModel model) {
    super(parent, model);
  }
  
  protected void addActions(final Panel actionsPanel) {
  }
  
  protected void createFormPanel(final Panel mainPanel) {
    this.setTitle("Expedientes");
    VerticalLayout _verticalLayout = new VerticalLayout();
    mainPanel.setLayout(_verticalLayout);
    Label _label = new Label(mainPanel);
    _label.setText("ACA VA TODA LA INFORMACION DE LOS EXPEDIENTES");
  }
}
