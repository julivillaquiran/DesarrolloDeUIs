package country;

import com.google.common.base.Objects;
import country.Places;
import org.uqbar.commons.utils.Observable;

@Observable
@SuppressWarnings("all")
public class InterestPlace {
  private Places _name;
  
  public Places getName() {
    return this._name;
  }
  
  public void setName(final Places name) {
    this._name = name;
  }
  
  private boolean _isHere;
  
  public boolean isIsHere() {
    return this._isHere;
  }
  
  public void setIsHere(final boolean isHere) {
    this._isHere = isHere;
  }
  
  public String messageIs() {
    Places _name = this.getName();
    if (_name != null) {
      switch (_name) {
        case Banco:
          return "Esta en el Banco";
        case Biblioteca:
          return "Esta en la Biblioteca";
        case Club:
          return "Esta en el Club";
        case Embajada:
          return "Esta en la Embajada";
        default:
          break;
      }
    }
    return null;
  }
  
  public String messageFinal() {
    String _switchResult = null;
    Places _name = this.getName();
    if (_name != null) {
      switch (_name) {
        case Banco:
          _switchResult = "En este Pais, pero no en el Banco";
          break;
        case Biblioteca:
          _switchResult = "En este Pais, pero no en la Biblioteca";
          break;
        case Club:
          _switchResult = "En este Pais, pero no en el Club";
          break;
        case Embajada:
          _switchResult = "En este Pais, pero no en la Embajada";
          break;
        default:
          break;
      }
    }
    return _switchResult;
  }
  
  public String messageFuge() {
    String _switchResult = null;
    Places _name = this.getName();
    if (_name != null) {
      switch (_name) {
        case Banco:
          _switchResult = "Paso por este Banco";
          break;
        case Biblioteca:
          return "Paso por esta Biblioteca";
        case Club:
          return "Paso por este Club";
        case Embajada:
          return "Paso por esta Embajada";
        default:
          break;
      }
    }
    return _switchResult;
  }
  
  public String messageWrong() {
    Places _name = this.getName();
    if (_name != null) {
      switch (_name) {
        case Banco:
          return "Nunca le hemos visto en este Banco";
        case Biblioteca:
          return "Nunca le hemos visto en esta Biblioteca";
        case Club:
          return "Nunca le hemos visto en este Club";
        case Embajada:
          return "Nunca le hemos visto en esta Embajada";
        default:
          break;
      }
    }
    return null;
  }
  
  public boolean equals(final Object obj) {
    boolean _and = false;
    if (!(obj instanceof InterestPlace)) {
      _and = false;
    } else {
      Places _name = ((InterestPlace) obj).getName();
      Places _name_1 = this.getName();
      boolean _equals = Objects.equal(_name, _name_1);
      _and = _equals;
    }
    return _and;
  }
  
  public int hashCode() {
    Places _name = this.getName();
    return _name.hashCode();
  }
}
