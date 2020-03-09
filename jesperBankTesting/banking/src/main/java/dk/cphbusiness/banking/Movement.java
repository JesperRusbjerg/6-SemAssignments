package dk.cphbusiness.banking;

import dk.cphbusiness.bankingInterfaces.IAccount;

public class Movement {

    private IAccount source;
    private IAccount target;
    private long amount;
    private long timestamp;
  
    public Movement(IAccount source, IAccount target, long amount, long timestamp) {
      this.source = source;
      this.target = target;
      this.amount = amount;
      this.timestamp = timestamp;
    }
  
  }