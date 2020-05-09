package dk.cphbusiness.banking;

import dk.cphbusiness.Utils;
import dk.cphbusiness.bankingInterfaces.IAccount;
import dk.cphbusiness.bankingInterfaces.IMovement;

public class Movement implements IMovement {

    private String source;
    private String target;
    private long amount;
    private String timestamp;
  
    public Movement(String source, String target, long amount, long timestamp) {
      this.source = source;
      this.target = target;
      this.amount = amount;
      this.timestamp = Utils.convertFromEpochToDate(timestamp);
    }

    @Override
    public String sourceAcc() {
        return source;
    }

    @Override
    public String destinationAcc() {
        return target;
    }

    @Override
    public String timestamp() {
        return timestamp;
    }

    @Override
    public long amount() {
    return amount;
    }
}