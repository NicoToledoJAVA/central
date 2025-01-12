


package ecomistika.central.service;

import ecomistika.central.model.PaymentMethod;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ecomistika.central.repository.IPaymentMethodRespository;



@Service

public class PaymentMethodService implements IPaymentMethodService {


    @Autowired
    public IPaymentMethodRespository paymentMethodRepository;

    @Override
    public List<PaymentMethod> getAllPaymentMethods() {
        return paymentMethodRepository.findAll();
    }

    @Override
    public Optional<PaymentMethod> getPaymentMethodById(Long id) {
        return paymentMethodRepository.findById(id);
    }

    @Override
    public PaymentMethod createPaymentMethod(PaymentMethod paymentMethod) {
        return paymentMethodRepository.save(paymentMethod);
    }

    @Override
    public PaymentMethod updatePaymentMethod(Long id, PaymentMethod updatedPaymentMethod) {
        return paymentMethodRepository.findById(id)
            .map(paymentMethod -> {
                paymentMethod.setName(updatedPaymentMethod.getName());
                // Actualizar los demás campos
                return paymentMethodRepository.save(paymentMethod);
            })
            .orElse(null);
    }

    @Override
    public void deletePaymentMethod(Long id) {
        paymentMethodRepository.deleteById(id);
    }






    
}
