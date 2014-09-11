package appmodel;

import appmodel.FilesWindowAppModel;
import model.GameSystem;
import model.Villain;
import org.uqbar.commons.utils.Observable;

@Observable
@SuppressWarnings("all")
public class GameSystemAppModel {
  private Villain _villain;
  
  public Villain getVillain() {
    return this._villain;
  }
  
  public void setVillain(final Villain villain) {
    this._villain = villain;
  }
  
  private GameSystem _gameSystem;
  
  public GameSystem getGameSystem() {
    return this._gameSystem;
  }
  
  public void setGameSystem(final GameSystem gameSystem) {
    this._gameSystem = gameSystem;
  }
  
  private FilesWindowAppModel _filesWindowAppModel;
  
  public FilesWindowAppModel getFilesWindowAppModel() {
    return this._filesWindowAppModel;
  }
  
  public void setFilesWindowAppModel(final FilesWindowAppModel filesWindowAppModel) {
    this._filesWindowAppModel = filesWindowAppModel;
  }
}
