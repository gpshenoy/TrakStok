package org.javamoney.trakstok.rest;

import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;

import org.javamoney.trakstok.model.Currency;
import org.javamoney.trakstok.utils.CurrencyType;

@Path("exchange")
@Produces("application/json")
public class TSExchangeRateService {

    @GET
    @Path("/supportedcurrencies")
    @Produces("application/json")
    public Response supportedCurrencies() {
        List<Currency> currencies = new ArrayList<>();
        for (CurrencyType type : CurrencyType.values())
            currencies.add(new Currency(type.code(), type.currencyName()));
        return Response.status(200).entity(currencies).build();
    }

    @GET
    @Path("/convert/{fromCurrency}/to/{toCurrency}/value/{amount}")
    @Produces("application/json")
    public void getExchangeRate(@PathParam("fromCurrency")
    String fromCurrency, @PathParam("toCurrency")
    String toCurrency, @PathParam("amount")
    float amount) {
        System.out.println(fromCurrency + " " + toCurrency + " " + amount);
    }

}
