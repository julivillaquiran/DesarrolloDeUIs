package model;

import java.util.ArrayList;
import java.util.List;
import model.Case;
import model.Country;
import org.eclipse.xtext.xbase.lib.CollectionLiterals;
import org.uqbar.commons.model.ObservableUtils;
import org.uqbar.commons.utils.Observable;
import villain.Villain;

@Observable
@SuppressWarnings("all")
public class GameSystem {
  private List<Country> _worldMap;
  
  public List<Country> getWorldMap() {
    return this._worldMap;
  }
  
  public void setWorldMap(final List<Country> worldMap) {
    this._worldMap = worldMap;
  }
  
  private List<Villain> _files;
  
  public List<Villain> getFiles() {
    return this._files;
  }
  
  public void setFiles(final List<Villain> files) {
    this._files = files;
  }
  
  private List<Case> _cases;
  
  public List<Case> getCases() {
    return this._cases;
  }
  
  public void setCases(final List<Case> cases) {
    this._cases = cases;
  }
  
  public GameSystem() {
    ArrayList<Villain> _newArrayList = CollectionLiterals.<Villain>newArrayList();
    this.setFiles(_newArrayList);
    ArrayList<Country> _newArrayList_1 = CollectionLiterals.<Country>newArrayList();
    this.setWorldMap(_newArrayList_1);
    ArrayList<Case> _newArrayList_2 = CollectionLiterals.<Case>newArrayList();
    this.setCases(_newArrayList_2);
  }
  
  public void addVillains(final Villain villain) {
    List<Villain> _files = this.getFiles();
    _files.add(villain);
    List<Villain> _files_1 = this.getFiles();
    ObservableUtils.firePropertyChanged(this, "files", _files_1);
  }
  
  public List<Villain> getVillains() {
    return this.getFiles();
  }
}
