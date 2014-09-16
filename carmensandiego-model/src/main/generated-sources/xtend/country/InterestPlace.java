package country;

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
  
  public String messageIs() {
    Places _name = this.getName();
    if (_name != null) {
      switch (_name) {
        case Banco:
          return "Esta en el Banco";
        case Biblioteca:
          return "Esta en la Biblioteca";
        case Club:
          return "Este en el Club";
        case Embajada:
          return "Esta en la Embajada";
        default:
          break;
      }
    }
    return null;
  }
  
  public String messageFinal() {
    Places _name = this.getName();
    if (_name != null) {
      switch (_name) {
        case Banco:
          return "En este Pais, pero no en el Banco";
        case Biblioteca:
          return "En este Pais, pero no en la Biblioteca";
        case Club:
          return "En este Pais, pero no en el Club";
        case Embajada:
          return "En este Pais, pero no en la Embajada";
        default:
          break;
      }
    }
    return null;
  }
  
  public String messageFuge() {
    Places _name = this.getName();
    if (_name != null) {
      switch (_name) {
        case Banco:
          return "Paso por este Banco";
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
    return null;
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
}
