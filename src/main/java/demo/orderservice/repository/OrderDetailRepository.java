package demo.orderservice.repository;

import demo.orderservice.model.entity.OrderDetail;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderDetailRepository extends JpaRepository<OrderDetail,Long> {
}
