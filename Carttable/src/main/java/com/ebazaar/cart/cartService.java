package com.ebazaar.cart;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ebazaar.user.User;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class cartService {

    @Autowired
    private CartRepository CartRepository;

    public Cart addItem( Cart cart) {
        
    	LocalDateTime localDateTime = LocalDateTime.now();
		//LocalDate localDate = localDateTime.toLocalDate();
       cart.setAddedAt(localDateTime );
        
        return CartRepository.save(cart);
    }

    public void updateQuantity(Integer userID,Cart cart) {
//        Cart cartItem = CartRepository.findByUserId(userId, productId)
//                .orElseThrow(() -> new RuntimeException("Item not found in cart"));
//        
//        cartItem.setQuantity(quantity);
        CartRepository.save(cart);
    }

    public void removeItem(int id) {
        CartRepository.deleteById(id);
    }

    public Optional<Cart> getCartItem(int cartId) {
        return CartRepository.findByCartId(cartId);
            //    .orElseThrow(() -> new RuntimeException("Item not found in cart"));
    }

	public Optional<Cart> getCartItemByUserId(int userId) {
		return CartRepository.findByUserId(userId);
	}

	
	
}
