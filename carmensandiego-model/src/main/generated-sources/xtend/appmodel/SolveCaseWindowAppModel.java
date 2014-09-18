package appmodel;

import com.google.common.base.Objects;
import country.Country;
import country.InterestPlace;
import gameCase.Case;
import java.util.List;
import model.GameSystem;
import org.eclipse.xtext.xbase.lib.CollectionLiterals;
import org.eclipse.xtext.xbase.lib.ObjectExtensions;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;
import org.uqbar.commons.model.ObservableUtils;
import org.uqbar.commons.utils.Observable;
import villain.Villain;

@Observable
@SuppressWarnings("all")
public class SolveCaseWindowAppModel {
  private GameSystem _gameSystem;
  
  public GameSystem getGameSystem() {
    return this._gameSystem;
  }
  
  public void setGameSystem(final GameSystem gameSystem) {
    this._gameSystem = gameSystem;
  }
  
  private Case _thisCase;
  
  public Case getThisCase() {
    return this._thisCase;
  }
  
  public void setThisCase(final Case thisCase) {
    this._thisCase = thisCase;
  }
  
  private Country _currentCountry;
  
  public Country getCurrentCountry() {
    return this._currentCountry;
  }
  
  public void setCurrentCountry(final Country currentCountry) {
    this._currentCountry = currentCountry;
  }
  
  private InterestPlace _thosePlaces0;
  
  public InterestPlace getThosePlaces0() {
    return this._thosePlaces0;
  }
  
  public void setThosePlaces0(final InterestPlace thosePlaces0) {
    this._thosePlaces0 = thosePlaces0;
  }
  
  private InterestPlace _thosePlaces1;
  
  public InterestPlace getThosePlaces1() {
    return this._thosePlaces1;
  }
  
  public void setThosePlaces1(final InterestPlace thosePlaces1) {
    this._thosePlaces1 = thosePlaces1;
  }
  
  private InterestPlace _thosePlaces2;
  
  public InterestPlace getThosePlaces2() {
    return this._thosePlaces2;
  }
  
  public void setThosePlaces2(final InterestPlace thosePlaces2) {
    this._thosePlaces2 = thosePlaces2;
  }
  
  private String _message;
  
  public String getMessage() {
    return this._message;
  }
  
  public void setMessage(final String message) {
    this._message = message;
  }
  
  private InterestPlace _whichPlace;
  
  public InterestPlace getWhichPlace() {
    return this._whichPlace;
  }
  
  public void setWhichPlace(final InterestPlace whichPlace) {
    this._whichPlace = whichPlace;
  }
  
  private List<Country> _currentPath = CollectionLiterals.<Country>newArrayList();
  
  public List<Country> getCurrentPath() {
    return this._currentPath;
  }
  
  public void setCurrentPath(final List<Country> currentPath) {
    this._currentPath = currentPath;
  }
  
  private List<Country> _currentPathErrors = CollectionLiterals.<Country>newArrayList();
  
  public List<Country> getCurrentPathErrors() {
    return this._currentPathErrors;
  }
  
  public void setCurrentPathErrors(final List<Country> currentPathErrors) {
    this._currentPathErrors = currentPathErrors;
  }
  
  private List<Country> _currentCorrectPath = CollectionLiterals.<Country>newArrayList();
  
  public List<Country> getCurrentCorrectPath() {
    return this._currentCorrectPath;
  }
  
  public void setCurrentCorrectPath(final List<Country> currentCorrectPath) {
    this._currentCorrectPath = currentCorrectPath;
  }
  
  private Villain _captureOrder = ObjectExtensions.<Villain>operator_doubleArrow(new Villain(), new Procedure1<Villain>() {
    public void apply(final Villain it) {
      it.setName("");
    }
  });
  
  public Villain getCaptureOrder() {
    return this._captureOrder;
  }
  
  public void setCaptureOrder(final Villain captureOrder) {
    this._captureOrder = captureOrder;
  }
  
  public SolveCaseWindowAppModel(final GameSystem gameSys, final Case t) {
    this.setGameSystem(gameSys);
    this.setThisCase(t);
    Case _thisCase = this.getThisCase();
    List<Country> _escapeRoute = _thisCase.getEscapeRoute();
    Country _get = _escapeRoute.get(0);
    this.setCurrentCountry(_get);
    Country _currentCountry = this.getCurrentCountry();
    List<InterestPlace> _places = _currentCountry.getPlaces();
    InterestPlace _get_1 = _places.get(0);
    this.setThosePlaces0(_get_1);
    Country _currentCountry_1 = this.getCurrentCountry();
    List<InterestPlace> _places_1 = _currentCountry_1.getPlaces();
    InterestPlace _get_2 = _places_1.get(1);
    this.setThosePlaces1(_get_2);
    Country _currentCountry_2 = this.getCurrentCountry();
    List<InterestPlace> _places_2 = _currentCountry_2.getPlaces();
    InterestPlace _get_3 = _places_2.get(2);
    this.setThosePlaces2(_get_3);
    List<Country> _currentPath = this.getCurrentPath();
    Country _currentCountry_3 = this.getCurrentCountry();
    _currentPath.add(_currentCountry_3);
    List<Country> _currentCorrectPath = this.getCurrentCorrectPath();
    Country _currentCountry_4 = this.getCurrentCountry();
    _currentCorrectPath.add(_currentCountry_4);
  }
  
  public void addCountryToPath(final Country country) {
    List<Country> _currentPath = this.getCurrentPath();
    _currentPath.add(country);
    List<Country> _currentPath_1 = this.getCurrentPath();
    ObservableUtils.firePropertyChanged(this, "currentPath", _currentPath_1);
    Case _thisCase = this.getThisCase();
    List<Country> _escapeRoute = _thisCase.getEscapeRoute();
    boolean _contains = _escapeRoute.contains(country);
    if (_contains) {
      List<Country> _currentCorrectPath = this.getCurrentCorrectPath();
      _currentCorrectPath.add(country);
      List<Country> _currentCorrectPath_1 = this.getCurrentCorrectPath();
      ObservableUtils.firePropertyChanged(this, "currentCorrectPath", _currentCorrectPath_1);
    } else {
      this.addCountryToPathErrors(country);
    }
  }
  
  public void addCountryToPathErrors(final Country country) {
    List<Country> _currentPathErrors = this.getCurrentPathErrors();
    _currentPathErrors.add(country);
    List<Country> _currentPathErrors_1 = this.getCurrentPathErrors();
    ObservableUtils.firePropertyChanged(this, "currentPathErrors", _currentPathErrors_1);
  }
  
  public void throwMessageThosePlaces0() {
    InterestPlace _thosePlaces0 = this.getThosePlaces0();
    this.setWhichPlace(_thosePlaces0);
    Case _thisCase = this.getThisCase();
    List<Country> _escapeRoute = _thisCase.getEscapeRoute();
    Country _currentCountry = this.getCurrentCountry();
    boolean _contains = _escapeRoute.contains(_currentCountry);
    boolean _not = (!_contains);
    if (_not) {
      InterestPlace _thosePlaces0_1 = this.getThosePlaces0();
      String _messageWrong = _thosePlaces0_1.messageWrong();
      this.setMessage(_messageWrong);
      String _message = this.getMessage();
      ObservableUtils.firePropertyChanged(this, "message", _message);
    } else {
      boolean _and = false;
      Country _currentCountry_1 = this.getCurrentCountry();
      Case _thisCase_1 = this.getThisCase();
      List<Country> _escapeRoute_1 = _thisCase_1.getEscapeRoute();
      Case _thisCase_2 = this.getThisCase();
      List<Country> _escapeRoute_2 = _thisCase_2.getEscapeRoute();
      int _size = _escapeRoute_2.size();
      int _minus = (_size - 1);
      Country _get = _escapeRoute_1.get(_minus);
      boolean _equals = Objects.equal(_currentCountry_1, _get);
      if (!_equals) {
        _and = false;
      } else {
        Case _thisCase_3 = this.getThisCase();
        List<Country> _escapeRoute_3 = _thisCase_3.getEscapeRoute();
        Country _get_1 = _escapeRoute_3.get(2);
        List<InterestPlace> _places = _get_1.getPlaces();
        InterestPlace _get_2 = _places.get(0);
        boolean _isIsHere = _get_2.isIsHere();
        _and = _isIsHere;
      }
      if (_and) {
        Villain _captureOrder = this.getCaptureOrder();
        Case _thisCase_4 = this.getThisCase();
        Villain _responsable = _thisCase_4.getResponsable();
        boolean _notEquals = (!Objects.equal(_captureOrder, _responsable));
        if (_notEquals) {
          InterestPlace _thosePlaces0_2 = this.getThosePlaces0();
          String _messageIs = _thosePlaces0_2.messageIs();
          this.setMessage(_messageIs);
          String _message_1 = this.getMessage();
          ObservableUtils.firePropertyChanged(this, "message", _message_1);
        } else {
          this.setMessage("TE HAN PILLADO POR LA ESPALDA SIN SABER QUIEN ERA EL LADRON");
        }
      } else {
        boolean _and_1 = false;
        Country _currentCountry_2 = this.getCurrentCountry();
        Case _thisCase_5 = this.getThisCase();
        List<Country> _escapeRoute_4 = _thisCase_5.getEscapeRoute();
        Case _thisCase_6 = this.getThisCase();
        List<Country> _escapeRoute_5 = _thisCase_6.getEscapeRoute();
        int _size_1 = _escapeRoute_5.size();
        int _minus_1 = (_size_1 - 1);
        Country _get_3 = _escapeRoute_4.get(_minus_1);
        boolean _equals_1 = Objects.equal(_currentCountry_2, _get_3);
        if (!_equals_1) {
          _and_1 = false;
        } else {
          InterestPlace _thosePlaces0_3 = this.getThosePlaces0();
          boolean _isIsHere_1 = _thosePlaces0_3.isIsHere();
          boolean _not_1 = (!_isIsHere_1);
          _and_1 = _not_1;
        }
        if (_and_1) {
          InterestPlace _thosePlaces0_4 = this.getThosePlaces0();
          String _messageFinal = _thosePlaces0_4.messageFinal();
          this.setMessage(_messageFinal);
          String _message_2 = this.getMessage();
          ObservableUtils.firePropertyChanged(this, "message", _message_2);
        } else {
          InterestPlace _thosePlaces0_5 = this.getThosePlaces0();
          String _messageFuge = _thosePlaces0_5.messageFuge();
          this.setMessage(_messageFuge);
          String _message_3 = this.getMessage();
          ObservableUtils.firePropertyChanged(this, "message", _message_3);
        }
      }
    }
  }
  
  public void throwMessageThosePlaces1() {
    InterestPlace _thosePlaces1 = this.getThosePlaces1();
    this.setWhichPlace(_thosePlaces1);
    Case _thisCase = this.getThisCase();
    List<Country> _escapeRoute = _thisCase.getEscapeRoute();
    Country _currentCountry = this.getCurrentCountry();
    boolean _contains = _escapeRoute.contains(_currentCountry);
    boolean _not = (!_contains);
    if (_not) {
      InterestPlace _thosePlaces1_1 = this.getThosePlaces1();
      String _messageWrong = _thosePlaces1_1.messageWrong();
      this.setMessage(_messageWrong);
      String _message = this.getMessage();
      ObservableUtils.firePropertyChanged(this, "message", _message);
    } else {
      boolean _and = false;
      Country _currentCountry_1 = this.getCurrentCountry();
      Case _thisCase_1 = this.getThisCase();
      List<Country> _escapeRoute_1 = _thisCase_1.getEscapeRoute();
      Case _thisCase_2 = this.getThisCase();
      List<Country> _escapeRoute_2 = _thisCase_2.getEscapeRoute();
      int _size = _escapeRoute_2.size();
      int _minus = (_size - 1);
      Country _get = _escapeRoute_1.get(_minus);
      boolean _equals = Objects.equal(_currentCountry_1, _get);
      if (!_equals) {
        _and = false;
      } else {
        Case _thisCase_3 = this.getThisCase();
        List<Country> _escapeRoute_3 = _thisCase_3.getEscapeRoute();
        Country _get_1 = _escapeRoute_3.get(2);
        List<InterestPlace> _places = _get_1.getPlaces();
        InterestPlace _get_2 = _places.get(1);
        boolean _isIsHere = _get_2.isIsHere();
        _and = _isIsHere;
      }
      if (_and) {
        Villain _captureOrder = this.getCaptureOrder();
        Case _thisCase_4 = this.getThisCase();
        Villain _responsable = _thisCase_4.getResponsable();
        boolean _notEquals = (!Objects.equal(_captureOrder, _responsable));
        if (_notEquals) {
          InterestPlace _thosePlaces1_2 = this.getThosePlaces1();
          String _messageIs = _thosePlaces1_2.messageIs();
          this.setMessage(_messageIs);
          String _message_1 = this.getMessage();
          ObservableUtils.firePropertyChanged(this, "message", _message_1);
        } else {
          this.setMessage("TE HAN PILLADO POR LA ESPALDA SIN SABER QUIEN ERA EL LADRON");
        }
      } else {
        boolean _and_1 = false;
        Country _currentCountry_2 = this.getCurrentCountry();
        Case _thisCase_5 = this.getThisCase();
        List<Country> _escapeRoute_4 = _thisCase_5.getEscapeRoute();
        Case _thisCase_6 = this.getThisCase();
        List<Country> _escapeRoute_5 = _thisCase_6.getEscapeRoute();
        int _size_1 = _escapeRoute_5.size();
        int _minus_1 = (_size_1 - 1);
        Country _get_3 = _escapeRoute_4.get(_minus_1);
        boolean _equals_1 = Objects.equal(_currentCountry_2, _get_3);
        if (!_equals_1) {
          _and_1 = false;
        } else {
          InterestPlace _thosePlaces1_3 = this.getThosePlaces1();
          boolean _isIsHere_1 = _thosePlaces1_3.isIsHere();
          boolean _not_1 = (!_isIsHere_1);
          _and_1 = _not_1;
        }
        if (_and_1) {
          InterestPlace _thosePlaces1_4 = this.getThosePlaces1();
          String _messageFinal = _thosePlaces1_4.messageFinal();
          this.setMessage(_messageFinal);
          String _message_2 = this.getMessage();
          ObservableUtils.firePropertyChanged(this, "message", _message_2);
        } else {
          InterestPlace _thosePlaces1_5 = this.getThosePlaces1();
          String _messageFuge = _thosePlaces1_5.messageFuge();
          this.setMessage(_messageFuge);
          String _message_3 = this.getMessage();
          ObservableUtils.firePropertyChanged(this, "message", _message_3);
        }
      }
    }
  }
  
  public void throwMessageThosePlaces2() {
    InterestPlace _thosePlaces2 = this.getThosePlaces2();
    this.setWhichPlace(_thosePlaces2);
    Case _thisCase = this.getThisCase();
    List<Country> _escapeRoute = _thisCase.getEscapeRoute();
    Country _currentCountry = this.getCurrentCountry();
    boolean _contains = _escapeRoute.contains(_currentCountry);
    boolean _not = (!_contains);
    if (_not) {
      InterestPlace _thosePlaces2_1 = this.getThosePlaces2();
      String _messageWrong = _thosePlaces2_1.messageWrong();
      this.setMessage(_messageWrong);
      String _message = this.getMessage();
      ObservableUtils.firePropertyChanged(this, "message", _message);
    } else {
      boolean _and = false;
      Country _currentCountry_1 = this.getCurrentCountry();
      Case _thisCase_1 = this.getThisCase();
      List<Country> _escapeRoute_1 = _thisCase_1.getEscapeRoute();
      Case _thisCase_2 = this.getThisCase();
      List<Country> _escapeRoute_2 = _thisCase_2.getEscapeRoute();
      int _size = _escapeRoute_2.size();
      int _minus = (_size - 1);
      Country _get = _escapeRoute_1.get(_minus);
      boolean _equals = Objects.equal(_currentCountry_1, _get);
      if (!_equals) {
        _and = false;
      } else {
        Case _thisCase_3 = this.getThisCase();
        List<Country> _escapeRoute_3 = _thisCase_3.getEscapeRoute();
        Country _get_1 = _escapeRoute_3.get(2);
        List<InterestPlace> _places = _get_1.getPlaces();
        InterestPlace _get_2 = _places.get(2);
        boolean _isIsHere = _get_2.isIsHere();
        _and = _isIsHere;
      }
      if (_and) {
        Villain _captureOrder = this.getCaptureOrder();
        Case _thisCase_4 = this.getThisCase();
        Villain _responsable = _thisCase_4.getResponsable();
        boolean _notEquals = (!Objects.equal(_captureOrder, _responsable));
        if (_notEquals) {
          InterestPlace _thosePlaces2_2 = this.getThosePlaces2();
          String _messageIs = _thosePlaces2_2.messageIs();
          this.setMessage(_messageIs);
          String _message_1 = this.getMessage();
          ObservableUtils.firePropertyChanged(this, "message", _message_1);
        } else {
          this.setMessage("TE HAN PILLADO POR LA ESPALDA SIN SABER QUIEN ERA EL LADRON");
        }
      } else {
        boolean _and_1 = false;
        Country _currentCountry_2 = this.getCurrentCountry();
        Case _thisCase_5 = this.getThisCase();
        List<Country> _escapeRoute_4 = _thisCase_5.getEscapeRoute();
        Case _thisCase_6 = this.getThisCase();
        List<Country> _escapeRoute_5 = _thisCase_6.getEscapeRoute();
        int _size_1 = _escapeRoute_5.size();
        int _minus_1 = (_size_1 - 1);
        Country _get_3 = _escapeRoute_4.get(_minus_1);
        boolean _equals_1 = Objects.equal(_currentCountry_2, _get_3);
        if (!_equals_1) {
          _and_1 = false;
        } else {
          InterestPlace _thosePlaces2_3 = this.getThosePlaces2();
          boolean _isIsHere_1 = _thosePlaces2_3.isIsHere();
          boolean _not_1 = (!_isIsHere_1);
          _and_1 = _not_1;
        }
        if (_and_1) {
          InterestPlace _thosePlaces2_4 = this.getThosePlaces2();
          String _messageFinal = _thosePlaces2_4.messageFinal();
          this.setMessage(_messageFinal);
          String _message_2 = this.getMessage();
          ObservableUtils.firePropertyChanged(this, "message", _message_2);
        } else {
          InterestPlace _thosePlaces2_5 = this.getThosePlaces2();
          String _messageFuge = _thosePlaces2_5.messageFuge();
          this.setMessage(_messageFuge);
          String _message_3 = this.getMessage();
          ObservableUtils.firePropertyChanged(this, "message", _message_3);
        }
      }
    }
  }
}
