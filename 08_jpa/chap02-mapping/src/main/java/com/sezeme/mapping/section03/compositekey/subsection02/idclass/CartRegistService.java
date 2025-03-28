package com.sezeme.mapping.section03.compositekey.subsection02.idclass;

import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

@Service
public class CartRegistService {

    private CartRepository cartRepository;

    public CartRegistService(CartRepository cartRepository) {
        this.cartRepository = cartRepository;
    }

    @Transactional
    public void addItemToCart(CartDTO cartDTO) {
        Cart cart = new Cart(
                cartDTO.getCartOwnerMemberNo(),
                cartDTO.getAddedBookNo(),
                cartDTO.getQuantity()
        );

        cartRepository.save(cart);
    }
}

