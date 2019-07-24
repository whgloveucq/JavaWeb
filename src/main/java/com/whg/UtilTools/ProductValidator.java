package com.whg.UtilTools;
import java.util.Date;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils ;
import org.springframework.validation.Validator;
import com.whg.model.Product3 ;

public class ProductValidator implements Validator  {
    @Override
    public boolean supports(Class<?> aClass) {
        return Product3.class.isAssignableFrom( aClass) ;
    }

    @Override
    public void validate(Object target, Errors errors) {
        Product3 product= (Product3)target ;
        ValidationUtils.rejectIfEmpty(errors,"price","price.required");
        ValidationUtils.rejectIfEmpty(errors,"productionDate","productiondate.required");
        Float price= product.getPrice();
        if(price != null && price < 0){

            errors.rejectValue("price", "price.negative");

        }
        Date productionDate= product.getProductionDate();
        if(productionDate!=null ){
            // The hour , minute ,second components of productionDate are 0
            if(productionDate.after(new Date())){

                System.out.println("salahlagi");
                errors.rejectValue("productionDate" ,"productiondate.invalid");
            }
        }
    }
}
