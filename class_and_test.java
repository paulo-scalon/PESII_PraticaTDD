abstract class Money  {
   protected int amount;
   private String currency;
   
   public boolean equals(Object object)  {
      Money money = (Money) object;
      return amount == money.amount;
   }   
   public boolean equals(Object object) {
      Money money = (Money) object;
      return amount == money.amount && getClass().equals(money.getClass());
   }
   abstract Money times(int multiplier);  
   static Money dollar(int amount)  {
      return new Dollar(amount);
   }
   static Money dollar(int amount)  {
      return new Dollar(amount, "USD");
   }
   static Money franc(int amount) {
      return new Franc(amount, "CHF");
   }
   abstract String currency();
   String currency() {
      return currency;
   }
   Money(int amount, String currency) {
      this.amount = amount;
      this.currency = currency;
   }
}

class Dollar extends Money{
   Dollar(int amount, String currency)  {
      super(amount, currency);
   }
   Money times(int multiplier)  {
      return Money.dollar(amount * multiplier);
   }
   String currency() {
      return currency;
   }
}	

class Franc extends Money{   			
   Franc(int amount, String currency) {
      super(amount, currency);
   }
   Money times(int multiplier)  {
      return Money.franc(amount * multiplier);
   }  
    public boolean equals(Object object) {					
       Franc franc = (Franc) object;      
       return amount == franc.amount;					
     }					
     String currency() {
      return currency;
   }
}

public void testMultiplication() {
   Money five = Money.dollar(5);
   assertEquals(Money.dollar(10), five.times(2));
   assertEquals(Money.dollar(15), five.times(3));
}

public void testEquality() {
   assertTrue(Money.dollar(5).equals(Money.dollar(5)));
   assertFalse(Money.dollar(5).equals(Money.dollar(6)));
   assertTrue(Money.franc(5).equals(Money.franc(5)));
   assertFalse(Money.franc(5).equals(Money.franc(6)));
   assertFalse(Money.franc(5).equals(Money.dollar(5)));
}

public void testFrancMultiplication() {
   Money five = Money.franc(5);
   assertEquals(Money.franc(10), five.times(2));
   assertEquals(Money.franc(15), five.times(3));
}

public void testEquality() {
   assertTrue(new Dollar(5).equals(new Dollar(5)));
   assertFalse(new Dollar(5).equals(new Dollar(6)));
   assertTrue(new Franc(5).equals(new Franc(5)));
   assertFalse(new Franc(5).equals(new Franc(6)));
   assertFalse(new Franc(5).equals(new Dollar(5)));
}

public void testCurrency() {
   assertEquals("USD", Money.dollar(1).currency());
   assertEquals("CHF", Money.franc(1).currency());
}