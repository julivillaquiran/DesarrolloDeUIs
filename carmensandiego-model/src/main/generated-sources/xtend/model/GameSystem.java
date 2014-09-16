package model;

import country.Country;
import country.InterestPlace;
import country.Places;
import gameCase.Case;
import java.util.ArrayList;
import java.util.List;
import org.eclipse.xtext.xbase.lib.CollectionLiterals;
import org.eclipse.xtext.xbase.lib.ObjectExtensions;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;
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
  
  private List<InterestPlace> _interestPlaces;
  
  public List<InterestPlace> getInterestPlaces() {
    return this._interestPlaces;
  }
  
  public void setInterestPlaces(final List<InterestPlace> interestPlaces) {
    this._interestPlaces = interestPlaces;
  }
  
  private Case newCase;
  
  public GameSystem() {
    ArrayList<Villain> _newArrayList = CollectionLiterals.<Villain>newArrayList();
    this.setFiles(_newArrayList);
    ArrayList<Country> _newArrayList_1 = CollectionLiterals.<Country>newArrayList();
    this.setWorldMap(_newArrayList_1);
    ArrayList<Case> _newArrayList_2 = CollectionLiterals.<Case>newArrayList();
    this.setCases(_newArrayList_2);
    this.fillInterestPlaces();
  }
  
  public boolean fillInterestPlaces() {
    boolean _xblockexpression = false;
    {
      ArrayList<InterestPlace> _newArrayList = CollectionLiterals.<InterestPlace>newArrayList();
      this.setInterestPlaces(_newArrayList);
      List<InterestPlace> _interestPlaces = this.getInterestPlaces();
      InterestPlace _interestPlace = new InterestPlace();
      final Procedure1<InterestPlace> _function = new Procedure1<InterestPlace>() {
        public void apply(final InterestPlace it) {
          it.setName(Places.Banco);
        }
      };
      InterestPlace _doubleArrow = ObjectExtensions.<InterestPlace>operator_doubleArrow(_interestPlace, _function);
      _interestPlaces.add(_doubleArrow);
      List<InterestPlace> _interestPlaces_1 = this.getInterestPlaces();
      InterestPlace _interestPlace_1 = new InterestPlace();
      final Procedure1<InterestPlace> _function_1 = new Procedure1<InterestPlace>() {
        public void apply(final InterestPlace it) {
          it.setName(Places.Club);
        }
      };
      InterestPlace _doubleArrow_1 = ObjectExtensions.<InterestPlace>operator_doubleArrow(_interestPlace_1, _function_1);
      _interestPlaces_1.add(_doubleArrow_1);
      List<InterestPlace> _interestPlaces_2 = this.getInterestPlaces();
      InterestPlace _interestPlace_2 = new InterestPlace();
      final Procedure1<InterestPlace> _function_2 = new Procedure1<InterestPlace>() {
        public void apply(final InterestPlace it) {
          it.setName(Places.Biblioteca);
        }
      };
      InterestPlace _doubleArrow_2 = ObjectExtensions.<InterestPlace>operator_doubleArrow(_interestPlace_2, _function_2);
      _interestPlaces_2.add(_doubleArrow_2);
      List<InterestPlace> _interestPlaces_3 = this.getInterestPlaces();
      InterestPlace _interestPlace_3 = new InterestPlace();
      final Procedure1<InterestPlace> _function_3 = new Procedure1<InterestPlace>() {
        public void apply(final InterestPlace it) {
          it.setName(Places.Embajada);
        }
      };
      InterestPlace _doubleArrow_3 = ObjectExtensions.<InterestPlace>operator_doubleArrow(_interestPlace_3, _function_3);
      _xblockexpression = _interestPlaces_3.add(_doubleArrow_3);
    }
    return _xblockexpression;
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
  
  public void addCountries(final Country country) {
    List<Country> _worldMap = this.getWorldMap();
    _worldMap.add(country);
    List<Country> _worldMap_1 = this.getWorldMap();
    ObservableUtils.firePropertyChanged(this, "worldMap", _worldMap_1);
  }
  
  public void removeCountries(final Country country) {
    List<Country> _worldMap = this.getWorldMap();
    _worldMap.remove(country);
    List<Country> _worldMap_1 = this.getWorldMap();
    ObservableUtils.firePropertyChanged(this, "worldMap", _worldMap_1);
  }
  
  public void addInterestPlaces(final InterestPlace place) {
    List<InterestPlace> _interestPlaces = this.getInterestPlaces();
    _interestPlaces.add(place);
    List<InterestPlace> _interestPlaces_1 = this.getInterestPlaces();
    ObservableUtils.firePropertyChanged(this, "interestPlaces", _interestPlaces_1);
  }
}
