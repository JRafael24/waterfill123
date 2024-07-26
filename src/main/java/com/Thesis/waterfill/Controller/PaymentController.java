package com.Thesis.waterfill.Controller;


import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.Thesis.waterfill.Model.*;
import com.Thesis.waterfill.NotFoundException.*;
import com.Thesis.waterfill.Repository.*;


@RestController
@RequestMapping("/api/v1/payment")
public class PaymentController {
    PaymentRepository repo;

    public PaymentController(PaymentRepository repo) {
        this.repo = repo;
    }

 @GetMapping("user/{userId}")
    public List<Payment> getPaymentByUserId(@PathVariable Long userId) {
        return repo.findByUserId(userId);


}

@GetMapping("/{id}")
    public Payment getPaymentId(@PathVariable Long id) {
        return repo.findById(id).orElseThrow(() -> new PaymentNotFoundException(id));
    }

     @PostMapping("/new")
    public String addPaymentId(@RequestBody Payment newPaymentId) {
        repo.save(newPaymentId);
        return "Payment Accepted";
    }

    @PutMapping("/edit/{id}")
    public Payment updatePaymentId(@PathVariable Long id, @RequestBody Payment newPaymentId) {
        return repo.findById(id)
                .map(payment -> {
                    payment.setPaymentId(newPaymentId.getPaymentId());
                    payment.setProductName(newPaymentId.getProductName());
                    payment.setQuantity(newPaymentId.getQuantity());
                    payment.setPaymentDate(newPaymentId.getPaymentDate());
                    return repo.save(payment);
                })
                .orElseGet(() -> {
                    
                    return repo.save(newPaymentId);
                });
    }
    

    @DeleteMapping("/delete/{id}")
    public String deleteGallon(@PathVariable Long id){
        repo.deleteById(id);
        return"Payment Remove!";
    }
}
