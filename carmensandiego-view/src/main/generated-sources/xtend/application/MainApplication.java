package application;

import appmodel.GameSystemAppModel;
import model.GameSystem;
import org.uqbar.arena.Application;
import org.uqbar.arena.windows.Window;
import testingData.TestingData;
import view.GameSystemWindow;

@SuppressWarnings("all")
public class MainApplication extends Application {
  private GameSystem gameSystem = new GameSystem();
  
  private GameSystemAppModel model = new GameSystemAppModel(this.gameSystem);
  
  protected Window<?> createMainWindow() {
    GameSystemWindow _xblockexpression = null;
    {
      TestingData _testingData = new TestingData();
      GameSystem _createGameSystem = _testingData.createGameSystem();
      this.model.setGameSystem(_createGameSystem);
      _xblockexpression = new GameSystemWindow(this, this.model);
    }
    return _xblockexpression;
  }
  
  public static void main(final String[] args) {
    MainApplication _mainApplication = new MainApplication();
    _mainApplication.start();
  }
}
