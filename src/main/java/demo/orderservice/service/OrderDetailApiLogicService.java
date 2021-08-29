package demo.orderservice.service;

import demo.orderservice.model.entity.OrderDetail;
import demo.orderservice.model.network.Header;
import demo.orderservice.model.network.request.OrderDetailApiRequest;
import demo.orderservice.model.network.response.OrderDetailApiResponse;
import demo.orderservice.repository.ItemRepository;
import demo.orderservice.repository.OrderInfoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderDetailApiLogicService extends BaseService<OrderDetailApiResponse, OrderDetailApiRequest, OrderDetail> {

    @Autowired
    private OrderInfoRepository orderRepository;

    @Autowired
    private ItemRepository itemRepository;

    @Override
    public Header<OrderDetailApiResponse> create(Header<OrderDetailApiRequest> request) {
        OrderDetailApiRequest body = request.getData();

        OrderDetail orderDetail = OrderDetail.builder()
                .quantity(body.getQuantity())
                .totalPrice(body.getTotalPrice())
                .orderInfo(orderRepository.getById(body.getOrderInfoId()))
                .item(itemRepository.getById(body.getItemId()))
                .build();

        return Header.OK(response(baseRepository.save(orderDetail)));
    }

    @Override
    public Header<OrderDetailApiResponse> read(Long id) {
        return null;
    }

    @Override
    public Header<OrderDetailApiResponse> update(Header<OrderDetailApiRequest> request) {
        return null;
    }

    @Override
    public Header delete(Long id) {
        return null;
    }

    @Override
    public Header<List<OrderDetailApiResponse>> search(Pageable pageable) {
        return null;
    }

    private OrderDetailApiResponse response(OrderDetail orderDetail) {
        return OrderDetailApiResponse.builder()
                .id(orderDetail.getId())
                .quantity(orderDetail.getQuantity())
                .totalPrice(orderDetail.getTotalPrice())
                .createdAt(orderDetail.getCreatedAt())
                .updatedAt(orderDetail.getUpdatedAt())
                .orderInfoId(orderDetail.getOrderInfo().getId())
                .itemId(orderDetail.getItem().getId())
                .build();
    }

}
