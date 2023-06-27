public class Money  {
   
   protected int amount;
   private String currency;

   Money(int amount, String currency) {
      this.amount = amount;
      this.currency = currency;
   }

   static Money dollar(int amount) {
      return new Money(amount, "USD");
   }

   static Money franc(int amount) {
      return new Money(amount, "CHF");
   }

   Money times(int multiplier) {
      return new Money(amount * multiplier, currency);
   }

   public String currency() {
      return currency;
   }

   public boolean equals(Object object)  {
      Money money = (Money) object;
      return amount == money.amount && currency().equals(money.currency());
   }   	

}

   @Test
   public void testMultiplication() {
	   Money five = Money.dollar(5);
		assertEquals(Money.dollar(10), five.times(2));
      assertEquals(Money.dollar(15), five.times(3));
   }

   @Test
   public void testEquality() {
	   assertTrue(Money.dollar(5).equals(Money.dollar(5)));
		assertFalse(Money.dollar(5).equals(Money.dollar(6)));
		assertFalse(Money.franc(5).equals(Money.dollar(5)));
   }

   @Test
   public void testCurrency() {
      assertEquals("USD", Money.dollar(1).currency());
      assertEquals("CHF", Money.franc(1).currency());
   }