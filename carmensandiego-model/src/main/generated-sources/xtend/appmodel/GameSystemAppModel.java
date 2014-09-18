package appmodel;

import appmodel.FilesWindowAppModel;
import appmodel.WorldMapAppModel;
import java.util.Random;
import model.GameSystem;
import org.uqbar.commons.utils.Observable;

@Observable
@SuppressWarnings("all")
public class GameSystemAppModel {
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
  
  private WorldMapAppModel _worldMapAppModel;
  
  public WorldMapAppModel getWorldMapAppModel() {
    return this._worldMapAppModel;
  }
  
  public void setWorldMapAppModel(final WorldMapAppModel worldMapAppModel) {
    this._worldMapAppModel = worldMapAppModel;
  }
  
  private Random _r1 = new Random();
  
  public Random getR1() {
    return this._r1;
  }
  
  public void setR1(final Random r1) {
    this._r1 = r1;
  }
  
  public GameSystemAppModel(final GameSystem gameSystem) {
    this.setGameSystem(gameSystem);
  }
}
