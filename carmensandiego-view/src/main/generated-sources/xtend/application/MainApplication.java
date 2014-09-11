package application;

import appmodel.GameSystemAppModel;
import org.uqbar.arena.Application;
import org.uqbar.arena.windows.Window;
import view.GameSystemWindow;

@SuppressWarnings("all")
public class MainApplication extends Application {
  protected Window<?> createMainWindow() {
    GameSystemWindow _xblockexpression = null;
    {
      GameSystemAppModel model = new GameSystemAppModel();
      _xblockexpression = new GameSystemWindow(this, model);
    }
    return _xblockexpression;
  }
  
  public static void main(final String[] args) {
    MainApplication _mainApplication = new MainApplication();
    _mainApplication.start();
  }
}
