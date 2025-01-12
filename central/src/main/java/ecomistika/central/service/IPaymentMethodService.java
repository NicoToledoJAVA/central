/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package ecomistika.central.service;

import ecomistika.central.model.PaymentMethod;
import java.util.List;
import java.util.Optional;


public interface IPaymentMethodService {
    
    public List<PaymentMethod> getAllPaymentMethods(); 

    public Optional<PaymentMethod> getPaymentMethodById(Long id);

    public PaymentMethod createPaymentMethod(PaymentMethod paymentMethod);

    public PaymentMethod updatePaymentMethod(Long id, PaymentMethod updatedPaymentMethod);

    public void deletePaymentMethod(Long id) ;
}
