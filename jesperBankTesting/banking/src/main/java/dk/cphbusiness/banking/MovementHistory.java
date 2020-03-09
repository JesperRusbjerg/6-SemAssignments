package dk.cphbusiness.banking;

import java.util.ArrayList;
import java.util.List;

import dk.cphbusiness.bankingInterfaces.IAccount;

public class MovementHistory {

  private List<Movement> ml = new ArrayList<Movement>();

  public MovementHistory(){
  }

  public void addMovement(IAccount source, IAccount target, long amount, long timestamp){
    ml.add(new Movement(source, target, amount, timestamp));
  }

  public List<Movement> returnList(){
    return this.ml;
  }


}