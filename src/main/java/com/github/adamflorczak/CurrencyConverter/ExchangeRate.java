package com.github.adamflorczak.CurrencyConverter;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Map;
import java.util.Objects;


@JsonIgnoreProperties(ignoreUnknown = true)
public class ExchangeRate {

    @JsonProperty("success")
    private boolean success;
    @JsonProperty("timestamp")
    private Long timestamp;
    @JsonProperty("source")
    private String source;
    @JsonProperty("quotes")
    Map<String, Double> quotes;

    public ExchangeRate() {
    }

    public ExchangeRate(Long timestamp, String source, Map<String, Double> quotes) {
        this.timestamp = timestamp;
        this.source = source;
        this.quotes = quotes;
    }

    public ExchangeRate(boolean success, String terms, String privacy, Long timestamp, String source, Map<String, Double> quotes) {
        this.success = success;
        this.timestamp = timestamp;
        this.source = source;
        this.quotes = quotes;
    }

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }


    public Long getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Long timestamp) {
        this.timestamp = timestamp;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public Map<String, Double> getQuotes() {
        return quotes;
    }

    public void setQuotes(Map<String, Double> quotes) {
        this.quotes = quotes;
    }

    @Override
    public String toString() {
        return "ExchangeRate{" +
                "success=" + success +
                ", timestamp=" + timestamp +
                ", source='" + source + '\'' +
                ", quotes=" + quotes +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ExchangeRate)) return false;
        ExchangeRate that = (ExchangeRate) o;
        return isSuccess() == that.isSuccess() &&
                Objects.equals(getTimestamp(), that.getTimestamp()) &&
                Objects.equals(getSource(), that.getSource()) &&
                Objects.equals(getQuotes(), that.getQuotes());
    }

    @Override
    public int hashCode() {

        return Objects.hash(isSuccess(), getTimestamp(), getSource(), getQuotes());
    }
}



