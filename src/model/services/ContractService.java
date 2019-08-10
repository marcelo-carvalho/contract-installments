package model.services;

import java.util.Calendar;

import model.entities.Contract;
import model.entities.Installments;

public class ContractService {
  
  private OnlinePaymentService paymentService = new PaypalService();
  
  public ContractService() {
    
  }
  
  public void processContract(Contract contract, Integer months) {

    Calendar cal = Calendar.getInstance();
    cal.setTime(contract.getDate());
    double amountPerMonth = contract.getTotalValue() / months;
         
    for(int i = 1; i <= months; i++) {
      cal.add(Calendar.MONTH, 1);
      double interest = paymentService.interest(amountPerMonth, i);
      double fee = paymentService.paymentFee(amountPerMonth);
      
      contract.addInstallments(new Installments(cal.getTime(), (amountPerMonth + interest + fee)));
    }
  }
}
