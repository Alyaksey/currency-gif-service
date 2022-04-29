package services;

import com.example.currencygifservice.client.ExchangeRatesClient;
import com.example.currencygifservice.client.GiphyClient;
import com.example.currencygifservice.config.OXRProperty;
import com.example.currencygifservice.services.ExchangeRatesService;
import com.example.currencygifservice.services.GifService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

@SpringBootTest(classes = ExchangeRatesService.class)
@EnableConfigurationProperties(OXRProperty.class)
public class ServiceTest {
    @MockBean
    private GifService mockGifService;

    @MockBean
    private ExchangeRatesClient mockExchangeRatesClient;

    @Autowired
    private ExchangeRatesService exchangeRatesService;

    @Test
    void testGifService() {
        String tag = "broke";
        String url = "https://abc.com";
        Mockito.when(mockGifService.getGifUrl(tag)).thenReturn(url);
        String expected = url;
        Assertions.assertEquals(expected, mockGifService.getGifUrl(tag));
    }

    @Test
    void testExchangeRatesService() {
        String tag = "broke";
        String url = "https://abc.com";
        String currency = "EUR";
        Mockito.when(mockGifService.getGifUrl(tag)).thenReturn(url);
        String expected = url;
        //Assertions.assertEquals(expected, exchangeRatesService.calculate(currency));
    }
}
