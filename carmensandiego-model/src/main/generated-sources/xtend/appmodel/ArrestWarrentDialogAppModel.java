package appmodel;

import appmodel.SolveCaseWindowAppModel;
import org.uqbar.commons.utils.Observable;
import villain.Villain;

@Observable
@SuppressWarnings("all")
public class ArrestWarrentDialogAppModel {
  private SolveCaseWindowAppModel _solveCaseWindowAppModel;
  
  public SolveCaseWindowAppModel getSolveCaseWindowAppModel() {
    return this._solveCaseWindowAppModel;
  }
  
  public void setSolveCaseWindowAppModel(final SolveCaseWindowAppModel solveCaseWindowAppModel) {
    this._solveCaseWindowAppModel = solveCaseWindowAppModel;
  }
  
  private Villain _warrent;
  
  public Villain getWarrent() {
    return this._warrent;
  }
  
  public void setWarrent(final Villain warrent) {
    this._warrent = warrent;
  }
  
  public ArrestWarrentDialogAppModel(final SolveCaseWindowAppModel solveCaseWindowAppModel) {
    this.setSolveCaseWindowAppModel(solveCaseWindowAppModel);
  }
  
  public void sendWarrent() {
    SolveCaseWindowAppModel _solveCaseWindowAppModel = this.getSolveCaseWindowAppModel();
    Villain _warrent = this.getWarrent();
    _solveCaseWindowAppModel.setCaptureOrder(_warrent);
  }
}
