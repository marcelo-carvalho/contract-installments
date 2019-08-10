package model.services;

public class PaypalService implements OnlinePaymentService {
  
  public PaypalService() {
    
  }
  
  @Override
  public double paymentFee(Double amount) {
    return amount * 0.02 ;
  }

  @Override
  public double interest(Double amount, Integer month) {
    return amount * 0.01 * month;
  }

}
