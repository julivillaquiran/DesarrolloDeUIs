package model;

import model.InterestPlace;

@SuppressWarnings("all")
public class Country {
  private String _name;
  
  public String getName() {
    return this._name;
  }
  
  public void setName(final String name) {
    this._name = name;
  }
  
  private String[] _characteristics;
  
  public String[] getCharacteristics() {
    return this._characteristics;
  }
  
  public void setCharacteristics(final String[] characteristics) {
    this._characteristics = characteristics;
  }
  
  private InterestPlace _places;
  
  public InterestPlace getPlaces() {
    return this._places;
  }
  
  public void setPlaces(final InterestPlace places) {
    this._places = places;
  }
  
  private Country[] _conexions;
  
  public Country[] getConexions() {
    return this._conexions;
  }
  
  public void setConexions(final Country[] conexions) {
    this._conexions = conexions;
  }
}
