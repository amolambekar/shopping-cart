package com.eshopper;

import java.util.AbstractMap.SimpleEntry;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import com.eshopper.Customer.CustomerType;

public interface Discount {
	
	Long apply(Long amount);

	//maintain cache of discounts against specific customer type
public static final Map <CustomerType,Discount> DISCOUNT_CACHE= Stream.of(
        new SimpleEntry<CustomerType,Discount>(CustomerType.REGULAR,regularDiscount()),
        new SimpleEntry<CustomerType,Discount>(CustomerType.PREMIUM, premiumDiscount()),
        new SimpleEntry<CustomerType,Discount>(CustomerType.GOLD, goldDiscount()))
       .collect(Collectors.toMap(SimpleEntry<CustomerType,Discount>::getKey, SimpleEntry<CustomerType,Discount>::getValue));
        
	public static Discount getDiscountScheme(CustomerType customerType) {
		Discount discount = DISCOUNT_CACHE.get(customerType);
		if(discount==null)
			discount=noDiscount();
		return discount;
	}
	
	 static  Discount noDiscount() {
		return amount->amount;
	}
 
    static Discount regularDiscount() {
        return amount -> { Long discount=0l;
		if(amount <=5000 ) {
			discount= 0l;
		}else if(amount<=10000){
			discount=500l;
		}else if(amount >10000) {
			discount = 500 +((amount-10000)*20/100);
		}
		return amount-discount;
    };
    }
    
    static Discount premiumDiscount() {
        return amount -> { Long discount=0l;
		if(amount <=4000 ) {
			discount= 400l;
		}
		if(amount >4000l && amount<=8000) {
			discount=1000l;
		}
		if(amount > 8000 && amount <12000) {
			discount = 1800l;
		}
		if(amount >12000) {
			discount = 1800l +((amount-12000)*30/100);
		}
		return amount-discount;
    };
    }
    
    static Discount goldDiscount() {
        return amount -> { Long discount=0l;
		if(amount <=4000 ) {
			//15 % discount
			discount= 600l;
		}
		if(amount >4000l && amount<=8000) {
			//20% discount 
			discount=1400l;
		}
		if(amount > 8000 && amount <12000) {
			//30% discount
			discount = 2600l;
		}
		if(amount >12000) {
			//35% discount
			discount = 2600l +((amount-12000)*35/100);
		}
		return amount-discount;
    };
    }
 
   
	

}
