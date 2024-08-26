package org.tc.backend.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.tc.backend.models.OrderDetail;

import java.util.List;

public interface OrderDetailRepository extends JpaRepository<OrderDetail, Long> {
    List<OrderDetail> findByOrderId (Long id);

}
