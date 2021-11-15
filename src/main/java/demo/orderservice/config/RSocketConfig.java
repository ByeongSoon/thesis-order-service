package demo.orderservice.config;

import io.rsocket.RSocket;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.codec.cbor.Jackson2CborDecoder;
import org.springframework.http.codec.cbor.Jackson2CborEncoder;
import org.springframework.messaging.rsocket.RSocketRequester;
import org.springframework.messaging.rsocket.RSocketStrategies;

import java.time.Duration;

@Configuration
public class RSocketConfig {

  @Bean
  RSocketRequester rSocketRequester(RSocketStrategies strategies) {
    strategies = RSocketStrategies.builder()
        .encoders(encoders -> encoders.add(new Jackson2CborEncoder()))
        .decoders(decoders -> decoders.add(new Jackson2CborDecoder()))
        .build();

    return RSocketRequester.builder()
        .rsocketStrategies(strategies)
        .connectTcp("localhost",7000)
        .block(Duration.ofSeconds(5));
  }

}
